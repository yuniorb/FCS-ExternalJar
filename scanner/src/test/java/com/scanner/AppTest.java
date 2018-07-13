package com.scanner;

import static org.hamcrest.MatcherAssert.assertThat;

import java.net.MalformedURLException;
import org.junit.Test;


public class AppTest {

  /**
   * The test is failing because there is a test class (in compiled test jar exterlanApp-tests.jar) that has an annotation with a Class<?> property called clazz.
   * The clazz property has a value of Foo.class from the externalApp.jar that cannot be found when trying to access this value in the match processor.
   */
  @Test
  public void matcherShouldNotCrash() throws MalformedURLException {
    Scanner scanner = new Scanner();
    int classes = scanner.scan();
    assertThat("Match processor should not throw exception", classes >= 1);
  }
}
