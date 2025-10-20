package com.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TPTest {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(10, 20, 60L, java.util.concurrent.TimeUnit.SECONDS,
                new java.util.concurrent.LinkedBlockingQueue<Runnable>(2), new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
        List<Future<Callable>> futureList = new ArrayList<>(10);

        for (int i = 0; i < 50; i++) {
            final int index = i;
            Future future = executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " " + index);
                return index;
            });
            futureList.add(future);
        }
        try {
            for (Future f : futureList) {
                System.out.println("result：" + f.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
