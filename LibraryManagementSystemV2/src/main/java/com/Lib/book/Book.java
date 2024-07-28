package main.java.com.Lib.book;

import java.util.HashMap;

public class Book {
  private String name;
  private Integer ISBN;
  private String author;
  private String publicationYear;
  private Genre genre;
  private Boolean available;
  HashMap<String,Integer> bookName = new HashMap<>();

  public Book(String name, Integer ISBN, String author, String publicationYear, Genre genre, Boolean available){
    this.name = name;
    this.ISBN = ISBN;
    this.author = author;
    this.publicationYear = publicationYear;
    this.genre = genre;
    this.available = available;
    bookName.put(name,ISBN);

  }
  public Book(String name, Integer ISBN, String author, String publicationYear, Genre genre){
    this.name = name;
    this.ISBN = ISBN;
    this.author = author;
    this.publicationYear = publicationYear;
    this.genre = genre;
    this.available = true;
    bookName.put(name,ISBN);
  }
  public Book(){
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getISBN() {
    return ISBN;
  }

  public void setISBN(Integer ISBN) {
    this.ISBN = ISBN;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(String publicationYear) {
    this.publicationYear = publicationYear;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public HashMap<String, Integer> getBookName() {
    return bookName;
  }

  public void setBookName(HashMap<String, Integer> bookName) {
    this.bookName = bookName;
  }
}
