package org.pjay;

import java.util.Scanner;

/**
 * @author vijayk
 */
public class Sudoku {

    String[][] sudokuDisplayGrid = {
            {"0,0", "0,1", "0,2"},
            {"1,0", "1,1", "1,2"},
            {"2,0", "2,1", "2,2"}
    };

    int[][] playBoard = new int[SIZE][SIZE];
    static final int EMPTY = -1; // empty cell
    static final int SIZE = 3; // size of our Sudoku grids

    public Sudoku() {
        // initialize the play board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.playBoard[i][j] = EMPTY;
            }
        }
    }

    // we check if a possible number is already in a row
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (playBoard[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    // we check if a possible number is already in a column
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (playBoard[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    // combined method to check if a number possible
    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number);
    }

    private boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (playBoard[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void playGame() {
        int row = -1;
        int col = -1;
        int numberEntered = -1;
        while (!isSolved()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Please enter the details of row, column and number of choice accordingly: ");
            System.out.println("Row: ");
            row = scanner.nextInt();
            System.out.println("Column: ");
            col = scanner.nextInt();
            System.out.println("Number: ");
            numberEntered = scanner.nextInt();
            if (!(row > SIZE - 1) && !(col > SIZE - 1) && !(numberEntered > 2 || numberEntered < 0)) {
                if (isOk(row, col, numberEntered)) {
                    playBoard[row][col] = numberEntered;
                    updateSudokuDisplayGrid(row, col, numberEntered);
                } else {
                    System.out.println("This number is not allowed or already present at specified location");
                }
            } else {
                System.out.println("Invalid Data row, column max is 2 and number of choice is 0 to 2");
            }
            printSudokuDisplayGrid();
        }
        System.out.println("\nCompleted :)");
    }

    private void printSudokuDisplayGrid() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + sudokuDisplayGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void updateSudokuDisplayGrid(int row, int col, int numberEntered) {
        for (int i = 0; i < SIZE; i++) {
            if (playBoard[row][i] == EMPTY) {
                sudokuDisplayGrid[row][i] = "x,x";
            }
            if (playBoard[i][col] == EMPTY) {
                sudokuDisplayGrid[i][col] = "x,x";
            }
        }
        sudokuDisplayGrid[row][col] = " " + numberEntered + " ";
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.printSudokuDisplayGrid();
        sudoku.playGame();
    }
}
