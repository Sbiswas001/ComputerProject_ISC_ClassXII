package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class checks if a string is palindrome or not.
 * A string is palindrome if it is read same from both sides.
 */
public class PalindromeString {

    /**
     * Stores the string
     */
    private String s;

    /**
     * Initialises instance variables
     */
    private PalindromeString() {
        s = "";
    }

    /**
     * Enters a string from user
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        s = sc.nextLine();
    }

    /**
     * Checks if string is palindrome or not
     * @param x String to be checked
     * @return true or false
     */
    private boolean palindromeCheck(String x) {
        String rev = (new StringBuilder(x)).reverse().toString();
        return rev.equals(s);
    }

    /**
     * Displays the result
     */
    private void display() {
        System.out.println(palindromeCheck(s) ?
                "String is palindrome." :
                "String is not palindrome.");
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        PalindromeString ob = new PalindromeString();
        ob.input();
        ob.display();
    }
}
