package com.zcx.designpattern.singleton;

/**
 * Created by zhou on 2019/1/11.
 */
public class App {
    public static void main(String[] args) {
        // 不能new
        // Singleton obj = new Singleton();
        Singleton obj = Singleton.getInstance();
        obj.print();
    }
}
