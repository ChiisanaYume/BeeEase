module gui {


    // 依赖的模块
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires tool;

    // 导出的包
    exports com.faintdream.bee.gui.javafx;

    // 将指定的包打开给其他模块(javafx.fxml)访问
    opens com.faintdream.bee.gui.javafx to javafx.fxml;
}
