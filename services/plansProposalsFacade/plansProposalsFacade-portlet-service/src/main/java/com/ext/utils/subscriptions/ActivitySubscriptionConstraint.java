package com.ext.utils.subscriptions;

import org.xcolab.activityEntry.ActivityEntryType;
import org.xcolab.activityEntry.proposal.ProposalBaseActivityEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Util class defining rules for certain types of SocialActivities where notifications to subscribed users should be restricted
 * (i.e. ProposalSupports are only shared with Proposal contributors)
 *
 * Created by kmang on 08/05/14.
 */
public class ActivitySubscriptionConstraint {

    private static final Map<String, ActivitySubscriptionWhitelistHandler> whitelistHandlers =
            new HashMap<>();

    static {
        whitelistHandlers.put(ActivityEntryType.PROPOSOSAL.getPrimaryTypeId() + "_" + ProposalBaseActivityEntry.ProposalActivitySubType.PROPOSAL_SUPPORTER_ADDED.getSecondaryTypeId(),
                new ActivitySubscriptionWhitelistProposalSupportHandler());
        whitelistHandlers.put(ActivityEntryType.PROPOSOSAL.getPrimaryTypeId() + "_" + ProposalBaseActivityEntry.ProposalActivitySubType.PROPOSAL_SUPPORTER_REMOVED.getSecondaryTypeId(),
                new ActivitySubscriptionWhitelistProposalSupportHandler());
        whitelistHandlers.put(ActivityEntryType.PROPOSOSAL.getPrimaryTypeId() + "_" + ProposalBaseActivityEntry.ProposalActivitySubType.PROPOSAL_VOTE.getSecondaryTypeId(),
                new ActivitySubscriptionWhitelistProposalSupportHandler());
        whitelistHandlers.put(ActivityEntryType.PROPOSOSAL.getPrimaryTypeId()+ "_" + ProposalBaseActivityEntry.ProposalActivitySubType.PROPOSAL_VOTE_SWITCH.getSecondaryTypeId(),
                new ActivitySubscriptionWhitelistProposalSupportHandler());
        whitelistHandlers.put(ActivityEntryType.PROPOSOSAL.getPrimaryTypeId() + "_" + ProposalBaseActivityEntry.ProposalActivitySubType.PROPOSAL_VOTE_RETRACT.getSecondaryTypeId(),
                new ActivitySubscriptionWhitelistProposalSupportHandler());
    }

    private long classNameId;
    private long activityType;

    public ActivitySubscriptionConstraint(long classNameId, long activityType) {
        this.classNameId = classNameId;
        this.activityType = activityType;
    }
    public boolean areSubscribersConstrained() {
        ActivitySubscriptionWhitelistHandler handler = whitelistHandlers.get(getClassNameId() + "_" + getActivityType());

        return handler != null;
    }

    public List<Long> getWhitelist(long classPk) {
        if (areSubscribersConstrained()) {
            return whitelistHandlers.get(getClassNameId() + "_" + getActivityType()).getWhitelistedUsers(classPk);
        }

        return new ArrayList<>();
    }

    public long getClassNameId() {
        return classNameId;
    }

    public long getActivityType() {
        return activityType;
    }

}
