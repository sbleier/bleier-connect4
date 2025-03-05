package bleier.connect4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectBoardTest {

    @Test
    void isFull() {
        char[][] board = {
                {' ', ' ', ' ', 'R', ' '},
                {' ', 'R', 'Y', 'R', ' '},
                {'Y', 'R', 'Y', 'R', ' '},
                {'Y', 'Y', 'Y', 'R', ' '},
                {'Y', 'R', 'R', 'Y', ' '}
        };
        ConnectBoard cBoard = new ConnectBoard(board);

        boolean full = cBoard.isFull(3);

        assertTrue(full);
    }

    @Test
    void insert() {
        ConnectBoard board = new ConnectBoard(7, 6);

        board.insert(4, 'r');
        char[][] cBoard = board.getBoard();

        assertEquals('R', cBoard[0][4]);

    }

    @Test
    void calcWinnerVert() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', 'R', 'Y', 'R', ' '},
                {'Y', 'R', 'Y', 'Y', ' '},
                {'Y', 'R', 'Y', 'R', ' '},
                {'Y', 'R', 'R', 'R', ' '}
        };
        ConnectBoard cBoard = new ConnectBoard(board);

        char winner = cBoard.calcWinner();

        assertEquals('R', winner);

    }

    @Test
    void calcWinnerDiagR() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' '},
                {'R', 'R', 'Y', 'R', ' '},
                {'Y', 'R', 'R', 'Y', ' '},
                {'Y', 'R', 'R', 'R', ' '},
                {'Y', 'R', 'R', 'R', ' '}
        };
        ConnectBoard cBoard = new ConnectBoard(board);

        char winner = cBoard.calcWinner();

        assertEquals('R', winner);

    }

    @Test
    void calcWinnerDiagL() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' '},
                {'R', 'R', 'Y', 'R', ' '},
                {'Y', 'Y', 'R', 'Y', ' '},
                {'Y', 'R', 'R', 'R', ' '},
                {'R', 'R', 'R', 'Y', ' '}
        };
        ConnectBoard cBoard = new ConnectBoard(board);

        char winner = cBoard.calcWinner();

        assertEquals('R', winner);

    }

    @Test
    void calcWinnerHoriz() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' '},
                {'R', 'R', 'R', 'R', ' '},
                {'R', 'Y', 'Y', 'Y', ' '},
                {'Y', 'Y', 'R', 'R', ' '},
                {'R', 'R', 'R', 'Y', ' '}
        };
        ConnectBoard cBoard = new ConnectBoard(board);

        char winner = cBoard.calcWinner();

        assertEquals('R', winner);

    }



}