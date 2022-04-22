package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class asks user to enter length and breadth
 * of a rectangle and displays a menu asking users to choose
 * among calculating perimeter, area or length of diagonal.
 */
public class Rectangle {

    /**
     * Stores length of the rectangle
     */
    private int length;

    /**
     * Stores breadth of the rectangle
     */
    private int breadth;

    /**
     * Stores choice of user
     */
    private int ch;

    /**
     * Initializes instance variables
     */
    private Rectangle() {
        length = 0;
        breadth = 0;
        ch = 0;
    }

    /**
     * Inputs length and breadth of rectangle from user
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of rectangle: ");
        length = Integer.parseInt(sc.next());
        System.out.print("Enter breadth of rectangle: ");
        breadth = Integer.parseInt(sc.next());
        System.out.println("""
                Choose from 1-3:
                1. Perimeter of rectangle
                2. Area of rectangle
                3. Length of Diagonal""");
        ch = Integer.parseInt(sc.next());
    }

    /**
     * Displays values according to user's choice
     */
    private void menu() {
        switch (ch) {
            case 1:
                System.out.println("Perimeter of rectangle is " + (2*(length + breadth)));
                break;
            case 2:
                System.out.println("Area of rectangle is " + (length * breadth));
                break;
            case 3:
                System.out.println("Length of Diagonal is " + Math.sqrt(length * breadth));
                break;
        }
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        Rectangle ob = new Rectangle();
        ob.input();
        ob.menu();
    }




}
