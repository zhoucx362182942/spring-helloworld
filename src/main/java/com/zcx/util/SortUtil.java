package com.zcx.util;

import java.util.Random;

/**
 * Created by zhou on 2019/1/9.
 */
public class SortUtil {
    /**
     * 快速排序
     * https://blog.csdn.net/Yexiaofen/article/details/78018204
     * @param arr 数组
     * @param start 0
     * @param end 长度 - 1
     */
    public static void fastSort(int[] arr, int start, int end) {
        // 1、非空判断
        if (null == arr || arr.length <= 1) {
            return;
        }

        // 2、找到递归出口
        if (start > end) {
            return;
        }

        int i = start;
        int j = end;
        int key = arr[start];

        // 3、一趟排序
        while (i < j) {
            // 从右向左，找到第一个比key小的数a
            while (i < j && arr[j] >= key) {
                j--;
            }
            // 从左往右，找到第一个比key大的数b
            while (i < j && arr[i] <= key) {
                i++;
            }
            // a、b交换
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;

        // 4、递归
        fastSort(arr, start, i - 1);
        fastSort(arr, i + 1, end);
    }

    /**
     * 输出数组
     * @param arr
     */
    public static void print(int[] arr) {
        for (int i = 0;i < arr.length;i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * main方法
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[999];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        print(arr);
        long t1 = System.currentTimeMillis();
        fastSort(arr,0 ,arr.length - 1);
        System.out.println(System.currentTimeMillis() - t1);
        print(arr);
    }
}
