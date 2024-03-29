package com.ameet.fhir.model;

public class Meta {
    private String versionId;
    private String lastUpdated;

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "{" +
                "versionId='" + versionId + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
