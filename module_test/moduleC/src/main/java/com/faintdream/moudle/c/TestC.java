package com.faintdream.moudle.c;

import com.faintdream.moudle.a.MyName;
import com.faintdream.moudle.a.MyService;

import java.util.ServiceLoader;

public class TestC {
    public static void main(String[] args) {
        ServiceLoader<MyService> serviceLoader = ServiceLoader.load(MyService.class);
        for(MyService myService:serviceLoader){
            myService.performAction();
        }

        ServiceLoader<MyName> myNameServiceLoader = ServiceLoader.load(MyName.class);
        for(MyName myName:myNameServiceLoader){
            myName.getName();
        }
    }

}
