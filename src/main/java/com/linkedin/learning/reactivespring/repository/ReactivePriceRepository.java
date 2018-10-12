package com.linkedin.learning.reactivespring.repository;

import com.linkedin.learning.reactivespring.model.Purchase;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactivePriceRepository
    extends ReactiveCrudRepository<Purchase, String> {

  Flux<Purchase> findByPrice(Mono<String> price);


}