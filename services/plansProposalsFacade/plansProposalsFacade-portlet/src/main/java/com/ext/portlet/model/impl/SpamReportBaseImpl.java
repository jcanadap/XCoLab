package com.ext.portlet.model.impl;

import com.ext.portlet.model.SpamReport;
import com.ext.portlet.service.SpamReportLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the SpamReport service. Represents a row in the &quot;xcolab_SpamReport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SpamReportImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpamReportImpl
 * @see com.ext.portlet.model.SpamReport
 * @generated
 */
public abstract class SpamReportBaseImpl extends SpamReportModelImpl
    implements SpamReport {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a spam report model instance should use the {@link SpamReport} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SpamReportLocalServiceUtil.addSpamReport(this);
        } else {
            SpamReportLocalServiceUtil.updateSpamReport(this);
        }
    }
}
