package ca.eve.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ca.eve.app.demo.domain.Hello;

@RestController
public class HelloController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hello")
	public Hello Hello() {
		return new Hello("Hello World");
	}

	@GetMapping(path = "/hello/{name}")
	public Hello helloWorldPathVariable(@PathVariable String name) {
		return new Hello(String.format("Hello World, %s", name));
	}
	
	@GetMapping(path = "/hello-i18n")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}
}
