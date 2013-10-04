package com.ext.portlet.model.impl;

import com.ext.portlet.model.Proposal2Phase;
import com.ext.portlet.model.Proposal2PhaseModel;
import com.ext.portlet.model.Proposal2PhaseSoap;
import com.ext.portlet.service.persistence.Proposal2PhasePK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the Proposal2Phase service. Represents a row in the &quot;xcolab_Proposal2Phase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.Proposal2PhaseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Proposal2PhaseImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal2PhaseImpl
 * @see com.ext.portlet.model.Proposal2Phase
 * @see com.ext.portlet.model.Proposal2PhaseModel
 * @generated
 */
@JSON(strict = true)
public class Proposal2PhaseModelImpl extends BaseModelImpl<Proposal2Phase>
    implements Proposal2PhaseModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a proposal2 phase model instance should use the {@link com.ext.portlet.model.Proposal2Phase} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_Proposal2Phase";
    public static final Object[][] TABLE_COLUMNS = {
            { "proposalId", Types.BIGINT },
            { "contestPhaseId", Types.BIGINT },
            { "ribbonTypeId", Types.BIGINT },
            { "versionFrom", Types.INTEGER },
            { "versionTo", Types.INTEGER },
            { "sortWeight", Types.INTEGER },
            { "autopromoteCandidate", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_Proposal2Phase (proposalId LONG not null,contestPhaseId LONG not null,ribbonTypeId LONG,versionFrom INTEGER,versionTo INTEGER,sortWeight INTEGER,autopromoteCandidate BOOLEAN,primary key (proposalId, contestPhaseId))";
    public static final String TABLE_SQL_DROP = "drop table xcolab_Proposal2Phase";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.Proposal2Phase"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.Proposal2Phase"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.Proposal2Phase"),
            true);
    public static long CONTESTPHASEID_COLUMN_BITMASK = 1L;
    public static long PROPOSALID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.Proposal2Phase"));
    private static ClassLoader _classLoader = Proposal2Phase.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            Proposal2Phase.class
        };
    private long _proposalId;
    private long _originalProposalId;
    private boolean _setOriginalProposalId;
    private long _contestPhaseId;
    private long _originalContestPhaseId;
    private boolean _setOriginalContestPhaseId;
    private long _ribbonTypeId;
    private int _versionFrom;
    private int _versionTo;
    private int _sortWeight;
    private boolean _autopromoteCandidate;
    private long _columnBitmask;
    private Proposal2Phase _escapedModelProxy;

    public Proposal2PhaseModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Proposal2Phase toModel(Proposal2PhaseSoap soapModel) {
        Proposal2Phase model = new Proposal2PhaseImpl();

        model.setProposalId(soapModel.getProposalId());
        model.setContestPhaseId(soapModel.getContestPhaseId());
        model.setRibbonTypeId(soapModel.getRibbonTypeId());
        model.setVersionFrom(soapModel.getVersionFrom());
        model.setVersionTo(soapModel.getVersionTo());
        model.setSortWeight(soapModel.getSortWeight());
        model.setAutopromoteCandidate(soapModel.getAutopromoteCandidate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Proposal2Phase> toModels(Proposal2PhaseSoap[] soapModels) {
        List<Proposal2Phase> models = new ArrayList<Proposal2Phase>(soapModels.length);

        for (Proposal2PhaseSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public Proposal2PhasePK getPrimaryKey() {
        return new Proposal2PhasePK(_proposalId, _contestPhaseId);
    }

    public void setPrimaryKey(Proposal2PhasePK primaryKey) {
        setProposalId(primaryKey.proposalId);
        setContestPhaseId(primaryKey.contestPhaseId);
    }

    public Serializable getPrimaryKeyObj() {
        return new Proposal2PhasePK(_proposalId, _contestPhaseId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((Proposal2PhasePK) primaryKeyObj);
    }

    public Class<?> getModelClass() {
        return Proposal2Phase.class;
    }

    public String getModelClassName() {
        return Proposal2Phase.class.getName();
    }

    @JSON
    public long getProposalId() {
        return _proposalId;
    }

    public void setProposalId(long proposalId) {
        _columnBitmask |= PROPOSALID_COLUMN_BITMASK;

        if (!_setOriginalProposalId) {
            _setOriginalProposalId = true;

            _originalProposalId = _proposalId;
        }

        _proposalId = proposalId;
    }

    public long getOriginalProposalId() {
        return _originalProposalId;
    }

    @JSON
    public long getContestPhaseId() {
        return _contestPhaseId;
    }

    public void setContestPhaseId(long contestPhaseId) {
        _columnBitmask |= CONTESTPHASEID_COLUMN_BITMASK;

        if (!_setOriginalContestPhaseId) {
            _setOriginalContestPhaseId = true;

            _originalContestPhaseId = _contestPhaseId;
        }

        _contestPhaseId = contestPhaseId;
    }

    public long getOriginalContestPhaseId() {
        return _originalContestPhaseId;
    }

    @JSON
    public long getRibbonTypeId() {
        return _ribbonTypeId;
    }

    public void setRibbonTypeId(long ribbonTypeId) {
        _ribbonTypeId = ribbonTypeId;
    }

    @JSON
    public int getVersionFrom() {
        return _versionFrom;
    }

    public void setVersionFrom(int versionFrom) {
        _versionFrom = versionFrom;
    }

    @JSON
    public int getVersionTo() {
        return _versionTo;
    }

    public void setVersionTo(int versionTo) {
        _versionTo = versionTo;
    }

    @JSON
    public int getSortWeight() {
        return _sortWeight;
    }

    public void setSortWeight(int sortWeight) {
        _sortWeight = sortWeight;
    }

    @JSON
    public boolean getAutopromoteCandidate() {
        return _autopromoteCandidate;
    }

    public boolean isAutopromoteCandidate() {
        return _autopromoteCandidate;
    }

    public void setAutopromoteCandidate(boolean autopromoteCandidate) {
        _autopromoteCandidate = autopromoteCandidate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public Proposal2Phase toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (Proposal2Phase) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        Proposal2PhaseImpl proposal2PhaseImpl = new Proposal2PhaseImpl();

        proposal2PhaseImpl.setProposalId(getProposalId());
        proposal2PhaseImpl.setContestPhaseId(getContestPhaseId());
        proposal2PhaseImpl.setRibbonTypeId(getRibbonTypeId());
        proposal2PhaseImpl.setVersionFrom(getVersionFrom());
        proposal2PhaseImpl.setVersionTo(getVersionTo());
        proposal2PhaseImpl.setSortWeight(getSortWeight());
        proposal2PhaseImpl.setAutopromoteCandidate(getAutopromoteCandidate());

        proposal2PhaseImpl.resetOriginalValues();

        return proposal2PhaseImpl;
    }

    public int compareTo(Proposal2Phase proposal2Phase) {
        Proposal2PhasePK primaryKey = proposal2Phase.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Proposal2Phase proposal2Phase = null;

        try {
            proposal2Phase = (Proposal2Phase) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        Proposal2PhasePK primaryKey = proposal2Phase.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
        Proposal2PhaseModelImpl proposal2PhaseModelImpl = this;

        proposal2PhaseModelImpl._originalProposalId = proposal2PhaseModelImpl._proposalId;

        proposal2PhaseModelImpl._setOriginalProposalId = false;

        proposal2PhaseModelImpl._originalContestPhaseId = proposal2PhaseModelImpl._contestPhaseId;

        proposal2PhaseModelImpl._setOriginalContestPhaseId = false;

        proposal2PhaseModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Proposal2Phase> toCacheModel() {
        Proposal2PhaseCacheModel proposal2PhaseCacheModel = new Proposal2PhaseCacheModel();

        proposal2PhaseCacheModel.proposalId = getProposalId();

        proposal2PhaseCacheModel.contestPhaseId = getContestPhaseId();

        proposal2PhaseCacheModel.ribbonTypeId = getRibbonTypeId();

        proposal2PhaseCacheModel.versionFrom = getVersionFrom();

        proposal2PhaseCacheModel.versionTo = getVersionTo();

        proposal2PhaseCacheModel.sortWeight = getSortWeight();

        proposal2PhaseCacheModel.autopromoteCandidate = getAutopromoteCandidate();

        return proposal2PhaseCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{proposalId=");
        sb.append(getProposalId());
        sb.append(", contestPhaseId=");
        sb.append(getContestPhaseId());
        sb.append(", ribbonTypeId=");
        sb.append(getRibbonTypeId());
        sb.append(", versionFrom=");
        sb.append(getVersionFrom());
        sb.append(", versionTo=");
        sb.append(getVersionTo());
        sb.append(", sortWeight=");
        sb.append(getSortWeight());
        sb.append(", autopromoteCandidate=");
        sb.append(getAutopromoteCandidate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.Proposal2Phase");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>proposalId</column-name><column-value><![CDATA[");
        sb.append(getProposalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestPhaseId</column-name><column-value><![CDATA[");
        sb.append(getContestPhaseId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ribbonTypeId</column-name><column-value><![CDATA[");
        sb.append(getRibbonTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>versionFrom</column-name><column-value><![CDATA[");
        sb.append(getVersionFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>versionTo</column-name><column-value><![CDATA[");
        sb.append(getVersionTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sortWeight</column-name><column-value><![CDATA[");
        sb.append(getSortWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>autopromoteCandidate</column-name><column-value><![CDATA[");
        sb.append(getAutopromoteCandidate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
