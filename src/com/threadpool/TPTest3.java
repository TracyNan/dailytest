package com.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class TPTest3 {

    static ExecutorService executor = new ThreadPoolExecutor(1, 10, 60L, java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<Runnable>(50), new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            startProduce(i);
        }
        executor.shutdown();
    }

    static void startProduce(Integer index){
        executor.submit(() -> {
            System.out.println("Current thread = "+Thread.currentThread()+",index=" + index);
        });
    }
}
