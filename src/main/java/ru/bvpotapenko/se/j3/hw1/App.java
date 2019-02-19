package ru.bvpotapenko.se.j3.hw1;

import java.util.ArrayList;
import java.util.List;

/**
 * HW1
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        switchItems((ArrayList) list, 0, 2);
        System.out.println(list);
    }

    /**
     * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
     */

    static void switchItems(ArrayList arr, int item1, int item2) {
        Object temp = arr.get(item1);
        arr.set(item1, arr.get(item2));
        arr.set(item2, temp);
    }
}
