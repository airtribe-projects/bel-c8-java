package org.airtribe.vehicle;

public class Vehicle {
  String vehicleRegistrationNumber;

  VehicleColor color;

  VehicleType type;

  public Vehicle(String vehicleRegistrationNumber, VehicleColor color, VehicleType type) {
    this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    this.color = color;
    this.type = type;
  }

  public String getVehicleRegistrationNumber() {
    return vehicleRegistrationNumber;
  }

  public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
    this.vehicleRegistrationNumber = vehicleRegistrationNumber;
  }

  public VehicleColor getColor() {
    return color;
  }

  public void setColor(VehicleColor color) {
    this.color = color;
  }

  public VehicleType getType() {
    return type;
  }

  public void setType(VehicleType type) {
    this.type = type;
  }
}
