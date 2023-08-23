package de.schulung.Schulung.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WarningLevelTest {
    @Test
    public void enumTest() {
        assertEquals(3, WarningLevel.ERROR.getCode());
    }

    @Test
    public void enumTest2() {
        WarningLevel[] values = WarningLevel.values();
        Arrays.stream(values)
                .forEach(System.out::println);
    }

    @Test
    public void enumTest3() {
        assertEquals(WarningLevel.DEBUG, WarningLevel.getByCode(2));
    }



}