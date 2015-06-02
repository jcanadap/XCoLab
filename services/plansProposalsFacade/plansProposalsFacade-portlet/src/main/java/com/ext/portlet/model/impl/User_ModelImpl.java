package com.ext.portlet.model.impl;

import com.ext.portlet.model.User_;
import com.ext.portlet.model.User_Model;
import com.ext.portlet.model.User_Soap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the User_ service. Represents a row in the &quot;xcolab_User_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.User_Model} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link User_Impl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see User_Impl
 * @see com.ext.portlet.model.User_
 * @see com.ext.portlet.model.User_Model
 * @generated
 */
@JSON(strict = true)
public class User_ModelImpl extends BaseModelImpl<User_> implements User_Model {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a user_ model instance should use the {@link com.ext.portlet.model.User_} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_User_";
    public static final Object[][] TABLE_COLUMNS = {
            { "userId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "screenName", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_User_ (userId LONG not null primary key,createDate DATE null,screenName VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_User_";
    public static final String ORDER_BY_JPQL = " ORDER BY user_.userId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_User_.userId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.User_"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.User_"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.User_"),
            true);
    public static long USERID_COLUMN_BITMASK = 1L;
    public static final String MAPPING_TABLE_XCOLAB_USERS_ROLES_NAME = "xcolab_Users_Roles";
    public static final Object[][] MAPPING_TABLE_XCOLAB_USERS_ROLES_COLUMNS = {
            { "userId", Types.BIGINT },
            { "roleId", Types.BIGINT }
        };
    public static final String MAPPING_TABLE_XCOLAB_USERS_ROLES_SQL_CREATE = "create table xcolab_Users_Roles (roleId LONG not null,userId LONG not null,primary key (roleId, userId))";
    public static final boolean FINDER_CACHE_ENABLED_XCOLAB_USERS_ROLES = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.xcolab_Users_Roles"), true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.User_"));
    private static ClassLoader _classLoader = User_.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { User_.class };
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private Date _createDate;
    private String _screenName;
    private long _columnBitmask;
    private User_ _escapedModel;

    public User_ModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static User_ toModel(User_Soap soapModel) {
        if (soapModel == null) {
            return null;
        }

        User_ model = new User_Impl();

        model.setUserId(soapModel.getUserId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setScreenName(soapModel.getScreenName());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<User_> toModels(User_Soap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<User_> models = new ArrayList<User_>(soapModels.length);

        for (User_Soap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _userId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setUserId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _userId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return User_.class;
    }

    @Override
    public String getModelClassName() {
        return User_.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("screenName", getScreenName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        String screenName = (String) attributes.get("screenName");

        if (screenName != null) {
            setScreenName(screenName);
        }
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getOriginalUserId() {
        return _originalUserId;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public String getScreenName() {
        if (_screenName == null) {
            return StringPool.BLANK;
        } else {
            return _screenName;
        }
    }

    @Override
    public void setScreenName(String screenName) {
        _screenName = screenName;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            User_.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public User_ toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (User_) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        User_Impl user_Impl = new User_Impl();

        user_Impl.setUserId(getUserId());
        user_Impl.setCreateDate(getCreateDate());
        user_Impl.setScreenName(getScreenName());

        user_Impl.resetOriginalValues();

        return user_Impl;
    }

    @Override
    public int compareTo(User_ user_) {
        long primaryKey = user_.getPrimaryKey();

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

        if (!(obj instanceof User_)) {
            return false;
        }

        User_ user_ = (User_) obj;

        long primaryKey = user_.getPrimaryKey();

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
        User_ModelImpl user_ModelImpl = this;

        user_ModelImpl._originalUserId = user_ModelImpl._userId;

        user_ModelImpl._setOriginalUserId = false;

        user_ModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<User_> toCacheModel() {
        User_CacheModel user_CacheModel = new User_CacheModel();

        user_CacheModel.userId = getUserId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            user_CacheModel.createDate = createDate.getTime();
        } else {
            user_CacheModel.createDate = Long.MIN_VALUE;
        }

        user_CacheModel.screenName = getScreenName();

        String screenName = user_CacheModel.screenName;

        if ((screenName != null) && (screenName.length() == 0)) {
            user_CacheModel.screenName = null;
        }

        return user_CacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", screenName=");
        sb.append(getScreenName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.User_");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>screenName</column-name><column-value><![CDATA[");
        sb.append(getScreenName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}