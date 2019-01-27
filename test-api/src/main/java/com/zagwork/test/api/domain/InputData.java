package com.zagwork.test.api.domain;

public class InputData {

    private String username;
    private String risk;
    private Double limit;

    public InputData() {
    }

    public InputData(String username, String risk, Double limit) {
        this.username = username;
        this.risk = risk;
        this.limit = limit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InputData{");
        sb.append("username='").append(username).append('\'');
        sb.append(", risk='").append(risk).append('\'');
        sb.append(", limit=").append(limit);
        sb.append('}');
        return sb.toString();
    }
}
