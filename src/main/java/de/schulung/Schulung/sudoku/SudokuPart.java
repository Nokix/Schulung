package de.schulung.Schulung.sudoku;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Builder
public class SudokuPart {

    private final List<Integer> numbersList;

    // "..." heißt "varargs"
    public SudokuPart(int... numbers) {
        this(Arrays.stream(numbers).boxed().toList());
    }

    public SudokuPart(List<Integer> numbers) {
        this.numbersList = numbers;
    }

    public boolean isCorrect() {
        List<Integer> goal = IntStream.rangeClosed(1, this.numbersList.size()).boxed().toList();
        return numbersList.containsAll(goal);
    }

}
