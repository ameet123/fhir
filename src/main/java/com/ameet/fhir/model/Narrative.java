package com.ameet.fhir.model;

public class Narrative {
    private String status;
    private String div;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", div='" + div + '\'' +
                '}';
    }
}
