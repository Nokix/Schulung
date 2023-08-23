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
    private List<List<Integer>> board;

    public Sudoku(List<List<Integer>> board) {
        this.board = board;
        this.size = board.size();
        if (!this.board.stream().allMatch(row -> row.size() == this.size)) {
            throw new IllegalArgumentException();
        }
    }

    //@Deprecated(since = "v1.2", forRemoval = true)
    public Sudoku(int[][] board) {
        this(arrayToList(board));
    }

    private static List<List<Integer>> arrayToList(int[][] intArray) {
        return Arrays.stream(intArray).map(
                ints -> Arrays.stream(ints).boxed().toList()
        ).toList();
    }

    public boolean isSolved() {
        return StreamSupport.stream(this.getRows().spliterator(), true)
                .allMatch(SudokuPart::isCorrect);
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
                        List<Integer> rowList = board.get(pos);
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
