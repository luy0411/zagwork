package com.zagwork.test.interest.microservice.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class InterestData {

    private Long id;
    private Long userId;
    private String riskType;
    private Float limit;
    private Float interestPercent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    private Date date;

    public InterestData() {
    }

    public InterestData(Long id, Long userId, String riskType, Float limit, Float interestPercent, Date date) {
        this.id = id;
        this.userId = userId;
        this.riskType = riskType;
        this.limit = limit;
        this.interestPercent = interestPercent;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public Float getLimit() {
        return limit;
    }

    public void setLimit(Float limit) {
        this.limit = limit;
    }

    public Float getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(Float interestPercent) {
        this.interestPercent = interestPercent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterestData that = (InterestData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(riskType, that.riskType) &&
                Objects.equals(limit, that.limit) &&
                Objects.equals(interestPercent, that.interestPercent) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, riskType, limit, interestPercent, date);
    }
}
