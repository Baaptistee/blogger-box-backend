package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
        name = "Hello world API",
        description = "My hello world endpoints"
)
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("hello")
    public String helloByName(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("hello/{name}")
    @Operation(
            summary = "hello by name endpoint",
            description = "Returns 'Hello {name}'by path variable"
    )
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}
