package com.foo.externalApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public FooResourceAssembler assembler() {
    return new FooResourceAssembler();
  }
}
