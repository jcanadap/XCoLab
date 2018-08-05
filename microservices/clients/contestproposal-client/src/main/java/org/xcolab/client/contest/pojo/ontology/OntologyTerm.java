package org.xcolab.client.contest.pojo.ontology;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.xcolab.util.http.client.enums.ServiceNamespace;

import java.util.ArrayList;
import java.util.List;

public class OntologyTerm extends AbstractOntologyTerm {

    public OntologyTerm() {}

    public OntologyTerm(OntologyTerm value) {
        super(value);
    }

    public OntologyTerm(Long id, Long parentid, Long ontologyspaceid, String name,
            String descriptionurl, Integer order_) {
        super(id, parentid, ontologyspaceid, name, descriptionurl, order_);
    }

    public OntologyTerm(AbstractOntologyTerm abstractOntologyTerm, ServiceNamespace serviceNamespace) {
        super(abstractOntologyTerm);
    }

    @JsonIgnore
    public Long getId() {
        return getId();
    }

    private OntologyTerm parent;
    private final List<OntologyTerm> children = new ArrayList<>();


    public OntologyTerm getParent() {
        return parent;
    }

    public void setParent(OntologyTerm parent) {
        if (parent != null) {
            this.parent = parent;
            parent.children.add(this);
        }
    }

    public List<OntologyTerm> getChildren() {
        return children;
    }



    public boolean hasParent() {
        return this.getParentId() > 0;
    }


    public int getOrder() {
        return this.getOrder_();
    }
}
