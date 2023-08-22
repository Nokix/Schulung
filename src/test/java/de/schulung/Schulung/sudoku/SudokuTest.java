package de.schulung.Schulung.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {
    @Test
    @DisplayName("Create regular 9x9 Sudoku")
    public void createSudoku1() throws Exception {
        int[][] board = new int[][]{
                {8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}};

        Sudoku sudoku = new Sudoku(board);
        int size = sudoku.getSize();
        assertEquals(9, size);
    }

    @Test
    @DisplayName("Fail because for wrong dimensions")
    public void createSudoku2() {
        int[][] board = new int[][]{
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };

        assertThrows(IllegalArgumentException.class,
                () -> new Sudoku(board));
    }

    @Test
    public void createSudoku3(){
        int[][] board = new int[][] {{}};

        assertThrows(IllegalArgumentException.class,
                () -> new Sudoku(board));
    }

    @Test
    public void createSudoku4() {
        int[][] board = new int[][] {{1}};

        Sudoku sudoku = new Sudoku(board);
        assertEquals(1, sudoku.getSize());
    }

    @Test
    public void checkSolution1() {
        int[][] board = new int[][]{
                {8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}};
        Sudoku sudoku = new Sudoku(board);
        assertTrue(sudoku.isSolved());
    }

    @Test
    public void checkSolution2() {
        int[][] board = new int[][]{
                {3, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}};
        Sudoku sudoku = new Sudoku(board);
        assertFalse(sudoku.isSolved());
    }

    @Test
    @Disabled
    void checkIterator() {
        Sudoku sudoku = new Sudoku(new int[][]{{1, 2}, {3, 4}});

        for (Integer i : sudoku) {
            System.out.println(i);
            assertTrue(i <= 4 && i >= 1);
        }
    }



}