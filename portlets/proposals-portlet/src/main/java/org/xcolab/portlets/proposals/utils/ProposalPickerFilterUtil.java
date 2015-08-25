package org.xcolab.portlets.proposals.utils;

import java.util.*;

import com.ext.portlet.model.PlanSectionDefinition;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.xcolab.enums.ContestTier;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;

import com.ext.portlet.NoSuchProposalContestPhaseAttributeException;
import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.OntologyTerm;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil;
import com.ext.portlet.service.Proposal2PhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalContestPhaseAttributeLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;

/**
 * Created with IntelliJ IDEA.
 * User: patrickhiesel
 * Date: 04/12/13
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public enum ProposalPickerFilterUtil {

    // why are lamdba expressions not supported here?
    ACCEPTALL(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal,Date>> proposals, Object additionalFilterCriterion) {
            // do not modify the list
        }

		@Override
		public void filterContests(List<Pair<ContestWrapper, Date>> proposals,
				Object additionalFilterCriterion) {
			// do nothing
		}
    }),
    TEXTBASED(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal,Date>> proposals, Object additionalFilterCriterion) {
            if (!(additionalFilterCriterion instanceof String)) return;
            String searchCriterion = (String) additionalFilterCriterion;
            for (Iterator<Pair<Proposal,Date>> i = proposals.iterator(); i.hasNext();){
                Proposal p = i.next().getLeft();
                 try{
                     // PROPOSAL NAME
                     String proposalName = ProposalLocalServiceUtil.getAttribute(p.getProposalId(), ProposalAttributeKeys.NAME,0l).getStringValue();
                     if (StringUtils.containsIgnoreCase(proposalName,searchCriterion)){
                         continue;
                     }
                     // CONTEST NAME
                     String contestName = Proposal2PhaseLocalServiceUtil.getCurrentContestForProposal(p.getProposalId()).getContestName();
                     if (StringUtils.containsIgnoreCase(contestName,searchCriterion)){
                         continue;
                     }
                     // Remove element if it does not match any criterion
                     i.remove();
                 } catch (Exception e){ /* LR EXCEPTIONS */e.printStackTrace(); }
            }

        }

		@Override
		public void filterContests(List<Pair<ContestWrapper, Date>> contests,
				Object additionalFilterCriterion) {
            if (!(additionalFilterCriterion instanceof String)) return;
            String searchCriterion = (String) additionalFilterCriterion;
            for (Iterator<Pair<ContestWrapper,Date>> i = contests.iterator(); i.hasNext();){
                ContestWrapper c = i.next().getLeft();
                
                 try{
                     // CONTEST NAME
                     if (StringUtils.containsIgnoreCase(c.getContestName(),searchCriterion)){
                         continue;
                     }
                     if (StringUtils.containsIgnoreCase(c.getContestShortName(), searchCriterion)) {
                    	 continue;
                     }
                     // focus area
                     if (StringUtils.containsIgnoreCase(c.getWhatName(), searchCriterion)) {
                    	 continue;
                     }
                     if (StringUtils.containsIgnoreCase(c.getWhoName(), searchCriterion)) {
                    	 continue;
                     }
                     if (StringUtils.containsIgnoreCase(c.getWhereName(), searchCriterion)) {
                    	 continue;
                     }
                     
                     // Remove element if it does not match any criterion
                     i.remove();
                 } catch (Exception e){ /* LR EXCEPTIONS */e.printStackTrace(); }
            }
		}
    }),
    WINNERSONLY(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal, Date>> proposals, Object additionalFilterCriterion) {
            for (Iterator<Pair<Proposal,Date>> i = proposals.iterator(); i.hasNext();){
                Proposal p = i.next().getLeft();
                try{
                    List<Long> phases = Proposal2PhaseLocalServiceUtil.getContestPhasesForProposal(p.getProposalId());
                    boolean winner = false;
                    for (long phase : phases){
                        try{
                            ProposalContestPhaseAttributeLocalServiceUtil.getProposalContestPhaseAttribute(p.getProposalId(),phase,"RIBBON");
                            winner = true;
                        }catch (NoSuchProposalContestPhaseAttributeException nspcpae){ /* NO WINNER */ }
                    }
                    if (!winner) i.remove();
                } catch (Exception e){ /* LR EXCEPTIONS */e.printStackTrace(); }
            }
        }

		@Override
		public void filterContests(List<Pair<ContestWrapper, Date>> proposals,
				Object additionalFilterCriterion) {
			// do nothing
			
		}
    }),
    ONTOLOGY_FOCUS_AREA(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal, Date>> proposals, Object additionalFilterCriterion) {
            try{

                long focusAreaId = (Long) additionalFilterCriterion;

                FocusArea focusArea = FocusAreaLocalServiceUtil.getFocusArea(focusAreaId);

                List<OntologyTerm> terms = new LinkedList<>();
                if (focusArea != null) {
                    terms.addAll(FocusAreaLocalServiceUtil.getTerms(focusArea));
                }

                if (terms.size() > 0) {
                    List<Contest> contests = ContestLocalServiceUtil.getContestsMatchingOntologyTerms(terms);
                    for (Iterator<Pair<Proposal,Date>> i = proposals.iterator(); i.hasNext();){
                        Proposal p = i.next().getLeft();
                        try {
                            if (!contests.contains(Proposal2PhaseLocalServiceUtil.getCurrentContestForProposal(p.getProposalId()))) i.remove();
                        } catch (Exception e){
                            i.remove();
                        }
                    }
                }
            } catch (Exception e){ /* LR EXCEPTIONS */ e.printStackTrace(); }
        }

		@Override
		public void filterContests(List<Pair<ContestWrapper, Date>> proposals,
				Object additionalFilterCriterion) {
			// do nothing
			
		}
    }), CONTEST_TIER(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal, Date>> proposals, Object additionalFilterCriterion) {
            try{
                // if filterTier < 0:
                //  allow tier < (-filterTier)
                // else if filterTier > 0
                //  only allow tier == filterTier - 1
                Long filterTier = (Long) additionalFilterCriterion;
                boolean exactMatch = true;
                if (filterTier < 0) {
                    filterTier = -filterTier;
                    exactMatch = false;
                }

                if (ContestTier.getContestTierByTierType(filterTier) != ContestTier.NONE) {
                    ContestTier contestTier = ContestTier.getContestTierByTierType(filterTier);
                    Set<Contest> tierFilteredContests = new HashSet<>(ContestLocalServiceUtil.getContestsMatchingTier(contestTier.getTierType()));
                    if (!exactMatch) {
                        for (Long currentTier = filterTier -1; currentTier >= 0; currentTier-- ) {
                            ContestTier localContestTier = ContestTier.getContestTierByTierType(currentTier);
                            tierFilteredContests.addAll(ContestLocalServiceUtil.getContestsMatchingTier(localContestTier.getTierType()));
                        }
                    }

                    for (Iterator<Pair<Proposal,Date>> i = proposals.iterator(); i.hasNext();){
                        Proposal p = i.next().getLeft();
                        try {
                            if (!tierFilteredContests.contains(Proposal2PhaseLocalServiceUtil.getCurrentContestForProposal(p.getProposalId())))
                                i.remove();
                        } catch (Exception e){
                            i.remove();
                        }
                    }
                }
            } catch (Exception e){ /* LR EXCEPTIONS */ e.printStackTrace(); }
        }

        @Override
        public void filterContests(List<Pair<ContestWrapper, Date>> proposals,
                                   Object additionalFilterCriterion) {
            // do nothing

        }
    });

    private final ProposalPickerFilter proposalPickerFilter;

    private ProposalPickerFilterUtil(ProposalPickerFilter proposalPickerFilter) {
        this.proposalPickerFilter = proposalPickerFilter;
    }

    public ProposalPickerFilter getProposalPickerFilter() {
        return proposalPickerFilter;
    }

    // CONVENIENCE METHODS
    public void filter(List<Pair<Proposal,Date>> proposals){
        this.getProposalPickerFilter().filter(proposals, null);
    }

    public void filter(List<Pair<Proposal,Date>> proposals, Object additionalFilterCriterion){
        this.getProposalPickerFilter().filter(proposals, additionalFilterCriterion);
    }

    // PARSE FILTER FROM FRONT END PARAMETER
    public static ProposalPickerFilterUtil getFilterByParameter(String filterKey) {
        if (filterKey == null) return ACCEPTALL;
        if (filterKey.equalsIgnoreCase("WINNERSONLY")) return WINNERSONLY;
        return ACCEPTALL;
    }

	public void filterContests(List<Pair<ContestWrapper, Date>> contests,
			String filterText) {
        this.getProposalPickerFilter().filterContests(contests, filterText);
		
	}

}
