package ru.codewars.solutions;

import java.util.Arrays;

public class Main {

    // English alphabet size
    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        int n = 45;
        int sum = 0;

        while (n > 0) {
            sum += n * n * n;
            --n;
        }

        System.out.println(sum);
    }

    // Splits string into array of strings with 2 symbols each
    // Adds underscore if last string contains only one symbols
    public static String[] StringSplit(String s) {
        if (s.length() == 0)
            return new String[0];
        if (s.length() % 2 != 0)
            s += "_";
        var arrayLength = s.length() / 2;
        var res = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++)
        {
            res[i] = String.valueOf(s.charAt(2 * i)) + s.charAt(2 * i + 1);
        }
        return res;
    }

    // Translate string from snake case to camel case
    // But keeps first letter case in first word
    public static String toCamelCase(String s){
        String[] words = s.split("[_|-]");
        String res = Arrays.stream(
                        words)
                .skip(1)
                .map(word -> word = String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1))
                .reduce(String::concat).orElse("");
        return words[0] + res;
    }

    // Check if string contains every letter of latin alphabet
    // At least once
    public static boolean checkPangram(String sentence) {

        if (sentence == null || sentence.isBlank())
            return false;

        sentence = sentence.toLowerCase();
        boolean[] alphabet = new boolean[ALPHABET_SIZE];

        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(sentence.charAt(i))) {
                alphabet[sentence.charAt(i) - 'a'] = true;
            }
        }

        for (var isLetterPresent: alphabet) {
            if (!isLetterPresent)
                return false;
        }

        return true;
    }

    // https://www.codewars.com/kata/5592e3bd57b64d00f3000047/java
    public static long findNb(long m) {
        int n = 1;

        do {
            m -= (long) n * n * n;
            ++n;
        } while (m > 0);

        return m == 0 ? n - 1 : -1;
    }

    // https://www.codewars.com/kata/523f5d21c841566fde000009/java
    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        return a;
    }
}
