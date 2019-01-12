package com.zcx.designpattern.factory;

/**
 * 设计模式之工厂
 * 优点：使用者可以根据自己的需要，任意获得不同的实例，而不需要知道生产过程
 * 缺点：每增加一个新品种，需要维护具体类和工厂，维护量比较大
 * Created by zhou on 2019/1/10.
 */
public class ConnectionFactory {
    private static final int MYSQL_CONNECTION = 1;
    private static final int ORACLE_CONNECTION = 2;

    public static Connection getConnection(int type) {
        switch (type) {
            case MYSQL_CONNECTION :
                return new MySqlConnection();
            case ORACLE_CONNECTION :
                return new OracleConnection();
        }
        return null;
    }
}
