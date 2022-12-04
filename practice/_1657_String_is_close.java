package practice;

import java.util.Arrays;

public class _1657_String_is_close {
    public static boolean operation(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.length() == 1 && word2.length() == 1) {
            if (word1.equals(word2)) return true; 
            else return false;
        }
        boolean onlyOneChar1 = false;
        boolean onlyOneChar2 = false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        int count = 1;
        char temp = word1Arr[0];
        int j = 0;
        for (int i = 1; i < word1Arr.length; i++) {
            if (word1Arr[i] == temp) {
                count++;
            } else {
                if (!word2.contains(Character.toString(temp)))
                    return false;
                count1[j] = count;
                j++;
                count = 1;
                temp = word1Arr[i];
            }

        }
        if (j < 1) {
            onlyOneChar1 = true;
        }
        count1[j] = count;
        j = 0;
        count = 1;
        temp = word2Arr[0];
        for (int i = 1; i < word2Arr.length; i++) {
            if (word2Arr[i] == temp) {
                count++;
            } else {
                count2[j] = count;
                j++;
                count = 1;
                temp = word2Arr[i];
            }

        }
        if (j < 1) {
            onlyOneChar2 = true;
        }
        if (onlyOneChar1 == true && onlyOneChar2 == true) {
            return false;
        }
        count2[j] = count;
        Arrays.sort(count1);
        Arrays.sort(count2);
        if (!Arrays.equals(count1, count2)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String word1 = "xxxxxxx";
        String word2 = "zzzzzzz";
        System.out.println(operation(word1, word2));
    }
}
