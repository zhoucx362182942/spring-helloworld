package com.zcx.designpattern.proxy;

/**
 * Created by zhou on 2019/1/11.
 */
public class App {
    public static void main(String[] args) {
        Producer p = new Proxy(new ShoeProducer());
        p.fun();
    }
}
