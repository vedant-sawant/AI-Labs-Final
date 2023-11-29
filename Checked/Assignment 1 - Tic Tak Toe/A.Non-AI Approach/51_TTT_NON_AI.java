package com.tanu;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        char num = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = num;
                num++;
            }
        }
    }

    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public boolean makeMove(int position) {
        if (position >= 1 && position <= 9) {
            int row = (position - 1) / 3;
            int col = (position - 1) % 3;
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return true;
            }
        }

        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");

        boolean gameOver = false;

        while (!gameOver) {
            game.printBoard();

            int position;
            do {
                System.out.print("Player " + game.currentPlayer + ", enter your move (1-9): ");
                position = scanner.nextInt();
            } while (!game.makeMove(position));

            if (game.checkWin()) {
                System.out.println("Player " + game.currentPlayer + " wins!");
                gameOver = true;
            } else if (game.isBoardFull()) {
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                game.switchPlayer();
            }
        }

        game.printBoard();
        System.out.println("Game over.");
    }
}
