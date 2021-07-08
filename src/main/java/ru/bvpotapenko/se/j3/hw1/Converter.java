package ru.bvpotapenko.se.j3.hw1;

import java.util.ArrayList;

public class Converter<E> {
    public ArrayList<E> toArrayList(E[] arr){
        ArrayList<E> eArrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            eArrayList.add(arr[i]);
        }
        return eArrayList;
    }
}
