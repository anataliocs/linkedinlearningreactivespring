package com.linkedin.learning.reactivespring.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.linkedin.learning.reactivespring.model.Purchase;
import com.linkedin.learning.reactivespring.service.CoinbaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PurchaseHandler {

  @Autowired
  private CoinbaseService coinbaseService;

  public Mono<ServerResponse> listPurchases(ServerRequest request) {

    final Mono<Purchase> purchase = coinbaseService.getPurchaseById(request.pathVariable("id"));

    return ServerResponse.ok().contentType(APPLICATION_JSON)
        .body(purchase, Purchase.class);
  }

  public Mono<ServerResponse> listAllPurchases(ServerRequest request) {

    final Flux<Purchase> purchase = coinbaseService.listAllPurchases();

    return ServerResponse.ok().contentType(APPLICATION_JSON)
        .body(purchase.collectList(), new ParameterizedTypeReference<List<Purchase>>() {
        });
  }
}
