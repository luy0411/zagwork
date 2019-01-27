package com.zagwork.test.user.microservice.core.repository;

import com.zagwork.test.user.microservice.core.entity.UserORM;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserORM, Long> {

    @Query("select u from UserORM as u where u.name = :name")
    List<UserORM> findUserByName(@Param("name") String name);
}
