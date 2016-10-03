package org.xcolab.portlets.proposals.view.action;



import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xcolab.client.contest.ContestClient;
import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.ContestPhase;
import org.xcolab.client.proposals.ProposalsClient;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.portlets.proposals.permissions.ProposalsPermissions;
import org.xcolab.portlets.proposals.utils.ProposalsContext;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;

@Controller
@RequestMapping("view")
public class PromoteProposalActionController {

    @Autowired
    private ProposalsContext proposalsContext;
    
    @RequestMapping(params = {"action=promoteProposal"})
    public void handleAction(ActionRequest request, Model model, ActionResponse response,
                             @RequestParam Long contestId,
                             @RequestParam Long contestPhaseId,
                             @RequestParam Long proposalId ) throws PortalException, SystemException, IOException {

        ProposalsPermissions proposalsPermissions = proposalsContext.getPermissions(request);
        ContestPhase contestPhase = ContestClient.getContestPhase(contestPhaseId);
        if (proposalsPermissions.getCanPromoteProposalToNextPhase(contestPhase)) {
            try {
                Contest latestProposalContest = ProposalsClient.getLatestContestInProposal(proposalId);
                ContestPhase currentProposalContestPhase = ContestClient.getContestPhase(contestPhaseId);
                ContestPhase activePhaseForContest = ContestClient.getActivePhase(latestProposalContest.getContestPK());

                ProposalsClient.promoteProposal(proposalId,
                        activePhaseForContest.getContestPhasePK(),
                        currentProposalContestPhase.getContestPhasePK());

                response.sendRedirect(proposalsContext.getProposal(request).getProposalLinkUrl(proposalsContext.getContest(request),
                        contestPhase.getContestPhasePK()));
            }catch (ContestNotFoundException ignored){

            }
        } else {
            response.sendRedirect(proposalsContext.getProposal(request).getProposalLinkUrl(proposalsContext.getContest(request),
                    contestPhase.getContestPhasePK()) + "/tab/ADMIN");
        }
    }
}
