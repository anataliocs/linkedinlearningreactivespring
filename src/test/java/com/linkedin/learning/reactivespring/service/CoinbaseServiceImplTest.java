package com.linkedin.learning.reactivespring.service;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.linkedin.learning.reactivespring.config.ApiConfig;
import com.linkedin.learning.reactivespring.config.DataConfig;
import com.linkedin.learning.reactivespring.model.CoinBaseResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ApiConfig.class, DataConfig.class})
@ComponentScan
@EnableAutoConfiguration
public class CoinbaseServiceImplTest {

  @Autowired
  private ObjectWriter objectWriter;

  @Autowired
  private WebClient webClient;

  @Autowired
  private ReactiveMongoOperations reactiveMongoTemplate;

  @Autowired
  CoinbaseService classUnderTest;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getCryptoPrice() throws Exception {
    Mono<CoinBaseResponse> responseMono = classUnderTest.getCryptoPrice("BTC-USD");

    responseMono.subscribe(System.out::println);
  }
}