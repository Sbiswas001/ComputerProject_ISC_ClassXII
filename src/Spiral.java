import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classname: Spiral
 * This class enters a two-dimensional matrix from the user
 * and prints it. It then prints it in spiral order.
 * Spiral order means the elements are printed clockwise
 * along the outermost row and column and eventually ending
 * in the centre.
 * @author Sayan Biswas
 * @version 15.04.2022
 */
public class Spiral {

    /**
     * mat Stores the matrix
     * spiral Stores elements in spiral order
     * m Stores number of rows
     * n Stores number of columns
     */
    private int[][] mat;
    private ArrayList<Integer> spiral;
    private int m;
    private int n;

    /**
     * Initializes instance variables
     */
    private Spiral() {
        mat = null;
        spiral = null;
        m = 0;
        n = 0;
    }

    /**
     * Inputs number of rows and columns of a matrix
     * and the elements of the matrix.
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        m = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the number of columns of the matrix: ");
        n = Integer.parseInt(sc.nextLine());
        mat = new int[m][n];
        spiral = new ArrayList<>(m * n);
        System.out.println("Enter the elements of the matrix: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(sc.next());
            }
        }
    }

    /**
     * Stores elements in spiral order
     */
    private void setSpiral() {
        int  startRow = 0, startColumn=0;
        while (startRow < m && startColumn < n) {
            //Print the first row from the remaining rows
            for (int i = startColumn; i < n; ++i) {
                spiral.add(mat[startRow][i]);
            }
            startRow++;

            // Print the last column from the remaining columns
            for (int i = startRow; i < m; ++i) {
                spiral.add(mat[i][n - 1]);
            }
            n--;

            // Print the last row from the remaining rows
            if (startRow < m) {
                for (int i = n - 1; i >= startColumn; --i) {
                    spiral.add(mat[m - 1][i]);
                }
                m--;
            }

            // Print the first column from the remaining columns
            if (startColumn < n) {
                for (int i = m - 1; i >= startRow; --i) {
                    spiral.add(mat[i][startColumn]);
                }
                startColumn++;
            }
        }
    }

    /**
     * Prints a one-dimensional arraylist
     * @param a The arraylist to be printed
     */
    private void displayArrayList(ArrayList<Integer> a) {
        for(int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
    }

    /**
     * Prints a two-dimensional array
     * @param a The array to be printed
     */
    private void displayArray(int[][] a) {
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
        Spiral ob = new Spiral();
        ob.input();
        System.out.println("Entered matrix is: ");
        ob.displayArray(ob.mat);
        ob.setSpiral();
        System.out.print("Array in spiral order is: ");
        ob.displayArrayList(ob.spiral);

    }
}
