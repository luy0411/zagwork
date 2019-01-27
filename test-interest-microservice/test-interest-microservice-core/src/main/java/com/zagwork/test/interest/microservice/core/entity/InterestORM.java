package com.zagwork.test.interest.microservice.core.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="interest")
@EntityListeners(AuditingEntityListener.class)
public class InterestORM {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "riskType")
    private String riskType;

    @Column(name = "limit")
    private Float limit;

    @Column(name = "interestPercent")
    private Float interestPercent;

    @CreatedDate
    private Date created;

    public InterestORM() {
    }

    public InterestORM(Long userId, String riskType, Float interestPercent, Float limit) {
        this.userId = userId;
        this.riskType = riskType;
        this.interestPercent = interestPercent;
        this.limit = limit;
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

    public Float getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(Float interestPercent) {
        this.interestPercent = interestPercent;
    }

    public Float getLimit() {
        return limit;
    }

    public void setLimit(Float limit) {
        this.limit = limit;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
