package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ProposalAttribute. This utility wraps
 * {@link com.ext.portlet.service.impl.ProposalAttributeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProposalAttributeLocalService
 * @see com.ext.portlet.service.base.ProposalAttributeLocalServiceBaseImpl
 * @see com.ext.portlet.service.impl.ProposalAttributeLocalServiceImpl
 * @generated
 */
public class ProposalAttributeLocalServiceUtil {
    private static ProposalAttributeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.ProposalAttributeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the proposal attribute to the database. Also notifies the appropriate model listeners.
    *
    * @param proposalAttribute the proposal attribute
    * @return the proposal attribute that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalAttribute addProposalAttribute(
        com.ext.portlet.model.ProposalAttribute proposalAttribute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addProposalAttribute(proposalAttribute);
    }

    /**
    * Creates a new proposal attribute with the primary key. Does not add the proposal attribute to the database.
    *
    * @param id the primary key for the new proposal attribute
    * @return the new proposal attribute
    */
    public static com.ext.portlet.model.ProposalAttribute createProposalAttribute(
        long id) {
        return getService().createProposalAttribute(id);
    }

    /**
    * Deletes the proposal attribute with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the proposal attribute
    * @return the proposal attribute that was removed
    * @throws PortalException if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalAttribute deleteProposalAttribute(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteProposalAttribute(id);
    }

    /**
    * Deletes the proposal attribute from the database. Also notifies the appropriate model listeners.
    *
    * @param proposalAttribute the proposal attribute
    * @return the proposal attribute that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalAttribute deleteProposalAttribute(
        com.ext.portlet.model.ProposalAttribute proposalAttribute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteProposalAttribute(proposalAttribute);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.ext.portlet.model.ProposalAttribute fetchProposalAttribute(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchProposalAttribute(id);
    }

    /**
    * Returns the proposal attribute with the primary key.
    *
    * @param id the primary key of the proposal attribute
    * @return the proposal attribute
    * @throws PortalException if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalAttribute getProposalAttribute(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getProposalAttribute(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the proposal attributes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @return the range of proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ProposalAttribute> getProposalAttributes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getProposalAttributes(start, end);
    }

    /**
    * Returns the number of proposal attributes.
    *
    * @return the number of proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public static int getProposalAttributesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getProposalAttributesCount();
    }

    /**
    * Updates the proposal attribute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param proposalAttribute the proposal attribute
    * @return the proposal attribute that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ProposalAttribute updateProposalAttribute(
        com.ext.portlet.model.ProposalAttribute proposalAttribute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateProposalAttribute(proposalAttribute);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.ext.portlet.model.ProposalAttribute getAttribute(
        long proposalId, int version, java.lang.String attributeName,
        long additionalId)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAttribute(proposalId, version, attributeName,
            additionalId);
    }

    /**
    * <p>Returns an attribute for current version of a proposal.</p>
    */
    public static com.ext.portlet.model.ProposalAttribute getAttribute(
        long proposalId, java.lang.String attributeName, long additionalId)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAttribute(proposalId, attributeName, additionalId);
    }

    /**
    * <p>Sets attribute value and creates new version for a proposal that reflects the change</p>
    * <p>The algorithm for setting an attribute value is as follows:</p>
    * <ol>
    * <li>new proposal version is created</li>
    * <li>for each attribute that was already present in the proposal (excluding the one that is currently being set)
    * it is copied to the new version</li>
    * <li>for attribute that is being set it's value (if present) isn't copied to the new version as it gets new value</li>
    * </ol>
    *
    * @return ProposalAttribute that represents newly set attribute
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        long additionalId, java.lang.String stringValue, long numericValue,
        double realValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            additionalId, stringValue, numericValue, realValue);
    }

    /**
    * <p>Sets attribute value and creates new version for a proposal that reflects the change</p>
    * <p>The algorithm for setting an attribute value is as follows:</p>
    * <ol>
    * <li>new proposal version is created</li>
    * <li>for each attribute that was already present in the proposal (excluding the one that is currently being set)
    * it is copied to the new version</li>
    * <li>for attribute that is being set it's value (if present) isn't copied to the new version as it gets new val`ue</li>
    * </ol>
    *
    * @return ProposalAttribute that represents newly set attribute
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        long additionalId, java.lang.String stringValue, long numericValue,
        double realValue, java.util.Date updatedDate, boolean publishActivity)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            additionalId, stringValue, numericValue, realValue, updatedDate,
            publishActivity);
    }

    /**
    * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)}
    * it uses nulls/zeros for unspecified values</p>
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        java.lang.String stringValue, long numericValue, double realValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            stringValue, numericValue, realValue);
    }

    /**
    * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)}
    * it uses nulls/zeros for unspecified values</p>
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        long additionalId, java.lang.String stringValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            additionalId, stringValue);
    }

    /**
    * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)}
    * it uses nulls/zeros for unspecified values</p>
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        java.lang.String stringValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            stringValue);
    }

    /**
    * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)}
    * it uses nulls/zeros for unspecified values</p>
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        long additionalId, long numericValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            additionalId, numericValue);
    }

    /**
    * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)}
    * it uses nulls/zeros for unspecified values</p>
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        long numericValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            numericValue);
    }

    /**
    * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)}
    * it uses nulls/zeros for unspecified values</p>
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        long additionalId, double realValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName,
            additionalId, realValue);
    }

    /**
    * <p>Sets an attribute for a proposal. See  {@link #setAttribute(long, long, String, long, String, long, double)}
    * it uses nulls/zeros for unspecified values</p>
    */
    public static com.ext.portlet.model.ProposalAttribute setAttribute(
        long authorId, long proposalId, java.lang.String attributeName,
        double realValue)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setAttribute(authorId, proposalId, attributeName, realValue);
    }

    /**
    * <p>Returns all attributes for current version of a proposal.</p>
    */
    public static java.util.List<com.ext.portlet.model.ProposalAttribute> getAttributes(
        long proposalId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAttributes(proposalId);
    }

    /**
    * <p>Returns all attributes for given version of a proposal.</p>
    */
    public static java.util.List<com.ext.portlet.model.ProposalAttribute> getAttributes(
        long proposalId, int version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAttributes(proposalId, version);
    }

    /**
    * <p>Removes a proposal attribute. All other proposal attributes in the current version are being promoted to the next version.</p>
    */
    public static void removeAttribute(long authorId,
        com.ext.portlet.model.ProposalAttribute attributeToDelete,
        boolean publishActivity)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService()
            .removeAttribute(authorId, attributeToDelete, publishActivity);
    }

    /**
    * <p>Removes a proposal attribute. This method is currently only used for the Proposal impact feature to delete already saved proposal impact serieses.</p>
    */
    public static void removeAttribute(long authorId,
        com.ext.portlet.model.ProposalAttribute attributeToDelete)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removeAttribute(authorId, attributeToDelete);
    }

    public static java.util.List<com.ext.portlet.model.ProposalAttribute> getImpactProposalAttributes(
        com.ext.portlet.model.Proposal proposal)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getImpactProposalAttributes(proposal);
    }

    public static java.util.List<com.ext.portlet.model.ProposalAttribute> getImpactProposalAttributes(
        com.ext.portlet.model.Proposal proposal,
        com.ext.portlet.model.FocusArea focusArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getImpactProposalAttributes(proposal, focusArea);
    }

    public static void clearService() {
        _service = null;
    }

    public static ProposalAttributeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ProposalAttributeLocalService.class.getName());

            if (invokableLocalService instanceof ProposalAttributeLocalService) {
                _service = (ProposalAttributeLocalService) invokableLocalService;
            } else {
                _service = new ProposalAttributeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ProposalAttributeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ProposalAttributeLocalService service) {
    }
}
