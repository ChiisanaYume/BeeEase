module moudleB {
    // 依赖模块
    requires transitive moudleA;

    // 导出的包
    exports com.faintdream.moudle.b;

    // 声明服务的提供者
    provides com.faintdream.moudle.a.MyService
            with com.faintdream.moudle.b.MyServiceBySqlLite;

    // 使用服务
    uses com.faintdream.moudle.a.MyService;
    uses com.faintdream.moudle.a.MyName;
}
