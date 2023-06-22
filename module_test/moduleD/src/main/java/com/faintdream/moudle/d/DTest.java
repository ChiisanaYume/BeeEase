package com.faintdream.moudle.d;

import com.faintdream.moudle.a.MyService;

import java.util.ServiceLoader;

public class DTest {
    public static void main(String[] args) {
        ServiceLoader<MyService> serviceLoader = ServiceLoader.load(MyService.class);
        for (MyService myService : serviceLoader) {
            myService.performAction();
        }
    }
}
