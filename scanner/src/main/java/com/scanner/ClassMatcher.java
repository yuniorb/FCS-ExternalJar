package com.scanner;

import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassMatchProcessor;

public class ClassMatcher implements ClassMatchProcessor {

  public int classesFound = 0;

  @Override
  public void processMatch(Class<?> aClass) {
    System.out.println("c: " + aClass.getName());
    classesFound++;
  }
}
