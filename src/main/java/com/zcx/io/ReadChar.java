package com.zcx.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhou on 2019/1/11.
 */
public class ReadChar {
    public static void main(String[] args) {
        char c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入字符，按q结束");
        try {
            do {
                c = (char)reader.read();
                System.out.println(c);
            } while (c != 'q');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
