import java.util.Scanner;
/**
 * Classname: UniqueNumber
 * This class enters a number from the user and displays if it is unique or not.
 * A number is unique if all of its digits are different.
 * @author Sayan Biswas
 * @version 02.04.2022
 */
public class UniqueNumber {
    private int[] number;                                //Stores digits of the number
    /**
     * Initializes instance variables
     */
    UniqueNumber() {
        number = null;                                    //Initialising instance variable with default value
    }

    /**
     * Inputs a number from user and store the digits into an array
     */
    void input() {
        String s;                                         //Variable to store the number

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        if(!sc.hasNextInt()){                              //Deals with InputMismatchException
            System.out.print("Wrong datatype; enter a number: ");
            input();
        }
        s = sc.nextLine();
        number = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {              //Loop to store the digits of the number in an array
            number[i] = s.charAt(i);
        }
    }

    /**
     * Checks if a number is unique or not.
     * @param digits The digit array to be checked.
     * @return true or false
     */
    boolean uniqueCheck(int[] digits) {
        for (int j = 0; j < digits.length; j++) {           //Loops through the digits of the number; Variable j acts as the search term
            for (int k = j + 1; k < digits.length; k++) {   //Loops through the digits of the number for each j
                if (digits[j] == digits[k]) {               //Element at position k is checked for equality with element at position j
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Displays the result
     * @param x Signifies if the number is unique or not.
     */
    void display(boolean x) {

        System.out.println(x ? "Number is unique." : "Number is not unique.");
    }

    /**
     * Calls other methods
     */
    public static void main(String[] args) {
        UniqueNumber ob = new UniqueNumber();
        ob.input();
        ob.display(ob.uniqueCheck(ob.number));
    }
}