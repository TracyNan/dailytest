package com.format;

import java.time.format.DateTimeFormatter;

public class FmtTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(java.time.LocalDateTime.now()));
    }
}
