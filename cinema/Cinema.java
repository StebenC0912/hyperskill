package cinema;

import java.util.Scanner;

public class Cinema {
    public static Scanner sc = new Scanner(System.in);

    public static char[][] printSit(int rows, int seatsEachRow) {
        System.out.println("Cinema:");
        char[][] map = new char[rows][seatsEachRow + 1];
        for (int i = 0; i < rows + 1; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
            for (int j = 1; j < seatsEachRow + 1; j++) {
                if (i == 0) {
                    System.out.print(j + " ");
                } else {
                    map[i - 1][j - 1] = 'S';
                    System.out.print("S ");
                }
            }
            System.out.println(" ");
        }
        return map;
    }

    public static int calIncome(int rows, int seatsEachRow) {
        int AllIncome = 0;

        int priceEachTicket, frontSeatPrice, backSeatPrice;
        if (rows * seatsEachRow < 60) {
            priceEachTicket = 10;
            AllIncome = priceEachTicket * rows * seatsEachRow;
        } else {
            frontSeatPrice = 10;
            backSeatPrice = 8;
            if (rows % 2 != 0) {
                AllIncome = (frontSeatPrice * (rows / 2) * seatsEachRow)
                        + (backSeatPrice * (rows / 2 + 1) * seatsEachRow);
            } else {
                AllIncome = (frontSeatPrice + backSeatPrice) * (rows / 2) * seatsEachRow;
            }
        }
        System.out.printf("Total income: \n$%d", AllIncome);
        return AllIncome;
    }

    public static void showPrice() {

    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows: ");
        System.out.print("> ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seatsEachRow = sc.nextInt();
        char[][] map = printSit(rows, seatsEachRow);
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
