package de.schulung.Schulung.sudoku;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {
    @Test
    void streamTest1() {
        List<Integer> list = List.of(1, 2, 3, 4);

        Stream<Integer> stream = list.stream();
        Stream<Integer> integerStream = stream.filter(this::isEven);
        List<Integer> filteredList = integerStream.toList();

        assertEquals(List.of(2, 4), filteredList);
    }

    boolean isEven(int i) {
        return i % 2 == 0;
    }

    @Test
    void streamTest2() {
        Predicate<Integer> isEven = this::isEven;
        Predicate<Integer> isBig = i -> i > 10;

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);

        List<Integer> result = list.stream()
                .filter(isEven)
                .filter(isBig)
                .filter(i -> i < 15)
                .toList();

        assertEquals(List.of(12, 14), result);
    }

    @Test
    void streamTest3() {
        Object[] words = {" ", '3', null, "2", 1, "", 1};

        List<Integer> result = Arrays.stream(words)
                .filter(Objects::nonNull)
                .map(Object::toString)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .sorted()
                .distinct()
                .toList();

        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void streamTest4() {
        Stream.generate(new Random()::nextInt)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    void streamTest5() {
        List<Integer> integers =
                Stream.generate(() -> {
                            System.out.println("Die Zahl ist 3");
                            System.out.println("In worten \"DREI\"");
                            return 3;
                        })
                        .limit(5)
                        .toList();

        assertEquals(integers, List.of(3, 3, 3, 3, 3));
    }

    @Test
    void streamTest6() {
        Supplier<Integer> integerSupplier =
                new AtomicInteger(1)::getAndIncrement;

        List<Integer> integers = Stream.generate(integerSupplier)
                .limit(10)
                .toList();
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), integers);
    }

    @Test
    void streamTest7() {
        Supplier<Integer> integerSupplier = new Supplier<>() {
            int i = 0;

            @Override
            public synchronized Integer get() {
                i++;
                return i;
            }
        };

        int max = Stream.generate(integerSupplier)
                .sequential().limit(10000)
                .mapToInt(i -> i)
                .max().orElse(100);

        System.out.println(max);
    }

    @Test
    void streamTest8() {
        Stream<Integer> intStream = IntStream.rangeClosed(1, 5).boxed();
        intStream.forEach(System.out::println);
        System.out.println();
    }

    @Test
    void streamTest9() {
        Optional<String> optionalString = Optional.ofNullable(null);

        if (optionalString.isPresent()) {
            System.out.println(optionalString.get());
        }
    }

    @Test
    void stream10() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallel()
                .filter(i -> i % 3 == 2)
                .findAny()
                .ifPresentOrElse(
                        i -> System.out.println("Found " + i),
                        () -> System.out.println("Nothing Found"));
    }


    @Test
    void stream11() {
        boolean b = Stream.of(1, 2, 3, 4, 5)
                .anyMatch(i -> i > 3);
        System.out.println(b);
    }

    @Test
    void stream12() {
        assertThrows(IllegalArgumentException.class,
                () -> Stream.of()
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new));
    }

    @Test
    void stream13() {
        Integer reduce = IntStream.rangeClosed(0, 1000).boxed()
                .reduce(0, (i1, i2) -> i1 + i2, (i1, i2) -> i1 + i2);

        System.out.println(reduce);

    }

    @Test
    void stream14() {
        System.out.println(IntStream.range(0, 100).boxed()
                .reduce(new ArrayList<Integer>(),
                        (list, integer) -> {
                            list.add(integer);
                            return list;
                        },
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }));


    }


}
