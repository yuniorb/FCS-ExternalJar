package com.foo.externalApp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Builder
@Getter
@Setter
public class FooResource extends ResourceSupport {

  private String value;
}
