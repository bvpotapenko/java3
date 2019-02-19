package ru.bvpotapenko.se.j3.hw1.fruit;

import java.util.ArrayList;

public class Box<E extends Fruit> {
    private ArrayList<E> box;
    public Box(){
        box = new ArrayList<>();
    }
    public float getWeight(){
        if(box.size() == 0) return 0;
        System.out.println("box.size(): "+box.size() + " box.get(0).getWeight(): " + box.get(0).getWeight());
        return box.size() * box.get(0).getWeight();
    }

    public void addFruit(E fruit){
        box.add(fruit);
    }

    public boolean compare(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box<?> box = (Box<?>) o;
        return Float.compare(box.getWeight(), getWeight()) == 0;
   }

}
