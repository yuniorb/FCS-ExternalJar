package com.foo.externalApp;

public class Foo {

  public Foo(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  private String value;
}
