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

  // Filters
  // Predicate<Car> byColor = car(name) -> car.getColor().equals(name);

  public LocalDB(String path) {
    // File file = null;
    try {
      // System.out.println("Working Directory = " + System.getProperty("user.dir"));
      // file = ResourceUtils.getFile(path);
      // String content = new String(Files.readAllBytes(file.toPath()));
      // System.out.println(content);
      // ObjectMapper objectMapper = new ObjectMapper();

      // List<Car> car = Arrays.asList(objectMapper.readValue(file, Car[].class));
      // cars = car.stream().collect(Collectors.toList());

      InputStream inJson = Car.class.getResourceAsStream(path);
      Car[] objects = new ObjectMapper().readValue(inJson, Car[].class);
      cars = Arrays.asList(objects);

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public LocalDB(List<Car> cars) {
    this.cars = cars;
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

  // Color (Red, White, Gray, Silver, Black)
  // sun roof
  // 4 wheel drive
  // low miles
  // power windows
  // navigation
  // heated seats
  public List<Car> filter(Map<String, String> params) {
    Stream<Car> streamOfCars = cars.stream();
    // White list possible filter options.
    if (params.containsKey("color")) {
      System.out.println(params.get("color"));
      streamOfCars = streamOfCars.filter(car -> car.getColor().equalsIgnoreCase(params.get("color")));
    }
    if (params.containsKey("sun_roof")) {
      System.out.println(Boolean.parseBoolean(params.get("sun_roof")));
      streamOfCars = streamOfCars.filter(car -> car.isHasSunroof() == Boolean.parseBoolean(params.get("sun_roof")));
    }
    if (params.containsKey("four_wheel_drive")) {
      System.out.println(Boolean.parseBoolean(params.get("four_wheel_drive")));
      streamOfCars = streamOfCars
          .filter(car -> car.isHasFourWheelDrive() == Boolean.parseBoolean(params.get("four_wheel_drive")));
    }
    if (params.containsKey("low_miles")) {
      System.out.println(Boolean.parseBoolean(params.get("low_miles")));
      streamOfCars = streamOfCars.filter(car -> car.isHasLowMiles() == Boolean.parseBoolean(params.get("low_miles")));
    }
    if (params.containsKey("power_windows")) {
      System.out.println(Boolean.parseBoolean(params.get("power_windows")));
      streamOfCars = streamOfCars
          .filter(car -> car.isHasPowerWindows() == Boolean.parseBoolean(params.get("power_windows")));
    }
    if (params.containsKey("navigation")) {
      System.out.println(Boolean.parseBoolean(params.get("navigation")));
      streamOfCars = streamOfCars
          .filter(car -> car.isHasNavigation() == Boolean.parseBoolean(params.get("navigation")));
    }
    if (params.containsKey("heated_seats")) {
      System.out.println(Boolean.parseBoolean(params.get("heated_seats")));
      streamOfCars = streamOfCars
          .filter(car -> car.isHasHeatedSeats() == Boolean.parseBoolean(params.get("heated_seats")));
    }

    return streamOfCars.collect(Collectors.toList());
  }

}
