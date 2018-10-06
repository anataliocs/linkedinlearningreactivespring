package com.linkedin.learning.reactivespring.repository;

import com.linkedin.learning.reactivespring.model.CoinBaseResponse;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactivePriceRepository
    extends ReactiveCrudRepository<CoinBaseResponse, String> {

  Flux<CoinBaseResponse> findByLastname(Mono<String> lastname);

  @Query("{ 'firstname': ?0, 'lastname': ?1}")
  Mono<CoinBaseResponse> findByFirstnameAndLastname(String firstname, String lastname);
}