package de.schulung.Schulung.sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

@Getter
public class Sudoku implements Iterable<Integer>{

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
        for (SudokuPart row : this.getRows()) {
            if (!row.isCorrect()) {
                return false;
            }
        }
        return true;
    }

    public Iterable<SudokuPart> getRows() {
        return new Iterable<>() {
            @Override
            public Iterator<SudokuPart> iterator() {
                return new Iterator<SudokuPart>() {
                    int pos = 0;

                    @Override
                    public boolean hasNext() {
                        return pos < size;
                    }

                    @Override
                    public SudokuPart next() {
                        int[] row = board[pos];
                        ArrayList<Integer> rowList = new ArrayList<>();
                        for (int i : row) {
                            rowList.add(i);
                        }

                        pos++;
                        return new SudokuPart(rowList);
                    }
                };
            }
        };
    }

    public Iterable<SudokuPart> getColumns() {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

}
