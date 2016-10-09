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
public class ProposalRatingValue implements Serializable {

    private static final long serialVersionUID = 1025084186;

    public static final TypeProvider<ProposalRatingValue> TYPES =
            new TypeProvider<>(ProposalRatingValue.class,
                    new ParameterizedTypeReference<List<ProposalRatingValue>>() {
                    });
    private Long   id_;
    private Long   ratingtypeid;
    private Long   value;
    private String name;
    private String description;

    public ProposalRatingValue() {}

    public ProposalRatingValue(ProposalRatingValue value) {
        this.id_ = value.id_;
        this.ratingtypeid = value.ratingtypeid;
        this.value = value.value;
        this.name = value.name;
        this.description = value.description;
    }

    public ProposalRatingValue(
        Long   id_,
        Long   ratingtypeid,
        Long   value,
        String name,
        String description
    ) {
        this.id_ = id_;
        this.ratingtypeid = ratingtypeid;
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public Long getId_() {
        return this.id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public Long getRatingTypeId() {
        return this.ratingtypeid;
    }

    public void setRatingTypeId(Long ratingtypeid) {
        this.ratingtypeid = ratingtypeid;
    }

    public Long getValue() {
        return this.value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ProposalRatingValue other = (ProposalRatingValue) obj;
        if (id_ == null) {
            if (other.id_ != null)
                return false;
        }
        else if (!id_.equals(other.id_))
            return false;
        if (ratingtypeid == null) {
            if (other.ratingtypeid != null)
                return false;
        }
        else if (!ratingtypeid.equals(other.ratingtypeid))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        }
        else if (!value.equals(other.value))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_ == null) ? 0 : id_.hashCode());
        result = prime * result + ((ratingtypeid == null) ? 0 : ratingtypeid.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ProposalRatingValue (");

        sb.append(id_);
        sb.append(", ").append(ratingtypeid);
        sb.append(", ").append(value);
        sb.append(", ").append(name);
        sb.append(", ").append(description);

        sb.append(")");
        return sb.toString();
    }
}