package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class tictactoe {
    public static void printTic(String input) {

        System.out.println("---------");
        for (int i = 0; i < input.length(); i++) {
            if (i == 0 || i == 3 || i == 6) {
                System.out.print("| ");
                System.out.print(input.charAt(i) + " ");
            } else if ((i + 1) % 3 == 0) {
                System.out.println(input.charAt(i) + " |");
            } else {
                System.out.print(input.charAt(i) + " ");
            }
        }
        System.out.println("---------");
    }

    public static boolean win(char check, String input) {
        // check win diagonal
        if (input.charAt(0) == check && input.charAt(0) == input.charAt(4)
                && input.charAt(8) == input.charAt(0)) {
            return true;
        }
        if (input.charAt(2) == check && input.charAt(2) == input.charAt(4)
                && input.charAt(6) == input.charAt(2)) {
            return true;
        }

        for (int i = 0; i < 6; i++) {
            // check win in col
            if (i < 3 && input.charAt(i) == check && input.charAt(i) == input.charAt(i + 3)
                    && input.charAt(i) == input.charAt(i + 6)) {
                return true;
            }
            // check win in row
            if ((i == 0 || i == 3 || i == 6) && (input.charAt(i) == check && input.charAt(i) == input.charAt(i + 1)
                    && input.charAt(i) == input.charAt(i + 2))) {
                return true;
            }
        }
        return false;
    }

    public static void printResult(String input, boolean XWin, boolean OWin) {
        int numX = 0, numY = 0;
        for (int i = 0; i < input.length(); i++) {
            if ('X' == input.charAt(i)) {
                numX++;
            } else if ('O' == input.charAt(i)) {
                numY++;
            }
        }
        // check if 1 of 2 players take turn of opponent
        // if (numX - numY >= 2 || numY - numX >= 2) {
        // System.out.println("Impossible");
        // System.exit(-1);
        // }
        // check if 2 players win together.
        // if (OWin == true && XWin == true) {
        // System.out.println("Impossible");
        // System.exit(-1);
        // }
        if (numX + numY == 9) {
            if (OWin == true) {
                System.out.println("O wins");
            } else if (XWin == true) {
                System.out.println("X wins");
            } else {
                System.out.println("Draw");
                System.exit(0);
            }
        } else {
            // if (OWin == false && XWin == false) {
            // System.out.println("Game not finished");
            // }
            if (OWin == true) {
                System.out.println("O wins");
            } else if (XWin == true) {
                System.out.println("X wins");
            }
        }
    }

    public static String takeOneMove(char move, String input) {
        Scanner sc = new Scanner(System.in);
        char[][] map = new char[3][3];
        int index = 0;
        // copy string to array.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = input.charAt(index);
                index++;
            }
        }
        boolean inValidEnter = true;
        while (inValidEnter) {
            try {
                System.out.print("> ");
                int row = sc.nextInt();
                int col = sc.nextInt();

                if (row >= 4 || col >= 4) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                // check empty spot
                if (map[row - 1][col - 1] == 'X' || map[row - 1][col - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    // return array to string
                    input = "";
                    map[row - 1][col - 1] = move;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            input = input.concat(Character.toString(map[i][j]));
                        }
                    }

                    inValidEnter = false;
                }
            } catch (InputMismatchException e) {
                // TODO: handle exception
                System.out.println("You should enter numbers!");
                inValidEnter = false;
                // e.printStackTrace();

            }
        }
        sc.close();
        return input;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "         ";
        printTic(input);
        boolean XWin = win('X', input);
        boolean OWin = win('O', input);
        int i = 0;
        char move;
        while (OWin == false && XWin == false && i <= 8) {
            if (i % 2 != 0) {
                move = 'O';
            } else {
                move = 'X';
            }
            input = takeOneMove(move,input);
            XWin = win('X', input);
            OWin = win('O', input);
            printTic(input);
            printResult(input, XWin, OWin);
            i++;
        }

        sc.close();

    }
}
