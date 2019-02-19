package ru.bvpotapenko.se.j3.hw1.fruit;

public class Box {
    private static final float THRESHOLD = 2 * Float.MIN_VALUE;
    private Fruit fruit;
    private int size;

    public Box(Fruit fruit) {
        this.fruit = fruit;
        size = 0;
    }

    public float getWeight() {
        return size * fruit.getWeight();
    }

    public void addFruit(int fruitAmount) {
        size += fruitAmount;
    }

    public boolean compare(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return Math.abs(box.getWeight() - getWeight()) < THRESHOLD;
    }

    public int empty() {
        int oldSize = size;
        size = 0;
        return oldSize;
    }

    public Fruit getFruitType() {
        return fruit;
    }

    public boolean getFruitFrom(Box box) {
        if (fruit != box.fruit) return false;
        addFruit(box.empty());
        return true;
    }

}
