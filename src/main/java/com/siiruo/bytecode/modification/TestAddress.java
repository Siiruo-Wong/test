package com.siiruo.bytecode.modification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siiruo wong on 2020/2/9.
 */
public class TestAddress {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("123");
        list.add("123");
        System.out.println(list.get(0)==list.get(1));//true
    }
}
