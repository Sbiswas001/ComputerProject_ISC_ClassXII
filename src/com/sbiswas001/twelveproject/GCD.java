package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class calculates the greatest common divisor
 * of two numbers.
 * @author Sayan Biswas
 * @version 23.04.2022
 */
public class GCD {

    /**
     * Stores first number
     */
    private int num1;

    /**
     * Stores second number
     */
    private int num2;

    /**
     * Initialises instance variables
     */
    private GCD() {
        num1 = 0;
        num2 = 0;
    }

    /**
     * Inputs two numbers from user
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        num1 = Integer.parseInt(sc.next());
        System.out.print("Enter second number: ");
        num2 = Integer.parseInt(sc.next());
    }

    /**
     * Calculates the greatest common divisor of two numbers.
     * @param a First number
     * @param b Second number
     * @return GCD
     */
    private int setGCD(int a, int b) {
        for(int i = Math.max(a,b); i > 1; i--) {
            if(a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        GCD ob = new GCD();
        ob.input();
        System.out.println("GCD is " + ob.setGCD(ob.num1, ob.num2));
    }

}
