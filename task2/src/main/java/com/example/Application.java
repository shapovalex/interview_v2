package com.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        int taskCount = 1000;
        CalculationService calculationService = new CalculationService();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 6L, TimeUnit.HOURS, new ArrayBlockingQueue<>(taskCount * 2));
        long start = System.currentTimeMillis();
        for (int i = 0; i < taskCount; i++) {
            Runnable r = calculationService::doOperation;
            executor.submit(r);
        }
        while (executor.getCompletedTaskCount() != taskCount) {

        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
        System.out.println("Calculation count: " + calculationService.getCalculationCount());
        executor.shutdown();

    }
}
