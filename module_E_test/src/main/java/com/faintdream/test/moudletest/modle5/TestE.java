package com.faintdream.test.moudletest.modle5;

import com.faintdream.test.moudletest.modle1.MyService;

import java.util.ServiceLoader;

public class TestE {
    public static void main(String[] args) {
        ServiceLoader<MyService> serviceLoader = ServiceLoader.load(MyService.class);
        for(MyService myService:serviceLoader){
            myService.performAction();
        }
    }
}
