package ru.bvpotapenko.se.j3.l7.reflections.tests;

import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.AfterSuite;
import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.BeforeSuite;
import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.Test;

public class TestExample1 {

    @BeforeSuite
    public void startMeFirst(){
        System.out.println("TestExample1 before");
    }

    @AfterSuite
    public void startMeLast(){
        System.out.println("TestExample1 after");
    }

    @Test(priority = 2)
    public boolean testSomething1(){
        System.out.println("\tTestExample1 testSomething1 priority 2");
        return true;
    }

    @Test(priority = 5)
    public boolean testSomething2(){
        System.out.println("\tTestExample1 testSomething2 priority 5");
        return true;
    }

    @Test(priority = 3)
    public boolean testSomething6(){
        System.out.println("\tTestExample1 testSomething6 priority 3");
        return true;
    }

    @Test(priority = 4)
    public boolean testSomething7(){
        System.out.println("\tTestExample1 testSomething7 priority 4");
        return true;
    }
}
