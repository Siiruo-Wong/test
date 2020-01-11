package com.siiruo.bytecode.modification;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by siiruo wong on 2019/5/4.
 */
public class TestThread {

    public static void main(String[] args) {
        try {
            ExecutorService executor= Executors.newFixedThreadPool(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
