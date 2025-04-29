package iterator.fibonacci;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence(20);
        for (int number : sequence) {
            System.out.print(number + " ");
        }
    }
}
