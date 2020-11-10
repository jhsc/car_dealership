package com.jhsc.car_dealership.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class CarsControllerTest {
  @Autowired
  private CarController controller;

  @Test
  void index() {
    // CarController controller = new CarController();
    String response = controller.home();
    assertEquals("hello from spring Boot", response);
  }

}
