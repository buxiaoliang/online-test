package com.xiaoliang.demo;

public class TicTacToe {

    // constants
    public static final String O_PLAYER = "O";
    public static final String X_PLAYER = "X";
    private static final String COMMA = ",";
    // data
    private String[][] data;

    public TicTacToe(int o, int x) {
        data = new String[o][x];
    }

    /**
     * Set matrix data using user input
     *
     * @param player
     * @param input
     * @throws TicTacToeException
     */
    public String[][] setData(String player, String input) throws TicTacToeException {
        String[] pos = input.split(COMMA);
        if (pos.length != 2) {
            throw new TicTacToeException("TicTacToe Error！Please check user input value format!");
        }
        int row = Integer.parseInt(pos[0]);
        int column = Integer.parseInt(pos[1]);
        String originalValue = data[row - 1][column - 1];
        if (originalValue != null && !originalValue.isEmpty()) {
            throw new TicTacToeException("TicTacToe Error！The position is already set, please choose another position!");
        }
        data[row - 1][column - 1] = player;
        return data;
    }

    /**
     * Check winner
     * @param player
     * @return
     */
    public boolean checkWin(String player) {
        if (player.equals(data[0][0])  && player.equals(data[0][1]) && player.equals(data[0][2])) {
            return true;
        }
        if (player.equals(data[1][0])  && player.equals(data[1][1]) && player.equals(data[1][2])) {
            return true;
        }
        if (player.equals(data[2][0])  && player.equals(data[2][1]) && player.equals(data[2][2])) {
            return true;
        }
        if (player.equals(data[0][0])  && player.equals(data[1][0]) && player.equals(data[2][0])) {
            return true;
        }
        if (player.equals(data[0][1])  && player.equals(data[1][1]) && player.equals(data[2][1])) {
            return true;
        }
        if (player.equals(data[0][2])  && player.equals(data[1][2]) && player.equals(data[2][2])) {
            return true;
        }
        if (player.equals(data[0][0])  && player.equals(data[1][1]) && player.equals(data[2][2])) {
            return true;
        }
        if (player.equals(data[0][2])  && player.equals(data[1][1]) && player.equals(data[2][0])) {
            return true;
        }
        return false;
    }

}
