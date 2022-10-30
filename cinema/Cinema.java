package cinema;

import java.util.Scanner;

public class Cinema {
    public static Scanner sc = new Scanner(System.in);
    public static int purchasedTicket = 0;
    public static int currentIncome = 0;

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
        return AllIncome;
    }

    public static char[][] purchase(int rows, int seatsEachRow, char[][] map) {

        int totalSeat = rows * seatsEachRow;
        System.out.print("Enter a row number:\n> ");
        int rowCheck = sc.nextInt();
        System.out.print("Enter a seat number in that row:\n> ");
        int seatCheck = sc.nextInt();

        try {
            if (map[rowCheck][seatCheck] == 'B') {
                System.out.println("That ticket has already been purchased!");
                return purchase(rows, seatsEachRow, map);
            }
            map[rowCheck][seatCheck] = 'B';
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            System.out.println("Wrong input!");
            return purchase(rows, seatsEachRow, map);

        }
        if (totalSeat >= 60 && rowCheck > (rows / 2)) {
            System.out.println("Ticket price: $8");
            currentIncome += 8;
        } else {
            System.out.println("Ticket price: $10");
            currentIncome += 10;
        }
        purchasedTicket++;

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

    public static int menu() {
        System.out.print("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n> ");
        int choice = sc.nextInt();
        return choice;
    }

    public static void Statistics(int rows, int seatsEachRow) {
        int AllIncome = calIncome(rows, seatsEachRow);
        double percentage = Double.parseDouble(Integer.toString(purchasedTicket))
                / Double.parseDouble(Integer.toString(rows * seatsEachRow)) * 100;
        System.out.println("Number of purchased tickets: " + purchasedTicket);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d", AllIncome);
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows: ");
        System.out.print("> ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seatsEachRow = sc.nextInt();
        char[][] map = start(rows, seatsEachRow);
        int userChoice = menu();
        while (userChoice != 0) {
            switch (userChoice) {
                case 1:
                    printSit(rows, seatsEachRow, map);
                    userChoice = menu();
                    break;
                case 2:
                    purchase(rows, seatsEachRow, map);
                    userChoice = menu();
                    break;
                case 3:
                    Statistics(rows, seatsEachRow);
                    userChoice = menu();
                    break;
                default:
                    break;
            }
        }
    }
}
