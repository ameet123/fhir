package com.ameet.fhir.model;

public class FhireParent {
    // from resource
    protected String resourceType;
    protected String id;
    protected Meta meta;
    protected String implicitRules;
    protected String language;
    // from domain
    protected Narrative text;
    protected String contained;

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getImplicitRules() {
        return implicitRules;
    }

    public void setImplicitRules(String implicitRules) {
        this.implicitRules = implicitRules;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Narrative getText() {
        return text;
    }

    public void setText(Narrative text) {
        this.text = text;
    }

    public String getContained() {
        return contained;
    }

    public void setContained(String contained) {
        this.contained = contained;
    }
}
