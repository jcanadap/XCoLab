package org.xcolab.portlets.proposals.permissions;

import com.liferay.portal.model.MembershipRequestConstants;

import org.xcolab.client.activities.ActivitiesClient;
import org.xcolab.client.contest.pojo.phases.ContestPhase;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.team.MembershipRequest;
import org.xcolab.enums.MembershipRequestStatus;
import org.xcolab.portlets.proposals.utils.context.ClientHelper;
import org.xcolab.portlets.proposals.utils.context.ProposalsContextUtil;
import org.xcolab.util.enums.activity.ActivityEntryType;

import javax.portlet.PortletRequest;

/**
 * Helper class to decide whether a certain user should see things in the UI
 */
public class ProposalsDisplayPermissions {

    private final ProposalsPermissions proposalsPermissions;
    private final ClientHelper clientHelper;
    private final Proposal proposal;
    private final ContestPhase contestPhase;
    private final Member member;
    private final long memberId;

    public ProposalsDisplayPermissions(ProposalsPermissions proposalsPermissions,
            Proposal proposal, ContestPhase contestPhase, PortletRequest request) {
        this.proposalsPermissions = proposalsPermissions;
        this.proposal = proposal;
        this.contestPhase = contestPhase;
        this.member = proposalsPermissions.getMember();
        this.clientHelper = ProposalsContextUtil.getClients(request);
        this.memberId = member == null ? 0 : member.getId_();
    }

    public boolean getCanSeeRequestMembershipButton() {
        return !proposalsPermissions.getIsTeamMember()
                && !getUserHasOpenMembershipRequest();
    }

    public boolean getUserHasOpenMembershipRequest() {
        for (MembershipRequest mr : clientHelper.getMembershipClient()
                .getMembershipRequests(proposal.getProposalId())) {
            if (mr.getUserId() == memberId && (
                    (mr.getStatusId() == MembershipRequestConstants.STATUS_PENDING)
                            || mr.getStatusId()
                            == MembershipRequestStatus.STATUS_PENDING_REQUESTED)) {
                return true;
            }
        }
        return false;
    }

    public boolean getCanSeeVoteButton() {
        return memberId == 0 || !hasVotedOnThisProposal();
    }

    private boolean hasVotedOnThisProposal() {
        return proposal != null && proposal.getProposalId() > 0
                && clientHelper.getProposalMemberRatingClient().hasUserVoted(
                proposal.getProposalId(), contestPhase.getContestPhasePK(), memberId);
    }

    public boolean getCanSeeUnsubscribeProposalButton() {
        return memberId > 0 && isSubscribedToProposal();
    }

    private boolean isSubscribedToProposal() {
        return proposal != null && proposal.getProposalId() > 0
                && clientHelper.getProposalMemberRatingClient()
                .isMemberProposalSupporter(proposal.getProposalId(), memberId);
    }

    public boolean getCanSeeUnsubscribeContestButton() {
        return memberId > 0 && isSubscribedToContest();
    }

    private boolean isSubscribedToContest() {
        return contestPhase != null
                &&
                ActivitiesClient.isSubscribedToActivity(memberId,
                        ActivityEntryType.CONTEST.getPrimaryTypeId(), contestPhase.getContestPK(),
                        0, "");
    }

    public boolean getCanSeeSubscribeProposalButton() {
        return memberId == 0 || !isSubscribedToProposal();
    }

    public boolean getCanSeeSubscribeContestButton() {
        return memberId == 0 || !isSubscribedToContest();
    }

    public boolean getCanSeeUnsupportButton() {
        return (memberId > 0 && isSupporter())
                && !proposalsPermissions.isVotingEnabled();
    }

    private boolean isSupporter() {
        return proposal != null && proposal.getProposalId() > 0
                && clientHelper.getProposalMemberRatingClient()
                .isMemberProposalSupporter(proposal.getProposalId(), memberId);
    }

    public boolean getCanSeeSupportButton() {
        return (memberId == 0 || !isSupporter())
                && !proposalsPermissions.isVotingEnabled();
    }
}