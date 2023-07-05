###

#### 笔记
* 执行程序会生成类似这样的代码，将这段代码在终端中运行即可打包：
```
jpackage.exe --type exe --app-version 1.0.0
 --copyright 版权归www.Snailcatmall.com蜗牛猫软件开发工作室
 --description 程序版权归www.SnailCatMall.com蜗牛猫软件开发工作室公司所有。 
 --name Demo 
 --dest D:\aaa\output
 --temp D:\aaa\output
 --vendor SnailCatMall
 --icon  
 --input D:\study\Beee\BeeEase\gui-test-javafx-jdk8\target\ 
 --main-class com.faintdream.test2.gui.javafx.Demo3
 --main-jar D:\study\Beee\BeeEase\gui-test-javafx-jdk8\target\gui-test-javafx-jdk8-1.0-SNAPSHOT.jar
```
* 实际应该就是给封装了一层，给`jpackage.exe`加上了GUI界面,简化操作
* 底层依赖于`jpackage.exe`;运行环境建议使用`jdk 16`;
* `jpackage.exe` 打包依赖 WiX 工具 (light.exe, candle.exe);
  可以从 `https://wixtoolset.org` 下载 WiX 3.0 或更高版本，然后将其添加到 PATH
