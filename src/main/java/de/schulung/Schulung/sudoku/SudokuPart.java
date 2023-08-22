package de.schulung.Schulung.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuPart {

    private final List<Integer> numbersList;

    // "..." heißt "varargs"
    public SudokuPart(int... numbers) {
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        this.numbersList = list;
    }

    public SudokuPart(List<Integer> numbers) {
        this.numbersList = numbers;
    }

    public boolean isCorrect() {
        List<Integer> goal = IntStream.rangeClosed(1, this.numbersList.size()).boxed().toList();
        return numbersList.containsAll(goal);
    }

}
