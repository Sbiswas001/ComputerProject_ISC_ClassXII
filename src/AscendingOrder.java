import java.util.Scanner;

/**
 * This class inputs an array of integers
 * and sorts them in ascending order.
 */
public class AscendingOrder {

    /**
     * Array to store the integers
     */
    private int[] arr;

    /**
     * Initializes instance variables
     */
    private AscendingOrder() {
        arr = null;
    }

    /**
     * Inputs an array of integers
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of integers: ");
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n];
        System.out.print("Enter the numbers: ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
    }

    /**
     * Sorts an array in ascending order
     * @param a Array to be sorted
     * @return Sorted array
     */
    private int[] sort(int[] a) {
        int temp;
        int n=a.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(a[j]>a[j+1]) {
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
     * @param a Array to be printed
     */
    private void display(int[] a) {
        System.out.print("Elements in ascending order are: ");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        AscendingOrder ob = new AscendingOrder();
        ob.input();
        ob.display(ob.sort(ob.arr));
    }
}
