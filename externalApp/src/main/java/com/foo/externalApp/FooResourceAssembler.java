package com.foo.externalApp;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class FooResourceAssembler implements ResourceAssembler<Foo, FooResource> {
  @Override
  public FooResource toResource(Foo model) {

    final FooResource resource = new FooResourceBuilder()
        .value(model.getValue())
        .build();

    resource.add(ControllerLinkBuilder.linkTo(methodOn(
        FooController.class)).withSelfRel());

    return resource;
  }
}
