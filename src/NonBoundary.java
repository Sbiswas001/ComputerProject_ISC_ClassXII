import java.util.*;

/**
 * Classname: NonBoundary
 * This class enters a matrix from the user, prints the non-boundary elements,
 * sorts them and prints the matrix with sorted non-boundary elements.
 * A number is unique if all of its digits are different.
 * @author Sayan Biswas
 * @version 02.04.2022
 */
public class NonBoundary {
    private int[][] mat;//Stores matrix
    int r;//Stores number of rows
    int c;//Sores number of columns

    /**
     * Initializes instance variables
     */
    NonBoundary() {
        mat = null;
        r=0;
        c=0;
    }

    /**
     * Inputs number of rows and columns of a matrix and the elements of the matrix
     */
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        r = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the number of columns of the matrix: ");
        c = Integer.parseInt(sc.nextLine());
        mat = new int[r][c];
        System.out.print("Enter the elements of the matrix: ");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                mat[i][j]=Integer.parseInt(sc.next());
            }
        }
    }

    /**
     * Stores boundary elements in a one dimensional array, prints the non-boundary elements,
     * sorts the non-boundary elements, then replaces the non-boundary elements of the original
     * two-dimensional array with the sorted non-boundary elements
     */
    void compute() {
        int[] nonBound = new int[(r - 2) * (c - 2)];//Stores boundary elements
        int k=0;
        for(int i = 1; i < r-1; i++) {
            for(int j = 1; j < c-1; j++) {
                nonBound[k]= mat[i][j];//Stores boundary elements in a one dimensional array
                k++;
            }
        }

        System.out.println("The non-boundary elements are: ");
        displayOneD(nonBound);

        int[] x=sort(nonBound);//Sorted non-boundary elements
        k=0;
        for(int i = 1; i < r-1; i++) {
            for(int j = 1; j < c-1; j++) {
                mat[i][j]=x[k];//Replaces the non-boundary elements of the original matrix
                k++;
            }
        }
    }

    /**
     * Sorts a one-dimensional array
     * @param a The array to a sorted
     * @return The sorted array
     */
    int[] sort(int[] a) {
        int temp;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a.length-i-1;j++) {
                if(a[j]>a[j+1]) {//Swapping values
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;
    }

    /**
     * Prints a one-dimensional array
     * @param a The array to be printed
     */
    void displayOneD(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    /**
     * Prints a two-dimensional array
     * @param a The array to be printed
     */
    void displayTwoD(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j=0;j<a[0].length;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Calls other methods
     */
    public static void main(String[] args) {
        NonBoundary ob = new NonBoundary();
        ob.input();
        System.out.println("Entered array is: ");
        ob.displayTwoD(ob.mat);
        ob.compute();
        System.out.println("The matrix with sorted non-boundary elements is: ");
        ob.displayTwoD(ob.mat);
    }
}