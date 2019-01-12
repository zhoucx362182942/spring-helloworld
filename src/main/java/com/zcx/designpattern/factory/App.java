package com.zcx.designpattern.factory;

/**
 * Created by zhou on 2019/1/10.
 */
public class App {
    public static void main(String[] args) {
        Connection connection1 = ConnectionFactory.getConnection(1);
        Connection connection2 = ConnectionFactory.getConnection(2);
    }
}
