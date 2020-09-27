package com.xiaoliang;

import com.xiaoliang.demo.TicTacToe;
import com.xiaoliang.demo.TicTacToeException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Run the application in the console
 */
public class Main {

    private static final String SEPARATOR = " | ";

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3, 3);
        String player = ticTacToe.O_PLAYER;
        for (int i = 1; i <= 9; ) {
            if (i % 2 == 0) {
                player = TicTacToe.X_PLAYER;
            } else {
                player = TicTacToe.O_PLAYER;
            }

            System.out.println("Hello, Sir " + player + "! Please input your position: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            //System.out.println("Current input position: " + input);
            boolean isValid = checkInput(input);
            if (!isValid) {
                System.out.println("Please input valid position! Row & column should be between 1 and 3");
                System.out.println("Example:1,2");
            } else {
                try {
                    // print the game
                    printPlay(ticTacToe.setData(player, input));
                    if (ticTacToe.checkWin(TicTacToe.O_PLAYER)) {
                        System.out.println("Winner is : Sir " + TicTacToe.O_PLAYER);
                        break;
                    }
                    if (ticTacToe.checkWin(TicTacToe.X_PLAYER)) {
                        System.out.println("Winner is: " + TicTacToe.X_PLAYER);
                        break;
                    }
                    i++;
                } catch (TicTacToeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Check input value
     *
     * @param input
     * @return
     */
    private static boolean checkInput(String input) {
        String regex = "[1-3],[1-3]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * This method is to print whole play picture
     *
     * @param ox 3*3 matrix data
     */
    private static void printPlay(String[][] ox) {
        for (String[] row : ox) {
            for (String elem : row) {
                System.out.print((elem == null ? " " : elem) + SEPARATOR);
            }
            System.out.println("");
        }

    }
}
