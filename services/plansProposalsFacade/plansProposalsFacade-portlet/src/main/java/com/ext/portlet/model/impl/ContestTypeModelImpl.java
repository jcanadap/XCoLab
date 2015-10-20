package com.ext.portlet.model.impl;

import com.ext.portlet.model.ContestType;
import com.ext.portlet.model.ContestTypeModel;
import com.ext.portlet.model.ContestTypeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ContestType service. Represents a row in the &quot;xcolab_ContestType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ContestTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContestTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestTypeImpl
 * @see com.ext.portlet.model.ContestType
 * @see com.ext.portlet.model.ContestTypeModel
 * @generated
 */
@JSON(strict = true)
public class ContestTypeModelImpl extends BaseModelImpl<ContestType>
    implements ContestTypeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contest type model instance should use the {@link com.ext.portlet.model.ContestType} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ContestType";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "contestName", Types.VARCHAR },
            { "proposalName", Types.VARCHAR },
            { "proposalNamePlural", Types.VARCHAR },
            { "hasDiscussion", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ContestType (id_ LONG not null primary key,contestName VARCHAR(75) null,proposalName VARCHAR(75) null,proposalNamePlural VARCHAR(75) null,hasDiscussion BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ContestType";
    public static final String ORDER_BY_JPQL = " ORDER BY contestType.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ContestType.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ContestType"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ContestType"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ContestType"));
    private static ClassLoader _classLoader = ContestType.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ContestType.class
        };
    private long _id;
    private String _contestName;
    private String _proposalName;
    private String _proposalNamePlural;
    private boolean _hasDiscussion;
    private ContestType _escapedModel;

    public ContestTypeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ContestType toModel(ContestTypeSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ContestType model = new ContestTypeImpl();

        model.setId(soapModel.getId());
        model.setContestName(soapModel.getContestName());
        model.setProposalName(soapModel.getProposalName());
        model.setProposalNamePlural(soapModel.getProposalNamePlural());
        model.setHasDiscussion(soapModel.getHasDiscussion());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ContestType> toModels(ContestTypeSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ContestType> models = new ArrayList<ContestType>(soapModels.length);

        for (ContestTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ContestType.class;
    }

    @Override
    public String getModelClassName() {
        return ContestType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("contestName", getContestName());
        attributes.put("proposalName", getProposalName());
        attributes.put("proposalNamePlural", getProposalNamePlural());
        attributes.put("hasDiscussion", getHasDiscussion());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String contestName = (String) attributes.get("contestName");

        if (contestName != null) {
            setContestName(contestName);
        }

        String proposalName = (String) attributes.get("proposalName");

        if (proposalName != null) {
            setProposalName(proposalName);
        }

        String proposalNamePlural = (String) attributes.get(
                "proposalNamePlural");

        if (proposalNamePlural != null) {
            setProposalNamePlural(proposalNamePlural);
        }

        Boolean hasDiscussion = (Boolean) attributes.get("hasDiscussion");

        if (hasDiscussion != null) {
            setHasDiscussion(hasDiscussion);
        }
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @JSON
    @Override
    public String getContestName() {
        if (_contestName == null) {
            return StringPool.BLANK;
        } else {
            return _contestName;
        }
    }

    @Override
    public void setContestName(String contestName) {
        _contestName = contestName;
    }

    @JSON
    @Override
    public String getProposalName() {
        if (_proposalName == null) {
            return StringPool.BLANK;
        } else {
            return _proposalName;
        }
    }

    @Override
    public void setProposalName(String proposalName) {
        _proposalName = proposalName;
    }

    @JSON
    @Override
    public String getProposalNamePlural() {
        if (_proposalNamePlural == null) {
            return StringPool.BLANK;
        } else {
            return _proposalNamePlural;
        }
    }

    @Override
    public void setProposalNamePlural(String proposalNamePlural) {
        _proposalNamePlural = proposalNamePlural;
    }

    @JSON
    @Override
    public boolean getHasDiscussion() {
        return _hasDiscussion;
    }

    @Override
    public boolean isHasDiscussion() {
        return _hasDiscussion;
    }

    @Override
    public void setHasDiscussion(boolean hasDiscussion) {
        _hasDiscussion = hasDiscussion;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ContestType.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ContestType toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ContestType) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ContestTypeImpl contestTypeImpl = new ContestTypeImpl();

        contestTypeImpl.setId(getId());
        contestTypeImpl.setContestName(getContestName());
        contestTypeImpl.setProposalName(getProposalName());
        contestTypeImpl.setProposalNamePlural(getProposalNamePlural());
        contestTypeImpl.setHasDiscussion(getHasDiscussion());

        contestTypeImpl.resetOriginalValues();

        return contestTypeImpl;
    }

    @Override
    public int compareTo(ContestType contestType) {
        long primaryKey = contestType.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContestType)) {
            return false;
        }

        ContestType contestType = (ContestType) obj;

        long primaryKey = contestType.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<ContestType> toCacheModel() {
        ContestTypeCacheModel contestTypeCacheModel = new ContestTypeCacheModel();

        contestTypeCacheModel.id = getId();

        contestTypeCacheModel.contestName = getContestName();

        String contestName = contestTypeCacheModel.contestName;

        if ((contestName != null) && (contestName.length() == 0)) {
            contestTypeCacheModel.contestName = null;
        }

        contestTypeCacheModel.proposalName = getProposalName();

        String proposalName = contestTypeCacheModel.proposalName;

        if ((proposalName != null) && (proposalName.length() == 0)) {
            contestTypeCacheModel.proposalName = null;
        }

        contestTypeCacheModel.proposalNamePlural = getProposalNamePlural();

        String proposalNamePlural = contestTypeCacheModel.proposalNamePlural;

        if ((proposalNamePlural != null) && (proposalNamePlural.length() == 0)) {
            contestTypeCacheModel.proposalNamePlural = null;
        }

        contestTypeCacheModel.hasDiscussion = getHasDiscussion();

        return contestTypeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", contestName=");
        sb.append(getContestName());
        sb.append(", proposalName=");
        sb.append(getProposalName());
        sb.append(", proposalNamePlural=");
        sb.append(getProposalNamePlural());
        sb.append(", hasDiscussion=");
        sb.append(getHasDiscussion());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ContestType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestName</column-name><column-value><![CDATA[");
        sb.append(getContestName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>proposalName</column-name><column-value><![CDATA[");
        sb.append(getProposalName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>proposalNamePlural</column-name><column-value><![CDATA[");
        sb.append(getProposalNamePlural());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasDiscussion</column-name><column-value><![CDATA[");
        sb.append(getHasDiscussion());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
