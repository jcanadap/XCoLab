package org.xcolab.client.activities.enums;

import java.util.Arrays;

public enum ActivityCategory {

    MEMBER(MemberActivityType.values()),
    DISCUSSION(DiscussionActivityType.values()),
    PROPOSAL(ProposalActivityType.values()),
    CONTEST(ContestActivityType.values());

    private final ActivityType[] activityTypes;

    ActivityCategory(ActivityType[] activityTypes) {
        this.activityTypes = activityTypes;
    }

    public ActivityType getActivityType(String activityType) {
        return Arrays.stream(activityTypes)
                .filter(s -> s.name().equalsIgnoreCase(activityType))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No ActivityType " + name() + "." + activityType));
    }
}