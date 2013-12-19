package org.xcolab.portlets.proposals.view.action;


import com.ext.portlet.NoSuchProposalContestPhaseAttributeException;
import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.messaging.MessageUtil;
import com.ext.portlet.model.ContestPhaseRibbonType;
import com.ext.portlet.model.ProposalContestPhaseAttribute;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.MessageLocalServiceUtil;
import com.ext.portlet.service.MessageRecipientStatusLocalServiceUtil;
import com.ext.portlet.service.ProposalContestPhaseAttributeLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.util.mail.MailEngineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xcolab.portlets.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.portlets.proposals.requests.JudgeProposalBean;
import org.xcolab.portlets.proposals.utils.ProposalsContext;
import org.xcolab.portlets.proposals.wrappers.ContestTeamRoleWrapper;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("view")
public class JudgeProposalActionController {

    @Autowired
    private ProposalsContext proposalsContext;

    @RequestMapping(params={"action=sendEmails"})
    public void sendEmails(ActionRequest request, Model model, ActionResponse response) {
        //TODO code me
    }

    @RequestMapping(params = {"action=saveJudgeRating"})
    public void saveJudgeRating(ActionRequest request, Model model,
                                 ActionResponse response, @Valid JudgeProposalBean judgeProposalBean,
                                 BindingResult result)
            throws PortalException, SystemException, ProposalsAuthorizationException {
        long proposalId = proposalsContext.getProposal(request).getProposalId();
        long contestPhaseId = proposalsContext.getContestPhase(request).getContestPhasePK();
        // save judge rating
        persistAttribute(proposalId, contestPhaseId,ProposalAttributeKeys.JUDGE_RATING,0, judgeProposalBean.getJudgeRating() , null);
        // save judge action
        persistAttribute(proposalId, contestPhaseId,ProposalAttributeKeys.JUDGE_ACTION,0, judgeProposalBean.getJudgeAction().getAttributeValue() , null);
        // save judge comment
        persistAttribute(proposalId, contestPhaseId,ProposalAttributeKeys.JUDGE_COMMENT,0, -1 , judgeProposalBean.getJudgeComment());
    }

    @RequestMapping(params = {"action=sendJudgeRating"})
    public void sendJudgeRating(ActionRequest request, Model model,
                                ActionResponse response, @RequestParam("judgeComment") String judgeComment)
            throws PortalException, SystemException, ProposalsAuthorizationException, AddressException, MailEngineException {
        long proposalId = proposalsContext.getProposal(request).getProposalId();

        List<Long> recipientIds = new ArrayList<Long>();
        String subject = "Judge comment from " + proposalsContext.getUser(request).getScreenName() + " for proposal [" + proposalId + "]";

        ContestWrapper cr = new ContestWrapper(proposalsContext.getContest(request));
        for (User fellow : cr.getContestFellows()) {
            recipientIds.add(fellow.getUserId());
        }

        MessageUtil.sendMessage(subject, judgeComment, proposalsContext.getUser(request).getUserId(),
                proposalsContext.getUser(request).getUserId(), recipientIds, null);

    }

    @RequestMapping(params = {"action=saveFellowRating"})
    public void saveFellowRating(ActionRequest request, Model model,
                                 ActionResponse response, @Valid JudgeProposalBean judgeProposalBean,
                                 BindingResult result) throws PortalException, SystemException, ProposalsAuthorizationException {
        long proposalId = proposalsContext.getProposal(request).getProposalId();
        long contestPhaseId = proposalsContext.getContestPhase(request).getContestPhasePK();
        // save selection of judges
        persistSelectedJudges(proposalId, contestPhaseId, judgeProposalBean.getSelectedJudges());
        // save fellow rating
        persistAttribute(proposalId, contestPhaseId,ProposalAttributeKeys.FELLOW_RATING,0,judgeProposalBean.getFellowRating(), null);
        // save fellow action
        persistAttribute(proposalId, contestPhaseId,ProposalAttributeKeys.FELLOW_ACTION,0,judgeProposalBean.getFellowAction().getAttributeValue(), null);
        // save fellow comment
        persistAttribute(proposalId, contestPhaseId,ProposalAttributeKeys.FELLOW_COMMENT,0, -1 , judgeProposalBean.getFellowComment());
    }

    private boolean persistAttribute(long proposalId, long contestPhaseId, String attributeName, long additionalId, long numericValue, String stringValue){
        ProposalContestPhaseAttribute attribute = getProposalContestPhaseAttributeCreateIfNotExists(proposalId,contestPhaseId,attributeName, additionalId);

        attribute.setAdditionalId(additionalId);
        if (numericValue != -1) attribute.setNumericValue(numericValue);
        if (stringValue != null) attribute.setStringValue(stringValue);

        try {
            ProposalContestPhaseAttributeLocalServiceUtil.updateProposalContestPhaseAttribute(attribute);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean persistSelectedJudges(long proposalId, long contestPhaseId, List<Long> selectedJudges){
        ProposalContestPhaseAttribute judges = getProposalContestPhaseAttributeCreateIfNotExists(proposalId,contestPhaseId,ProposalAttributeKeys.SELECTED_JUDGES,0);

        String s = "";
        for (Long l : selectedJudges) s += l + ";";
        judges.setStringValue(s.replaceAll(";$", ""));

        try {
            ProposalContestPhaseAttributeLocalServiceUtil.updateProposalContestPhaseAttribute(judges);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ProposalContestPhaseAttribute getProposalContestPhaseAttributeCreateIfNotExists(long proposalId, long contestPhaseId, String attributeName, long additionalId){
        try {
            return ProposalContestPhaseAttributeLocalServiceUtil.getProposalContestPhaseAttribute(proposalId, contestPhaseId, attributeName,additionalId);
        } catch (NoSuchProposalContestPhaseAttributeException e) {
            try {
                ProposalContestPhaseAttribute attribute = ProposalContestPhaseAttributeLocalServiceUtil.createProposalContestPhaseAttribute(
                        CounterLocalServiceUtil.increment(ProposalContestPhaseAttribute.class.getName()));
                attribute.setProposalId(proposalId);
                attribute.setContestPhaseId(contestPhaseId);
                attribute.setName(attributeName);
                ProposalContestPhaseAttributeLocalServiceUtil.addProposalContestPhaseAttribute(attribute);
                return attribute;
            } catch (Exception e2) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
