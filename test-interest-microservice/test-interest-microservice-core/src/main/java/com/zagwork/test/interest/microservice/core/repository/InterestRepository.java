package com.zagwork.test.interest.microservice.core.repository;

import com.zagwork.test.interest.microservice.core.entity.InterestORM;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends CrudRepository<InterestORM, Long> {

    @Query("select a from InterestORM as a where a.userId = :userId")
    List<InterestORM> findAllByUserId(@Param("userId") Long userId);
}
