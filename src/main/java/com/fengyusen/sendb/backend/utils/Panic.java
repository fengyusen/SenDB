package com.fengyusen.sendb.backend.utils;

/**
 * 用于处理异常的工具类
 */
public class Panic {
    public static void panic(Exception err) {
        err.printStackTrace();
        System.exit(1);
    }
}
