package com.linkedin.learning.reactivespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class ReactivespringApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactivespringApplication.class, args);
  }
}
