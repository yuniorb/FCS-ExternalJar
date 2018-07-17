package com.foo.externalApp;

import org.springframework.hateoas.ResourceSupport;

public class FooResource extends ResourceSupport {

  public FooResource(String value) {
    this.value = value;
  }

  private String value;
}
