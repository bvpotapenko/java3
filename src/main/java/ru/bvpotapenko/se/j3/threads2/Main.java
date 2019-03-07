package ru.bvpotapenko.se.j3.threads2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("IMPORTANT NOTICE >>> Prepare!!!");
        final CountDownLatch finish = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Starter starter = new Starter(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), starter, finish);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            starter.getCb().await();
            System.out.println("IMPORTANT NOTICE >>> The Race has started!!!");
            starter.startCommand().countDown();
            finish.await();
            System.out.println("IMPORTANT NOTICE >>> The Race is over!!!");
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("IMPORTANT NOTICE >>> The Race was canceled!!!");
            e.printStackTrace();
        }

    }
}

