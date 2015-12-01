package com.ext.portlet.model.impl;

import com.ext.portlet.model.ContestType;
import com.ext.portlet.service.ContestTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ContestType service. Represents a row in the &quot;xcolab_ContestType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContestTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestTypeImpl
 * @see com.ext.portlet.model.ContestType
 * @generated
 */
public abstract class ContestTypeBaseImpl extends ContestTypeModelImpl
    implements ContestType {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contest type model instance should use the {@link ContestType} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContestTypeLocalServiceUtil.addContestType(this);
        } else {
            ContestTypeLocalServiceUtil.updateContestType(this);
        }
    }
}