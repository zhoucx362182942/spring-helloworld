package com.zcx.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhou on 2019/1/11.
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\qichezhijia\\temp\\jiemi\\mkdir");

        if (file.exists()) {
            System.out.println("存在");
            if (file.isDirectory()) {
                System.out.println("文件夹");
            } else {
                System.out.println("文件");
            }
        } else {
            System.out.println("不存在");
            if (file.isDirectory()) {
                System.out.println("文件夹");
                // 可以创建多级
                file.mkdirs();

                // 只可以创建一级目录
                // file.mkdir();
            } else {
                System.out.println("文件");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(file.getAbsolutePath());
        System.out.println(file.length());
    }
}
