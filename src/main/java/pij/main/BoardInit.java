package pij.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BoardInit {
    private final int[][] board;
    public BoardInit() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/resources/defaultBoard.txt"));
        String firstLine = reader.readLine();
        String[] dimensions = firstLine.split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        this.board = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = 1;
            }
        }
    }

    public void setElement(int row, int col, int value) {
        if (isValidIndex(row, col)) {
            board[row][col] = value;
        }
    }

    public void setRow(int row, String string) {
        try {
            String[] numbers = string.split(",");
            if (numbers.length == board[0].length) {
                for (int i = 0; i < numbers.length; i++) {
                    board[row][i] = Integer.parseInt(numbers[i]);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {

        }
    }

    public void setColumn(int col, String string) {
        try {
            String[] numbers = string.split(",");
            if (numbers.length == board.length) {
                for (int i = 0; i < numbers.length; i++) {
                    board[i][col] = Integer.parseInt(numbers[i]);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {

        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]);
                if (j < board[i].length - 1) {
                    builder.append(", ");
                }
            }
            if (i < board.length - 1) {
                builder.append(";\n ");
            }
        }
        return builder.append("]").toString();
    }


    public void prettyPrint() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\t" + board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
