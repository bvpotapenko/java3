package ru.bvpotapenko.se.j3.threads2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Starter {
    private CyclicBarrier cb ;
    private CountDownLatch cdl = new CountDownLatch(1);

    public Starter(int carsAmount) {
        this.cb = new CyclicBarrier(carsAmount + 1);
    }

    public CyclicBarrier getCb() {
        return cb;
    }

    public CountDownLatch startCommand() {
        return cdl;
    }
}
