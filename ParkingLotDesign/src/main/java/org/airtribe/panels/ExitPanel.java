package org.airtribe.panels;

import java.util.Date;
import org.airtribe.display.DisplayPanel;
import org.airtribe.ticket.ParkingTicket;


public class ExitPanel {
  String panelId;

  DisplayPanel displayPanel;

  public ExitPanel(String panelId, DisplayPanel displayPanel) {
    this.panelId = panelId;
    this.displayPanel = displayPanel;
  }

  public ParkingTicket checkout(ParkingTicket parkingTicket) {
    parkingTicket.setExitTime(new Date());
    parkingTicket.setPaid(true);
    parkingTicket.setAmount(calculateAmount(parkingTicket));
    return parkingTicket;
  }

  public double calculateAmount(ParkingTicket parkingTicket) {
    long entryTime = parkingTicket.getEntryTime().getTime();
    long exitTime = parkingTicket.getExitTime().getTime();
    long duration = exitTime - entryTime;
    long hours = duration / 3600000;
    return hours * 10;
  }

  public String getPanelId() {
    return panelId;
  }

  public void setPanelId(String panelId) {
    this.panelId = panelId;
  }

  public DisplayPanel getDisplayPanel() {
    return displayPanel;
  }

  public void setDisplayPanel(DisplayPanel displayPanel) {
    this.displayPanel = displayPanel;
  }
}
