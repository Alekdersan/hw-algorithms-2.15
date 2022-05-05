package ru.skypro;


import ru.skypro.execptions.NotFoundException;
import java.util.Objects;


public class StringListImpl implements StringList {

    private String[] array = new String[10];
    private int size = 0;

    @Override
    public String add(String item) {
        if (size >= array.length) {
            String[] extended = new String[array.length * 2];
            System.arraycopy(array, 0, extended, 0,array.length);
            array = extended;
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        String replaced = get(index);
        array[index] = item;
        return replaced;
    }

    @Override
    public String remove(String item) {
        int num = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                num = i;
                break;
            }
        }
        if (num != -1) {
            remove(num);
        } else {
            throw new NotFoundException("Was not found");
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String element = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
            if (element.equals(array[i])) {
                throw new NotFoundException("Was not found");
            }
        }
            size--;
        return element;
    }

    @Override
    public boolean contains(String item) {
        boolean haber = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                haber = true;
                break;
            }
        }
        return haber;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return 1;
    }

    @Override
    public int lastIndexOf(String item) {
        int result = -1;
        for (int i = size - 1; i >= 0 ; i--) {
            if (array[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        boolean result = true;
        if (size != otherList.size()) {
            result = false;
        } else {
            for (int i = 0; i < size; i++) {
                if (!(get(i)).equals(otherList.get(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        for (String s :
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
        array = new String[10];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        for (int i = 0; i < size; i++) {
            newArray [i] = this.get(i);
        }
        return newArray;
    }
}
