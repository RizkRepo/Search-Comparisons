import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Contains all methods required to create a character array and search through it using multiple methods.
 * Student Name: Fadi Rizk
 * Student Number: 041174349
 * Course: CST8130 302 - Data Structures
 * CET-CS-Level 3
 * Professor James Mwangi PhD.
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 */
public class BinaryLinearSearch {
    private SecureRandom secureRandom = new SecureRandom();// Random Selector of characters
    private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // String that contains all possible values for array

    /**
     * Performs an iterative binary search for a provided char, also printing the duration of search in nanoseconds and milliseconds
     *
     * @param array The sorted array of characters to search in.
     * @param key The character to search for within the array.
     * @return the array position, or -1 if the value is not found
     */
    public int iterativeBinarySearch(char[] array, char key){
        long[] startTime = {System.nanoTime(), System.currentTimeMillis()};
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            remainingElements(array, left, right);
            if (array[middle] == key) {
                long[] endTime = {System.nanoTime(), System.currentTimeMillis()};
                long[] duration = {endTime[0]-startTime[0],endTime[1]-startTime[1]};
                System.out.println("Time Taken Nanoseconds: " + duration[0] + "\nTime Taken Milliseconds: " + duration[1]);
                return middle;
            } else if (array[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        long[] endTime = {System.nanoTime(), System.currentTimeMillis()};
        long[] duration = {endTime[0]-startTime[0],endTime[1]-startTime[1]};
        System.out.println("Time Taken Nanoseconds: " + duration[0] + "\nTime Taken Milliseconds: " + duration[1]);
        return -1;
    }

    /**
     * Performs a Recursive Binary Search for provided char, also printing the duration of search in nanoseconds and milliseconds
     * @param array array of characters
     * @param key
     * @param left
     * @param right
     * @return the array position, or -1 if the value is not found
     */
    public int recursiveBinarySearch(char[] array, char key,int left, int right){
        long[] startTime = {System.nanoTime(), System.currentTimeMillis()};
        remainingElements(array, left, right);
        int middle = (left + right) / 2;
        if(left>right) {
            long[] endTime = {System.nanoTime(), System.currentTimeMillis()};
            long[] duration = {endTime[0]-startTime[0],endTime[1]-startTime[1]};
            System.out.println("Time Taken Nanoseconds: " + duration[0] + "\nTime Taken Milliseconds: " + duration[1]);
            return -1;
        } else if(array[middle]==key){
            long[] endTime = {System.nanoTime(), System.currentTimeMillis()};
            long[] duration = {endTime[0]-startTime[0],endTime[1]-startTime[1]};
            System.out.println("Time Taken Nanoseconds: " + duration[0] + "\nTime Taken Milliseconds: " + duration[1]);
            return middle;
        }else if(array[middle]<key){
            recursiveBinarySearch(array, key, middle+1, right);
        } else {
            recursiveBinarySearch(array, key, left, middle-1);
        }
        return -1;
    }

    /**
     * Creates and fills an array randomly based on CHARACTERS string
     * @return the array position, or -1 if the value is not found
     */
    public char[] generateRandomChars(){
        char[] randomChars = new char[32];
        for (int i = 0; i < 32; i++) {
            randomChars[i] = CHARACTERS.charAt(secureRandom.nextInt(CHARACTERS.length()));
        }
        System.out.println("Unsorted: "+ Arrays.toString(randomChars));
        Arrays.sort(randomChars);
        System.out.println("Sorted: "+ Arrays.toString(randomChars));
        return randomChars;
     }

    /**
     * Prints a copy of the array based on the current search range, is called in all other search methods.
      * @param arr array of chars
     * @param left leftmost point of search range
     * @param right rightmost point of search range
     */
    public void remainingElements(char[] arr,int left, int right){
        System.out.println("Current search space: " + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
    }

    /**
     * Performs an iterative linear search of a provided character, also printing the duration of search in nanoseconds and milliseconds
     * @param array char array
     * @param key search value
     * @return the array position, or -1 if the value is not found
     */
    public int iterativeLinearSearch(char[] array, char key){
        int left=0, right=31;
        long[] startTime = {System.nanoTime(), System.currentTimeMillis()};
        remainingElements(array, left, right);//Prints the search area
        for(int i=left; i<=right; i++){
            if(array[i]==key){
                long[] endTime = {System.nanoTime(), System.currentTimeMillis()};
                long[] duration = {endTime[0]-startTime[0],endTime[1]-startTime[1]};
                System.out.println("Time Taken Nanoseconds: " + duration[0] + "\nTime Taken Milliseconds: " + duration[1]);
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs a recursive linear search for a provided character value, also printing the duration of search in nanoseconds and milliseconds.
     *
     * @param array The array of characters to search in.
     * @param key The character to search for within the array.
     * @param index The current index being checked during the recursive search.
     * @return The index of the character in the array if found, or -1 if the character is not present in the array.
     */
    public int recursiveLinearSearch(char[] array, char key, int index){
        long[] startTime = {System.nanoTime(), System.currentTimeMillis()};//Logs the start of the search in nanoseconds and milliseconds
        int right=31;
        if(index>=array.length) {
            long[] endTime = {System.nanoTime(), System.currentTimeMillis()};//Logs the end of the search in nanoseconds and milliseconds
            long[] duration = {endTime[0]-startTime[0],endTime[1]-startTime[1]};//Calculates the Duration of the search in nanoseconds and milliseconds
            remainingElements(array, 0, right);//Prints the search area
            System.out.println("Time Taken Nanoseconds: " + duration[0] + "\nTime Taken Milliseconds: " + duration[1]);
            return -1;
        }else if(array[index]==key){
            long[] endTime = {System.nanoTime(), System.currentTimeMillis()};
            long[] duration = {endTime[0]-startTime[0],endTime[1]-startTime[1]};
            remainingElements(array, 0, right);//Prints the search area
            System.out.println("Time Taken Nanoseconds: " + duration[0] + "\nTime Taken Milliseconds: " + duration[1]);
            return index;
        }else{
            return recursiveLinearSearch(array, key, index+1);
        }
    }



}
