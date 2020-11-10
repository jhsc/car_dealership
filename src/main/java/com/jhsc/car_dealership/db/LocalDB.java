package com.jhsc.car_dealership.db;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhsc.car_dealership.models.Car;

public class LocalDB {
  private List<Car> cars = new ArrayList<Car>();

  public LocalDB(String path) {
    try {
      InputStream inJson = Car.class.getResourceAsStream(path);
      Car[] objects = new ObjectMapper().readValue(inJson, Car[].class);
      this.cars = Arrays.asList(objects);

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public LocalDB(List<Car> cars) {
    this.cars = cars;
  }

  public LocalDB() {

  }

  public List<Car> getAllCars() {
    return cars;
  }

  public List<Car> filterByColor(String color) {
    return cars.stream().filter(Car -> Car.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
  }

  // Specific filters
  public Predicate<Car> byColor(String color) {
    return car -> car.getColor().equals(color);
  }

  public Predicate<Car> bySunRoof(String sun_roof) {
    return car -> car.isHasSunroof() == Boolean.parseBoolean(sun_roof);
  }

  public Predicate<Car> byFourWheelDrive(String four_wheel_drive) {
    return car -> car.isHasFourWheelDrive() == Boolean.parseBoolean(four_wheel_drive);
  }

  public Predicate<Car> byLowMiles(String low_miles) {
    return car -> car.isHasLowMiles() == Boolean.parseBoolean(low_miles);
  }

  public Predicate<Car> byPowerWindows(String power_windows) {
    return car -> car.isHasPowerWindows() == Boolean.parseBoolean(power_windows);
  }

  public Predicate<Car> byNavigation(String navigation) {
    return car -> car.isHasNavigation() == Boolean.parseBoolean(navigation);
  }

  public Predicate<Car> byHeatedSeats(String heated_seats) {
    return car -> car.isHasHeatedSeats() == Boolean.parseBoolean(heated_seats);
  }

  public List<Car> filter(Map<String, String> params) {
    Stream<Car> streamOfCars = cars.stream();
    // White list possible filter options.
    if (params.containsKey("color")) {
      streamOfCars = streamOfCars.filter(byColor(params.get("color")));
    }
    if (params.containsKey("sun_roof")) {
      streamOfCars = streamOfCars.filter(bySunRoof(params.get("sun_roof")));
    }
    if (params.containsKey("four_wheel_drive")) {
      streamOfCars = streamOfCars.filter(byFourWheelDrive(params.get("four_wheel_drive")));
    }
    if (params.containsKey("low_miles")) {
      streamOfCars = streamOfCars.filter(byLowMiles(params.get("low_miles")));
    }
    if (params.containsKey("power_windows")) {
      streamOfCars = streamOfCars.filter(byPowerWindows(params.get("power_windows")));
    }
    if (params.containsKey("navigation")) {
      streamOfCars = streamOfCars.filter(byNavigation(params.get("navigation")));
    }
    if (params.containsKey("heated_seats")) {
      streamOfCars = streamOfCars.filter(byHeatedSeats(params.get("heated_seats")));
    }

    return streamOfCars.collect(Collectors.toList());
  }

}
