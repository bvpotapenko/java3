package ru.bvpotapenko.se.j3.hw1.fruit;

public class Box<F extends Fruit> {
    private static final float THRESHOLD = 2 * Float.MIN_VALUE;
    private F fruit;
    private int size;

    public Box(F fruit) {
        size = 0;
        this.fruit = fruit;

    }

    public float getWeight() {
        return size * fruit.getWeight();
    }

    public void addFruit(int fruitAmount) {
        size += fruitAmount;
    }

    public boolean compare(Box box) {
        if (this == box) return true;
        return Math.abs(box.getWeight() - getWeight()) < THRESHOLD;
    }

    private int empty() {
        int oldSize = size;
        size = 0;
        return oldSize;
    }

    public Fruit getFruitType() {
        return fruit;
    }

    public int getFruitFrom(Box<F> box) {
        int boxHadFruit = box.empty();
        addFruit(boxHadFruit);
        return boxHadFruit;
    }

}
