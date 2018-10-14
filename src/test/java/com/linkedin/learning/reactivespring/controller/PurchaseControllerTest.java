package com.linkedin.learning.reactivespring.controller;

import static org.junit.Assert.*;

import com.linkedin.learning.reactivespring.model.Purchase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest
public class PurchaseControllerTest {

  private WebTestClient client;



  @Before
  public void setUp() throws Exception {
    client = WebTestClient
        .bindToController(new PurchaseController())
        .build();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void createPurchase() throws Exception {
    client.get()
        .uri("/coin/purchase/v1/{id}", 123)
        .exchange()
        .expectStatus().isOk()
        .expectBody(Purchase.class);
  }
}