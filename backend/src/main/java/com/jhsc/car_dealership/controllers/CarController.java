package com.jhsc.car_dealership.controllers;

import java.util.List;
import java.util.Map;

import com.jhsc.car_dealership.db.LocalDB;
import com.jhsc.car_dealership.models.Car;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CarController {

  private final LocalDB db = new LocalDB("data.json");

  @GetMapping("/cars")
  public ResponseEntity<List<Car>> getCars(@RequestParam Map<String, String> requestParams) {
    try {
      List<Car> cars = db.filter(requestParams);

      if (cars.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(cars, HttpStatus.OK);

    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/")
  public String home() {
    return "hello from spring Boot";
  }

}
