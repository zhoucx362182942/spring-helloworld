package com.zcx.designpattern.factory;

/**
 * Oracle连接
 * Created by zhou on 2019/1/10.
 */
public class OracleConnection extends Connection {
    public OracleConnection() {
        System.out.println("OracleConnection已创建");
    }
}
