package ru.bvpotapenko.se.j3.l7.reflections.tester;

import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.AfterSuite;
import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.BeforeSuite;
import ru.bvpotapenko.se.j3.l7.reflections.tester.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestExecutor {
    private static Comparator<Method> cmp = Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority());
    public static Queue<Method> methodsToExecute = new PriorityQueue<>(cmp);
    public static Method beforeSuite;
    public static Method afterSuite;
    public static boolean overallResult = true;
    public static Object test;
    private static Class testClass;

    public static boolean start(String className) {
        try {
            return start(Class.forName(className));
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load test " + className + " - class not found");
        } catch (RuntimeException e) {
            System.err.println("Test: " + className + " - failed: " + e.getMessage());
        }
        return false;
    }

    public static boolean start(Class testClass) {
        /**
         * 0. Throw an exception if there are two or more methods with @BeforeSuite and/or @AfterSuite annotations
         * 1. Start @BeforeSuite
         * 2. Prioritize @Test by "priority" value
         * 3. Run tests according to their priority
         * 4. Start @AfterSuite
         */
        TestExecutor.testClass = testClass;


        try {
            prepareTestSet();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return false;
        }
        if (createTestObject()) return false;

        System.out.println("Test " + testClass.getSimpleName() + " STARTED");
        if (runBoundary(beforeSuite)) return false;
        while (!methodsToExecute.isEmpty()) {
            Method currentTest = methodsToExecute.poll();
            StringBuilder sb = new StringBuilder();
            sb.append("\tTest ").append(currentTest.getName()).append(": ");
            try {
                boolean currentResult = (boolean) currentTest.invoke(test);
                overallResult &= currentResult;
                sb.append(currentResult);
                if (currentResult) {
                    System.out.println(sb.toString());
                } else {
                    System.err.println(sb.toString());
                    System.err.flush();
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                sb.append(false).append(" ").append(e.getMessage());
                overallResult = false;
                System.err.println(sb.toString());
            }

        }
        if (runBoundary(afterSuite)) return false;

        return overallResult;
    }

    private static boolean createTestObject() {
        try {
            test = testClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private static void prepareTestSet() {
        beforeSuite = null;
        afterSuite = null;
        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsToExecute.add(method);
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteCount++;
                beforeSuite = method;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteCount++;
                afterSuite = method;
            }

            if (beforeSuiteCount > 1) throw new RuntimeException("Multiply @BeforeSuite declaration");
            if (afterSuiteCount > 1) throw new RuntimeException("Multiply @AfterSuite declaration");
        }
    }

    private static boolean runBoundary(Method boundaryMethod) {
        if (boundaryMethod != null) {
            try {
                boundaryMethod.invoke(test);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.err.println(e.getMessage());
                return true;
            }
        }
        return false;
    }
}
