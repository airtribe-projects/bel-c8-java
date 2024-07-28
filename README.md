Please note: Regarding the submission, by mistake I pushed into main gave the URL of the main branch. Later, I created a new branch and moved all my changes there, then created a PR. You can check all my changes in the PR page.

Classes:
  1. Patron 
  2. Book
  3. Library

Class Diagram: 



  ![LibraryManagementSystem drawio](https://github.com/user-attachments/assets/573ca840-d0e3-4797-9ba3-cc601e0bdecd)


  
  
  The Library Class is responsible for storing the details of the available collection of Books and all the patrons. The Patron will interact with the Library to lend or return a book. 
  The Library will also be responsible to maintain the lending history of the Patron to keep a track of all the books that were borrowed and if they were returned or not. 
  This Borrowing history of the patron will help the library class to build a recommendation system to recommend a book to the patron based on their borrowing history.

Design Patterns used:
  1. Singleton pattern - This would ensure that only one object of library gets created (This design pattern would not be applicable if we go ahead with the optional requirements to have multiple branches for a library).
  2. Command Pattern - This is used to encapsulate operations like borrowing and returning book.
  
  
