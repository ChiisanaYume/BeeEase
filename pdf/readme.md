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