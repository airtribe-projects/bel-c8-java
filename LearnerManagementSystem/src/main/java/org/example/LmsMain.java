package org.example;
import java.util.Scanner;
import java.io.IOException;

public class LmsMain {

  public static void main(String[] args) {
    String[] names = new String[100];
    int[] ages = new int[100];
    int[] xps = new int[100];
    int count = 0; // Track number of learners added
    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    do {
      try {
        System.out.println("\n=== Learner Management System Menu ===");
        System.out.println("1. Add New Learner");
        System.out.println("2. Display All Learners");
        System.out.println("3. Calculate Average XP");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
          case 1:
            if (count < names.length) {
              addNewLearner(names, ages, xps, count, scanner);
              count++;
            } else {
              System.out.println("Maximum learners reached. Cannot add more.");
            }
            break;
          case 2:
            displayAllLearners(names, ages, xps, count);
            break;
          case 3:
            calculateAverageXP(names, ages, xps, count);
            break;
          case 4:
            System.out.println("Exiting program...");
            break;
          default:
            System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }
      } catch (IOException e) {
        System.out.println("IOException occurred: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        scanner.nextLine(); // Clear input buffer
      }
    } while (choice != 4);

    scanner.close();
  }

  private static void addNewLearner(String[] names, int[] ages, int[] xps, int count, Scanner scanner) throws IOException {
    System.out.print("Enter learner's name: ");
    names[count] = scanner.next();

    int age;
    do {
      try {
        System.out.print("Enter learner's age (between 18 and 100): ");
        age = scanner.nextInt();
        if (age < 18 || age > 100) {
          throw new IllegalArgumentException("Invalid age. Please enter an age between 18 and 100.");
        }
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        scanner.nextLine(); // Clear input buffer
        age = -1; // Set age to -1 to continue loop
      }
    } while (age < 18 || age > 100);
    ages[count] = age;

    System.out.print("Enter learner's XP: ");
    xps[count] = scanner.nextInt();

    System.out.println("Learner added successfully.");
  }

  private static void displayAllLearners(String[] names, int[] ages, int[] xps, int count) {
    if (count == 0) {
      System.out.println("No learners to display.");
    } else {
      System.out.println("\n=== All Learners ===");
      for (int i = 0; i < count; i++) {
        System.out.println("Name: " + names[i] + ", Age: " + ages[i] + ", XP: " + xps[i]);
      }
    }
  }

  private static void calculateAverageXP(String[] names, int[] ages, int[] xps, int count) {
    if (count == 0) {
      System.out.println("No learners to calculate average XP.");
    } else {
      int totalXP = 0;
      for (int i = 0; i < count; i++) {
        totalXP += xps[i];
      }
      double averageXP = (double) totalXP / count;
      System.out.println("Average XP of all learners: " + averageXP);
    }
  }
}
