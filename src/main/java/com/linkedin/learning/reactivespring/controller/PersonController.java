package com.linkedin.learning.reactivespring.controller;

import com.linkedin.learning.reactivespring.model.CoinBaseResponse;
import com.linkedin.learning.reactivespring.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/price")
class PriceController {

  @Autowired
  private CoinbaseService coinbaseService;

  @GetMapping("/{name}")
  public Mono<CoinBaseResponse> getPerson(@PathVariable String name) {

    return coinbaseService.getCryptoPrice(name);
  }

}