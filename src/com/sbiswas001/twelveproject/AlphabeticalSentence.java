package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class enters multiple strings from user and arranges
 * them in ascending order.
 * @author Sayan Biswas
 * @version 08.04.2022
 */
public class AlphabeticalSentence {
    /**
     * Stores strings
     */
    private String[] s;

    /**
     * Initializes instance variables
     */
    private AlphabeticalSentence() {
        s = null;
    }

    /**
     * Inputs strings from user and stores them into an array
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        //Deals with InputMismatchException
        if(!sc.hasNextInt()){
            System.out.print("Wrong input! Enter a number: ");
            input();
        }
        int x=Integer.parseInt(sc.next());
        s = new String[x];
        System.out.print("Enter the strings: ");
        for (int i = 0; i < x; i++) {
            s[i] = sc.next();
        }
    }

    /**
     * Arranges the strings in alphabetical order
     * @param a Strings to be sorted
     */
    private void compute(String[] a) {
        String temp;
        //Bubble sort technique
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].toUpperCase().
                        compareTo(a[j].toUpperCase())>0) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * Displays the sorted strings
     */
    private void display() {

        for(int i=0; i<s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        AlphabeticalSentence ob = new AlphabeticalSentence();
        ob.input();
        ob.compute(ob.s);
        ob.display();
    }
}

