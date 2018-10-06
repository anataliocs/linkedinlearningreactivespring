package com.linkedin.learning.reactivespring.repository;

import com.linkedin.learning.reactivespring.model.Price;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactivePriceRepository
    extends ReactiveCrudRepository<Price, String> {

  Flux<Price> findByPrice(Mono<String> price);

}