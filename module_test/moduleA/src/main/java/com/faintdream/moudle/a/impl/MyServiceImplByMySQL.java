package com.faintdream.moudle.a.impl;

import com.faintdream.moudle.a.MyService;

public class MyServiceImplByMySQL implements MyService {
    /**
     *
     */
    @Override
    public void performAction() {
        System.out.println("执行操作" + getClass().getSimpleName());
    }
}
