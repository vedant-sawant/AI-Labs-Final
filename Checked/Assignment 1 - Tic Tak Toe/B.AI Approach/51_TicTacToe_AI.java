package com.tanu;

import java.util.*;

public class TicTacToe_AI {
    private static final char COMPUTERMOVE = 'O';
    private static final char HUMANMOVE = 'X';
    private static final char EMPTY_CELL = ' ';

    private static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        boolean isGameOver = false;

        while (!isGameOver) {
            playerMove(scanner);
            printBoard();

            if (checkWin(HUMANMOVE)) {
                System.out.println("Congratulations! You win!");
                isGameOver = true;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                isGameOver = true;
            } else {
                computerMove();
                printBoard();

                if (checkWin(COMPUTERMOVE)) {
                    System.out.println("Computer wins! Better luck next time.");
                    isGameOver = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    isGameOver = true;
                }
            }
        }

        scanner.close();
        System.out.println("Game over.");
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                int position = i * 3 + j + 1;
                char cellValue = board[i][j] == EMPTY_CELL ? (char) (position + '0') : board[i][j];
                System.out.print(cellValue + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playerMove(Scanner scanner) {
        int position;
        do {
            System.out.print("Enter position (1-9): ");
            position = scanner.nextInt();
        } while (!isValidMove(position) || !isEmptyCell(position));

        board[(position - 1) / 3][(position - 1) % 3] = HUMANMOVE;
    }

    private static boolean isValidMove(int position) {
        return position >= 1 && position <= 9;
    }

    private static boolean isEmptyCell(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return board[row][col] == EMPTY_CELL;
    }

    public static void computerMove() {
        List<Integer> availableMoves = getAvailableMoves();

        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int move : availableMoves) {
            int row = move / 3;
            int col = move % 3;

            board[row][col] = COMPUTERMOVE;
            int score = minimax(board, 0, HUMANMOVE);
            board[row][col] = EMPTY_CELL;

            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }

        int row = bestMove / 3;
        int col = bestMove % 3;
        board[row][col] = COMPUTERMOVE;
    }

    public static List<Integer> getAvailableMoves() {
        List<Integer> availableMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    availableMoves.add(i * 3 + j);
                }
            }
        }
        return availableMoves;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char playerSymbol) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol) {
                return true;
            }
            if (board[0][i] == playerSymbol && board[1][i] == playerSymbol && board[2][i] == playerSymbol) {
                return true;
            }
        }
        if (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) {
            return true;
        }
        if (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol) {
            return true;
        }
        return false;
    }

    private static int minimax(char[][] board, int depth, char currentPlayer) {
        if (checkWin(COMPUTERMOVE)) {
            return 1;
        }
        if (checkWin(HUMANMOVE)) {
            return -1;
        }
        if (isBoardFull()) {
            return 0;
        }

        if (currentPlayer == COMPUTERMOVE) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY_CELL) {
                        board[i][j] = COMPUTERMOVE;
                        int score = minimax(board, depth + 1, HUMANMOVE);
                        board[i][j] = EMPTY_CELL;
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY_CELL) {
                        board[i][j] = HUMANMOVE;
                        int score = minimax(board, depth + 1, COMPUTERMOVE);
                        board[i][j] = EMPTY_CELL;
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }
}














