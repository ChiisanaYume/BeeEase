package com.faintdream.tool;

/**
 * 抽象工厂(所有工厂的顶级接口)
 * @author faintdream
 * @version 1.0
 * @param <P> Product 生产的商品
 * */

@FunctionalInterface
public interface Factory<P>{
    /**
     * 生产商品
     * @return P  Product 生产的商品
     * @throws Exception 异常
     * */
    P build()throws Exception;
}
