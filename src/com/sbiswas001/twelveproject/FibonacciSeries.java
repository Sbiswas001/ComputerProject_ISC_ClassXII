package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class prints n terms of the fibonacci series specified by user.
 * In fibonacci series, next number is the sum of previous two numbers.
 * @author Sayan Biswas
 * @version 06.04.2022
 */
public class FibonacciSeries {

    /**
     * Stores number of terms
     */
    private int x;

    /**
     * Initializes instance variables
     */
    private FibonacciSeries() {
        x=0;
    }

    /**
     * Inputs number of terms from user
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        x=Integer.parseInt(sc.next());
    }

    /**
     * Calculates and prints out the Fibonacci series
     * @param n Number of terms
     */
    private void compute(int n) {
        int a1 = 0, a2 = 1, a3;
        //Printing first two terms
        System.out.print(a1 + " " + a2);
        for(int i = 2; i < n; ++i) {
            a3 = a1 + a2;
            System.out.print(" " + a3);
            a1 = a2;
            a2 = a3;
        }
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        FibonacciSeries ob = new FibonacciSeries();
        ob.input();
        ob.compute(ob.x);
    }
}
