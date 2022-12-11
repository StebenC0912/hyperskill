package practice;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.function.LongUnaryOperator;

public class practice {
    public static void print(String strArg) {
        System.out.println("print(\"" + strArg + "\")");
    }

    public static void print(String strArg, int intArg) {
        System.out.println("print(\"" + strArg + "\", " + intArg + ")");
    }
    // write your method here

    /* Do not change code below */
    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 2, 1);
        System.out.println(set1.equals(set2));

    }
}

class ThreadUtil {
    public static String getName(Thread thread) {
        // implement logic
        return thread.toString();
    }
}