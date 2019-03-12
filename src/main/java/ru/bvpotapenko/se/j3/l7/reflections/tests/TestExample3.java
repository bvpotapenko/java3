package ru.bvpotapenko.se.j3.l7.reflections.tests;

import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.BeforeSuite;
import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.Test;

public class TestExample3 {

    @Test
    public boolean dummyTest(){
        System.out.println("\tTestExample3 dummyTest");
        return true;
    }

    @BeforeSuite
    public void before1(){};

    @BeforeSuite
    public void before2(){};
}
