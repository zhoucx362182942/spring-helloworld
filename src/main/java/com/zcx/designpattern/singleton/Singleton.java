package com.zcx.designpattern.singleton;

/**
 * 单例
 * Created by zhou on 2019/1/11.
 */
public class Singleton {
    // 私有、静态
    private static Singleton instance = new Singleton();

    // 构造器为私有，这样不能new
    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("hello world");
    }
}
