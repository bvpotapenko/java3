package ru.bvpotapenko.se.j3.l7.reflections.tests;

import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.Test;

public class TestExample2 {

    @Test
    public boolean testSomething3(){
        System.out.println("\tTestExample2 testSomething3  priority DEFAULT");
        return true;
    }

    @Test(priority = 15)
    public boolean testSomething4(){
        System.out.println("\tTestExample2 testSomething4 priority 15");
        return true;
    }

    @Test(priority = -3)
    public boolean testSomething9(){
        System.out.println("\tTestExample2 testSomething9 priority -3");
        return false;
    }
}
