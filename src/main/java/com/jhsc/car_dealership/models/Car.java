package com.jhsc.car_dealership.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
  @JsonProperty("_id")
  private String id;
  private String make;
  private int year;
  private String color;
  private double price;
  private boolean hasSunroof;
  @JsonProperty("isFourWheelDrive")
  private boolean hasFourWheelDrive;
  private boolean hasLowMiles;
  private boolean hasPowerWindows;
  private boolean hasNavigation;
  private boolean hasHeatedSeats;

  public Car() {
  }

  public boolean isHasFourWheelDrive() {
    return hasFourWheelDrive;
  }

  public void setHasFourWheelDrive(boolean hasFourWheelDrive) {
    this.hasFourWheelDrive = hasFourWheelDrive;
  }

  public boolean isHasHeatedSeats() {
    return hasHeatedSeats;
  }

  public void setHasHeatedSeats(boolean hasHeatedSeats) {
    this.hasHeatedSeats = hasHeatedSeats;
  }

  public boolean isHasNavigation() {
    return hasNavigation;
  }

  public void setHasNavigation(boolean hasNavigation) {
    this.hasNavigation = hasNavigation;
  }

  public boolean isHasPowerWindows() {
    return hasPowerWindows;
  }

  public void setHasPowerWindows(boolean hasPowerWindows) {
    this.hasPowerWindows = hasPowerWindows;
  }

  public boolean isHasLowMiles() {
    return hasLowMiles;
  }

  public void setHasLowMiles(boolean hasLowMiles) {
    this.hasLowMiles = hasLowMiles;
  }

  public boolean isHasSunroof() {
    return hasSunroof;
  }

  public void setHasSunroof(boolean hasSunroof) {
    this.hasSunroof = hasSunroof;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public Car(String id, String make, int year, String color, double price, boolean hasSunroof, boolean isFourWheelDrive,
      boolean hasLowMiles, boolean hasPowerWindows, boolean hasNavigation, boolean hasHeatedSeats) {
    this.id = id;
    this.setMake(make);
    this.setYear(year);
    this.setColor(color);
    this.setPrice(price);
    this.setHasSunroof(hasSunroof);
    this.setHasFourWheelDrive(isFourWheelDrive);
    this.setHasLowMiles(hasLowMiles);
    this.setHasPowerWindows(hasPowerWindows);
    this.setHasNavigation(hasNavigation);
    this.setHasHeatedSeats(hasHeatedSeats);
  }

}
