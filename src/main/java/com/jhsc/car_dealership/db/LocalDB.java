package com.jhsc.car_dealership.db;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhsc.car_dealership.models.Car;

import org.springframework.util.ResourceUtils;

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
      // TODO: handle exception
      System.out.println(e);
    }
  }

  public List<Car> getAllCars() {
    return cars;
  }

  public List<Car> filterByColor(String color) {
    return cars.stream().filter(Car -> Car.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
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
          .filter(car -> car.isFourWheelDrive() == Boolean.parseBoolean(params.get("four_wheel_drive")));
    }

    return streamOfCars.collect(Collectors.toList());
  }

}
