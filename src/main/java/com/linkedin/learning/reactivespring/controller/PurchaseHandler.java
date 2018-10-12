package com.linkedin.learning.reactivespring.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.linkedin.learning.reactivespring.model.Purchase;
import com.linkedin.learning.reactivespring.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PurchaseHandler {

  @Autowired
  private CoinbaseService coinbaseService;

  public Mono<ServerResponse> listPurchases(ServerRequest request) {

    System.out.println("request = " + request);
    System.out.println("request = " + request.pathVariable("id"));
    System.out.println("request = " + request.path());
    System.out.println("request = " + request.methodName());

    System.out.println();
    System.out.println("coinbaseService = " + coinbaseService);
    coinbaseService.getPurchase(request.pathVariable("id")).subscribe(System.out::println);

    //TODO to get Purchases using Service layer
    final Mono<Purchase> purchase = coinbaseService.getPurchase(request.pathVariable("id"));

    return ServerResponse.ok().contentType(APPLICATION_JSON)
        .body(purchase, Purchase.class);
  }
}
