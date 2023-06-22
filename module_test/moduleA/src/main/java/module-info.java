module moudleA {
    // 依赖模块
    // requires guiTestJavafx;

    // 导出的包
    exports com.faintdream.moudle.a;

    // 声明服务的提供者
    provides com.faintdream.moudle.a.MyService
            with com.faintdream.moudle.a.impl.MyServiceImplByMySQL,
                    com.faintdream.moudle.a.impl.MyServiceImplByOracle,
                    com.faintdream.moudle.a.impl.MyServiceImplDataSource;
    provides com.faintdream.moudle.a.MyName with com.faintdream.moudle.a.impl.Kirara;
}
