package ru.skypro.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgorithmsPart2 {
    // Алгоритмическая сложность- количественная характеристика, которая зависит
    // от количества времени на выполнение операции и количеством элементов над которыми эта операция выполняется.
    /*List<Integer> arrayList = new ArrayList<>(); // Динамический массив
    List<Integer> linkedList = new LinkedList<>(); // Связный список

    *//*
     * Получение элемента по индексу
     * *//*
    arrayList.get(2); // Константная сложность
    linkedList.get(2); // Линейная сложность

    *//*
     * Вставка в начало
     * *//*
    arrayList.add(0,2); // Линейная сложность
    linkedList.add(0,2); // Константная сложность

    *//*
     * Перебор всех комбинаций элементов
     * *//*
        for (int i = 0; i < arrayList.size(); i++) { // Квадратичная сложность
            for (int j = 0; j < arrayList.size(); j++) {
                System.out.println(arrayList(i) +  "- -" + arrayList(j));
            }
        }
    *//*
    * Печать всех элементов
    * *//*
    for(int i = 0; i < arrayList.size(); i++) // Линейная сложность
            System.out.println(arrayList.get(i));


    *//*
     * Печать всех элементов
     * *//*
    for(int i = 0; i < linkedList.size(); i++) // Квадратичная сложность, т.к. если посмотреть реализацию, то увидим цикл внутри цикла.
            System.out.println(linkedList.get(i));*/
}
