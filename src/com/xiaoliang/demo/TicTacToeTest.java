package com.xiaoliang.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * General unit tests for Tic Tac Toe
 */
class TicTacToeTest {

    @BeforeEach
    public void tearup() {
    }


    /**
     * Test set data
     */
    @Test
    void setData() throws TicTacToeException {
        TicTacToe ticTacToe = new TicTacToe(3, 3);
        ticTacToe.setData(TicTacToe.O_PLAYER, "1,1");
        assertEquals(TicTacToe.O_PLAYER, ticTacToe.getData()[0][0]);

        ticTacToe.setData(TicTacToe.O_PLAYER, "3,3");
        assertEquals(TicTacToe.O_PLAYER, ticTacToe.getData()[2][2]);
    }

    /**
     * Test set data exception
     */
    @Test
    void setDataWithException() throws TicTacToeException {
        TicTacToe ticTacToe = new TicTacToe(3, 3);
        assertThrows(TicTacToeException.class, () -> {
            ticTacToe.setData(TicTacToe.X_PLAYER, "1");
        });

        ticTacToe.setData(TicTacToe.X_PLAYER, "1,2");
        assertThrows(TicTacToeException.class, () -> {
            ticTacToe.setData(TicTacToe.X_PLAYER, "1,2");
        });
    }

    /**
     * Test win checker is true
     */
    @Test
    void checkWinTrue() {
        TicTacToe ticTacToe = new TicTacToe(3, 3);
        String[][] data = {{"X", "X", "X"}, {"O", "O", null}, {null, null, null}};
        ticTacToe.setData(data);
        boolean win = ticTacToe.checkWin(TicTacToe.X_PLAYER);
        assertEquals(true, win);
    }

    /**
     * Test win checker is false
     */
    @Test
    void checkWinFalse() {
        TicTacToe ticTacToe = new TicTacToe(3, 3);
        String[][] data = {{"X", "X", null}, {"O", "O", null}, {null, null, null}};
        ticTacToe.setData(data);
        boolean win = ticTacToe.checkWin(TicTacToe.X_PLAYER);
        assertEquals(false, win);
    }

}