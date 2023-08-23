package de.schulung.Schulung.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static de.schulung.Schulung.enums.WarningLevel.*;
import static org.junit.jupiter.api.Assertions.*;

class WarningLevelTest {
    @Test
    public void enumTest() {
        assertEquals(3, ERROR.getCode());
    }

    @Test
    public void enumTest2() {
        WarningLevel[] values = values();
        Arrays.stream(values)
                .forEach(System.out::println);
    }

    @Test
    public void enumTest3() {
        assertEquals(DEBUG, getByCode(2));
    }

    @Test
    public void enumTest6() {
        assertThrows(NoSuchElementException.class,
                () -> getByCode(4));
    }

    @Test
    public void enumTest4() {
        assertEquals(INFO,
                valueOf("INFO"));
    }

    @Test
    public void enumTest5() {
        WarningLevel w = INFO;

        switch (w) {
            case ERROR:
                System.out.println("Something went horribly wrong!");
                break;
            case DEBUG:
                System.out.println("Where is the bug?");
                break;
            default:
                System.out.println("Some infos for you");
        }
    }



}