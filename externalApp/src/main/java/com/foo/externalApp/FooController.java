package com.foo.externalApp;

import java.awt.print.Pageable;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class FooController {
  private static final int DEFAULT_PAGE_SIZE = 30;

  private final FooResourceAssembler fooResourceAssembler;

  @RequestMapping(method = RequestMethod.GET, value = "/foo")
  public ResponseEntity<PagedResources<FooResource>> getAllFoo(
      @PageableDefault(size = DEFAULT_PAGE_SIZE, sort = "name", direction = Sort.Direction.ASC) Pageable page,
      PagedResourcesAssembler<Foo> pagedAssembler) {

    Foo foo = Foo.builder().value("Bar").build();

    Page<Foo> items = new PageImpl<>(Collections.singletonList(foo));
    PagedResources<FooResource> resources =
        pagedAssembler.toResource(items, fooResourceAssembler);
    return ResponseEntity.ok(resources);
  }
}
