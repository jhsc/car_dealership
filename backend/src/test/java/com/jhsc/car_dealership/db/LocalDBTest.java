package com.jhsc.car_dealership.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.jhsc.car_dealership.models.Car;

public class LocalDBTest {

  @Test
  void whenFilterByColor_thenSuccess() {
    Car car1 = new Car();
    car1.setColor("Red");
    Car car2 = new Car();
    car2.setColor("White");

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);

    LocalDB db = new LocalDB();
    List<Car> result = cars.stream().filter(db.byColor("Red")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterBySunRoof_thenSuccess() {
    Car car1 = new Car();
    car1.setHasSunroof(true);
    Car car2 = new Car();
    car2.setHasSunroof(false);

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);

    LocalDB db = new LocalDB();
    List<Car> result = cars.stream().filter(db.bySunRoof("true")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterByFourWheelDrive_thenSuccess() {
    Car car1 = new Car();
    car1.setHasFourWheelDrive(true);
    Car car2 = new Car();
    car2.setHasFourWheelDrive(false);

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);

    LocalDB db = new LocalDB();
    List<Car> result = cars.stream().filter(db.byFourWheelDrive("true")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterByLowMiles_thenSuccess() {
    Car car1 = new Car();
    car1.setHasLowMiles(true);
    Car car2 = new Car();
    car2.setHasLowMiles(false);

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);

    LocalDB db = new LocalDB();
    List<Car> result = cars.stream().filter(db.byLowMiles("true")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterByPowerWindows_thenSuccess() {
    Car car1 = new Car();
    car1.setHasPowerWindows(true);
    Car car2 = new Car();
    car2.setHasPowerWindows(false);

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);

    LocalDB db = new LocalDB();
    List<Car> result = cars.stream().filter(db.byPowerWindows("true")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterByNavigation_thenSuccess() {
    Car car1 = new Car();
    car1.setHasNavigation(true);
    Car car2 = new Car();
    car2.setHasNavigation(false);

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);

    LocalDB db = new LocalDB();
    List<Car> result = cars.stream().filter(db.byNavigation("true")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterByHeatedSeats_thenSuccess() {
    Car car1 = new Car();
    car1.setHasHeatedSeats(true);
    Car car2 = new Car();
    car2.setHasHeatedSeats(false);

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);

    LocalDB db = new LocalDB();
    List<Car> result = cars.stream().filter(db.byHeatedSeats("true")).collect(Collectors.toList());

    assertEquals(1, result.size());
  }

  @Test
  void whenFilterAll_thenSuccess() {
    Car car1 = new Car("1", "Toyota", 2020, "Red", 50000.00, true, true, true, true, true, true);
    Car car2 = new Car("2", "Chevy", 2012, "Black", 10000.00, false, false, false, false, false, false);
    Car car3 = new Car("3", "Ford", 2012, "Red", 1535.00, false, false, false, false, false, false);
    Car car4 = new Car("4", "Ford", 2018, "White", 1606.00, true, false, true, false, true, false);

    // List<Car> cars = List.of(car1, car2, car3, car4);
    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);
    cars.add(car3);
    cars.add(car4);

    LocalDB db = new LocalDB(cars);
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("color", "Red");

    List<Car> result = db.filter(params);

    assertEquals(2, result.size());
  }

  @Test
  void whenFilterAllMultipleParams_thenSuccess() {
    Car car1 = new Car("1", "Toyota", 2020, "Red", 50000.00, true, true, true, true, true, true);
    Car car2 = new Car("2", "Chevy", 2012, "Black", 10000.00, false, false, false, false, false, false);
    Car car3 = new Car("3", "Ford", 2012, "Red", 1535.00, false, false, false, false, false, false);
    Car car4 = new Car("4", "Ford", 2018, "White", 1606.00, true, false, true, false, true, false);

    List<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);
    cars.add(car3);
    cars.add(car4);

    LocalDB db = new LocalDB(cars);
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("color", "Red");
    params.put("heated_seats", "true");

    List<Car> result = db.filter(params);

    assertEquals(1, result.size());
  }

}
