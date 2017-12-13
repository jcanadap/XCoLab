package org.xcolab.view.activityentry.discussion;

import org.apache.commons.text.StringEscapeUtils;

import org.xcolab.client.activities.enums.ContestActivityType;
import org.xcolab.client.activities.enums.DiscussionActivityType;
import org.xcolab.client.activities.enums.ProposalActivityType;
import org.xcolab.client.activities.pojo.ActivityEntry;
import org.xcolab.client.comment.exceptions.CategoryNotFoundException;
import org.xcolab.client.comment.exceptions.CommentNotFoundException;
import org.xcolab.client.comment.exceptions.ThreadNotFoundException;
import org.xcolab.client.comment.pojo.Category;
import org.xcolab.client.comment.pojo.CategoryGroup;
import org.xcolab.client.comment.pojo.Comment;
import org.xcolab.client.comment.pojo.CommentThread;
import org.xcolab.client.comment.util.CategoryClientUtil;
import org.xcolab.client.comment.util.CommentClientUtil;
import org.xcolab.client.comment.util.ThreadClientUtil;
import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalAttributeClientUtil;
import org.xcolab.client.proposals.ProposalClientUtil;
import org.xcolab.client.proposals.enums.ProposalAttributeKeys;
import org.xcolab.client.proposals.exceptions.ProposalNotFoundException;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.view.activityentry.ActivityInitializationException;
import org.xcolab.view.activityentry.provider.ActivityEntryContentProvider;
import org.xcolab.view.i18n.ResourceMessageResolver;

public abstract class DiscussionBaseActivityEntry implements ActivityEntryContentProvider {

    private static final String HYPERLINK_FORMAT = "<a href=\"%s\">%s</a>";

    protected ActivityEntry activityEntry;

    protected Comment comment;
    protected CommentThread thread;
    protected Category category;
    protected CategoryGroup categoryGroup;

    protected Proposal proposal;
    protected Contest contest;
    protected String proposalName;

    protected final ResourceMessageResolver resourceMessageResolver;

    public DiscussionBaseActivityEntry(ResourceMessageResolver resourceMessageResolver) {
        this.resourceMessageResolver = resourceMessageResolver;
    }

    @Override
    public void setActivityEntry(ActivityEntry activityEntry)
            throws ActivityInitializationException {
        this.activityEntry = activityEntry;
        if (DiscussionActivityType.COMMENT_ADDED.equals(getActivityType())
            || DiscussionActivityType.THREAD_ADDED.equals(getActivityType())) {

            try {//DISCUSSION_ADDED_COMMENT
                category = CategoryClientUtil.getCategory(activityEntry.getClassPrimaryKey());
                comment = CommentClientUtil
                        .getComment(Long.parseLong(activityEntry.getExtraData()), true);
                thread = ThreadClientUtil.getThread(comment.getThreadId());
                category = CategoryClientUtil.getCategory(thread.getCategoryId());
            } catch (CategoryNotFoundException | ThreadNotFoundException |
                    CommentNotFoundException e) {
                throw new ActivityInitializationException(activityEntry.getActivityEntryId(), e);
            }
            return;
        }
        if (ContestActivityType.COMMENT_ADDED.equals(getActivityType())) {
            try {
                thread = ThreadClientUtil.getThread(activityEntry.getClassPrimaryKey());
                contest = ContestClientUtil.getContestByThreadId(thread.getThreadId());
            } catch (ProposalNotFoundException | ContestNotFoundException |
                    ThreadNotFoundException ignored) {

            }
            return;
        }
        if (ProposalActivityType.COMMENT_ADDED.equals(getActivityType())) {
            try {//proposal comment
                thread = ThreadClientUtil.getThread(activityEntry.getClassPrimaryKey());

                proposal = ProposalClientUtil.getProposalByThreadId(thread.getThreadId());
                contest = ProposalClientUtil.getCurrentContestForProposal(proposal.getProposalId());


                proposalName = ProposalAttributeClientUtil
                        .getProposalAttribute(proposal.getProposalId(), ProposalAttributeKeys.NAME,
                                null).getStringValue();
            } catch (ProposalNotFoundException | ContestNotFoundException |
                    ThreadNotFoundException ignored) {


            }
        }
    }

    protected String getContestLink() {
        String url = "&#160;";
        if (contest != null) {
            url = "<a href='" + contest.getContestUrl() + "/discussion" + "'>" + contest
                    .getContestShortNameWithEndYear() + "</a>";
        }
        return url;
    }

    protected String getProposalLink() {
        String url = "&#160;";
        if (proposal != null) {
            url = "<a href='" + proposal.getProposalLinkUrl(contest) + "/tab/COMMENTS" + "'>"
                    + proposalName + "</a>";
        }
        return url;
    }

    protected String getThreadLink() {
        if (thread != null) {
            return String
                    .format(HYPERLINK_FORMAT, StringEscapeUtils.escapeHtml4(thread.getLinkUrl()),
                            thread.getTitle());
        } else {
            return "&#160;";
        }
    }

    protected String getCategoryLink() {
        if (category != null) {
            return String
                    .format(HYPERLINK_FORMAT, StringEscapeUtils.escapeHtml4(category.getLinkUrl()),
                            category.getName());
        } else {
            return "&#160;";
        }
    }

    protected String getUserLink() {

        try {
            Member member = MembersClient.getMember(this.activityEntry.getMemberId());
            if (member != null) {
                return member.getUserLinkTag();
            } else {
                return "&#160;";
            }

        } catch (MemberNotFoundException ignored) {
            return "<user removed>";
        }
    }
}
