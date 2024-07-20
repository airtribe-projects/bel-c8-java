package org.airtribe.parkinglot;

import java.util.ArrayList;
import java.util.List;
import org.airtribe.ParkingFloor.ParkingFloor;
import org.airtribe.panels.EntryPanel;
import org.airtribe.panels.ExitPanel;
import org.airtribe.parkingspot.ParkingSpot;
import org.airtribe.ticket.ParkingTicket;
import org.airtribe.vehicle.Vehicle;


public class ParkingLot {
  String parkingLotId;

  String parkingLotName;

  String address;

  int totalFloors;

  List<ParkingFloor> parkingFloors;

  EntryPanel entryPanel;

  ExitPanel exitPanel;

  public ParkingLot(String parkingLotId, String parkingLotName,
      String address, int totalFloors, EntryPanel entryPanel, ExitPanel exitPanel) {
    this.parkingLotId = parkingLotId;
    this.parkingLotName = parkingLotName;
    this.address = address;
    this.totalFloors = totalFloors;
    this.parkingFloors = new ArrayList<>();
    this.entryPanel = entryPanel;
    this.exitPanel = exitPanel;
  }

  public boolean isParkingLotFull() {
    return parkingFloors.stream().allMatch(floor -> floor.getTotalAvailableSpotsCount() == 0);
  }

  public boolean isParkingLotEmpty() {
    return parkingFloors.stream().allMatch(floor -> floor.getTotalOccupiedSpotsCount() == 0);
  }

  public boolean addParkingFloor(ParkingFloor floor) {
    return parkingFloors.add(floor);
  }

  public boolean removeParkingFloor(ParkingFloor floor) {
    return parkingFloors.remove(floor);
  }

  public void parkVehicle(Vehicle vehicle) {
    ParkingFloor parkingFloor = entryPanel.computeFloorToBeParkedOn(parkingFloors, vehicle.getType());
    ParkingTicket ticket = entryPanel.generateParkingTicket(vehicle, parkingFloor);
    ParkingSpot spot = parkingFloor.getAvailableParkingSpotForVehicle(entryPanel.generateSpotTypeBasedOnVehicleType(vehicle.getType()));
    spot.parkVehicle(vehicle);
    System.out.println("Vehicle parked at spot: " + spot.getSpotName() + " on floor: " + parkingFloor.getFloorName() + " with ticket id: " + ticket.getTicketId());
  }

  public void exitVehicle(Vehicle vehicle, ParkingTicket parkingTicket) {
    ParkingFloor parkingFloor = parkingTicket.getParkingFloor();
    ParkingSpot spot = parkingTicket.getSpot();
    spot.removeVehicle();
    parkingTicket.setExitTime(java.util.Date.from(java.time.Instant.now()));
    double amount = exitPanel.calculateAmount(parkingTicket);
    parkingTicket.setAmount(amount);
    parkingTicket.setPaid(true);
    System.out.println("Vehicle exited from spot: " + spot.getSpotName() + " on floor: " + parkingFloor.getFloorName() + " with ticket id: " + parkingTicket.getTicketId() + " and amount: " + amount);
  }
}
