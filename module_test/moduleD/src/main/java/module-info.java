module moudleD {
    // 依赖模块
    requires transitive moudleB;

    // 导出的包
    // exports com.faintdream.moudle.b;


    // 使用服务
    uses com.faintdream.moudle.a.MyService;
}
