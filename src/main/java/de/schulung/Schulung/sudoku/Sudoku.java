package de.schulung.Schulung.sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

@Getter
public class Sudoku implements Iterable<Integer>{

    private Integer size;
    @Setter
    private List<List<Integer>> board;

    public Sudoku(List<List<Integer>> board) {
        this.board = board;
        this.size = board.size();
        if (this.board.stream().anyMatch(row -> row.size() != this.size)) {
            throw new IllegalArgumentException();
        }
    }

    //@Deprecated(since = "v1.2", forRemoval = true)
    public Sudoku(Integer[][] board) {
        this(arrayToList(board));
    }

    private static <T> List<List<T>> arrayToList(T[][] intArray) {
        return Arrays.stream(intArray).map(
                innerIntArray -> Arrays.stream(innerIntArray).toList()
        ).toList();
    }

    public boolean isSolved() {
        return StreamSupport.stream(this.getRows().spliterator(), true)
                .allMatch(SudokuPart::isCorrect);
    }

    public Iterable<SudokuPart> getRows() {
        return () -> new Iterator<>() {
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

    public Iterable<SudokuPart> getColumns() {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

}
