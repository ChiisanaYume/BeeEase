package com.faintdream.moudle.b;

import com.faintdream.moudle.a.MyService;

public class MyServiceBySqlLite implements MyService {

    @Override
    public void performAction() {
        System.out.println("执行操作" + getClass().getSimpleName());
    }
}
