package org.airtribe.ParkingFloor;

import java.util.Map;
import org.airtribe.display.DisplayPanel;
import org.airtribe.parkingspot.ParkingSpot;
import org.airtribe.parkingspot.ParkingSpotType;


public class DisplayBoard implements DisplayPanel {

  String displayBoardId;

  String displayBoardLocation;

  public DisplayBoard(String displayBoardId, String displayBoardLocation) {
    this.displayBoardId = displayBoardId;
    this.displayBoardLocation = displayBoardLocation;
  }

  public void showAvailableSpots(Map<String, ParkingSpot> parkingSpotMap, ParkingSpotType parkingSpotType) {
    for (Map.Entry<String, ParkingSpot> entry : parkingSpotMap.entrySet()) {
      if (entry.getValue().getSpotType() == parkingSpotType && !entry.getValue().isOccupied()) {

        System.out.println(entry.getKey());
      }
    }
  }

  public void showCountOfAvailableSpots(ParkingSpotType parkingSpotType, int count) {
    System.out.println("Available spots of type " + parkingSpotType + " are " + count);
  }

  public void showCountOfOccupiedSpots(ParkingSpotType parkingSpotType, int count) {
    System.out.println("Occupied spots of type " + parkingSpotType + " are " + count);
  }

  public void showParkingFullMessage() {
    System.out.println("Parking is full");
  }

  public void showAddNewParkingSpot(String spotName, ParkingSpotType spotType) {
    System.out.println("New parking spot added: " + spotName + " of type " + spotType);
  }

  public void showParkingFloorMaintenanceMessage() {
    System.out.println("Parking floor is under maintenance");
  }

  @Override
  public void displayMessage(String message) {
    System.out.println(message);
  }
}
