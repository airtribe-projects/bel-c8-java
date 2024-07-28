package main.java.com.Lib;

import main.java.com.Lib.book.Book;
import main.java.com.Lib.book.Genre;
import main.java.com.Lib.patron.Patron;
import main.java.com.Lib.library.Library;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    HashMap<String,Integer> bookMap = new HashMap<>();
    Book book1 = new Book("The Diary of a Young Girl",1,"1947","Anne Frank", Genre.BIOGRAPHY,true);
    bookMap.put(book1.getName(),book1.getISBN());
    Book book2 = new Book("The Famous Five",2,"1942","Enid Blyton",Genre.FICTION);
    bookMap.put(book2.getName(),book2.getISBN());
    Book book3 = new Book("Freakonomics",3,"2005","Steven Levitt",Genre.NONFICTION,true);
    bookMap.put(book3.getName(),book3.getISBN());
    Book book4 = new Book("The Art of War",4,"2008","Sun Tzu",Genre.NONFICTION,true);
    bookMap.put(book4.getName(),book4.getISBN());
    Book book5 = new Book("The Alchemist",5,"1988","Paulo Coelho",Genre.FICTION,true);
    bookMap.put(book5.getName(),book5.getISBN());
    Book book6 = new Book("To Kill a Mockingbird",6,"1960","Harper Lee",Genre.FICTION);
    bookMap.put(book6.getName(),book6.getISBN());
    Book book7 = new Book("The Hunger Games",7,"2008","Suzanne Collins",Genre.FICTION,true);
    bookMap.put(book7.getName(),book7.getISBN());
    Book book8 = new Book("Wings of Fire",8,"1999","A. P. J. Abdul Kalam",Genre.BIOGRAPHY);
    bookMap.put(book8.getName(),book8.getISBN());
    Book book9 = new Book("The Story of My Experiments with Truth",9,"1929","Mahatma Gandhi",Genre.BIOGRAPHY,true);
    bookMap.put(book9.getName(),book9.getISBN());
    Book book10 = new Book("I Am Malala",10,"2013","Malala Yousafzai",Genre.BIOGRAPHY,true);
    bookMap.put(book10.getName(),book10.getISBN());


    Library library = new Library("LIBRARY001","Gurgaon");
    Patron patron1 = new Patron(1, "Ashish");
    library.addPatronList(patron1);
    Patron patron2 = new Patron(2, "Rajat");
    Patron patron3 = new Patron(3, "Sakshi");
    Patron patron4 = new Patron(4, "Bhavya");


    library.addPatronList(patron2);
    library.addPatronList(patron3);
    library.addPatronList(patron4);
    library.addBookList(book1);
    library.addBookList(book2);
    library.addBookList(book3);
    library.addBookList(book4);
    library.addBookList(book6);
    library.addBookList(book5);
    library.addBookList(book7);
    library.addBookList(book8);
    library.addBookList(book9);
    library.addBookList(book10);

    System.out.println("Welcome to Library Management System. Choose one of the following options.\n");
    System.out.println("\t1.Display Patron Details.\n\t2.Display Book Details\n\t3.Lend a Book\n\t4.Return a Book\n\t5.Exit");
    int choice = 0;
    do{
      System.out.println("Enter choice:\t");
      Scanner myObj = new Scanner(System.in);
      choice = Integer.parseInt(myObj.nextLine());
      switch(choice)
      {
        case 1: {library.DiplayAllPatrons(library); break;}
        case 2: {library.DiplayAllBooks(library); break;}
        case 3: {
          System.out.println("Enter Patron ID:");
          Integer pID = Integer.parseInt(myObj.nextLine());
          System.out.println("Enter Book name:");
          String bookName = myObj.nextLine();
          if(bookMap.containsKey(bookName))
            library.lendBook(bookMap.get(bookName),pID);
          else
            System.out.println("Book Not Available");
          break;
        }
        case 4: {
          System.out.println("Enter Patron ID:");
          Integer pID = Integer.parseInt(myObj.nextLine());
          System.out.println("Enter Book name:");
          String bookName = myObj.nextLine();
          if(bookMap.containsKey(bookName))
            library.returnBook(bookMap.get(bookName),pID);
          else
            System.out.println("Book Not from our Library");
          break;
        }
        case 5: {
          break;
        }
      }
    }while (choice!=5);


  }

}

