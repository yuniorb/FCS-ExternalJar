package com.foo.externalApp;

import com.lib.externalLib.AbstractaseClass;
import com.lib.externalLib.FooAnnotation;

@FooAnnotation(name = "bar")
public class SomeClass extends AbstractaseClass {

  @FooAnnotation(name = "z")
  public void method() {
  }
}
