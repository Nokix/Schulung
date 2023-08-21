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



}