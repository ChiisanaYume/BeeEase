package com.faintdream.test.moudletest.modle3.impl;

import com.faintdream.test.moudletest.modle1.MyService;

public class MyServiceImplByC implements MyService {

    @Override
    public void performAction() {
        System.out.println("执行操作-->" + getClass().getSimpleName());
    }
}
