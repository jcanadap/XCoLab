package com.ext.portlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.service.http.ContestTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.http.ContestTypeServiceSoap
 * @generated
 */
public class ContestTypeSoap implements Serializable {
    private long _id;
    private String _contestName;
    private String _proposalName;
    private String _proposalNamePlural;
    private boolean _hasDiscussion;

    public ContestTypeSoap() {
    }

    public static ContestTypeSoap toSoapModel(ContestType model) {
        ContestTypeSoap soapModel = new ContestTypeSoap();

        soapModel.setId(model.getId());
        soapModel.setContestName(model.getContestName());
        soapModel.setProposalName(model.getProposalName());
        soapModel.setProposalNamePlural(model.getProposalNamePlural());
        soapModel.setHasDiscussion(model.getHasDiscussion());

        return soapModel;
    }

    public static ContestTypeSoap[] toSoapModels(ContestType[] models) {
        ContestTypeSoap[] soapModels = new ContestTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContestTypeSoap[][] toSoapModels(ContestType[][] models) {
        ContestTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContestTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new ContestTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContestTypeSoap[] toSoapModels(List<ContestType> models) {
        List<ContestTypeSoap> soapModels = new ArrayList<ContestTypeSoap>(models.size());

        for (ContestType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContestTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getContestName() {
        return _contestName;
    }

    public void setContestName(String contestName) {
        _contestName = contestName;
    }

    public String getProposalName() {
        return _proposalName;
    }

    public void setProposalName(String proposalName) {
        _proposalName = proposalName;
    }

    public String getProposalNamePlural() {
        return _proposalNamePlural;
    }

    public void setProposalNamePlural(String proposalNamePlural) {
        _proposalNamePlural = proposalNamePlural;
    }

    public boolean getHasDiscussion() {
        return _hasDiscussion;
    }

    public boolean isHasDiscussion() {
        return _hasDiscussion;
    }

    public void setHasDiscussion(boolean hasDiscussion) {
        _hasDiscussion = hasDiscussion;
    }
}
