package com.linkedin.learning.reactivespring.repository;

import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactivePriceRepository
    extends ReactiveMongoOperations {

}