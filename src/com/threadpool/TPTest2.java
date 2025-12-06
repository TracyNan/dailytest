package com.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class TPTest2 {



    static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(50);

    public static void main(String[] args) throws InterruptedException {
        startExecute();
        startProduce();
    }

    static void startProduce(){

        ((Runnable) () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put(i);
                    System.out.println("produce " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).run();
    }
    private static void startExecute(){
        ExecutorService executor = new ThreadPoolExecutor(1, 2, 60L, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.LinkedBlockingQueue<Runnable>(50), new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(() -> {
            while(true){
                try {
                    Integer index = queue.take();
                    System.out.println(Thread.currentThread().getName() + "-" + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });
    }

}
