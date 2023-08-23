package de.schulung.Schulung.stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    public void testMyStack() {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.pop());
        assertEquals(1, myStack.pop());
    }

    @Test
    public void testMyStack1() {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.pushAll(List.of(1, 2, 3));

        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.pop());
        assertEquals(1, myStack.pop());
    }

    @Test
    public void testMyStack2() {
        MyStack<Number> myStack = new MyStack<>();

        List<Integer> integerList = List.of(1, 2, 3);
        List<Long> longList = List.of(4L, 5L, 6L);

        myStack.pushAll(integerList);
        myStack.pushAll(longList);

        assertEquals(6L, myStack.pop());
        assertEquals(5L, myStack.pop());
        assertEquals(4L, myStack.pop());
        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.pop());
        assertEquals(1, myStack.pop());
    }

    @Test
    public void testMyStack3() {
        // setup
        MyStack<Number> myStack = new MyStack<>();
        myStack.pushAll(List.of(1, 2, 3));
        ArrayList<Number> goal = new ArrayList<>();

        // act
        myStack.popAll(goal);

        // assert
        assertEquals(List.of(3, 2, 1), goal);
    }

    // Bounded Wildcards
    // PECS
    // Producer extends, Consumer super


}