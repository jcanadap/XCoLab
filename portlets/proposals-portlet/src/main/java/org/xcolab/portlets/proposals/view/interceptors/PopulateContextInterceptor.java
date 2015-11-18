package org.xcolab.portlets.proposals.view.interceptors;

import com.ext.portlet.model.Contest;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;
import org.xcolab.portlets.proposals.permissions.ProposalsDisplayPermissions;
import org.xcolab.portlets.proposals.permissions.ProposalsPermissions;
import org.xcolab.portlets.proposals.utils.ProposalsContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class PopulateContextInterceptor extends HandlerInterceptorAdapter {

    private static final String MODEL_ATTRIBUTE_PROPOSALS_PERMISSIONS = "proposalsPermissions";
    private static final String MODEL_ATTRIBUTE_PROPOSAL_DISPLAY_PERMISSIONS = "proposalsDisplayPermissions";
    private static final String MODEL_ATTRIBUTE_CONTEST_PHASE = "contestPhase";
    private static final String MODEL_ATTRIBUTE_PROPOSAL = "proposal";
    private static final String MODEL_ATTRIBUTE_CONTEST = "contest";
    private static final String MODEL_ATTRIBUTE_VIEW_CONTEST_PHASE_ID = "viewContestPhaseId";
    private static final String MODEL_ATTRIBUTE_PROPOSALS_PREFERENCES = "preferences";
    private static final String MODEL_ATTRIBUTE_CONTEST_TYPE = "contestType";
    
    @Autowired
    private ProposalsContext proposalsContext;

    
    @Override
    public void postHandleRender(RenderRequest request, RenderResponse response, Object handler,
            org.springframework.web.portlet.ModelAndView modelAndView) throws Exception {
        super.postHandleRender(request, response, handler, modelAndView);
        
        if (modelAndView != null) {
            Contest contest = proposalsContext.getContest(request);
            ContestPhase contestPhase = proposalsContext.getContestPhase(request);
            Proposal proposal = proposalsContext.getProposal(request);
            ProposalsPermissions permissions = proposalsContext.getPermissions(request);
            ProposalsDisplayPermissions displayPermissions = proposalsContext.getDisplayPermissions(request);

            if (contest != null) {
                modelAndView.addObject(MODEL_ATTRIBUTE_CONTEST, proposalsContext.getContestWrapped(request));
                
                if (contestPhase != null) {
                    modelAndView.addObject(MODEL_ATTRIBUTE_CONTEST_PHASE, proposalsContext.getContestPhaseWrapped(request));
                    
                    if (proposal != null) {
                        modelAndView.addObject(MODEL_ATTRIBUTE_PROPOSAL, proposalsContext.getProposalWrapped(request));
                    }
                }
            }

            modelAndView.addObject(MODEL_ATTRIBUTE_PROPOSALS_PERMISSIONS, permissions);
            modelAndView.addObject(MODEL_ATTRIBUTE_PROPOSAL_DISPLAY_PERMISSIONS, displayPermissions);
            modelAndView.addObject(MODEL_ATTRIBUTE_VIEW_CONTEST_PHASE_ID, proposalsContext.getViewContestPhaseId(request));
            modelAndView.addObject(MODEL_ATTRIBUTE_PROPOSALS_PREFERENCES, proposalsContext.getProposalsPreferences(request));
            modelAndView.addObject(MODEL_ATTRIBUTE_CONTEST_TYPE, proposalsContext.getContestType(request));
        }
    }
}
