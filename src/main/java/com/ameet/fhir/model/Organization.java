package com.ameet.fhir.model;

import java.util.Arrays;

public class Organization extends FhireParent {
    private Identifier[] identifier;
    private String name;

    public Organization() {
        this.setResourceType("Organization");
    }

    public Identifier[] getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier[] identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tidentifier=" + Arrays.toString(identifier) +
                ",\n\tname='" + name + '\'' +
                ",\n\tresourceType='" + resourceType + '\'' +
                ",\n\tid='" + id + '\'' +
                ",\n\tmeta='" + meta + '\'' +
                ",\n\timplicitRules='" + implicitRules + '\'' +
                ",\n\tlanguage='" + language + '\'' +
                ",\n\ttext=" + text  +
                ",\n\tcontained='" + contained + '\'' +
                "\n}";
    }
}
