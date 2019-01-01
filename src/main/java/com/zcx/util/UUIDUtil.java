package com.zcx.util;

import java.util.UUID;

public class UUIDUtil {
    public static String get() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}
