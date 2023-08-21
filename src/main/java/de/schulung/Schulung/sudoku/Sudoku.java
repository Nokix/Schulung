package de.schulung.Schulung.sudoku;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Sudoku {

    private int size;

    @Setter
    private int[][] board;

    public Sudoku(int[][] board, int size) {
        this.board = board;
        this.size = size;
        if (this.board.length != this.size)
            throw new IllegalArgumentException();

        for (int[] row: board) {
            if(row.length != this.size)
                throw new IllegalArgumentException();
        }
    }

    public Sudoku(int[][] board) {
        this(board, board.length);
    }

    public boolean isSolved() {
        return false;
    }
}
