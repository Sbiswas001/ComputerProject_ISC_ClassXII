import java.util.Scanner;

/**
 * Classname: LinearSearch
 * This class checks if a term is in an array.
 * If found it displays appropriate message along
 * with index number of the term.
 */
public class LinearSearch {

    /**
     * Stores the index of search term
     */
    int searchTermIndex;

    /**
     * The term to be searched for
     */
    int searchTerm;

    /**
     * Array to be searched
     */
    int[] arr;

    /**
     * Initializes instance variables
     */
    private LinearSearch()  {
        searchTermIndex = 0;
        searchTerm = 0;
        arr = null;
    }

    /**
     * Inputs number of an array and search term.
     */
    private void input() {
        int arrayLength;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        arrayLength = Integer.parseInt(sc.nextLine());
        arr = new int[arrayLength];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < arrayLength; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        System.out.print("Enter the search term: ");
        searchTerm = Integer.parseInt(sc.next());
    }

    /**
     * Checks if a term is in an array.
     * If found it sets the searchTermIndex.
     * @param a Array to be searched in
     * @param x Term to be searched for
     * @return true or false
     */
    boolean array_search(int[] a, int x) {
        for(int i =0; i <a.length; i++) {
            if(x==a[i]) {
                searchTermIndex = i;
                return true;
            }
        }
        return false;
    }

    /**
     *Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        LinearSearch ob = new LinearSearch();
        ob.input();
        System.out.println(ob.array_search(ob.arr, ob.searchTerm) ?
                "Element is found at index " + ob.searchTermIndex :
                "Element is not found.");
    }
}
