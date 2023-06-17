package com.faintdream.gui.javafx.test;

import org.junit.Test;

public class Demo15 {
    @Test
    public void classTest(){
        System.out.println(String.class);
        String s = new String("234");
        System.out.println(s.getClass());
        System.out.println(s.getClass()==String.class);
    }
}
