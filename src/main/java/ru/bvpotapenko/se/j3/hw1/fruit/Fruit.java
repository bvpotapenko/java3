package ru.bvpotapenko.se.j3.hw1.fruit;

public enum Fruit {
    APPLE(1.0f), ORANGE(1.5f);
    private float weight;

    Fruit(float weight){
        this.weight = weight;
    }

    public float getWeight(){ return weight;}
}
