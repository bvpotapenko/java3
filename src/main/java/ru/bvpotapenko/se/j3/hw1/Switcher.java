package ru.bvpotapenko.se.j3.hw1;

import java.util.ArrayList;

public class Switcher<E> {
    public void switchItems(E[] arr, int item1, int item2) {
        E temp = arr[item1];
        arr[item1] = arr[item2];
        arr[item2] = temp;
    }
}
