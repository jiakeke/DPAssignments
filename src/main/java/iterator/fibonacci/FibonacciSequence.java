package iterator.fibonacci;

import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer>, Sequence {
    int amount;

    public FibonacciSequence(int amount) {
        this.amount = amount;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(amount);
    }

}
