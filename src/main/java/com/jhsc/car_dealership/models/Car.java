package com.jhsc.car_dealership.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
  @JsonProperty("_id")
  private final String id;
  private final String make;
  private final int year;
  private final double price;
  private final boolean hasSunroof;
  private final boolean isFourWheelDrive;
  private final boolean hasLowMiles;
  private final boolean hasPowerWindows;
  private final boolean hasNavigation;
  private final boolean hasHeatedSeats;

  public Car(String id, String make, int year, double price, boolean hasSunroof, boolean isFourWheelDrive,
      boolean hasLowMiles, boolean hasPowerWindows, boolean hasNavigation, boolean hasHeatedSeats) {
    this.id = id;
    this.make = make;
    this.year = year;
    this.price = price;
    this.hasSunroof = hasSunroof;
    this.isFourWheelDrive = isFourWheelDrive;
    this.hasLowMiles = hasLowMiles;
    this.hasPowerWindows = hasPowerWindows;
    this.hasNavigation = hasNavigation;
    this.hasHeatedSeats = hasHeatedSeats;

  }

  public boolean isHasHeatedSeats() {
    return hasHeatedSeats;
  }

  public boolean isHasNavigation() {
    return hasNavigation;
  }

  public boolean isHasPowerWindows() {
    return hasPowerWindows;
  }

  public boolean isHasLowMiles() {
    return hasLowMiles;
  }

  public boolean isFourWheelDrive() {
    return isFourWheelDrive;
  }

  public boolean isHasSunroof() {
    return hasSunroof;
  }

  public double getPrice() {
    return price;
  }

  public int getYear() {
    return year;
  }

  public String getMake() {
    return make;
  }
}
