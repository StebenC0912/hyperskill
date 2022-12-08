package practice;

import java.io.IOException;
import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int val = scanner.nextInt();
        print(str);
        print(str, val);
    }
}

class Converter {

    // Write a lambda expression that accepts two integer arguments and returns max
    // of them.
    // Sample Input 1:
    // 4 2
    // Sample Output 1:
    // 4
    public static IntBinaryOperator binaryOperator = (x, y) -> x > y ? x : y;
}