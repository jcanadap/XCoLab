package com.ext.portlet.service.impl;

import com.ext.portlet.NoSuchProposalReferenceException;
import com.ext.portlet.PlanSectionTypeKeys;
import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.model.ProposalReference;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.base.ProposalReferenceLocalServiceBaseImpl;
import com.ext.portlet.service.persistence.ProposalReferencePK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import org.apache.commons.lang3.StringUtils;
import org.xcolab.enums.ContestTier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The implementation of the proposal reference local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.service.ProposalReferenceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.ProposalReferenceLocalServiceBaseImpl
 * @see com.ext.portlet.service.ProposalReferenceLocalServiceUtil
 */
public class ProposalReferenceLocalServiceImpl
    extends ProposalReferenceLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.service.ProposalReferenceLocalServiceUtil} to access the proposal reference local service.
     */

    private final static Log _log = LogFactoryUtil.getLog(ProposalReferenceLocalServiceImpl.class);

    public List<ProposalReference> getByProposalId(long proposalId) throws SystemException {
        return proposalReferencePersistence.findByProposalId(proposalId);
    }

    public List<ProposalReference> getBySubProposalId(long subProposalId) throws SystemException {
        return proposalReferencePersistence.findBySubProposalId(subProposalId);
    }

    public void populateTable() throws SystemException, PortalException {

        Set<Long> processedProposals = new HashSet<>();

        List<Contest> contests = new ArrayList<>();
        contests.addAll(ContestLocalServiceUtil.getContestsMatchingTier(ContestTier.GLOBAL.getTierType()));
        contests.addAll(ContestLocalServiceUtil.getContestsMatchingTier(ContestTier.REGION_AGGREGATE.getTierType()));

        _log.debug(String.format("Populating table using %d contests", contests.size()));

        for (Contest contest : contests) {
            for (Proposal proposal : proposalLocalService.getProposalsInContest(contest.getContestPK())) {
                populateTableWithProposal(proposal, processedProposals);
                _log.debug(String.format("Populating table using proposal %d", proposal.getProposalId()));
            }
        }
    }

    public void populateTableWithProposal(Proposal proposal) throws PortalException, SystemException {
        populateTableWithProposal(proposal, new HashSet<Long>());
    }

    private void populateTableWithProposal(Proposal proposal, Set<Long> processedProposals) throws SystemException, PortalException {
        if (processedProposals.contains(proposal.getProposalId())) {
            return;
        }
        processedProposals.add(proposal.getProposalId());
        for (ProposalAttribute attribute : proposalLocalService.getAttributes(proposal.getProposalId())) {
            if (!attribute.getName().equals(ProposalAttributeKeys.SECTION)) {
                continue;
            }
            PlanSectionDefinition psd = planSectionDefinitionLocalService.getPlanSectionDefinition(attribute.getAdditionalId());

            if (StringUtils.isBlank(psd.getType())) {
                continue;
            }

            PlanSectionTypeKeys type = PlanSectionTypeKeys.valueOf(psd.getType());
            Set<Long> subProposalIds = new HashSet<>();
            switch (type) {
                case PROPOSAL_REFERENCE: {
                    final long subProposalId = attribute.getNumericValue();
                    if (subProposalId != 0) {
                        subProposalIds.add(subProposalId);
                        _log.debug(String.format("Found PROPOSAL_REFERENCE for %d", subProposalId));
                    }
                    break;
                }
                case PROPOSAL_LIST_REFERENCE: {
                    if (Validator.isNull(attribute.getStringValue())) {
                        break;
                    }
                    String[] referencedProposals = attribute.getStringValue().split(",");
                    for (String referencedProposal : referencedProposals) {
                        final long subProposalId = Long.parseLong(referencedProposal);
                        subProposalIds.add(subProposalId);
                        _log.debug(String.format("Found PROPOSAL_LIST_REFERENCE for %d", subProposalId));
                    }
                    break;
                }
                case PROPOSAL_LIST_TEXT_REFERENCE: {
                    Pattern proposalLinkPattern = Pattern.compile(
                            "(href=|https?://).*?/plans/-/plans/contestId/(\\d*)/(?:phaseId/\\d*/)?planId/(\\d*)");
                    Matcher m = proposalLinkPattern.matcher(attribute.getStringValue());
                    while (m.find()) {
                        final long subProposalId = Long.parseLong(m.group(3));
                        subProposalIds.add(subProposalId);
                        _log.debug(String.format("Found PROPOSAL_LIST_TEXT_REFERENCE for %d", subProposalId));
                    }
                    break;
                }
            }
            if (subProposalIds.size() > 0) {
                for (long subProposalId : subProposalIds) {
                    addProposalReference(proposal.getProposalId(), subProposalId, attribute.getId());
                    populateTableWithProposal(proposalLocalService.fetchProposal(subProposalId), processedProposals);
                }
            }
        }
    }

    private void addProposalReference(long proposalId, long subProposalId, long sectionAttributeId) throws SystemException {
        ProposalReferencePK proposalReferencePK = new ProposalReferencePK(proposalId, subProposalId);
        try {
            proposalReferencePersistence.findByPrimaryKey(proposalReferencePK);
            _log.debug(String.format("Found ProposalReference with primary key %d, %d", proposalId, subProposalId));
            return;
        } catch (NoSuchProposalReferenceException ignored) { }
        ProposalReference proposalReference = proposalReferencePersistence.create(proposalReferencePK);
        proposalReference.setSectionAttributeId(sectionAttributeId);
        proposalReference.persist();
        _log.debug(String.format("Added ProposalReference for %d, %d, %d", proposalId, subProposalId, sectionAttributeId));
    }
}