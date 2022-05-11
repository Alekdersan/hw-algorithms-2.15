package ru.skypro.test;

import java.util.Arrays;
import java.util.Random;

import static ru.skypro.SortUtils.*;

public class SortUtilsTest {

    private static final int ARRAY_CAPACITY = 10_000;
    private static final int ARRAY_MAX_RANGE_VALUE = 100_000;

    public static void main(String[] args) {
        Random random = new Random();

        Integer[] array1 = new Integer[ARRAY_CAPACITY];
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            array1[i] = random.nextInt(ARRAY_MAX_RANGE_VALUE);
        }

        Integer[] array2 = Arrays.copyOf(array1, ARRAY_CAPACITY);
        Integer[] array3 = Arrays.copyOf(array1, ARRAY_CAPACITY);

        long start = System.currentTimeMillis();
        sortBubble(array1);
        System.out.println("Bubble sort: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sortSelection(array2);
        System.out.println("Selection sort: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sortInsertion(array3);
        System.out.println("Insertion sort: " + (System.currentTimeMillis() - start));
    }
}
