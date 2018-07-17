package com.foo.externalApp;

public class FooResourceBuilder {
  private String value;

  public FooResourceBuilder value(String value) {
    this.value = value;
    return this;
  }

  public FooResource build() {
    return new FooResource(value);
  }
}
