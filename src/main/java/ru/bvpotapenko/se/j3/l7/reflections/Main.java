package ru.bvpotapenko.se.j3.l7.reflections;

import ru.bvpotapenko.se.j3.l7.reflections.tester.TestExecutor;
import ru.bvpotapenko.se.j3.l7.reflections.tests.TestExample1;
import ru.bvpotapenko.se.j3.l7.reflections.tests.TestExample3;

public class Main {
    public static void main(String[] args) {
        //Started by Class name
        execTestByClass(TestExample1.class);
        System.out.println();

        //Started by String name
        execTestByName("ru.bvpotapenko.se.j3.l7.reflections.tests.TestExample2");
        System.out.println();

        //Must fail because of multiply @BeforeSuite notation
        execTestByClass(TestExample3.class);

    }

    private static void execTestByClass(Class testClass) {
        showTestResults(TestExecutor.start(testClass), testClass.getSimpleName());
    }

    private static void execTestByName(String testClass) {
        showTestResults(TestExecutor.start(testClass), testClass);
    }

    private static void showTestResults(boolean testResult, String test) {
        if (testResult) {
            System.out.println("Test " + test + " OK");
        } else {
            System.err.println("Test " + test + " FAILED");
        }
    }
}
