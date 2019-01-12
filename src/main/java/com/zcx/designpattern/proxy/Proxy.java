package com.zcx.designpattern.proxy;

/**
 * Created by zhou on 2019/1/11.
 */
public class Proxy implements Producer {
    private Producer producer;

    public Proxy(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void fun() {
        producer.fun();
    }
}
