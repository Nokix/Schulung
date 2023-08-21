package de.schulung.Schulung.sudoku;

import java.util.List;

public class SudokuPart {

    private final int[] numbers;

    // "..." heißt "varargs"
    public SudokuPart(int... numbers) {
        this.numbers = numbers;
    }

    public boolean isCorrect() {
        int length = this.numbers.length;

        for (int i = 1; i <= length; i++) {

            int found_i = 0;

            for (int number : numbers) {
                if (number == i) {
                    found_i = found_i + 1;
                }
            }

            if (found_i != 1) {
                return false;
            }
        }

        return true;
    }

}
