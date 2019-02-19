package ru.bvpotapenko.se.j3.hw1;

import java.util.ArrayList;

public class Switcher<E> {
    public void switchItems(ArrayList<E> arr, int item1, int item2) {
        E temp = arr.get(item1);
        arr.set(item1, arr.get(item2));
        arr.set(item2, temp);
    }
}
