package ru.skypro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        List<String> array2 = new ArrayList<>();
        List<String> array3 = new ArrayList<>();

        array.add("Enigma");
        array.add("Puma");
        array.add("Fima");
        array.add("Fima");
        array2.add("Fima");
        array2.add("Fima");
        array2.add("Fima");
        array3.add("Fima");
        array3.add("Fima");
        array3.add("Fima");
        array.add("Dora");
        array.add(5,"Kuka");
        array.get(3);
        System.out.println(array);
        System.out.println(array.get(3));
        array.set(3, "Popov");
        System.out.println(array.get(3));
        System.out.println(array);
        System.out.println(array.contains("Pumi"));
        System.out.println(array.indexOf("Puma"));
        System.out.println(array.lastIndexOf("Pumap"));
        System.out.println(array3.equals(array2));
        System.out.println(array.size() + " " + array2.size() + " " + array3.size());
        array.clear();
        System.out.println(array.size() + " " + array2.size() + " " + array3.size());
    }
}
