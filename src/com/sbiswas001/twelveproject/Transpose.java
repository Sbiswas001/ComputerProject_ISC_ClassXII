package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class transposes a matrix.
 * Transpose of a matrix is formed by interchanging
 * the rows and columns of the matrix.
 * @author Sayan Biswas
 * @version 25.04.2022
 */
public class Transpose {
    /**
     * Stores the matrix
     */
    private int[][] mat;

    /**
     * Stores order of matrix
     */
    private int order;

    /**
     * Initializes instance variables
     */
    private Transpose() {
        mat = null;
        order = 0;
    }

    /**
     * Inputs number of rows and columns of a matrix
     * and the elements of the matrix.
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order of the square matrix: ");
        order = Integer.parseInt(sc.nextLine());
        mat = new int[order][order];
        System.out.println("Enter the elements of the matrix: ");
        for(int i = 0; i < order; i++) {
            for(int j = 0; j < order; j++) {
                mat[i][j] = Integer.parseInt(sc.next());
            }
        }
    }

    /**
     * Transposes the matrix
     */
    private void compute() {
        int temp;
        for(int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    /**
     * Prints a two-dimensional array
     * @param a The array to be printed
     */
    private void display(int[][] a) {
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
        Transpose ob = new Transpose();
        ob.input();
        System.out.println("Entered matrix is: ");
        ob.display(ob.mat);
        ob.compute();
        System.out.println("Transpose of matrix is ");
        ob.display(ob.mat);
    }
}
