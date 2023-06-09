# JavaFX 笔记

### javaFX VM参数

* --module-path "E:\lib\Other\javafx-sdk-18\lib" --add-modules javafx.controls,javafx.fxml
* 其中module-path 为javafx-jdk(\lib)的的目录

### javaFX结构

* 应用程序(javaFX Application)
* 舞台 - 设置场景(Stage)
* 场景 - 设置布局(Scenes)
* 布局 - 添加控件
* 控件

### 第一个 JavaFX 应用程序

* javaFX 应用程序需要一个主启动类
* 该类必须
    * 扩展 javafx.application.Application 接口
    * 实现 start() 方法
* 添加一个 main() 方法
* 设置场景,添加控件...

### Stage(舞台)

* 设置标题
    * setTitle("标题") // 设置(窗口)标题
* 设置位置
    * setX(); // 设置X轴
    * setY(); // 设置Y轴
* 设置大小
    * setWidth(); // 设置宽度
    * setHeight(); // 设置高度
    *
    * 注意,窗口的大小一般通过场景(Scene)来设置
    * Scene scene = new Scene(hBox,WIDTH,HEIGHT);

* 设置窗口图标
    * getIcon().addIcon(); // 设置窗口图标
    *
    * FileInputStream inputStream = new FileInputStream(getClassPath()+"纸箱.png");
    * inputStream.close();
    * Image icon = new Image(inputStream);
    * 注意IO问题
* 设置窗口风格
    * stage.initStyle(StageStyle.DECORATED); // 设置舞台的风格
    *
    * StageStyle.DECORATED：默认样式，舞台具有装饰（标题栏、边框等）
    * StageStyle.UNDECORATED：舞台没有装饰，即没有标题栏和边框
    * StageStyle.TRANSPARENT：舞台透明，没有背景颜色和装饰，只显示舞台中的内容。
    * StageStyle.UNIFIED：舞台具有统一的装饰，标题栏与内容区域融为一体。
    * StageStyle.UTILITY：类似于UNIFIED样式，但舞台具有较小的尺寸和简化的装饰，通常用作工具窗口或对话框。
* 设置全屏模式
    * setFullScreen(true); // 全屏
* 绑定生命周期事件(监听器)
    * 注册窗口关闭事件
    * stage.setOnCloseRequest((event)->{System.out.println("关闭窗口");});

    * 窗口生命周期
        * setOnShowing()： 窗口即将显示时触发的事件。
        * setOnShown()： 窗口已经显示后触发的事件。
        * setOnHiding()： 窗口即将隐藏时触发的事件。
        * setOnHidden()： 窗口已经隐藏后触发的事件。
        *
* 绑定键盘事件(监听器)

### 场景(javafx.scene.Scene)

* 场景是场景图(布局)的根
* 场景 <- 场景图(布局) <- 可视 JavaFX GUI 组件

* 创建场景
    * 您必须传递根场景图(布局)组件
    ``` java
    * VBox vBox = new VBox();
    * Scene scene = new Scene(vBox);
    ```
    * 指定场景宽高
    ``` java
    VBox vBox = new VBox();
    Scene scene = new Scene(vBox,640,480);
    ```

* 将场景添加到舞台
    * 一个舞台(stage)智能添加一个场景
    * stage.setScene(scene);

    * 场景鼠标样式
    ``` java
      scene.setCursor(Cursor.OPEN_HAND); // 设置场景鼠标样式
    ```

    * 一些常用的鼠标样式值
    ```
      Cursor.OPEN_HAND // 手掌展开
      Cursor.CLOSED_HAND // 半握
      Cursor.CROSSHAIR // 十字
      Cursor.DEFAULT // 默认
      Cursor.HAND // 手指点击
      Cursor.WAIT // 转圈圈
      Cursor.H_RESIZE // 双向箭头水平
      Cursor.V_RESIZE // 双向箭头垂直
      Cursor.MOVE
      Cursor.TEXT
    ```

### 节点(javafx.scene.Node)

* javafx.scene.Node是添加到JavaFX 场景图的所有组件 的基类（超类）
    * JavaFX Node 类是抽象的，因此您只需将 Node 类的子类添加到场景中
    * 每个 JavaFX 节点（子类）实例只能添加到 JavaFX 场景中一次
    * JavaFX 节点有时可以有子项——也称为子项
    * 将 Node 实例附加到场景图后，仅允许管理 JavaFX 场景图的线程(JavaFX 应用程序线程)修改 Node 实例

*

### 文本(javafx.scene.text.Text)

* Text节点是JavaFX节点，它允许我们在场景图上显示文本

### 异常(~~解决方法~~)

 ```
  6月 13, 2023 4:13:08 下午 com.sun.javafx.application.PlatformImpl startup
  警告: Unsupported JavaFX configuration: classes were loaded from 'unnamed module @573fd745'
 ```

* 使用 junit 测试方法 @Test运行javaFX launch()方法的报错↑↑↑ <br>
虽然报错但是程序可以跑起来???

* `错误: 缺少 JavaFX 运行时组件, 需要使用该组件来运行此应用程序` jdk8之后的版本需要引入模块

* `Error: A JNI error has occurred, please check your installation and try again`
  java虚拟机（JVM）无法加载或调用本地方法库（Native Method Library）↑↑↑
  一般是java版本不是您期望的版本或与Maven不兼容
* `java: 程序包javafx.application不存在`

* -source 11 中不支持 instanceof 中的模式匹配
* `Process exited with an error: 1 (Exit value: 1)` 未知的问题
* `找不到模块: javafx.controls` 使用javaFX 17版本及以上版本找不到模块;原因未知;
* `找不到模块: javafx.fxml` 使用javaFX 17版本及以上版本找不到模块;原因未知;

```
6月 27, 2023 9:02:29 下午 com.sun.javafx.css.StyleManager loadStylesheetUnPrivileged
警告: Resource "D:\study\Beee\BeeEase\gui-test-javafx\target\classes\style-30.css" not found.
```

* ↑↑`scene.getStylesheets().add("style-30.css");`↑↑这个路径是相对于类路径根的相对路径

```
六月 28, 2023 2:40:37 下午 javafx.fxml.FXMLLoader$ValueElement processValue
WARNING: Loading FXML document with JavaFX API of version 16 by JavaFX runtime of version 8.0.202-ea
```
* ↑↑ 警告：通过8.0.202-ea版的JavaFX运行时加载带有16版JavaFX API的FXML文档
```
Error occurred during initialization of boot layer
java.lang.module.FindException: Module guiTestJavafx not found
```
## 课外

* VM选项 -ea 表示启用java的断言assert