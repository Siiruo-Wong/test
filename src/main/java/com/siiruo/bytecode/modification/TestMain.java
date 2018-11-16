package com.siiruo.bytecode.modification;

import com.siiruo.bytecode.modification.service.IUserService;
import com.siiruo.bytecode.modification.service.impl.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by siiruo wong on 2018/11/13.
 */
public class TestMain {
    public static void main(String[] args) {

        IUserService userService=new UserService();

        IUserService proxy=(IUserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("来自代理对象的前置通知");
                Object obj=method.invoke(userService,args);
                System.out.println(obj);
                System.out.println("来自代理对象的后置通知");
                return obj;
            }
        });
        proxy.query("meng");
        System.out.println(proxy);


    }
}
