package main.java.com.Lib.patron;

import java.util.HashMap;

public class Patron {
  private Integer patronID;
  private String patronName;
  private HashMap <Integer, Boolean> lendingHistory;

  //public void updatePatron();
  public Patron(Integer pID, String pName){
    this.patronID = pID;
    this.patronName = pName;
    this.lendingHistory = new HashMap<>();
  }

  public Patron(Integer pID, String pName, Integer ISBN, Boolean isReturned){
    this.patronID = pID;
    this.patronName = pName;
    this.lendingHistory.put(ISBN,isReturned);
  }

  public Patron(){
  }

  public Integer getPatronID() {
    return patronID;
  }

  public void setPatronID(Integer patronID) {
    this.patronID = patronID;
  }

  public String getPatronName() {
    return patronName;
  }

  public void setPatronName(String patronName) {
    this.patronName = patronName;
  }

  public HashMap<Integer, Boolean> getLendingHistory() {
    return lendingHistory;
  }

  public void setLendingHistory(HashMap<Integer, Boolean> lendingHistory) {
    this.lendingHistory = lendingHistory;
  }
}
