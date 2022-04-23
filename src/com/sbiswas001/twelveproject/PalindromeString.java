package com.sbiswas001.twelveproject;

import java.util.Scanner;

public class PalindromeString {

    private String s;

    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        s = sc.nextLine();
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        PalindromeString ob = new PalindromeString();
        ob.input();
        System.out.println();//TODO
    }
}
