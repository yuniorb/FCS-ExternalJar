package com.foo.externalApp;

public class FooBuilder {
  private String value;

  public FooBuilder value(String value) {
    this.value = value;
    return this;
  }

  public Foo build() {
    return new Foo(value);
  }
}
