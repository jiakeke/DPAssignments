package iterator.fibonacci;

import java.util.Iterator;
/*
I choose to store the state of Fibonacci (such as prev, current, counter) in FibonacciIterator instead of FibonacciSequence.
In this way, it is safer, each iterator is independent, supports concurrency, does not affect each other.
*/

public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0;
    private int current = 1;
    private int counter = 0;
    private final int amount;

    public FibonacciIterator(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean hasNext() {
        return counter < amount; // Infinite sequence
    }

    @Override
    public Integer next() {
        counter++;
        int next = this.prev + this.current;
        this.prev = this.current;
        this.current = next;
        return this.prev;
    }
}
