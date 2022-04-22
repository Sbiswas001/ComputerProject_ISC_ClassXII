package com.sbiswas001.twelveproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class returns the number of words in a sentence.
 * Words are separated by ' ' and ends with '.', '?' or '!'.
 */
public class WordCounter {

    /**
     * Stores the sentence
     */
    private String s;

    /**
     * Stores the words
     */
    private final ArrayList<String> words;

    /**
     * Initializes instance variables
     */
    private WordCounter() {
        s = "";
        words = new ArrayList<>();
    }

    /**
     * Inputs a sentence from user
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        s = sc.nextLine().trim() + " ";
    }

    /**
     * Counts the number of words in a sentence.
     * Words are separated by ' ' and ends with '.', '?' or '!'.
     * @return Number of words
     */
    private int countWords() {
        int startIndex = 0;
        for(int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if(c == '.' || c == '?' || c == '!') {
                words.add(s.substring(startIndex, i));
                break;
            }
            if(c == ' ') {
                words.add(s.substring(startIndex, i));
                startIndex = i;
            }
        }
        return words.size();
    }

    /**
     * Displays words and number of words
     */
    private void display() {
        int count = countWords();
        System.out.print("The words in the sentence are: ");
        for(int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + " ");
        }
        System.out.print("\nNumber of words in the sentence are : " + count);
    }

    /**
     * Calls other methods
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {
        WordCounter ob = new WordCounter();
        ob.input();
        ob.display();
    }
}
