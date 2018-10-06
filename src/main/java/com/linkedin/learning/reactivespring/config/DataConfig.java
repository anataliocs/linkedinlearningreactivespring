package com.linkedin.learning.reactivespring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories("com.linkedin.learning.reactivespring.repository")
@Configuration
public class DataConfig extends AbstractReactiveMongoConfiguration {


  private final Environment environment;

  public DataConfig(Environment environment) {
    this.environment = environment;
  }

  @Bean
  @Override
  public com.mongodb.reactivestreams.client.MongoClient reactiveMongoClient() {
    return com.mongodb.reactivestreams.client.MongoClients.create("mongodb://localhost:27017");
  }

  @Override
  protected String getDatabaseName() {
    return "reactive";
  }
}