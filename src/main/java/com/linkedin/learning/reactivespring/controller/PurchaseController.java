package com.linkedin.learning.reactivespring.controller;

import com.linkedin.learning.reactivespring.model.CoinBaseResponse;
import com.linkedin.learning.reactivespring.model.Purchase;
import com.linkedin.learning.reactivespring.service.CoinbaseService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/purchase/v1")
class PurchaseController {

  @Autowired
  private CoinbaseService coinbaseService;

  @PostMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Purchase> createPurchase(@PathVariable("name") String name) {

    return Mono.fromSupplier(() -> new Purchase("test", "price", LocalDateTime.now()));
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Purchase> updatePurchase(@RequestBody Purchase purchase) {

    return Mono.fromSupplier(() -> new Purchase("test", "price", LocalDateTime.now()));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Purchase> updatePurchase(@PathVariable String id) {

    return Mono.fromSupplier(() -> new Purchase("test", "price", LocalDateTime.now()));
  }
}