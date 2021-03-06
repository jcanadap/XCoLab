package org.xcolab.client.contest.pojo;

import org.apache.commons.lang3.StringUtils;

import org.xcolab.client.admin.ContestTypeClient;
import org.xcolab.client.admin.attributes.configuration.ConfigurationAttributeKey;
import org.xcolab.client.admin.pojo.ContestType;
import org.xcolab.client.comment.CommentClient;
import org.xcolab.client.comment.ThreadClient;
import org.xcolab.client.comment.pojo.CommentThread;
import org.xcolab.client.comment.util.CommentClientUtil;
import org.xcolab.client.comment.util.ThreadClientUtil;
import org.xcolab.client.contest.ContestClient;
import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.ContestTeamMemberClient;
import org.xcolab.client.contest.ContestTeamMemberClientUtil;
import org.xcolab.client.contest.OntologyClient;
import org.xcolab.client.contest.OntologyClientUtil;
import org.xcolab.client.contest.PlanTemplateClient;
import org.xcolab.client.contest.PlanTemplateClientUtil;
import org.xcolab.client.contest.enums.ContestRole;
import org.xcolab.client.contest.enums.ContestStatus;
import org.xcolab.client.contest.pojo.ontology.FocusArea;
import org.xcolab.client.contest.pojo.ontology.OntologyTerm;
import org.xcolab.client.contest.pojo.phases.ContestPhase;
import org.xcolab.client.contest.pojo.phases.ContestPhaseType;
import org.xcolab.client.contest.pojo.team.ContestTeamMember;
import org.xcolab.client.contest.pojo.team.ContestTeamMemberRole;
import org.xcolab.client.contest.pojo.templates.PlanSectionDefinition;
import org.xcolab.client.contest.util.ContestScheduleChangeHelper;
import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.legacy.enums.MemberRole;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalClient;
import org.xcolab.client.proposals.ProposalMemberRatingClient;
import org.xcolab.client.proposals.ProposalPhaseClient;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.commons.html.HtmlUtil;
import org.xcolab.util.http.client.enums.ServiceNamespace;
import org.xcolab.util.http.exceptions.UncheckedEntityNotFoundException;
import org.xcolab.commons.time.DateUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Contest extends AbstractContest implements Serializable {

    private static final long serialVersionUID = 1L;

    private final ContestClient contestClient;
    private final ContestTeamMemberClient contestTeamMemberClient;
    private final OntologyClient ontologyClient;
    private final CommentClient commentClient;
    private final ThreadClient threadClient;
    private final PlanTemplateClient planTemplateClient;


    private static final Map<Long, FocusArea> faCache = new HashMap<>();
    private final Map<String, List<OntologyTerm>> ontologySpaceCache = new HashMap<>();

    protected static final String WHERE = "where";
    protected static final String WHAT = "what";
    protected static final String WHO = "who";
    protected static final String HOW = "how";
    private static final long ONTOLOGY_SPACE_ID_WHERE = 104L;
    private static final long ONTOLOGY_SPACE_ID_WHO = 102L;
    private static final long ONTOLOGY_SPACE_ID_WHAT = 103L;
    private static final long ONTOLOGY_SPACE_ID_HOW = 103L;
    private static final long CONTEST_TIER_FOR_SHOWING_SUB_CONTESTS = 3L;
    private static final String EMAIL_TEMPLATE_URL = "/resources/-/wiki/Main/Judging+Mail+Templates";

    private final Map<String, String> ontologyJoinedNames = new HashMap<>();
    private List<ContestPhase> visiblePhases;


    protected List<ContestPhase> phases;
    protected ContestType contestType;
    protected Map<ContestTeamMemberRole, List<Member>> contestTeamMembersByRole;

    protected ContestPhase activePhase;

    private ServiceNamespace serviceNamespace;

    public Contest() {
        contestClient = ContestClientUtil.getClient();
        contestTeamMemberClient = ContestTeamMemberClientUtil.getClient();
        ontologyClient = OntologyClientUtil.getClient();
        planTemplateClient = PlanTemplateClientUtil.getClient();
        commentClient = CommentClientUtil.getClient();
        threadClient = ThreadClientUtil.getClient();
    }

    public Contest(Contest value) {
        this(value, value.getServiceNamespace());
    }

    public Contest(AbstractContest value, ServiceNamespace serviceNamespace) {
        super(value);
        if (serviceNamespace != null) {
            contestClient = ContestClient.fromNamespace(serviceNamespace);
            contestTeamMemberClient = ContestTeamMemberClient.fromService(serviceNamespace);
            ontologyClient = OntologyClient.fromService(serviceNamespace);
            planTemplateClient = PlanTemplateClient.fromNamespace(serviceNamespace);
            commentClient = CommentClient.fromService(serviceNamespace);
            threadClient = ThreadClient.fromService(serviceNamespace);
        } else {
            contestClient = ContestClientUtil.getClient();
            contestTeamMemberClient = ContestTeamMemberClientUtil.getClient();
            ontologyClient = OntologyClientUtil.getClient();
            planTemplateClient = PlanTemplateClientUtil.getClient();
            commentClient = CommentClientUtil.getClient();
            threadClient = ThreadClientUtil.getClient();
        }
        this.serviceNamespace = serviceNamespace;
    }

    public String getContestDiscussionLinkUrl() {
        return getContestLinkUrl() + "/discussion";
    }

    public String getContestLinkUrl() {
        String link = "/";

        if (this.getIsSharedContestInForeignColab()) {
            link += ContestTypeClient.getContestType(ConfigurationAttributeKey.DEFAULT_CONTEST_TYPE_ID.get())
                    .getFriendlyUrlStringContests();
        } else {

            if(this.getContestTypeId()!=null) {
                link += ContestTypeClient.getContestType(this.getContestTypeId())
                        .getFriendlyUrlStringContests();
            }else{
                System.out.println(" > ContestID("+this.getContestPK()+")");
                System.out.println(" > Contest: " + this.toString() + " - ");
            }
        }

        link += "/%d/%s";
        return String.format(link, this.getContestYear(), this.getContestUrlName());
    }

    public String getContestLinkUrl(long contestPhaseId) {
        return getContestLinkUrl() + "/phase/" + contestPhaseId;
    }

    public String getSponsorLogoPath() {
        if (this.getIsSharedContestInForeignColab()) {

            Long imgId = this.getSponsorLogoId();
            if (imgId != null) {
                return ConfigurationAttributeKey.PARTNER_COLAB_ADDRESS.get()
                        + "/image/contest/" + imgId;
            }
            return "";
        } else {
            Long imgId = this.getSponsorLogoId();
            if (imgId != null) {
                return "/image/contest/" + imgId;
            }
            return "";
        }
    }

    public String getCleanContestDescription() {
        return HtmlUtil.cleanAll(this.getContestDescription());
    }

    public String getLogoPath() {
        long imgId = this.getContestLogoId() != null ? this.getContestLogoId() : 0;
        final String imagePath = "/image/contest/" + imgId;
        if (this.getIsSharedContestInForeignColab()) {
            return ConfigurationAttributeKey.PARTNER_COLAB_ADDRESS.get() + imagePath;
        }
        return imagePath;
    }

    public boolean getShowInTileView(){
        return this.getShow_in_tile_view();
    }

    public boolean isShowInTileView(){
        return this.getShow_in_tile_view();
    }

    public void setShowInTileView(boolean showInTileView){
        this.setShow_in_tile_view(showInTileView);
    }

    public boolean getShowInListView(){
        return this.getShow_in_list_view();
    }

    public boolean isShowInListView(){
        return this.getShow_in_list_view();
    }

    public void setShowInListView(boolean showInListView){
        this.setShow_in_list_view(showInListView);
    }

    public boolean getShowInOutlineView(){
        return this.getShow_in_outline_view() && getFocusAreaId() != null;
    }

    public boolean isShowInOutlineView(){
        return this.getShow_in_outline_view();
    }

    public void setShowInOutlineView(boolean showInOutlineView){
        this.setShow_in_outline_view(showInOutlineView);
    }

    public String generateContestUrlName() {
        String contestUrlName = this.getContestShortName().toLowerCase();
        return contestUrlName.replaceAll(" ", "-").replaceAll("[^a-z0-9-]", "");
    }

    public void persist() {
        contestClient.updateContest(this);
    }

    public String getContestShortNameWithEndYear() {
        final String contestShortName = getContestShortName();
        if (ConfigurationAttributeKey.CONTESTS_SHOW_YEAR_WHEN_COMPLETED.get()) {
            final char lastCharOfName = contestShortName.charAt(contestShortName.length() - 1);
            final boolean nameEndsInNumber = Character.isDigit(lastCharOfName);
            if (isContestCompleted() && !nameEndsInNumber) {
                ContestPhase activePhase = getActivePhase();
                if (activePhase != null) {
                    int phaseEndYear = DateUtil.getYearFromDate(activePhase.getPhaseStartDate());
                    return contestShortName + " " + phaseEndYear;
                }
            }
        }
        return contestShortName;
    }

    public boolean isContestActive() {
        return this.getContestActive();
    }

    public boolean getContestInVotingPhase() {
        ContestPhase phase = contestClient.getActivePhase(this.getContestPK());
        if (phase == null) {
            return false;
        }

        String status = phase.getContestStatusStr();
        return status != null && ContestStatus.valueOf(status).isCanVote();

    }

    public boolean isContestCompleted(){
        ContestPhase activePhase = getActivePhase();
        if (activePhase != null) {
            return activePhase.isCompleted();
        }
        return getLastPhase().isEnded();
    }

    public boolean isShowColoredFlag() {
        if (getFlag() > 0) {
            return getFlag() == 1;
        }
        return getActivePhase().getStatus().isCanAnything();
    }

    public boolean isFeatured() {
        return this.getFeatured_();
    }

    public boolean isPlansOpenByDefault() {
        return this.getPlansOpenByDefault();
    }


    public boolean getSponsorLinkAvailable() {
        return !StringUtils.isEmpty(this.getSponsorLink());
    }


    public long getProposalsCount() {
        try {
            ContestPhase cp = contestClient.getActivePhase(this.getContestPK());
            if (cp != null) {
                return ProposalPhaseClient.fromNamespace(serviceNamespace)
                        .getProposalCountForActiveContestPhase(cp.getContestPhasePK());
            }
        } catch (UncheckedEntityNotFoundException e) {
            //fall through - return 0
        }
        return 0L;
    }

    public long getCommentsCount() {

        return commentClient.countComments(this.getDiscussionGroupId());
    }

    public List<OntologyTerm> getWho() {
        return getTermFromSpace(WHO);
    }

    public List<OntologyTerm> getWhat() {
        return getTermFromSpace(WHAT);
    }

    public List<OntologyTerm> getWhere() {
        return getTermFromSpace(WHERE);
    }

    public List<OntologyTerm> getHow() {
        return getTermFromSpace(HOW);
    }

    protected List<OntologyTerm> getTermFromSpace(String space) {

        if (!ontologySpaceCache.containsKey(space) && getHasFocusArea()) {
            final Long focusAreaId = getFocusAreaId();
            if (!faCache.containsKey(focusAreaId)) {
                FocusArea fa = ontologyClient.getFocusArea(focusAreaId);
                if (fa == null) {
                    ontologySpaceCache.put(space, null);
                    return null;
                }
                faCache.put(fa.getId_(), fa);
            }
            List<OntologyTerm> terms = new ArrayList<>();
            terms.addAll(ontologyClient
                    .getOntologyTermsByFocusAreaOntologySpaceName(focusAreaId, space));
            ontologySpaceCache.put(space, terms.isEmpty() ? null : terms);
        }
        return ontologySpaceCache.get(space);

    }

    public List<ContestPhase> getPhases() {
        if (phases == null) {
            phases = new ArrayList<>();
            phases.addAll(contestClient.getAllContestPhases(this.getContestPK()));
        }
        return phases;
    }

    public Map<ContestTeamMemberRole, List<Member>> getContestTeamMembersByRole() {
        if (contestTeamMembersByRole == null) {
            contestTeamMembersByRole = new TreeMap<>();
            final List<ContestTeamMember> teamMembers =
                    contestTeamMemberClient.getTeamMembers(null, this.getContestPK(), null);
            for (ContestTeamMember teamMember : teamMembers) {
                try {
                    ContestTeamMemberRole role = contestTeamMemberClient
                            .getContestTeamMemberRole(teamMember.getRoleId());
                    List<Member> roleUsers = contestTeamMembersByRole
                            .computeIfAbsent(role, k -> new ArrayList<>());
                    roleUsers.add(MembersClient.getMember(teamMember.getUserId()));
                } catch (MemberNotFoundException e) {
                    //_log.warn("Contest team member " + teamMember.getUserId() + " does not have an account");
                }
            }
        }
        return contestTeamMembersByRole;
    }

    public boolean getHasUserRoleInContest(long memberId, long roleId) {
        for (Entry<ContestTeamMemberRole, List<Member>> entry
                : getContestTeamMembersByRole().entrySet()) {
            final ContestTeamMemberRole role = entry.getKey();
            final List<Member> members = entry.getValue();
            if (role.getId_() == roleId) {
                return members.stream()
                        .anyMatch(p -> p.getId_() == memberId);
            }
        }
        return false;
    }

    public boolean getCanFellow(long memberId) {
        return getHasUserRoleInContest(memberId, MemberRole.FELLOW.getRoleId());
    }

    public ContestPhase getActivePhase() {
        if (activePhase == null) {
            ContestPhase phase = contestClient.getActivePhase(this.getContestPK());
            if (phase == null) {
                return null;
            }
            activePhase = phase;
        }
        return activePhase;
    }

    public List<Member> getContestImpactAssessmentFellows() {
        return getMembersWithRole(ContestRole.IAF);
    }

    public List<Member> getContestJudges() {
        return getMembersWithRole(ContestRole.JUDGE);
    }

    public List<Member> getContestFellows() {
        return getMembersWithRole(ContestRole.FELLOW);
    }

    public List<Member> getContestAdvisors() {
        return getMembersWithRole(ContestRole.ADVISOR);
    }

    private List<Member> getMembersWithRole(ContestRole contestRole) {
        return getContestTeamMembersByRole().entrySet().stream()
                .filter(e -> e.getKey().getContestRole() == contestRole)
                .map(Entry::getValue)
                .findAny().orElse(Collections.emptyList());
    }

    public long getTotalProposalsCount() {
        Set<Proposal> proposalList = new HashSet<>();

        List<ContestPhase> contestPhases = contestClient.getAllContestPhases(this.getContestPK());
        for (ContestPhase contestPhase : contestPhases) {
            List<Proposal> proposals = ProposalClient.fromNamespace(serviceNamespace)
                    .getActiveProposalsInContestPhase(contestPhase.getContestPhasePK());
            proposalList.addAll(proposals);

        }

        return proposalList.size();
    }

    public ContestType getContestType() {
        if (contestType == null) {
            contestType = ContestTypeClient.getContestType(this.getContestTypeId());
        }
        return contestType;
    }

    public Contest getWrapped() {
        return this;
    }

    public String getContestUrl() {
        return this.getContestLinkUrl();
    }


    public String getResourceArticleUrl() {
        if(this.getIsSharedContestInForeignColab()) {
            return ConfigurationAttributeKey.PARTNER_COLAB_ADDRESS.get()+"/resources/"
                    + this.getContestYear() + "/" + this.getContestUrlName();
        } else {
            return "/resources/" + this.getContestYear()
                    + "/" + this.getContestUrlName();
        }
    }

    @Override
    public String getEmailTemplateUrl() {
        if (super.getEmailTemplateUrl().isEmpty()) {
            return EMAIL_TEMPLATE_URL;
        } else {
            return super.getEmailTemplateUrl();
        }
    }
    public long getTotalCommentsCount() {
        int contestComments = commentClient.countComments(this.getDiscussionGroupId());
        ContestPhase phase = contestClient.getActivePhase(this.getContestPK());
        final List<Long> proposalDiscussionThreads =
                contestClient.getProposalDiscussionThreads(phase.getContestPhasePK());
        contestComments += commentClient.countComments(proposalDiscussionThreads);

        return contestComments;
    }

    public long getVotesCount() {
        ContestPhase phase = contestClient.getActivePhase(this.getContestPK());

        return ProposalMemberRatingClient.fromNamespace(serviceNamespace)
                .countProposalVotesInContestPhase(phase.getContestPhasePK());
    }

    public long getCreatedTime(){
        if (this.getCreated() != null) {
            return this.getCreated().getTime();
        }
        if (this.getUpdated() != null) {
            return this.getUpdated().getTime();
        }
        return 0;
    }

    public ContestPhase getLastPhase() {
        ContestPhase last = null;
        for (ContestPhase ph : getPhases()) {
            if (last == null || (ph.getPhaseReferenceDate() != null
                    && ph.getPhaseReferenceDate().compareTo(last.getPhaseReferenceDate()) > 0)) {
                last = ph;
            }
        }
        return last;
    }


    public ServiceNamespace getServiceNamespace() {
        return serviceNamespace;
    }

    public String getWhoName() {
        return getTermNameFromSpace(WHO);
    }

    public String getWhatName() {
        return getTermNameFromSpace(WHAT);
    }

    public String getWhereName() {
        return getTermNameFromSpace(WHERE);
    }

    public String getHowName() {
        return getTermNameFromSpace(HOW);
    }

    private String getTermNameFromSpace(String space) {
        String ontologyJoinedName = ontologyJoinedNames.get(space);
        if (ontologyJoinedName == null) {
            getTermFromSpace(space);
            ontologyJoinedName = ontologyJoinedNames.get(space);
        }

        if (ontologyJoinedName == null) {
            return "";
        }
        return ontologyJoinedName;
    }

    public boolean getShowSubContests(){
        // Removed due to COLAB-518; keep the functionality in the code base for the case that we need it again.
        //        return contest.getContestTier() == CONTEST_TIER_FOR_SHOWING_SUB_CONTESTS;
        return false;
    }

    public boolean getShowParentContest(){
        return false;
        //        return this.getContestTier() == 3 - 1;
    }

    public List<Contest> getSubContests() {
        List <Contest> subContests = contestClient
                .getSubContestsByOntologySpaceId(this.getContestPK(), ONTOLOGY_SPACE_ID_WHERE);
        subContests.sort(Comparator.comparingInt(AbstractContest::getWeight));
        return subContests;
    }

    public Contest getParentContest() {
        final Long focusAreaId = getFocusAreaId();
        if (!getHasFocusArea()) {
            return null;
        }
        List<OntologyTerm> list = ontologyClient.getAllOntologyTermsFromFocusAreaWithOntologySpace(
                ontologyClient.getFocusArea(focusAreaId), ontologyClient.getOntologySpace(ONTOLOGY_SPACE_ID_WHERE));
        List<Long> focusAreaOntologyTermIds = new ArrayList<>();
        for (OntologyTerm ot : list) {
            focusAreaOntologyTermIds.add(ot.getId_());
        }

        List<Contest> contests = contestClient
                .findContestsByTierAndOntologyTermIds(3L, focusAreaOntologyTermIds);
        if (!contests.isEmpty()) {
            return contests.get(0);
        } else {
            return null;
        }
    }

    public Long getVotingPhasePK() {
        ContestPhase lastVotingPhase = null;
        for (ContestPhase ph : getPhases()) {
            final ContestPhaseType contestPhaseType = ph.getContestPhaseTypeObject();
            if (contestPhaseType != null && "VOTING".equals(
                    contestPhaseType.getStatus())) {
                lastVotingPhase = ph;
            }
        }
        return lastVotingPhase != null ? lastVotingPhase.getContestPhasePK() : 0;
    }

    public List<ContestPhase> getVisiblePhases() {
        if (visiblePhases == null) {
            visiblePhases = new ArrayList<>();
            visiblePhases.addAll(contestClient
                    .getVisibleContestPhases(this.getContestPK()));
        }
        return visiblePhases;
    }

    public boolean getHasFocusArea() {
        return getFocusAreaId() != null;
    }

    public boolean isUserAmongAdvisors(long memberId) {
        for (Member judge : getContestAdvisors()) {
            if (judge.getUserId() == memberId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Long getDiscussionGroupId() {
        Long discussionGroupId = super.getDiscussionGroupId();
        if (discussionGroupId == null) {
            ContestType contestType = getContestType();
            CommentThread thread = new CommentThread();
            thread.setAuthorId(getAuthorId());
            thread.setTitle(contestType.getContestName() + " discussion");
            thread.setIsQuiet(false);
            thread = threadClient.createThread(thread);
            discussionGroupId = thread.getThreadId();
            setDiscussionGroupId(discussionGroupId);
        }
        return discussionGroupId;
    }

    public boolean isEmpty() {
        return !isNotEmpty();
    }

    public boolean isNotEmpty() {
        return getTotalProposalsCount() > 0;
    }

    public boolean isCompatibleWithSchedule(long contestScheduleId) {
        if (isEmpty()) {
            return true;
        }
        final ContestScheduleChangeHelper contestScheduleChangeHelper =
                new ContestScheduleChangeHelper(getContestPK(), contestScheduleId);
        return contestScheduleChangeHelper.isValidChange();
    }

    public boolean isCompatibleWithSchedulePhases(List<ContestPhase> schedulePhases) {
        if (isEmpty()) {
            return true;
        }
        final ContestScheduleChangeHelper contestScheduleChangeHelper =
                new ContestScheduleChangeHelper(getContestPK(), schedulePhases);
        return contestScheduleChangeHelper.isValidChange();
    }

    public void changeScheduleTo(long contestScheduleId) {
        final ContestScheduleChangeHelper contestScheduleChangeHelper =
                new ContestScheduleChangeHelper(getContestPK(), contestScheduleId);

        if (isEmpty()) {
            contestScheduleChangeHelper.changeScheduleForBlankContest();
        } else {
            contestScheduleChangeHelper.changeScheduleForStartedContest();
        }
        setContestScheduleId(contestScheduleId);
        ContestClientUtil.updateContest(this);
    }

    public boolean getIsSharedContestInForeignColab() {
        final String colabName = ConfigurationAttributeKey.COLAB_NAME.get();
        return getIsSharedContest() != null && getIsSharedContest()
                && !colabName.equals(getSharedOrigin());
    }
    /**
     * Determine if judges are done with proposal
     *
     * @return 0 if judge action is incomplete, 1 judge actions completed
     */
    public boolean getJudgeStatus() {
        //TODO COLAB-2421: this code does nothing - remove?
//        try {
//            ContestPhase contestPhase = contestClient.getActivePhase(this.getContestPK());
//            for (Proposal proposal : ProposalClient.fromNamespace(serviceNamespace)
//                    .getProposalsInContestPhase(contestPhase.getContestPhasePK())) {
//                Proposal2Phase p2p = ProposalPhaseClient.fromNamespace(serviceNamespace)
//                        .getProposal2PhaseByProposalIdContestPhaseId(proposal.getProposalId(),
//                                contestPhase.getContestPhasePK());
//                /*
//                final Proposal proposalWrapper =
//                        new ProposalWrapper(proposal, proposal.getCurrentVersion(), this,
//                                contestPhase, p2p);
//                if (proposalWrapper.getJudgeStatus() == GenericJudgingStatus.STATUS_ACCEPTED) {
//                    return false;
//                }
//                */
//            }
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }

    /**
     * Determine if fellows are done with proposal
     *
     * @return 0 if fellow action is incomplete, 1 fellow action completed
     */
    public boolean getScreeningStatus() {
        //TODO COLAB-2421: this code does nothing - remove?
//        try {
//            ContestPhase contestPhase = contestClient.getActivePhase(this.getContestPK());
//
//            for (Proposal proposal : ProposalClient.fromNamespace(serviceNamespace)
//                    .getProposalsInContestPhase(contestPhase.getContestPhasePK())) {
//                Proposal2Phase p2p = ProposalPhaseClient.fromNamespace(serviceNamespace)
//                        .getProposal2PhaseByProposalIdContestPhaseId(proposal.getProposalId(), contestPhase.getContestPhasePK());
//                /*
//                if ((new ProposalWrapper(proposal, proposal.getCurrentVersion(), this, contestPhase, p2p)).getScreeningStatus() == GenericJudgingStatus.STATUS_UNKNOWN) {
//                    return false;
//                }*/
//            }
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }
    public void setUpForeignContestVisualConfigsFromLocal(Contest c) {
        this.setFeatured_(c.getFeatured_());
        this.setContestActive(c.getContestActive());
        this.setContestPrivate(c.getContestPrivate());
        this.setFlag(c.getFlag());
        this.setFlagText(c.getFlagText());
        this.setFlagTooltip(c.getFlagText());
        this.setFeatured_(c.getFeatured_());
        this.setShowInListView(c.getShowInListView());
        this.setShowInOutlineView(c.getShowInOutlineView());
        this.setShowInTileView(c.getShowInTileView());
        this.setWeight(c.getWeight());
    }

    public String getNewProposalLinkUrl() {
        if (getIsSharedContestInForeignColab()) {
            final ContestType contestType = ContestTypeClient
                    .getContestType(ConfigurationAttributeKey.DEFAULT_CONTEST_TYPE_ID.get());
            final String portletUrl = contestType.getContestBaseUrl();
            return String.format("%s/%s/%s/createProposal",
                    portletUrl, this.getContestYear(), this.getContestUrlName());
        } else {
            final String portletUrl = getContestType().getContestBaseUrl();
            return String.format("%s/%s/%s/createProposal",
                    portletUrl, this.getContestYear(), this.getContestUrlName());
        }
    }

    public List<PlanSectionDefinition> getSections() {
        return planTemplateClient.getPlanSectionDefinitionByPlanTemplateId(getPlanTemplateId(),
                        true);
    }

    public int getMaxVotesPerContest() {
        return ConfigurationAttributeKey.PROPOSALS_MAX_VOTES_PER_CONTEST.get().intValue();
    }

    public int getMaxVotesPerProposal() {
        return ConfigurationAttributeKey.PROPOSALS_MAX_VOTES_PER_PROPOSAL.get().intValue();
    }
}
