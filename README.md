
### 每天提交并推送代码的步骤：

#### 1. **检查项目的当前状态**

首先，查看 Git 状态，确认哪些文件发生了变化（新增、修改、删除）：

```bash
git status
```

列出所有的修改或新文件，提示哪些文件已准备好提交，哪些文件未被跟踪。

#### 2. **添加新的更改**

对于更改的文件（如新增代码或修改了现有代码），需要将它们添加到 Git 索引中：

```bash
git add .
```


#### 3. **提交更改**

提交刚刚添加的文件写上有意义的注释或日期：

```bash
git commit -m
```
示例：
```bash
git commit -m "注释注释"
```



确保提交消息简明扼要且能够清楚描述本次提交的更改内容。

#### 4. **推送到 GitHub**

将更改推送到远程 GitHub 仓库中：

```bash
git push origin master
```


#### 5. **验证推送是否成功**

推送完成后，可以通过浏览器访问 GitHub 仓库。如果想查看详细的提交记录，可以运行：

```bash
git log
```

这个命令会显示提交历史，你可以查看每个提交的时间、作者以及提交消息。

### 代码运行步骤示例

#### 编译
```bash
javac -cp lib/algs4.jar -d out src/main/java/chapter1/fundamentals/BinarySearch.java
```
#### 运行
```bash
java -cp lib/algs4.jar:out chapter1.fundamentals.BinarySearch src/main/resources/algs4-data/tinyW.txt < src/main/resources/algs4-data/tinyT.txt
```
