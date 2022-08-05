package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class takes a two-dimensional square matrix from the
 * user with number of rows and columns between 2 and 10 and
 * prints it.
 * It then checks if it is symmetric or not.
 * A square matrix is symmetric if element of the ith row and
 * jth column is equal to the element of jth row and ith
 * column. It then prints the sum of the elements of the left
 * diagonal and sum of elements of right diagonal.
 * @author Sayan Biswas
 * @version 10.04.2022
 */
public class Matrix {
    /**
     * Stores the matrix
     */
    private int[][] A;

    /**
     * Stores number of rows
     */
    private int m;

    /**
     * Stores number of columns
     */
    private int n;

    /**
     * Stores sum of left diagonal elements
     */
    private int leftDiagonalSum;

    /**
     * Stores sum of right diagonal elements
     */
    private int rightDiagonalSum;

    /**
     * Initializes instance variables
     */
    private Matrix() {
        A = null;
        m = 0;
        n = 0;
        leftDiagonalSum = 0;
        rightDiagonalSum = 0;
    }

    /**
     * Inputs order of matrix (between 2 and 10) and
     * columns of a matrix and the elements of the matrix.
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order of matrix: ");
        m = Integer.parseInt(sc.nextLine());
        if(m <= 2 || m >= 10) {
            System.out.print("Out of range!" +
                    "Enter order of matrix(2-10): ");
            input();
        }
        n = m;
        A = new int[m][n];
        System.out.println("Enter the elements of matrix: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(sc.next());
            }
        }
    }

    /**
     * Checks if a matrix is symmetric.
     * A square matrix is symmetric if element of the ith row
     * and jth column is equal to the element of jth row and
     * ith column.
     * @param a Matrix to be checked
     * @return true or false
     */
    private boolean symmetricCheck(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j]!=a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * It calculates the sum of the elements of the left diagonal
     * and sum of elements of right diagonal.
     * @param a Matrix to be checked
     */
    private void diagonalSum(int[][] a) {
        for(int i = 0; i < a.length; i++) {
                //Elements are like a00, a11, a22, ...
                leftDiagonalSum += a[i][i];
                //Elements are a0((n-1)-0), a1((n-1)-1), ...
                rightDiagonalSum += a[i][(a.length - 1) - i];
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
        Matrix ob = new Matrix();
        ob.input();
        System.out.println("Entered matrix is: ");
        ob.display(ob.A);
        System.out.println(ob.symmetricCheck(ob.A) ?
                "The matrix is symmetric." :
                "The matrix is not symmetric.");
        ob.diagonalSum(ob.A);
        System.out.println("The sum of left diagonal elements is " +
                ob.leftDiagonalSum + ".\n" +
                "The sum of right diagonal elements is " +
                ob.rightDiagonalSum + ".");
    }
}
