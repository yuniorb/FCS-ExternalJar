package com.scanner;

import com.lib.externalLib.AnnotationWithClassValue;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassAnnotationMatchProcessor;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import lombok.Getter;


public class ScannerMain {
  public static void main(String[] args) throws MalformedURLException {
    Scanner scanner = new Scanner();
    scanner.scan();
  }
}

class TestMatcher implements ClassAnnotationMatchProcessor {

  @Getter
  private int found;

  @Override
  public void processMatch(Class<?> classWithAnnotation) {

    AnnotationWithClassValue a = classWithAnnotation.getAnnotation(AnnotationWithClassValue.class);
    Class<?> foo = a.clazz();
    System.out.println(foo.getName());
    found++;
  }
}

class Scanner {
  public int scan() throws MalformedURLException {
    // TODO Update with correct path
    final URL jar = new File("/Users/yuniorb/Downloads/FCS-ExternalJar/externalApp/target/externalApp.jar").toURI().toURL();
    final File file = new File("/Users/yuniorb/Downloads/FCS-ExternalJar/externalApp/target/externalApp-tests.jar");

    URL testJar = file.toURI().toURL();

    ClassLoader loader = new URLClassLoader(new URL[]{jar, testJar});

    final TestMatcher classAnnotationMatchProcessor = new TestMatcher();
    new FastClasspathScanner("com.foo")
        .overrideClassLoaders(loader)
        .ignoreParentClassLoaders()
        .matchClassesWithAnnotation(AnnotationWithClassValue.class, classAnnotationMatchProcessor)
        .verbose()
        .scan();

    return classAnnotationMatchProcessor.getFound();
  }
}
