package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class enters a matrix from the user, prints the
 * non-boundary elements, sorts them and prints the matrix
 * with sorted non-boundary elements.
 * The non-boundary elements of a matrix are those not at
 * extreme rows and columns.
 * @author Sayan Biswas
 * @version 04.04.2022
 */
public class NonBoundary {

    /**
     * Stores the matrix
     */
    private int[][] mat;

    /**
     * Stores number of rows
     */
    private int r;

    /**
     * Stores number of columns
     */
    private int c;

    /**
     * Initializes instance variables
     */
    private NonBoundary() {
        mat = null;
        r = 0;
        c = 0;
    }

    /**
     * Inputs number of rows and columns of a matrix
     * and the elements of the matrix
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows of matrix: ");
        r = Integer.parseInt(sc.nextLine());
        System.out.print("Enter number of columns of matrix: ");
        c = Integer.parseInt(sc.nextLine());
        mat = new int[r][c];
        System.out.println("Enter elements of matrix: ");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                mat[i][j] = Integer.parseInt(sc.next());
            }
        }
    }

    /**
     * Stores boundary elements in a one dimensional array,
     * prints the non-boundary elements, sorts the
     * non-boundary elements, then replaces the non-boundary
     * elements of the original two-dimensional array with
     * the sorted non-boundary elements
     */
    private void compute() {
        //Stores non-boundary elements
        int[] nonBound = new int[(r - 2) * (c - 2)];
        int k = 0;
        for(int i = 1; i < r-1; i++) {
            for(int j = 1; j < c-1; j++) {
                //Stores non-boundary elements in 1-D array
                nonBound[k] = mat[i][j];
                k++;
            }
        }

        System.out.println("The non-boundary elements are: ");
        displayOneD(nonBound);

        //Sorted non-boundary elements
        int[] x = sort(nonBound);
        k = 0;
        for(int i = 1; i < r-1; i++) {
            for(int j = 1; j < c-1; j++) {
                //Replaces non-boundary elements of original matrix
                mat[i][j] = x[k];
                k++;
            }
        }
    }

    /**
     * Sorts a one-dimensional array
     * @param a The array to a sorted
     * @return The sorted array
     */
    private int[] sort(int[] a) {
        int temp;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-i-1; j++) {
                if(a[j] > a[j+1]) {
                    //Swapping values
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * Prints a one-dimensional array
     * @param a The array to be printed
     */
    private void displayOneD(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    /**
     * Prints a two-dimensional array
     * @param a The array to be printed
     */
    private void displayTwoD(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        NonBoundary ob = new NonBoundary();
        ob.input();
        System.out.println("Entered array is: ");
        ob.displayTwoD(ob.mat);
        ob.compute();
        System.out.println("The matrix with sorted " +
                "non-boundary elements is: ");
        ob.displayTwoD(ob.mat);
    }
}