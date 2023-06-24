module guiTestJavafx {


    // 依赖的模块
    requires javafx.controls;
    requires javafx.fxml;
    // 导出的包
    exports com.faintdream.test1.gui.javafx;

    //将指定的包打开给其他模块(javafx.fxml)访问
    opens com.faintdream.test1.gui.javafx to javafx.fxml;
}
