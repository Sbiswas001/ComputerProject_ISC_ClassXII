package com.sbiswas001.twelveproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class enters a name from user and
 * prints out the initials.
 * @author Sayan Biswas
 * @version 23.04.2022
 */
public class Initials {

    /**
     * Stores name
     */
    private String name;

    /**
     * Stores initials
     */
    private final ArrayList<String> initials;

    /**
     * Initialises instance variables
     */
    private Initials() {
        name = "";
        initials = new ArrayList<>();
    }

    /**
     * Inputs name from user
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        name = " " + sc.nextLine().trim();
    }

    /**
     * Sets the initials of the name
     */
    private void setInitials() {
        for(int i = 0; i < name.lastIndexOf(' '); i++) {
            if(name.charAt(i) == ' ') {
                initials.add(name.charAt(i+1) + ". ");
            }
        }
        initials.add(name.substring(name.lastIndexOf(' ')));
    }

    /**
     * Displays the initials
     */
    private void display() {
        System.out.print("Initials: ");
        for(int i = 0; i < initials.size(); i++) {
            System.out.print(initials.get(i));
        }
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        Initials ob = new Initials();
        ob.input();
        ob.setInitials();
        ob.display();
    }
}
