package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class enters a number from the user and displays if it is unique or not.
 * A number is unique if all of its digits are different.
 * @author Sayan Biswas
 * @version 02.04.2022
 */
public class UniqueNumber {

    /**
     * Stores digits of the number
     */
    private int[] number;

    /**
     * Initializes instance variables
     */
    private UniqueNumber() {
        number = null;
    }

    /**
     * Inputs a number from user and store the digits into an array
     */
    private void input() {
        //Variable to store the number
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        if(!sc.hasNextInt()){
            //Deals with InputMismatchException
            System.out.print("Wrong datatype; enter a number: ");
            input();
        }
        s = sc.nextLine();
        number = new int[s.length()];
        //Iteration to store the digits of the number in an array
        for(int i = 0; i < s.length(); i++) {
            number[i] = s.charAt(i);
        }
    }

    /**
     * Checks if a number is unique or not.
     * @param digits The digit array to be checked.
     * @return boolean true or false
     */
    private boolean uniqueCheck(int[] digits) {
        //Loops through the digits of the number; Variable j acts as the search term
        for (int j = 0; j < digits.length; j++) {
            //Loops through the digits of the number for each j
            for (int k = j + 1; k < digits.length; k++) {
                //Element at position k is checked for equality with element at position j
                if (digits[j] == digits[k]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Displays the result
     * @param x Signifies number is unique or not.
     */
    private void display(boolean x) {

        System.out.println(x ? "Number is unique." : "Number is not unique.");
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        UniqueNumber ob = new UniqueNumber();
        ob.input();
        ob.display(ob.uniqueCheck(ob.number));
    }
}
