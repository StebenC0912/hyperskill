package practice;

import java.util.Scanner;
import java.util.Arrays;


record Person(String name, int age, String gender) {
  //don't change this record
}


public class Main {

    private static long mainThreadId = Thread.currentThread().getId();

    // Fix this method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person(scanner.next(), scanner.nextInt(), scanner.next());

        // your code goes here
        System.out.printf("%s is %d years old and is %s", person.age(), person.age(), person.gender());
    }
    //Don't change the code below
    static class SlowStringProcessor extends Thread {

        private final String s;
        private volatile long numberOfUniqueCharacters = 0;

        public SlowStringProcessor(String s) {
            this.s = s;
        }

        @Override
        public void run() {

            final long currentId = Thread.currentThread().getId();

            if (currentId == mainThreadId) {
                throw new RuntimeException("You must start a new thread!");
            }

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                throw new RuntimeException("Do not interrupt the processor", e);
            }

            this.numberOfUniqueCharacters = Arrays.stream(s.split("")).distinct().count();
        }

        public long getNumberOfUniqueCharacters() {
            return numberOfUniqueCharacters;
        }
    }
}