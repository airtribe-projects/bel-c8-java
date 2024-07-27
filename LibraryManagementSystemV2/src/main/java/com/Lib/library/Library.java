package main.java.com.Lib.library;

import main.java.com.Lib.book.*;
import main.java.com.Lib.patron.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Library {
  public String receptionID;
  public String branch;
  ArrayList<Patron> patronList;
  ArrayList<Book> bookList;

  public void updateBook(Integer ISBN, Boolean available){
    Book book = bookList.get(ISBN-1);
    //Patron patron = new Patron();
    if(book != null) {
      book.setAvailable(available);
      System.out.println("Book Name: "+book.getName());
      System.out.println("ISBN: "+book.getISBN());
      System.out.println("Author Name: "+book.getAuthor());
      System.out.println("Genre: "+book.getGenre());
      System.out.println("Year Of Publication: "+book.getPublicationYear());
      System.out.println("Is Book Available?: "+book.getAvailable());
    }
    else
      System.out.println("Book not found");
  }
  public void updatePatron(Integer pID, Integer ISBN, Boolean returned){
    //Book book = new Book();
    Patron patron = patronList.get(pID-1);
    if(patron != null) {
      HashMap<Integer, Boolean> lendingHistory = new HashMap<Integer, Boolean>();
      lendingHistory.put(ISBN,returned);
      patron.setLendingHistory(lendingHistory);
      System.out.println("PatronID: "+patron.getPatronID());
      System.out.println("Patron Name: "+patron.getPatronName());
      System.out.println("Patron Lending History: "+patron.getLendingHistory());
    }
    else
      System.out.println("Patron not found");
  }

  public void lendBook(Integer ISBN, Integer patronID)
  {
    updatePatron(patronID, ISBN, false);
    updateBook(ISBN, false);
  }
  public void returnBook(Integer ISBN, Integer patronID)
  {
    updatePatron(patronID, ISBN, true);
    updateBook(ISBN, true);
  }
  public static void DiplayAllPatrons(Library library) {
    ArrayList<Patron> patronList1 = library.patronList;
    System.out.println("Patron Name: "+patronList1.toString());
    /*for (Object patronTemp:patronList1) {
      System.out.println("Patron Name: "+patronTemp.toString());
    }*/
  }
  public static void DiplayAllBooks(Library library) {
    ArrayList<Book> bookList1 = library.bookList;
    for (Object bookTemp:bookList1) {
      System.out.println("Book Name: "+bookList1.toString());
    }
  }
  public void addPatronList(Patron patron) {
    patronList.add(patron);
  }

  public Boolean removePatronList(Patron patron) {
    return patronList.remove(patron);
  }

  public Boolean addBookList(Book book) {
    return bookList.add(book);
  }

  public Boolean removeBookList(Book book) {
    return bookList.remove(book);
  }

  public Library(String receptionID, String branch){
    this.receptionID = receptionID;
    this.branch = branch;
    this.patronList = new ArrayList<>();
    this.bookList = new ArrayList<>();
  }

  public String getReceptionID() {
    return receptionID;
  }

  public void setReceptionID(String receptionID) {
    this.receptionID = receptionID;
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public ArrayList<Patron> getPatronList() {
    return patronList;
  }

  public void setPatronList(ArrayList<Patron> patronList) {
    this.patronList = patronList;
  }

  public ArrayList<Book> getBookList() {
    return bookList;
  }

  public void setBookList(ArrayList<Book> bookList) {
    this.bookList = bookList;
  }
}
