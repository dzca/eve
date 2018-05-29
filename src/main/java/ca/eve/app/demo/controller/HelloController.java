package ca.eve.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ca.eve.app.demo.domain.Hello;

@RestController
public class HelloController {
	@GetMapping(path = "/hello")
	public Hello Hello() {
		return new Hello("Hello World");
	}

	@GetMapping(path = "/hello/{name}")
	public Hello helloWorldPathVariable(@PathVariable String name) {
		return new Hello(String.format("Hello World, %s", name));
	}
}
