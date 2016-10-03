/**
 * This class is generated by jOOQ
 */
package org.xcolab.client.contest.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FocusArea implements Serializable {

    public static final TypeProvider<FocusArea> TYPES = new TypeProvider<>(FocusArea.class,
            new ParameterizedTypeReference<List<FocusArea>>() {
            });

    private static final long serialVersionUID = -650199900;

    private Long    id_;
    private String  name;
    private Integer order_;

    public FocusArea() {}

    public FocusArea(FocusArea value) {
        this.id_ = value.id_;
        this.name = value.name;
        this.order_ = value.order_;
    }

    public FocusArea(
        Long    id_,
        String  name,
        Integer order_
    ) {
        this.id_ = id_;
        this.name = name;
        this.order_ = order_;
    }

    public Long getId_() {
        return this.id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder_() {
        return this.order_;
    }

    public void setOrder_(Integer order_) {
        this.order_ = order_;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final FocusArea other = (FocusArea) obj;
        if (id_ == null) {
            if (other.id_ != null)
                return false;
        }
        else if (!id_.equals(other.id_))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (order_ == null) {
            if (other.order_ != null)
                return false;
        }
        else if (!order_.equals(other.order_))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_ == null) ? 0 : id_.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((order_ == null) ? 0 : order_.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FocusArea (");

        sb.append(id_);
        sb.append(", ").append(name);
        sb.append(", ").append(order_);

        sb.append(")");
        return sb.toString();
    }
}
