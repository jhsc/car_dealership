package com.jhsc.car_dealership.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.jhsc.car_dealership.models.Car;

public class LocalDBTest {

  @Test
  void whenFilterByColorFunc_thenSuccess() {
    Car car1 = new Car();
    car1.setPrice(500);
    car1.setColor("Red");
    Car car2 = new Car();
    car2.setColor("White");

    List<Car> cars = List.of(car1, car2);

    LocalDB db = new LocalDB(cars);

    List<Car> result = cars.stream().filter(db.byColor("Red")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterByColor_thenSuccess() {
    Car car1 = new Car();
    car1.setPrice(500);
    car1.setColor("Red");
    Car car2 = new Car();
    car2.setColor("White");

    List<Car> cars = List.of(car1, car2);

    LocalDB db = new LocalDB(cars);
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("color", "Red");
    List<Car> result = db.filter(params);

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterByNoColor_thenSuccess() {
    Car car1 = new Car();
    car1.setPrice(500);
    car1.setColor("Red");
    Car car2 = new Car();
    car2.setColor("White");

    List<Car> cars = List.of(car1, car2);

    LocalDB db = new LocalDB(cars);
    HashMap<String, String> params = new HashMap<String, String>();
    List<Car> result = db.filter(params);

    assertEquals(2, result.size());
  }

}
