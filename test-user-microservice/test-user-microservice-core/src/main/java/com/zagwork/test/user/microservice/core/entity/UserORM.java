package com.zagwork.test.user.microservice.core.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserORM {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public UserORM() {
    }

    public UserORM(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
