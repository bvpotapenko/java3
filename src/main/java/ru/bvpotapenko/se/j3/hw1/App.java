package ru.bvpotapenko.se.j3.hw1;

import java.util.ArrayList;
import java.util.List;

/**
 * HW1
 */
public class App {
    public static void main(String[] args) {
        task_1();
        task_2();
    }

    /**
     * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
     */
    static void task_1() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        new Switcher<Integer>().switchItems((ArrayList) list, 0, 2);
        System.out.println(list);
    }

    /**
     * Написать метод, который преобразует массив в ArrayList;
     */
    static void task_2() {
        String[] strArr = {"1", "2", "3"};
        List<String> sList = new Converter<String>().toArrayList(strArr);
        System.out.println(sList.getClass() + ": " + sList);
    }
}
