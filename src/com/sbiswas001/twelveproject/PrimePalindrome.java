package com.sbiswas001.twelveproject;

import java.util.Scanner;

/**
 * This class checks if a number is prime-palindrome
 * or not. A number is prime-palindrome if it is a
 * prime number as well as a palindrome number.
 * @author Sayan Biswas
 * @version 25.04.2022
 */
public class PrimePalindrome {

    /**
     * Stores number
     */
    private int x;

    /**
     * Initializes instance variables
     */
    private PrimePalindrome() {
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
    private boolean palindromeCheck(int n)
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
     * Checks if number is prime or not
     * @param a Number to be checked
     * @return true or false
     */
    private boolean primeCheck(int a) {
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
     * Displays if number is prime-palindrome or not.
     */
    private void display() {
        System.out.println(palindromeCheck(x) && primeCheck(x) ?
                "Number is prime-palindrome." :
                "Number is not prime-palindrome.");
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        PrimePalindrome ob  = new PrimePalindrome();
        ob.input();
        ob.display();
    }


}
