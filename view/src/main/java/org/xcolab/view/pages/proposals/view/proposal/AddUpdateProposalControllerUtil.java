package org.xcolab.view.pages.proposals.view.proposal;

import org.xcolab.client.activities.ActivitiesClient;
import org.xcolab.client.activities.pojo.ActivitySubscription;
import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.enums.ContestStatus;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.phases.ContestPhase;
import org.xcolab.client.members.PermissionsClient;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.phases.Proposal2Phase;
import org.xcolab.util.activities.enums.ActivityCategory;
import org.xcolab.util.activities.enums.ContestActivityType;
import org.xcolab.util.activities.enums.ProposalActivityType;
import org.xcolab.util.http.ServiceRequestUtils;
import org.xcolab.util.http.caching.CacheName;
import org.xcolab.view.auth.MemberAuthUtil;
import org.xcolab.view.pages.proposals.requests.UpdateProposalDetailsBean;
import org.xcolab.view.pages.proposals.utils.context.ClientHelper;
import org.xcolab.view.pages.proposals.utils.context.ProposalContext;
import org.xcolab.view.pages.proposals.utils.edit.ProposalCreationUtil;
import org.xcolab.view.pages.proposals.utils.edit.ProposalMoveUtil;
import org.xcolab.view.pages.proposals.utils.edit.ProposalUpdateHelper;
import org.xcolab.view.util.googleanalytics.GoogleAnalyticsEventType;
import org.xcolab.view.util.googleanalytics.GoogleAnalyticsUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public final class AddUpdateProposalControllerUtil {

    private AddUpdateProposalControllerUtil() {
    }

    private static boolean isProposalListClosed(ContestPhase contestPhase) {
        return contestPhase.getStatus() == ContestStatus.CLOSED
                || contestPhase.getStatus() == ContestStatus.COMPLETED;
    }

    public static String createOrUpdateProposal(HttpServletRequest request,
            UpdateProposalDetailsBean updateProposalSectionsBean, Proposal proposal,
            ProposalContext proposalContext) {
        long memberId = MemberAuthUtil.getMemberId(request);
        final Contest contest = proposalContext.getContest();

        final ClientHelper clients = proposalContext.getClients();

        boolean createNew = false;
        final ContestPhase contestPhase = proposalContext.getContestPhase();
        if (proposal != null) {
            if (updateProposalSectionsBean.getIsMove() && updateProposalSectionsBean.getMoveToContestId() > 0) {
                Contest moveToContest = ContestClientUtil.getContest(updateProposalSectionsBean.getMoveToContestId());
                ProposalMoveUtil.moveProposal(proposalContext, updateProposalSectionsBean,
                        proposal, contestPhase, moveToContest, memberId);
            }
        } else {
            createNew = true;
            proposal = ProposalCreationUtil
                    .createProposal(memberId, updateProposalSectionsBean, contest, contestPhase);
        }

        final Proposal2Phase p2p = proposalContext.getProposal2Phase();
        ProposalUpdateHelper proposalUpdateHelper = new ProposalUpdateHelper(request,
                proposalContext, updateProposalSectionsBean, proposal, p2p, memberId);
        proposalUpdateHelper.updateProposal();

        final ActivitiesClient activitiesClient = clients.getActivitiesClient();
        if (createNew) {
            boolean isAdmin = PermissionsClient.canAdminAll(memberId);
            boolean isClosed = isProposalListClosed(contestPhase);
            if (isAdmin && isClosed) {
                ServiceRequestUtils.clearCache(CacheName.PROPOSAL_LIST_CLOSED);
            }

            final List<ActivitySubscription> activitySubscriptions = activitiesClient
                    .getActivitySubscriptions(ActivityCategory.CONTEST,
                            contest.getContestPK(), null);
            for (ActivitySubscription activitySubscription : activitySubscriptions) {
                final Long receiverId = activitySubscription.getReceiverId();
                activitiesClient.addSubscription(receiverId, ActivityCategory.PROPOSAL,
                        proposal.getProposalId(), "");

            }

            activitiesClient.createActivityEntry(ContestActivityType.PROPOSAL_CREATED, memberId,
                    contest.getContestPK(), proposal.getProposalId());

            GoogleAnalyticsUtils.pushEventAsync(GoogleAnalyticsEventType.CONTEST_ENTRY_CREATION);

        } else {
            activitiesClient.createActivityEntry(ProposalActivityType.UPDATED, memberId,
                    proposal.getProposalId());
        }

        return "redirect:" + proposal.getProposalLinkUrl(contest);
    }
    
}
