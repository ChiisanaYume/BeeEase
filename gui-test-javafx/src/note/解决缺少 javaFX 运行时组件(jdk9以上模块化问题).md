### 解决JavaFX报错缺少 JavaFX 运行时组件, 需要使用该组件来运行此应用程序

#### 概述(废话)
Java JDK 1.8以后，JavaFX 被从Java JDK中移除了，
因此我们使用 JavaFX 来进行开发时，如果我们使用的是1.8以后的版本，
需要引入JavaFX的依赖(使用Maven或者手动配置jar包);
Java JDK 1.8之后的JDK 9,引入了 模块 这一概念,
在未启用java模块的情况下，JVM 找不到JavaFX相关的依赖
所以即使我们引入了JavaFX的依赖jar包,
仍然会报错无法运行;
<!-- 空行 -->
![错误: 缺少 JavaFX 运行时组件, 需要使用该组件来运行此应用程序](ExceptionImage1.png)
<!-- 空行 -->
如何解决?根据我自己的研究和网上的一些资料,我总结出以下4种方法解决:

#### 方法1: 直接使用 Java JDK 1.8 进行开发
既然解决不了问题,那么久直接绕过,直接使用JDK 1.8进行开发;
看似逃避问题的方法,实则少走几十年弯路...
#### 方法2: 使用模块化的方式引入JavaFX 的依赖
#### 方法3: 配置VM参数
配置VM参数 来告诉java虚拟机 JavaFX在哪!
注意，这里配置的VM参数,不是程序实参
<!-- 空行 -->
![配置VM参数](03配置VM参数.png)
<!-- 空行 -->

#### 方法4: 奇奇怪怪的方法
不使用main方法调用launch()方法,
而是使用Junit单元测试的测试方法(@Test)来调用;
<!-- 空行 -->
![测试方法调用launch()](04测试方法调用launch().png)
<!-- 空行 -->
原理未知,但是可以运行!个人猜测可能是Junit帮我们封装了模块;
如果要使用这种方法,记得引入Junit的依赖,
使用这种方法运行会在控制台输出以下警告(不影响运行):
<!-- 空行 -->
<font style="color:#fd6b68; ">
6月 13, 2023 4:13:08 下午 com.sun.javafx.application.PlatformImpl startup
警告: Unsupported JavaFX configuration: classes were loaded from 'unnamed module @573fd745'
</font>