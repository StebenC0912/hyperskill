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
        Thread test = new NumbersFilter();
        test.start();

    }
}

class HelloThread extends Thread {

    @Override
    public void run() {
        String helloMsg = String.format("Hello, i'm %s", getName());
        System.out.println(helloMsg);
    }
}

class MessageNotifier extends Thread {

    // write fields to store variables here
    private String msg;
    private int repeats;

    public MessageNotifier(String msg, int repeats) {
        // implement the constructor
        this.msg = msg;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        // implement the method to print the message stored in a field
        for (int i = 0; i < repeats; i++) {
            System.out.println(msg);
        }
    }
}

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        // implement this method
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            if (input % 2 == 0) {
                System.out.println(input);
            }

        }
    }
}

class NumbersThread extends Thread {
    private int from;
    private int to;

    public NumbersThread(int from, int to) {
        // implement the constructor
        this.from = from;
        this.to = to;
    }

    // you should override some method here
    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            System.out.println(i);
        }
    }
}

class Account {

    private long balance = 0;

    public synchronized boolean withdraw(long amount) {
        if (amount > this.balance)
            return false;
        else {
            this.balance = balance - amount;
        }
        return true;
    }

    public synchronized void deposit(long amount) {
        // do something useful
        this.balance = balance + amount;
    }

    public long getBalance() {
        return balance;
    }
}

class Util {
    public static int[] swapInts(int[] ints) {
        return new int[] { ints[1], ints[0] };
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ints = new int[2];
        ints[0] = Integer.parseInt(scanner.nextLine());
        ints[1] = Integer.parseInt(scanner.nextLine());

        ints = Util.swapInts(ints);

        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
