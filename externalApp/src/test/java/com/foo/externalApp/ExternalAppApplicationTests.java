package com.foo.externalApp;

import com.lib.externalLib.AnnotationWithClassValue;
import org.junit.Test;

@AnnotationWithClassValue(
    name = "foo annotation on test",
    clazz = Foo.class)
public class ExternalAppApplicationTests {

  @Test
  public void contextLoads() {
  }

}
