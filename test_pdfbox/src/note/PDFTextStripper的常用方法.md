PDFTextStripper

PDFTextStripper是PDFBox库中的一个类，用于从PDF文档中提取文本内容。下面是PDFTextStripper类中一些常用的方法：

1. `getText(PDDocument document)`：
   从整个PDF文档中提取文本内容，并将其作为一个字符串返回。

2. `setStartPage(int startPage)`：
   设置要提取文本的起始页码。

3. `setEndPage(int endPage)`：
   设置要提取文本的结束页码。

4. `getStartPage()`：
   获取当前设置的起始页码。

5. `getEndPage()`：
   获取当前设置的结束页码。

6. `setSortByPosition(boolean sortByPosition)`：
   设置是否按照文本在PDF页面上的位置进行排序。默认情况下，PDFTextStripper按照文档中的读取顺序提取文本，如果将该选项设置为`true`，则会按照文本在页面上的位置进行排序。

7. `setLineSeparator(String lineSeparator)`：
   设置提取文本时使用的行分隔符。默认情况下，PDFTextStripper使用系统默认的行分隔符。

这些只是PDFTextStripper类中的一部分方法。您可以根据需要进一步探索PDFTextStripper类，了解更多可用的方法，以满足您的具体需求。