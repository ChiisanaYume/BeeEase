module moudleTestE {
    // 依赖模块
    requires moudleTestA;

    // 导出的包
    // exports com.faintdream.test.moudletest.modle2;
    exports com.faintdream.test.moudletest.modle5;

   // uses com.faintdream.test.mouletest.;
    uses com.faintdream.test.moudletest.modle1.MyService;

}
