package com.siiruo.bytecode.modification;

import com.siiruo.bytecode.modification.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siiruo wong on 2020/2/10.
 */
public class TestGC {
    public static void main(String[] args) {
        List<User> users=new ArrayList<>();
        String perfix="name-";
        int index=1;
        while (true){
            users.add(new User(perfix+index,index));
            index++;
            if (index%50==0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            if (index%200==0) {
//                System.gc();
//                System.runFinalization();
//                System.gc();
//            }

        }
    }
}
