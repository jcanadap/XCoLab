package org.xcolab.portlets.proposals.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.xcolab.client.admin.enums.ConfigurationAttributeKey;
import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.OntologyClientUtil;
import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.ContestCollectionCard;
import org.xcolab.client.contest.pojo.ContestType;
import org.xcolab.client.contest.pojo.ontology.FocusArea;
import org.xcolab.client.contest.pojo.ontology.FocusAreaOntologyTerm;
import org.xcolab.client.contest.pojo.ontology.OntologySpace;
import org.xcolab.client.contest.pojo.ontology.OntologyTerm;
import org.xcolab.client.members.PermissionsClient;
import org.xcolab.commons.beans.SortFilterPage;
import org.xcolab.portlets.proposals.utils.ContestsColumn;
import org.xcolab.portlets.proposals.wrappers.CollectionCardFilterBean;
import org.xcolab.portlets.proposals.wrappers.CollectionCardWrapper;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;
import org.xcolab.portlets.proposals.wrappers.ContestsSortFilterBean;
import org.xcolab.portlets.proposals.wrappers.FocusAreaWrapper;
import org.xcolab.portlets.proposals.wrappers.OntologySpaceWrapper;
import org.xcolab.portlets.proposals.wrappers.OntologyTermWrapper;
import org.xcolab.portlets.proposals.wrappers.ProposalsPreferencesWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;

@Controller
@RequestMapping("view")
public class ContestsIndexController extends BaseProposalsController {

    private static final Log _log = LogFactoryUtil.getLog(ContestsIndexController.class);

    private final static String COOKIE_VIEW_TYPE = "cc_contests_viewType";
    private final static String VIEW_TYPE_GRID = "GRID";
    private final static String VIEW_TYPE_LIST = "LIST";
    private final static String VIEW_TYPE_OUTLINE = "OUTLINE";
    private final static String VIEW_TYPE_DEFAULT = VIEW_TYPE_GRID;
    private static final int MIN_SIZE_CONTEST_FILTER = 9;
    private static final int FEATURED_COLLECTION_CARD_ID = 1;
    private static final int BY_TOPIC__COLLECTION_CARD_ID = 2;
    private static final int BY_LOCATION_COLLECTION_CARD_ID = 3;

    @RequestMapping
    public String showContestsIndex(PortletRequest request, PortletResponse response, Model model,
            @RequestParam(required = false) String viewType,
            @RequestParam(required = false, defaultValue="true") boolean showActiveContests,
            @RequestParam(required = false, defaultValue="false") boolean showAllContests,
            @RequestParam(required = false, defaultValue = "" + BY_TOPIC__COLLECTION_CARD_ID) long collectionCard,
            SortFilterPage sortFilterPage) 
                    throws PortalException, SystemException {

        ProposalsPreferencesWrapper preferences = new ProposalsPreferencesWrapper(request);
        ContestType contestType = preferences.getContestType();

        if (contestType.getSuggestionContestId() > 0) {
            try {
                Contest c = ContestClientUtil.getContest(contestType.getSuggestionContestId());
                String link = c.getContestLinkUrl();
                model.addAttribute("suggestionContestLink", link);
            }catch (ContestNotFoundException ignored){

            }
        }

        if (viewType == null) {
            // view type wasn't set
            final Cookie[] cookies = request.getCookies(); //null if cookies are disabled
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(COOKIE_VIEW_TYPE)) {
                        viewType = cookie.getValue();
                    }
                }
            }
        }
        else {
            // we need to change the view type
            if (viewType.equals(VIEW_TYPE_GRID) || viewType.equals(VIEW_TYPE_LIST) || viewType.equals(VIEW_TYPE_OUTLINE)) {
                // we should set the cookie but it doesn't work currently https://issues.liferay.com/browse/LPS-25733
                // it should be handled in the view
                response.addProperty(new Cookie(COOKIE_VIEW_TYPE, viewType));
            }
        }
        if (viewType == null) {
            viewType = VIEW_TYPE_DEFAULT;
        }



        //Collection cards
        List<CollectionCardWrapper> collectionCards = new ArrayList<>();
        for (ContestCollectionCard card: ContestClientUtil.getSubContestCollectionCards(collectionCard)) {
            collectionCards.add(new CollectionCardWrapper(card));
        }

        //contests
        boolean showOnlyFeatured = false;
        List<ContestWrapper> contests = new ArrayList<>();
        if (!viewType.equals(VIEW_TYPE_OUTLINE)) {

            LinkedList<CollectionCardWrapper> collectionHierarchy = new LinkedList<>();
            long tempId = collectionCard;
            while(ContestClientUtil.getContestCollectionCard(tempId).getParent() != null) {
                collectionHierarchy.addFirst(new CollectionCardWrapper(ContestClientUtil.getContestCollectionCard(tempId)));
                tempId = ContestClientUtil.getContestCollectionCard(tempId).getParent();
            }

            model.addAttribute("collectionHierarchy", collectionHierarchy);


            if(collectionCard == FEATURED_COLLECTION_CARD_ID) {
                showOnlyFeatured = true;
                for (org.xcolab.client.contest.pojo.Contest contest : ContestClientUtil.getAllContests()) {
                    contests.add(new ContestWrapper(contest));
                }
            } else {
                for (org.xcolab.client.contest.pojo.Contest contest : ContestClientUtil
                        .getContestMatchingOntologyTerms(
                                Arrays.asList(ContestClientUtil.getContestCollectionCard(collectionCard)
                                        .getOntology_term_to_load()))) {
                    contests.add(new ContestWrapper(contest));
                }
            }
        }



        //ONLY OUTLINE VIEW

        if (viewType.equals(VIEW_TYPE_OUTLINE)) {
            List<Contest> contestsToWrap = showAllContests ? ContestClientUtil.getContestsByContestTypeId(contestType.getId_()) :
                    ContestClientUtil.getContestsByActivePrivateType(showActiveContests, false, contestType.getId_());
            List<Contest> priorContests = ContestClientUtil.getContestsByActivePrivateType(false, false,
                    contestType.getId_());

            if (contestsToWrap.size() == 1) {
                final Contest contest = contestsToWrap.get(0);
                final String contestLinkUrl = (contest).getContestLinkUrl();
                /*
                try {
                    PortalUtil.getHttpServletResponse(response).sendRedirect(contestLinkUrl);
                    return "contestsIndex"; //won't be shown, but avoid null pointer exception during redirection
                } catch (IOException e) {
                    _log.error("Failed to redirect to only contest in this contest type", e);
                }
                */
            }

            for (Contest contest: contestsToWrap) {
                if (! contest.getContestPrivate()) {
                    try {
                        org.xcolab.client.contest.pojo.Contest contestMicro = ContestClientUtil.getContest(contest.getContestPK());
                        contests.add(new ContestWrapper(contestMicro));//contest
                    }catch (ContestNotFoundException ignored){

                    }
                }
            }
        	List<OntologySpace> ontologySpacesRaw = OntologyClientUtil.getAllOntologySpaces();
        	List<OntologyTerm> ontologyTermsRaw = OntologyClientUtil.getAllOntologyTerms();
        	List<FocusArea> focusAreasRaw = OntologyClientUtil.getAllFocusAreas();
        	List<FocusAreaOntologyTerm> focusAreasOntologyTermsRaw = OntologyClientUtil.getAllFocusAreaOntologyTerms();
        	Map<Long, FocusAreaWrapper> focusAreas = new TreeMap<>();
        	Map<Long, OntologySpaceWrapper> ontologySpaces = new HashMap<>();
        	Map<Long, OntologyTermWrapper> ontologyTerms = new TreeMap<>();
        	
        	for (FocusArea area: focusAreasRaw) {
        		focusAreas.put(area.getId_(), new FocusAreaWrapper(area));
        	}
        	
        	for (OntologySpace space: ontologySpacesRaw) {
        		ontologySpaces.put(space.getId_(), new OntologySpaceWrapper(space));
        	}
        	
        	for (OntologyTerm term: ontologyTermsRaw) {
        		OntologyTermWrapper termWrapped = new OntologyTermWrapper(term);
        		ontologySpaces.get(term.getOntologySpaceId()).addTerm(termWrapped);
        		ontologyTerms.put(term.getId_(), termWrapped);
        	}

        	for (OntologyTerm term: ontologyTermsRaw) {
        		if (term.getParentId() > 0) {
        			ontologyTerms.get(term.getId_()).setParent(ontologyTerms.get(term.getParentId()));
        		}
        	}
        	
        	for (FocusAreaOntologyTerm faTerm: focusAreasOntologyTermsRaw) {
        		focusAreas.get(faTerm.getFocusAreaId()).addOntologyTerm(ontologyTerms.get(faTerm.getOntologyTermId()));
        	}

            List<ContestWrapper> otherContests = new ArrayList<>();
            for (Contest contest: ContestClientUtil
                    .getContestsByActivePrivate(!showActiveContests, false)) {
                try {
                    org.xcolab.client.contest.pojo.Contest contestMicro = ContestClientUtil.getContest(contest.getContestPK());
                    otherContests.add(new ContestWrapper(contestMicro));//contest
                }catch (ContestNotFoundException ignored){

                }
            }
        	List<OntologySpaceWrapper> sortedSpaces = new ArrayList<>(ontologySpaces.values());
        	Collections.sort(sortedSpaces, new Comparator<OntologySpaceWrapper>() {

				@Override
				public int compare(OntologySpaceWrapper o1,
						OntologySpaceWrapper o2) {
					return o1.getOrder() - o2.getOrder();
				}
        		
        	});
        	model.addAttribute("focusAreas", focusAreas.values());
        	model.addAttribute("ontologyTerms", ontologyTerms.values());
        	model.addAttribute("ontologySpaces", sortedSpaces);
        	model.addAttribute("otherContests", otherContests);
        	model.addAttribute("contestType", contestType);
        }


        //Adding attributes to model


        model.addAttribute("collectionCards", new CollectionCardFilterBean(collectionCards));

        //if only featured
        if(ContestClientUtil.getContestCollectionCard(collectionCard).getOntology_term_to_load() != null) {
            model.addAttribute("ontologySpaceId", OntologyClientUtil.getOntologyTerm(ContestClientUtil.getContestCollectionCard(collectionCard).getOntology_term_to_load()).getOntologySpaceId());
        } else {
            model.addAttribute("ontologySpaceId", 0);
        }

        model.addAttribute("contests", contests);
        model.addAttribute("showFilter", contests.size() >= MIN_SIZE_CONTEST_FILTER);
        //model.addAttribute("priorContestsExist", !priorContests.isEmpty());
        model.addAttribute("priorContestsExist", true);
        //hacked
        model.addAttribute("contestsSorted", new ContestsSortFilterBean(showOnlyFeatured, contests, sortFilterPage,
                showActiveContests ? null : ContestsColumn.REFERENCE_DATE));
        model.addAttribute("viewType", viewType);
        model.addAttribute("sortFilterPage", sortFilterPage);
        model.addAttribute("showActiveContests", showActiveContests);
        model.addAttribute("showAllContests", showAllContests);

        //PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();

        boolean showContestManagementLink = PermissionsClient
                .canAdminAll(proposalsContext.getUser(request).getUserId()) ; //permissionChecker.isOmniadmin();
        model.addAttribute("showContestManagementLink", showContestManagementLink);

        model.addAttribute("showContestDisplayOptions",
                ConfigurationAttributeKey.SHOW_CONTESTS_DISPLAY_OPTIONS.get());

        setSeoTexts(request, showAllContests ? "All contests" : showActiveContests ? "Active contests" : "Prior contests", null, null);

        
        return "contestsIndex";
    }

}
