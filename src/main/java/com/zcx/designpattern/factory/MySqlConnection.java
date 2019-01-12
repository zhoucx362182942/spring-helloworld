package com.zcx.designpattern.factory;

/**
 * MySql连接
 * Created by zhou on 2019/1/10.
 */
public class MySqlConnection extends Connection {
    public MySqlConnection() {
        System.out.println("MySqlConnection已创建");
    }
}
