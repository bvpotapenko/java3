package ru.bvpotapenko.se.j3.l6tools;

import java.util.Arrays;

/**
 * JUnit tasks for Java-3
 */
public class App {

    /**
     * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки.
     * Входной массив должен содержать хотя бы одну четверку,
     * иначе в методе необходимо выбросить RuntimeException.
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */
    public static int[] getTailAfterLastTetrad(int[] arr) {
        if (arr.length < 4) throw new RuntimeException("Array size must be gte 4");
        return Arrays.copyOfRange(arr, (arr.length - arr.length % 4), arr.length);
    }

    /**
     * Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */
    public static boolean arrayDummyCheck(int[] arr) {
        boolean has_1 = false;
        boolean has_4  = false;
        for (int i: arr) {
            switch (i) {
                case 1:
                    has_1 = true;
                    break;
                case 4:
                    has_4 = true;
                    break;
                default:
                    return false;
            }
        }
        return has_1 && has_4;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 1, 2, 3, 4, 1, 4, 1};
        System.out.println(arrayDummyCheck(getTailAfterLastTetrad(arr)));
    }
}
