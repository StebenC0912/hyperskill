package cinema;

import java.util.Scanner;

public class Cinema {
    public static Scanner sc = new Scanner(System.in);

    public static char[][] start(int rows, int seatsEachRow) {
        
        char[][] map = new char[rows + 1][seatsEachRow + 1];

        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seatsEachRow + 1; j++) {
                if (i == 0 && j == 0) {
                    map[0][0] = ' ';
                } else if (i == 0 && j != 0) {
                    map[i][j] = (char) (j + '0');
                } else if (i != 0 && j == 0) {
                    map[i][j] = (char) (i + '0');
                } else {
                    map[i][j] = 'S';
                }
            }
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

    public static char[][] showPrice(int rows, int seatsEachRow, char[][] map) {
        int totalSeat = rows * seatsEachRow;
        System.out.print("Enter a row number: \n> ");
        int rowCheck = sc.nextInt();
        System.out.print("Enter a seat number in that row:\n> ");
        int seatCheck = sc.nextInt();
        map[rowCheck][seatCheck] = 'B';
        if (totalSeat < 60) {
            System.out.println("Ticket price: $10");
        } else if (rowCheck <= (rows / 2)) {
            System.out.println("Ticket price: $10");
        } else{
            System.out.println("Ticket price: $8");
        }
        return map;
    }

    public static void printSit(int rows, int seatsEachRow, char[][] map) {
        System.out.println("Cinema:");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seatsEachRow + 1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows: ");
        System.out.print("> ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seatsEachRow = sc.nextInt();
        char[][] map = start(rows, seatsEachRow);
        printSit(rows, seatsEachRow, map);
        showPrice(rows, seatsEachRow, map);
        printSit(rows, seatsEachRow, map);
    }
}
