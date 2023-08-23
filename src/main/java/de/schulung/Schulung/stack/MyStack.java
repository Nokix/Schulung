package de.schulung.Schulung.stack;

import java.util.LinkedList;
import java.util.List;

public class MyStack<E> {
    private LinkedList<E> list = new LinkedList<>();
    public MyStack() {
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty!");
        return list.removeFirst();
    }

    public Boolean isEmpty() {
        return list.isEmpty();
    }
}
