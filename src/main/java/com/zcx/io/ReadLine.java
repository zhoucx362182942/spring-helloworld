package com.zcx.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zhou on 2019/1/11.
 */
public class ReadLine {
    public static void main(String[] args) {
//        String str = null;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            str = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(str);
        fun();
    }

    public static void fun() {
        String s = null;
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(s);
    }
}
