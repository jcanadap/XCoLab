package com.ext.portlet.service.base;

import com.ext.portlet.service.PlanFanServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlanFanServiceClpInvoker {
    private String _methodName586;
    private String[] _methodParameterTypes586;
    private String _methodName587;
    private String[] _methodParameterTypes587;

    public PlanFanServiceClpInvoker() {
        _methodName586 = "getBeanIdentifier";

        _methodParameterTypes586 = new String[] {  };

        _methodName587 = "setBeanIdentifier";

        _methodParameterTypes587 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName586.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes586, parameterTypes)) {
            return PlanFanServiceUtil.getBeanIdentifier();
        }

        if (_methodName587.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes587, parameterTypes)) {
            PlanFanServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
