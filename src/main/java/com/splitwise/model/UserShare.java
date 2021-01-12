package com.splitwise.model;

import java.util.Map;

public class UserShare {

    private String emailId;
    private Map<String, Double> particularUserShare;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Map<String, Double> getParticularUserShare() {
        return particularUserShare;
    }

    public void setParticularUserShare(Map<String, Double> particularUserShare) {
        this.particularUserShare = particularUserShare;
    }

    public UserShare(String emailId, Map<String, Double> particularUserShare) {
        this.emailId = emailId;
        this.particularUserShare = particularUserShare;
    }

    public UserShare() {
    }
}
