package com.linkedin.learning.reactivespring.service;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.linkedin.learning.reactivespring.model.CoinBaseResponse;
import com.linkedin.learning.reactivespring.model.Purchase;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class CoinbaseServiceImpl implements CoinbaseService {

  @Autowired
  private ObjectWriter objectWriter;

  @Autowired
  private WebClient webClient;

  @Autowired
  private ReactiveMongoOperations reactiveMongoTemplate;

  @Override
  public Mono<CoinBaseResponse> getCryptoPrice(String priceName) {

    return webClient.get()
        .uri("https://api.coinbase.com/v2/prices/{crytoType}/buy", priceName)
        .accept(MediaType.APPLICATION_JSON)
        .exchange().flatMap(clientResponse -> clientResponse.bodyToMono(CoinBaseResponse.class));
  }

  @Override
  public Mono<Purchase> createPurchase(String priceName) {

    return getCryptoPrice(priceName).flatMap(price -> reactiveMongoTemplate
        .save(new Purchase(priceName, price.getData().getAmount(), LocalDateTime.now())));
  }

  @Override
  public Mono<Purchase> getPurchaseById(final String id) {

    final Mono<Purchase> purchaseMono = reactiveMongoTemplate.findById(id, Purchase.class);

    return purchaseMono;
  }

  @Override
  public Flux<Purchase> listAllPurchases() {

    final Flux<Purchase> purchaseMono = reactiveMongoTemplate.findAll(Purchase.class);

    return purchaseMono;
  }
}
