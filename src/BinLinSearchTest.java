import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main method that allows user to initialize array and search for a character in it using different methods.
 * Student Name: Fadi Rizk
 * Student Number: 041174349
 * Course: CST8130 302 - Data Structures
 * CET-CS-Level 3
 * Professor James Mwangi PhD.
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 */
public class BinLinSearchTest {
    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] randomChars = null;
        boolean willing = true;
        char key = 0;
        BinaryLinearSearch BLS = new BinaryLinearSearch();
        int choice = 0;

        System.out.println("=====Welcome to the Binary and Linear Search Tester!=====");
        while (willing) {
            displayMenu();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    randomChars = BLS.generateRandomChars();
                    break;
                case 2:
                    if (randomChars != null) {
                        System.out.println("Enter a character to search for: ");
                        try {
                            key = scanner.next().charAt(0);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please try again.");
                            scanner.nextLine();
                        }
                        System.out.println("Recursive Binary Search:");
                        int search = BLS.recursiveBinarySearch(randomChars, key, 0, randomChars.length - 1);
                        findCheck(search,key);
                        System.out.println("Recursive Linear Search:");
                        search = BLS.recursiveLinearSearch(randomChars, key, 0);
                        findCheck(search,key);
                    } else {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    }
                    break;
                case 3:
                    if (randomChars != null) {
                        System.out.println("Enter a character to search for: ");
                        try {
                            key = scanner.next().charAt(0);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please try again.");
                            scanner.nextLine();
                        }
                        System.out.println("Iterative Binary Search:");
                        int search = BLS.iterativeBinarySearch(randomChars, key);
                        findCheck(search,key);
                        System.out.println("Iterative Linear Search:");
                        search = BLS.iterativeLinearSearch(randomChars, key);
                        findCheck(search,key);
                    } else {
                        System.out.println("Array not initialized. Please initialize the array first.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    willing = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    /**
     * Simple Menu Display
     */
    public static void displayMenu() {
        System.out.print("1. Initialize and populate an array of 32 random characters.\n" +
                "2. Perform recursive binary and linear search.\n" +
                "3. Perform iterative binary and linear search.\n" +
                "4. Exit.");
    }

    /**
     * Simple method to check if value was found or not found,
     * @param search
     * @param key
     */
    public static void findCheck(int search,int key){
        if (search == -1) {
            System.out.println(key + " not found.\n\n");
        } else {
            System.out.println(key + " found at index: " + search + "\n\n");
        }
    }

}
