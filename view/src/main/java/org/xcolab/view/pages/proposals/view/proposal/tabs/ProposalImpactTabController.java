package org.xcolab.view.pages.proposals.view.proposal.tabs;

import edu.mit.cci.roma.client.comm.ModelNotFoundException;
import edu.mit.cci.roma.client.comm.ScenarioNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.ImpactClientUtil;
import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.impact.ImpactIteration;
import org.xcolab.client.contest.pojo.ontology.OntologyTerm;
import org.xcolab.client.modeling.roma.RomaClientUtil;
import org.xcolab.client.proposals.ProposalAttributeClientUtil;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.attributes.ProposalUnversionedAttribute;
import org.xcolab.view.util.entity.enums.ProposalUnversionedAttributeName;
import org.xcolab.util.enums.contest.ContestTier;
import org.xcolab.view.pages.proposals.impact.IntegratedProposalImpactSeries;
import org.xcolab.view.pages.proposals.impact.ProposalImpactScenarioCombinationWrapper;
import org.xcolab.view.pages.proposals.impact.ProposalImpactSeries;
import org.xcolab.view.pages.proposals.impact.ProposalImpactSeriesList;
import org.xcolab.view.pages.proposals.impact.ProposalImpactUtil;
import org.xcolab.view.pages.proposals.utils.context.ProposalsContext;
import org.xcolab.view.pages.proposals.utils.context.ProposalsContextUtil;
import org.xcolab.view.pages.proposals.tabs.ProposalTab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/contests/{contestYear}/{contestUrlName}")
public class ProposalImpactTabController extends BaseProposalTabController {

    private final static Logger _log = LoggerFactory.getLogger(ProposalImpactTabController.class);

    @Autowired
    private ProposalsContext proposalsContext;

    @GetMapping(value = "c/{proposalUrlString}/{proposalId}", params = "tab=IMPACT")
    public String showProposalDetails(HttpServletRequest request, Model model,
            @PathVariable Long proposalId, @PathVariable String contestUrlName,
            @PathVariable Long contestYear, @RequestParam(defaultValue = "false") boolean edit)
            throws IOException, ScenarioNotFoundException, ModelNotFoundException  {

        Contest contest = proposalsContext.getContest(request);
        Proposal proposalWrapper = proposalsContext.getProposalWrapped(request);
        setCommonModelAndPageAttributes(request, model, ProposalTab.IMPACT);

        boolean userAllowedToEdit = false;

        if (edit) {
            userAllowedToEdit = canEditImpactTab(request);
            boolean userCanCommentAsAuthor = canCommentAsAuthor(request);
            model.addAttribute("canCommentAsAuthor", userCanCommentAsAuthor);
            boolean userCanCommentAsAIF = canCommentAsAIF(request);
            model.addAttribute("canCommentAsAIF", userCanCommentAsAIF);
        }

        List<ProposalUnversionedAttribute> unversionedAttributes = ProposalAttributeClientUtil

                .
                getProposalUnversionedAttributesByProposalId(proposalWrapper.getProposalId());
        if ( unversionedAttributes != null && ! unversionedAttributes.isEmpty()) {
            for (ProposalUnversionedAttribute pua : unversionedAttributes) {
                if (pua.getName().equals(ProposalUnversionedAttributeName.IMPACT_AUTHOR_COMMENT
                        .toString())) {
                    if (StringUtils.isNotBlank(pua.getStringValue())) {
                        model.addAttribute("authorComment", pua);
                    }
                }
                if (pua.getName()
                        .equals(ProposalUnversionedAttributeName.IMPACT_IAF_COMMENT.toString())) {
                    if (StringUtils.isNotBlank(pua.getStringValue())) {
                        model.addAttribute("iafComment", pua);
                    }
                }
            }
        }

        model.addAttribute("edit", userAllowedToEdit);
        model.addAttribute("isRegionalSectorContest", isRegionalSectorContest(contest));
        model.addAttribute("isRegionalContest", isRegionalContest(contest));
        model.addAttribute("isGlobalContest", isGlobalContest(contest));

        boolean tabUsesModeling = (isRegionalContest(contest) || isGlobalContest(contest));
        if (tabUsesModeling){
            model.addAttribute("availableModels", ContestClientUtil.getModelIdsAndNames(contest.getContestPK()));
            model.addAttribute("modelId", getModelIdIfProposalHasScenarioIdOrContestDefaultModelId(
                    proposalWrapper));
            model.addAttribute("scenarioId", proposalWrapper.getScenarioId());
        }

        boolean showSubProposalListing = (isRegionalContest(contest));
        boolean showDataTable = (isRegionalContest(contest));
        if (showDataTable) {
            IntegratedProposalImpactSeries integratedProposalImpactSeries =
                    new IntegratedProposalImpactSeries(proposalWrapper.getWrapped(), contest,
                    request);
            model.addAttribute("impactSeries", integratedProposalImpactSeries);
            List<ImpactIteration> impactIterations = ImpactClientUtil.getContestImpactIterations(contest);
            model.addAttribute("impactIterations", impactIterations);
        }

        if(showSubProposalListing){
            model.addAttribute("impactSerieses", getImpactTabBasicProposal(proposalWrapper.getWrapped(),


                    request, contest));
        }
        model.addAttribute("showSubProposalListing", showSubProposalListing);
        model.addAttribute("showDataTable", showDataTable);

        final ContestTier contestTier = ContestTier.getContestTierByTierType(contest.getContestTier());
        if (contestTier != null) {
            switch (contestTier) {
                case BASIC:
                    return showImpactTabBasic(request, model, contest, proposalWrapper);
                case REGION_SECTOR:
                    //return showImpactTabRegionSector();
                    return "proposalImpactError";
                case REGION_AGGREGATE:
                    return showImpactTabRegionAggregate();
                case GLOBAL:
                    if(userAllowedToEdit) {
                        return showImpactTabEditGlobal(request, model, proposalWrapper);
                    } else {
                        return showImpactTabGlobal();
                    }
            }
        }
        _log.warn("Using default impact tab view since contest tier is not set for contest: {}",
                contest.getContestPK());
        return "/proposals/proposalImpactError";
    }

    private Long getModelIdIfProposalHasScenarioIdOrContestDefaultModelId(Proposal proposalWrapper) {
        Long modelId = proposalWrapper.getModelId();
        boolean scenarioIdValid =
               proposalWrapper.getScenarioId() != null && proposalWrapper.getScenarioId() > 0;
        if(scenarioIdValid){
            try {
                modelId = RomaClientUtil.client()
                        .getScenario(proposalWrapper.getScenarioId()).getSimulation().getId();
            } catch (IOException e){
                _log.warn("Could not fetch simulation id for proposal scenario: ", e);
            }
        }
        return modelId;
    }

    private boolean canCommentAsAuthor(HttpServletRequest request) {
        return proposalsContext.getPermissions(request).getCanAdminProposal();
    }
    private boolean canCommentAsAIF(HttpServletRequest request) {
        return proposalsContext.getPermissions(request).getCanIAFActions()
                || proposalsContext.getPermissions(request).getCanAdminAll();
    }
    private boolean canEditImpactTab(HttpServletRequest request) {
        return ProposalTab.IMPACT.getCanEdit(request);
    }

    private String showImpactTabRegionSector() {
        return "/proposals/integratedProposalImpact";
    }

    private String showImpactTabRegionAggregate() {
        return "/proposals/integratedProposalImpact";
    }

    private String showImpactTabGlobal() {
        return "/proposals/integratedProposalImpact";
    }

    private String showImpactTabEditGlobal(HttpServletRequest request, Model model,
            Proposal proposalWrapper)
            throws IOException, ScenarioNotFoundException, ModelNotFoundException {

        List<Proposal> subProposals =
                ProposalsContextUtil.getClients(request).getProposalClient().getContestIntegrationRelevantSubproposals(proposalWrapper.getProposalId());
        ProposalImpactScenarioCombinationWrapper proposalImpactScenarioCombinationWrapper =
                new ProposalImpactScenarioCombinationWrapper(subProposals);
        boolean isConsolidationPossible =
                proposalImpactScenarioCombinationWrapper.isConsolidationOfScenariosPossible();
        boolean isProposalUsingCombinedScenario = false;

        if(isConsolidationPossible){
            boolean isValidScenario = (proposalWrapper.getScenarioId() != null && proposalWrapper.getScenarioId() != 0);
            if (isValidScenario) {
                Long proposalScenarioId = proposalWrapper.getScenarioId();
                boolean isScenarioUsingSameModelId = proposalImpactScenarioCombinationWrapper.isScenarioUsingSameModelId(proposalScenarioId);
                if (proposalWrapper.isConsolidatedScenario(proposalScenarioId)){
                    isProposalUsingCombinedScenario = true;
                    proposalImpactScenarioCombinationWrapper.calculateCombinedInputParameters();

                    if (!isScenarioUsingSameModelId || proposalImpactScenarioCombinationWrapper.
                            scenarioInputParameterAreDifferentThanAggregated(proposalScenarioId)) {
                        proposalImpactScenarioCombinationWrapper.runCombinedScenarioSimulation();
                        model.addAttribute("consolidatedScenarioId",
                                proposalImpactScenarioCombinationWrapper.getOutputScenarioId());
                        model.addAttribute("consolidatedModelId",
                                proposalImpactScenarioCombinationWrapper.getOutputModelId());
                    } else {
                        model.addAttribute("consolidatedScenarioId", proposalScenarioId);
                        model.addAttribute("consolidatedModelId",
                                proposalImpactScenarioCombinationWrapper.getModelIdForScenarioId(proposalScenarioId));
                    }
                } else {
                    proposalImpactScenarioCombinationWrapper.runCombinedScenarioSimulation();
                    model.addAttribute("consolidatedScenarioId",
                            proposalImpactScenarioCombinationWrapper.getOutputScenarioId());
                    model.addAttribute("consolidatedModelId",
                            proposalImpactScenarioCombinationWrapper.getOutputModelId());
                }
            } else {
                proposalImpactScenarioCombinationWrapper.runCombinedScenarioSimulation();
                model.addAttribute("consolidatedScenarioId",
                        proposalImpactScenarioCombinationWrapper.getOutputScenarioId());
                model.addAttribute("consolidatedModelId",
                        proposalImpactScenarioCombinationWrapper.getOutputModelId());
            }
        } else{
            model.addAttribute("proposalToModelMap",
                    proposalImpactScenarioCombinationWrapper.getRegionToProposalSimulationScenarioMap());
        }

        model.addAttribute("isProposalUsingCombinedScenario", isProposalUsingCombinedScenario);
        model.addAttribute("consolidationPossible", isConsolidationPossible);
        model.addAttribute("consolidateOptions", getConsolidationOptions());

        return "/proposals/integratedProposalImpact";
    }

    private Map<String, String[]> getConsolidationOptions() {
        return getConsolidateOptionsOnGlobalLevel();
    }

    private String showImpactTabBasic(HttpServletRequest request, Model model, Contest contest,
            Proposal proposalWrapper) {

        List<ImpactIteration> impactIterations = ImpactClientUtil.getContestImpactIterations(contest);
        model.addAttribute("impactIterations", impactIterations);

        ProposalImpactSeriesList proposalImpactSeriesList =
                new ProposalImpactSeriesList(contest, proposalWrapper.getWrapped());
        model.addAttribute("impactSerieses", proposalImpactSeriesList.getImpactSerieses());

        Map<OntologyTerm, List<OntologyTerm>> ontologyMap =
                new ProposalImpactUtil(contest).calculateAvailableOntologyMap(proposalImpactSeriesList.getImpactSerieses());
        model.addAttribute("regionTerms", sortByName(ontologyMap.keySet()));
        model.addAttribute("proposalsPermissions", proposalsContext.getPermissions(request));

        return "/proposals/basicProposalImpact";
    }

    private List<ProposalImpactSeries> getImpactTabBasicProposal(Proposal proposalParent,
            HttpServletRequest request, Contest contest) {
        Set<Proposal> referencedSubProposals =
                IntegratedProposalImpactSeries.getSubProposalsOnContestTier(proposalParent,
                        ContestTier.BASIC.getTierType(), request);
        try {
            List<OntologyTerm> ontologyTermList = contest.getWhere();
            List<ProposalImpactSeries> proposalImpactSerieses = new ArrayList<>();
            for (Proposal proposal : referencedSubProposals) {
                ProposalImpactSeriesList proposalImpactSeriesList = new ProposalImpactSeriesList(
                        contest, proposal);
                for (ProposalImpactSeries proposalImpactSeries : proposalImpactSeriesList.getImpactSerieses()) {
                    if (proposalImpactSeries.getWhereTerm().equals(ontologyTermList.get(0))) {
                        proposalImpactSerieses.add(proposalImpactSeries);
                    }
                }
            }
            return proposalImpactSerieses;
        } catch(ContestNotFoundException ignored) {

        }
        return null;
    }


    private List<OntologyTerm> sortByName(Collection<OntologyTerm> collection) {
        List<OntologyTerm> list = new ArrayList<>(collection);
        list.sort(Comparator.comparing(o -> o.getName()));
        return list;
    }

    private boolean isGlobalContest(Contest contest) {
        return contest.getContestTier() == ContestTier.GLOBAL.getTierType();
    }

    private boolean isRegionalContest(Contest contest) {
        return contest.getContestTier() == ContestTier.REGION_AGGREGATE.getTierType();
    }

    private boolean isRegionalSectorContest(Contest contest) {
        return contest.getContestTier() == ContestTier.REGION_SECTOR.getTierType();
    }

    private Map<String, String[]> getConsolidateOptionsOnGlobalLevel() {
        Map<String, String[]> consolidateOptions = new LinkedHashMap<>();
        String[] consolidated = {"USE VALUES FROM THE REGIONAL PLANS", "The values from your regional plans will be automatically used as inputs for the global simulation model."};
        String[] separate = {"SPECIFY NEW VALUES", "Use the options below to calculate the impact of your global plan. These results will be independent of the values from the regional plans you included."};
        consolidateOptions.put("CONSOLIDATE", consolidated);
        consolidateOptions.put("SEPARATE", separate);
        return consolidateOptions;
    }

}
