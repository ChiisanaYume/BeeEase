module moudleC {
    // 依赖模块
    requires moudleA;

    // 导出的包
    // exports com.faintdream.moudle.a;

    uses com.faintdream.moudle.a.MyService;
    uses com.faintdream.moudle.a.MyName;
}
