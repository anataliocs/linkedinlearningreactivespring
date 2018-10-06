package com.linkedin.learning.reactivespring.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Price {

	private @Id
	String id;
  private final String price;

	public Price(String price) {
		this.price = price;
	}
}