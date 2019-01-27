package com.zagwork.test.interest.microservice.core.converter;

import com.zagwork.test.interest.microservice.core.domain.InterestData;
import com.zagwork.test.interest.microservice.core.entity.InterestORM;
import org.springframework.stereotype.Component;

@Component
public class InterestConverter {

    public InterestData toDomain(InterestORM interestORM) {
        return new InterestData(interestORM.getId(),
                interestORM.getUserId(),
                interestORM.getRiskType(),
                interestORM.getLimit(),
                interestORM.getInterestPercent(),
                interestORM.getCreated());
    }

    public InterestORM toEntity(InterestData interest) {
        return new InterestORM (interest.getUserId(),
                interest.getRiskType(),
                interest.getInterestPercent(),
                interest.getLimit());
    }
}
