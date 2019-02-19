package ru.bvpotapenko.se.j3.hw1;

import ru.bvpotapenko.se.j3.hw1.fruit.Box;
import ru.bvpotapenko.se.j3.hw1.fruit.Fruit;

import java.util.Arrays;
import java.util.List;

/**
 * HW1
 */
public class App {
    public static void main(String[] args) {
        task_1();
        task_2();
        task_3();
    }

    /**
     * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
     */
    static void task_1() {
        Integer[] list = {5, 6, 7};
        System.out.println(Arrays.toString(list));
        new Switcher<Integer>().switchItems(list, 0, 2);
        System.out.println(Arrays.toString(list));
        System.out.println();
    }

    /**
     * Написать метод, который преобразует массив в ArrayList;
     */
    static void task_2() {
        String[] strArr = {"1", "2", "3"};
        List<String> sList = new Converter<String>().toArrayList(strArr);
        System.out.println(sList.getClass() + ": " + sList);
        System.out.println();
    }

    /**
     * Fruit
     */
    static void task_3() {
        Box appleBox = new Box(Fruit.APPLE);
        Box appleBox2 = new Box(Fruit.APPLE);
        Box orangeBox = new Box(Fruit.ORANGE);
        appleBox.addFruit(5);
        appleBox2.addFruit(5);
        orangeBox.addFruit(10);
        System.out.println("appleBox: "+appleBox.getWeight());
        System.out.println("appleBox_2: "+appleBox2.getWeight());
        System.out.println("orangeBox: "+orangeBox.getWeight());
        System.out.println();
        System.out.println("Compare Apple with Orange: "+appleBox.compare(orangeBox));
        System.out.println("Compare Apple with Apple_2: "+appleBox.compare(appleBox2));
        System.out.println();
        System.out.println("From Orange to Apple: " + appleBox.getFruitFrom(orangeBox));
        System.out.println("appleBox: "+appleBox.getWeight());
        System.out.println("orangeBox: "+orangeBox.getWeight());
        System.out.println();
        System.out.println("From Apple to Apple2: " + appleBox2.getFruitFrom(appleBox));
        System.out.println("appleBox: "+appleBox.getWeight());
        System.out.println("appleBox_2: "+appleBox2.getWeight());

    }
}
