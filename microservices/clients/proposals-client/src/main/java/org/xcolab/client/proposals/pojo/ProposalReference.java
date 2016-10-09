/**
 * This class is generated by jOOQ
 */
package org.xcolab.client.proposals.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.core.ParameterizedTypeReference;
import org.xcolab.util.http.client.types.TypeProvider;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProposalReference implements Serializable {

    private static final long serialVersionUID = -599887398;

    public static final TypeProvider<ProposalReference> TYPES =
            new TypeProvider<>(ProposalReference.class,
                    new ParameterizedTypeReference<List<ProposalReference>>() {
                    });

    private Long proposalid;
    private Long subproposalid;
    private Long sectionattributeid;

    public ProposalReference() {}

    public ProposalReference(ProposalReference value) {
        this.proposalid = value.proposalid;
        this.subproposalid = value.subproposalid;
        this.sectionattributeid = value.sectionattributeid;
    }

    public ProposalReference(
        Long proposalid,
        Long subproposalid,
        Long sectionattributeid
    ) {
        this.proposalid = proposalid;
        this.subproposalid = subproposalid;
        this.sectionattributeid = sectionattributeid;
    }

    public Long getProposalId() {
        return this.proposalid;
    }

    public void setProposalId(Long proposalid) {
        this.proposalid = proposalid;
    }

    public Long getSubProposalId() {
        return this.subproposalid;
    }

    public void setSubProposalId(Long subproposalid) {
        this.subproposalid = subproposalid;
    }

    public Long getSectionAttributeId() {
        return this.sectionattributeid;
    }

    public void setSectionAttributeId(Long sectionattributeid) {
        this.sectionattributeid = sectionattributeid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ProposalReference other = (ProposalReference) obj;
        if (proposalid == null) {
            if (other.proposalid != null)
                return false;
        }
        else if (!proposalid.equals(other.proposalid))
            return false;
        if (subproposalid == null) {
            if (other.subproposalid != null)
                return false;
        }
        else if (!subproposalid.equals(other.subproposalid))
            return false;
        if (sectionattributeid == null) {
            if (other.sectionattributeid != null)
                return false;
        }
        else if (!sectionattributeid.equals(other.sectionattributeid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((proposalid == null) ? 0 : proposalid.hashCode());
        result = prime * result + ((subproposalid == null) ? 0 : subproposalid.hashCode());
        result = prime * result + ((sectionattributeid == null) ? 0 : sectionattributeid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ProposalReference (");

        sb.append(proposalid);
        sb.append(", ").append(subproposalid);
        sb.append(", ").append(sectionattributeid);

        sb.append(")");
        return sb.toString();
    }
}