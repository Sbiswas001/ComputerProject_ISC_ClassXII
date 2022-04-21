import java.util.Scanner;

/**
 * Classname: Mobius
 * This class enters a number from the user and displays the mobius function value.
 * The mobius function return 1, -1, 0 based on some conditions.
 * @author Sayan Biswas
 * @version 06.04.2022
 */
public class Mobius {
    /**
     * Stores number
     */
    private int x;

    /**
     * Initializes instance variables
     */
    private Mobius() {
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
     * Returns 1, -1, 0 based on the following conditions
     * 1 if n = 1
     * (−1)^k if n is products of k distinct primes.
     * 0 if n has a squared prime factor.
     * @param a Number to be checked
     * @return 1, -1, 0
     */
    private int mobius(int a) {
        if(a==1) {
            return 1;
        }
        //Counts number of prime factors
        int count = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && primeCheck(i)) {
                //Checks if a has squared prime factor.
                if (a % (i * i) == 0) {
                    return 0;
                }
                else {
                    count++;
                }
            }
        }
        return (count % 2 != 0) ? -1 : 1;
    }


    /**
     * Checks if number is prime or not
     * @param a Number to be checked
     * @return true or false
     */
    private boolean primeCheck(int a)
    {
        int flag=0;
        if(a<2) return false;
        for(int i=2;i<a;i++) {
            if(a%i==0) {
                flag++;
                break;
            }
        }
        return flag != 1;
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        Mobius ob = new Mobius();
        ob.input();
        System.out.println(ob.mobius(ob.x));
    }
}
