package com.linkedin.learning.reactivespring.service;

import com.linkedin.learning.reactivespring.model.CoinBaseResponse;
import reactor.core.publisher.Mono;

public interface CoinbaseService {

  Mono<CoinBaseResponse> getCryptoPrice(String priceName);
}