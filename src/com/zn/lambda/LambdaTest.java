package com.zn.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import javax.swing.JButton;

public class LambdaTest {

    public static void main(String[] args) {
        // 1.匿名类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("this is a test before java 8");
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("this is a test after java 8");
        });
        thread.start();
        thread2.start();
        // 2.action
        JButton button = new JButton("ON");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println("without lambda!");
            }
        });
        button.addActionListener((e) -> System.out.println("with lambda!"));

        // 3.List处理
        List<String> fruit = Arrays.asList("apple", "orange", "banana");
        // without lambda
        for (String f : fruit) {
            System.out.println(f);
        }
        // with lambda
        fruit.forEach(a -> System.out.println(a));

        // 4.函数式接口

        fruit.stream().map(a -> a.toUpperCase()).forEach(System.out::println);

        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        // without lambda
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        // with lambda
        double summ = costBeforeTax.stream().map(a -> a + a * 0.12).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + summ);

        ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4)
                .reduce(new ArrayList<Integer>(),
                        (acc, item) -> {
                            acc.add(item);
                            System.out.println("item: " + item);
                            System.out.println("acc+ : " + acc);
                            System.out.println("BiFunction");
                            return acc;
                        }, (acc, item) -> {
                            System.out.println("BinaryOperator");
                            acc.addAll(item);
                            System.out.println("item: " + item);
                            System.out.println("acc+ : " + acc);
                            System.out.println("--------");
                            return acc;
                        });
        System.out.println("accResult_: " + accResult_);
        
        Stream.of("apple","orange","banana").filter(a->a.startsWith("a")).forEach(System.out::println);

    }

}
