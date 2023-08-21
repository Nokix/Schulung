package de.schulung.Schulung.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuPartTest {

    @Test
    public void checkSudokuPart1() {
        SudokuPart sudokuPart = new SudokuPart(1, 3, 2, 4, 5, 9, 8, 7, 6);
        assertTrue(sudokuPart.isCorrect());
    }

    @Test
    void checkSudokuPart2() {
        SudokuPart sudokuPart = new SudokuPart(1, 3, 3, 4, 5, 9, 8, 7, 6);
        assertFalse(sudokuPart.isCorrect());
    }

    @Test
    void checkSudokuPart3() {
        SudokuPart sudokuPart = new SudokuPart(1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertFalse(sudokuPart.isCorrect());
    }

    @Test
    void checkSudokuPart4() {
        SudokuPart sudokuPart = new SudokuPart(2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertFalse(sudokuPart.isCorrect());
    }

    @Test
    void checkSudokuPart5() {
        SudokuPart sudokuPart = new SudokuPart(1);
        assertTrue(sudokuPart.isCorrect());
    }

    @Test
    void checkSudokuPart6() {
        SudokuPart sudokuPart = new SudokuPart(1, 2, 3);
        assertTrue(sudokuPart.isCorrect());
    }



}