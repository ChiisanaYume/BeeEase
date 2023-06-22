package com.faintdream.moudle.a.impl;

import com.faintdream.moudle.a.MyName;

public class Kirara implements MyName {

    private String name;
    /**
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    public Kirara(String name) {
        System.out.println("getName()方法执行");
        this.name = name;
    }

    public static Kirara provider(){
        return new Kirara("Kirara");
    }

    public Kirara() {
    }
}
