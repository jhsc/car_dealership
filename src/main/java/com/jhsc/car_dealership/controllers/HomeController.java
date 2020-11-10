package com.jhsc.car_dealership.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.jhsc.car_dealership.models.Greeting;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  // /greeting?name=Juan
  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  // @GetMapping("/")
  // public String home() {
  // return "hello from spring Boot";
  // }
}
