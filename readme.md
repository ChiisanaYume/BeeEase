## 项目结构

## 待解决BUG
* 模块 `gui-test-javafx` 无法通过maven构建和和打包;
* 项目根目录无法构建成功，
* `Could not create modular JAR file. The JDK jar tool exited with 1`

## 异常
`java.util.ConcurrentModificationException`是在多线程环境下，当一个线程正在遍历集合（如`List`、`Set`、`Map`），
而另一个线程对该集合进行了结构性修改（如添加、删除元素）时可能会抛出的异常。
这种异常通常在单线程环境下不会出现，但在多线程环境下容易发生，因为一个线程可能在遍历集合时，另一个线程同时对集合进行了修改，
导致集合的结构被破坏，从而触发了该异常。
