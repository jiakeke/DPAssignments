package strategy.sorting;


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] smallArray2 = smallArray.clone();
        int[] smallArray3 = smallArray.clone();

        System.out.println("Sorting small array: ");

        System.out.print("\n    Bubble Sorting:   ");
        SortingContext sortingContext = new SortingContext(new BubbleSorting());
        checkPerformance(sortingContext, smallArray);

        System.out.print("\n    Selection Sorting: ");
        sortingContext.setSortingStrategy(new SelectionSorting());
        checkPerformance(sortingContext, smallArray3);

        System.out.print("\n    Insertion Sorting: ");
        sortingContext.setSortingStrategy(new InsertionSorting());
        checkPerformance(sortingContext, smallArray2);

        int[] largeArray = generateRandomArray(100000);
        int[] largeArray2 = largeArray.clone();
        int[] largeArray3 = largeArray.clone();

        System.out.println("\n\nSorting large array: ");
        System.out.print("\n    Bubble Sorting:   ");
        sortingContext = new SortingContext(new BubbleSorting());
        checkPerformance(sortingContext, largeArray);

        System.out.print("\n    Selection Sorting: ");
        sortingContext.setSortingStrategy(new SelectionSorting());
        checkPerformance(sortingContext, largeArray3);

        System.out.print("\n    Insertion Sorting: ");
        sortingContext.setSortingStrategy(new InsertionSorting());
        checkPerformance(sortingContext, largeArray2);
    }

    private static void checkPerformance(SortingContext sortingContext, int[] array) {
        long startTime = System.nanoTime();
        sortingContext.sort(array);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/1000.0;
        System.out.printf("%.1f Microseconds", duration);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
