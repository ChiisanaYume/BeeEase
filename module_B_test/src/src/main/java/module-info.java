module moudleTestB {
    // 依赖模块
    requires moudleTestA;

    // 导出的包
    exports com.faintdream.test.moudletest.modle2.impl;

    // 声明服务的提供者
    provides com.faintdream.test.moudletest.modle1.MyService with com.faintdream.test.moudletest.modle2.impl.MyServiceImplByB;

}
