package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class enters a number of days and a year(4 digit)
 * from user and prints the date. It also takes an
 * increment(1 to 100) value and shows the new date.
 * @author Sayan Biswas
 * @version 25.04.2022
 */
public class DateRepresentation {
    /**
     * Stores number of initial days entered by user
     */
    private int days;

    /**
     * Stores year entered by user
     */
    private int year;

    /**
     * Stores number of days to increment to old date
     */
    private int increment;

    /**
     * Stores the month index
     */
    private int monthIndex;

    /**
     * Stores the suffix of date
     */
    private String suffix;

    /**
     * Stores the old date
     */
    private int oldDate;

    /**
     * Stores new date
     */
    private int daysAfter;

    /**
     * Stores names of months
     */
    private final String[] monthNames;

    /**
     * Stores number of days of each month
     */
    private final int[] monthDays;

    /**
     * Initialises instance variables
     */
    private DateRepresentation() {
        days = 0;
        year = 0;
        increment = 0;
        monthIndex = 0;
        suffix = "";
        oldDate = 0;
        daysAfter = 0;
        monthNames = new String[]{"JANUARY", "FEBRUARY",
                "MARCH", "APRIL", "MAY", "JUNE", "JULY",
                "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER",
                "DECEMBER"};
        monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31,
                30, 31, 30, 31};
    }

    /**
     * Inputs the days, year and increment value
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        days = Integer.parseInt(sc.next());
        System.out.print("Enter year(4 digits): ");
        year = Integer.parseInt(sc.next());
        if (year < 1000 || year > 9999) {
            System.out.println("Try again! " +
                    "Year must be 4 digits.");
            input();
        }
        System.out.print("Enter increment after old date: ");
        increment = Integer.parseInt(sc.next());
        if (increment < 1 || increment > 100) {
            System.out.println("Try again! Range 1 to 100.");
            input();
        }
    }

    /**
     * Calculates old date
     */
    private void oldDateCalculator() {
        //February should have 29 days if it is leap year
        if (year % 400 == 0 ||
                (year % 100 != 0 && year % 4 == 0)) {
            monthDays[1] = 29;
        }

        oldDate = days;
        while(oldDate > monthDays[monthIndex]) {
            oldDate -= monthDays[monthIndex];
            monthIndex++;
            if (monthIndex == 12) {
                monthIndex = 0;
                year++;
                if (year % 400 == 0 ||
                        (year % 100 != 0 && year % 4 == 0)) {
                    monthDays[1] = 29;
                }
            }
        }

        //Adding suffix as per day
        if (oldDate % 10 == 1 && oldDate / 10 != 1) {
            suffix = "ST";
        } else if (oldDate % 10 == 2 && oldDate / 10 != 1) {
            suffix = "ND";
        } else if (oldDate % 10 == 3 && oldDate / 10 != 1) {
            suffix = "RD";
        } else {
            suffix = "TH";
        }
    }

    /**
     * Calculates new date
     */
    private void newDateCalculator() {
        //Calculating date after n days
        daysAfter = oldDate + increment;
        while(daysAfter > monthDays[monthIndex]) {
            daysAfter -= monthDays[monthIndex];
            monthIndex ++;
            if (monthIndex == 12) {
                monthIndex = 0;
                year++;
                if (year % 400 == 0 ||
                        (year % 100 != 0 && year % 4 == 0)) {
                    monthDays[1] = 29;
                }
            }
        }
        //Adding suffix as per day
        if (daysAfter % 10 == 1 && daysAfter / 10 != 1) {
            suffix = "ST";
        } else if (daysAfter % 10 == 2 && daysAfter / 10 != 1) {
            suffix = "ND";
        } else if (daysAfter % 10 == 3 && daysAfter / 10 != 1) {
            suffix = "RD";
        } else {
            suffix = "TH";
        }
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        DateRepresentation ob = new DateRepresentation();
        ob.input();
        ob.oldDateCalculator();
        System.out.println("Old date: " + ob.oldDate +
                ob.suffix + " " + ob.monthNames[ob.monthIndex]
                + " " + ob.year);
        ob.newDateCalculator();
        System.out.println("New date: " + ob.daysAfter +
                ob.suffix + " " + ob.monthNames[ob.monthIndex]
                + " " + ob.year);
    }
}
