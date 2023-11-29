package com.tanu;

import java.util.*;

public class CSP {
    public static void main(String[] args) {
        String[] words = {"BANJO", "VIOLA", "VIOLIN"};
        List<Character> uniqueLetters = new ArrayList<>();

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                if (!uniqueLetters.contains(letter)) {
                    uniqueLetters.add(letter);
                }
            }
        }

        int[] digits = new int[uniqueLetters.size()];
        boolean[] used_digits = new boolean[10];
        boolean answer = Cryptarithmetic(words, uniqueLetters, digits, used_digits, 0);

        if (answer) {
            System.out.println("Solution found:");
            for (int i = 0; i < uniqueLetters.size(); i++) {
                System.out.print(uniqueLetters.get(i) + " = " + digits[i] + " ");
            }
        } else {
            System.out.println("No solution found.");
        }
    }

    static boolean Cryptarithmetic(String[] words, List<Character> uniqueLetters, int[] digits, boolean[] used, int index) {
        if (index == uniqueLetters.size()) {
            return evaluateExpression(words, uniqueLetters, digits);
        }

        for (int digit = 9; digit >= 0; digit--) {
            if (!used[digit]) {
                used[digit] = true;
                digits[index] = digit;
                if (Cryptarithmetic(words, uniqueLetters, digits, used, index + 1)) {
                    return true;
                }
                used[digit] = false;
            }
        }
        return false;
    }

    static boolean evaluateExpression(String[] words, List<Character> uniqueLetters, int[] digits) {
        int[] wordValues = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int value = 0;
            for (char letter : words[i].toCharArray()) {
                int index = uniqueLetters.indexOf(letter);
                value = value * 10 + digits[index];
            }
            wordValues[i] = value;
        }

        int total = 0;
        for (int i = 0; i < wordValues.length - 1; i++) {
            total += wordValues[i];
        }

        return (total == wordValues[wordValues.length - 1]);
    }
}