import java.util.Scanner;

/**
 * Classname: PalindromeNumber
 * This class enters a number from the user and displays if it is palindrome or not.
 * A number is palindrome if it is same when read from both sides.
 * @author Sayan Biswas
 * @version 05.04.2022
 */
public class PalindromeNumber {

    /**
     * x Stores number
     */
    private int x;

    /**
     * Initializes instance variables
     */
    private PalindromeNumber() {
        x=0;
    }

    /**
     * Inputs a number from user
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        x=Integer.parseInt(sc.next());
    }

    /**
     * Checks if a number is palindrome or not.
     * @param n Number to be checked
     * @return true or false
     */
    private boolean palindrome_check(int n)
    {
        return n == reverse(n);
    }

    /**
     * Reverses a number
     * @param n Number to be reversed
     * @return Reversed number
     */
    private int reverse(int n)
    {
        int sum=0, r;
        while(n>0)
        {
            r=n%10;
            sum=(sum*10)+r;
            n=n/10;
        }
        return sum;
    }

    /**
     * Displays the result
     * @param x Signifies number is palindrome or not.
     */
    private void display(boolean x) {

        System.out.println(x ? "Number is palindrome." : "Number is not palindrome.");
    }

    /**
     * Calls other methods
     */
    public static void main(String[] args) {
        PalindromeNumber ob = new PalindromeNumber();
        ob.input();
        ob.display(ob.palindrome_check(ob.x));
    }
}
