package ru.skypro;


import ru.skypro.execptions.NotFoundException;

import java.util.Arrays;
import java.util.Objects;


public class IntegerListImpl implements IntegerList {

    private static final int DEFAULT_CAPACITY = 10;

    private Integer[] array;
    private int size;

    public IntegerListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerListImpl(int capacity) {
        this.array = new Integer[capacity];
    }

    @Override

    public Integer add(Integer item) {
        checkOverflow();
        checkNotNull(item);
        array[size++] = item;
        return item;
    }

    private void checkOverflow() {
        if (size >= array.length) {
            Integer[] extended = new Integer[array.length * 2];
            System.arraycopy(array, 0, extended, 0, array.length);
            array = extended;
        }
    }

    @Override
    public Integer add(int index, Integer item) {
        checkNotNull(item);
        checkIndex(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[size++] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkNotNull(item);
        checkIndex(index);
        Integer replaced = get(index);
        array[index] = item;
        return replaced;
    }

    @Override
    public Integer remove(Integer item) {
        checkNotNull(item);
        checkIfItemExists(item);
        int index = indexOf(item);
        removeItem(index);
        return item;
    }

    private void removeItem(int index) {
        if (size - 1 > index) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        array[--size] = null;
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = get(index);
        removeItem(index);
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        checkNotNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkNotNull(item);
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(array[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            return false;
        }
        return Arrays.equals(toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        for (Integer s :
                array) {
            if (s == null) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        array = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void checkNotNull(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Null value is unacceptable for use.");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index must be positive or less than " + size);
        }
    }

    private void checkIfItemExists(Integer item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("The passed " + item + " does not exist in the list.");
        }
    }

    private boolean binarySearch(Integer item) {
        checkNotNull(item);

        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(array[mid])) {
                return true;
            }
            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
