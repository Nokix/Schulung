package de.schulung.Schulung.stack;

import java.util.Collection;
import java.util.LinkedList;

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

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            this.push(e);
        }

//        StreamSupport.stream(src.spliterator(), false)
//                .forEach(this::push);
    }

    public void popAll(Collection<? super E> dest) {
        while (!isEmpty()) dest.add(pop());
    }


}
