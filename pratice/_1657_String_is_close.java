package pratice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class _1657_String_is_close {
    public static boolean operation1(String word1, String word2) {
        HashMap<Character, Integer> count1 = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        int count = 1;
        char temp = word1Arr[0];
        for (int j = 1; j < word1Arr.length; j++) {
            if (word1Arr[j] == temp) {
                count++;
            } else {
                count1.put(word1Arr[j], count);
                count = 1;
                temp = word1Arr[j];
            }
            if (j == word1Arr[word1Arr.length - 1]) {
                count1.put(word1Arr[j], count);
            }
        }
        temp = word2Arr[0];
        for (int i = 1; i < word2Arr.length; i++) {
            if (word2Arr[i] == temp) {
                count++;
            } else {
                count2.put(word1Arr[i], count);
                count = 1;
                temp = word2Arr[i];
            }
            if (i == word2Arr[word1Arr.length - 1]) {
                count2.put(word1Arr[i], count);
            }
        }
        return true;
    }
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        
    }
}
