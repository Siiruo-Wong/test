package com.siiruo.bytecode.modification.service.impl;

import com.siiruo.bytecode.modification.bean.User;
import com.siiruo.bytecode.modification.service.IUserService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by siiruo wong on 2018/11/13.
 */
public class UserService implements IUserService {

    private static final Map<String,User> users=new ConcurrentHashMap<>();


    static {

        users.put("wang",new User("wang",45));
        users.put("yan",new User("yan",15));
        users.put("jun",new User("jun",30));
        users.put("meng",new User("meng",90));
        users.put("siiruo",new User("siiruo",20));



    }


    @Override
    public User query(String name) {
        return users.get(name);
    }
    
}
