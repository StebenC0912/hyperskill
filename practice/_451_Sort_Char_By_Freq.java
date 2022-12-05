package practice;

import java.util.Arrays;

public class _451_Sort_Char_By_Freq {
    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        
        char temp = sChar[0];
        int frequency = 1;
        
        for (int i = 1; i < sChar.length; i++) {
            if (temp == sChar[i]) {
                frequency++;
            } else {
                
                temp = sChar[i];
                
                frequency = 1;
            }
        }
        
        
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("aaaccc"));
        System.out.println(frequencySort("Aabb"));
    }
}
