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
        Thread thread = new Thread();
        System.out.println(thread.MIN_PRIORITY);
        System.out.println(thread.MAX_PRIORITY);
    }
}
//
class ThreadUtil {
    public static String getName(Thread thread) {
        // implement logic
        return thread.getName().toString();
    }

    public static void printIfDaemon(Thread thread) {
        // implement logic
        if (thread.isDaemon()) {
            System.out.println(thread.isDaemon());
        }
    }

    public static void printCurrentThreadInfo() {
        // get the thread and print its info
        // comment
        System.out.println("name: " + Thread.currentThread().getName());
        System.out.println("priority: " + Thread.currentThread().getPriority());
    }
}