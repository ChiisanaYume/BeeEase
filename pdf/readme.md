### 笔记
* a4纸的大小(近似值72px下)：
``` java
// 1mm ≈ 2.834645669像素(分辨率72px)
private float ratio 2.834645669f
// 210mm
private float defPageWidth = 595.27563f;
// 297mm
private float defPageHeight = 841.8898f;
```

### 异常
``` java
7月 07, 2023 9:24:26 下午 org.apache.pdfbox.pdmodel.PDPageContentStream <init>
警告: You are overwriting an existing content, you should use the append mode
```
* PDPage 不能复用
* 未知问题
```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-dependency-plugin:2.8:purge-local-repository (default-cli) on project pdf: Failed to refresh project dependencies for: com.faintdream:pdf:jar:1.0-SNAPSHOT: required artif
acts missing:
[ERROR] com.faintdream:tool:jar:1.0-SNAPSHOT
[ERROR]
[ERROR] for the artifact:
[ERROR] com.faintdream:pdf:jar:1.0-SNAPSHOT
[ERROR]
[ERROR] from the specified remote repositories:
[ERROR] central (https://repo.maven.apache.org/maven2, releases=true, snapshots=false)
[ERROR] -> [Help 1]
[ERROR]
```
* 未知问题
```
[WARNING] Missing POM for com.faintdream:tool:jar:1.0-SNAPSHOT
[INFO] Unable to resolve all dependencies for : com.faintdream:pdf:1.0-SNAPSHOT. Falling back to non-transitive mode for initial artifact resolution.
[WARNING] Unable to purge local repository location: E:\lib\maven_repository\com\faintdream\tool\1.0-SNAPSHOT
```