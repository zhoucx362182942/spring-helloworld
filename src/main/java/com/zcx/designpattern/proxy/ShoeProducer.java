package com.zcx.designpattern.proxy;

/**
 * Created by zhou on 2019/1/11.
 */
public class ShoeProducer implements Producer {
    private String name = "nike";

    @Override
    public void fun() {
        System.out.println(name);
    }
}
