<p>You are given an <em>absolute</em> path for a Unix-style file system, which always begins with a slash <code>'/'</code>. Your task is to transform this absolute path into its <strong>simplified canonical path</strong>.</p>

<p>The <em>rules</em> of a Unix-style file system are as follows:</p>

<ul> 
 <li>A single period <code>'.'</code> represents the current directory.</li> 
 <li>A double period <code>'..'</code> represents the previous/parent directory.</li> 
 <li>Multiple consecutive slashes such as <code>'//'</code> and <code>'///'</code> are treated as a single slash <code>'/'</code>.</li> 
 <li>Any sequence of periods that does <strong>not match</strong> the rules above should be treated as a <strong>valid directory or</strong> <strong>file </strong><strong>name</strong>. For example, <code>'...' </code>and <code>'....'</code> are valid directory or file names.</li> 
</ul>

<p>The simplified canonical path should follow these <em>rules</em>:</p>

<ul> 
 <li>The path must start with a single slash <code>'/'</code>.</li> 
 <li>Directories within the path must be separated by exactly one slash <code>'/'</code>.</li> 
 <li>The path must not end with a slash <code>'/'</code>, unless it is the root directory.</li> 
 <li>The path must not have any single or double periods (<code>'.'</code> and <code>'..'</code>) used to denote current or parent directories.</li> 
</ul>

<p>Return the <strong>simplified canonical path</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">path = "/home/"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">"/home"</span></p>

<p><strong>Explanation:</strong></p>

<p>The trailing slash should be removed.</p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">path = "/home//foo/"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">"/home/foo"</span></p>

<p><strong>Explanation:</strong></p>

<p>Multiple consecutive slashes are replaced by a single one.</p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">path = "/home/user/Documents/../Pictures"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">"/home/user/Pictures"</span></p>

<p><strong>Explanation:</strong></p>

<p>A double period <code>".."</code> refers to the directory up a level (the parent directory).</p>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">path = "/../"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">"/"</span></p>

<p><strong>Explanation:</strong></p>

<p>Going one level up from the root directory is not possible.</p>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">path = "/.../a/../b/c/../d/./"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">"/.../b/d"</span></p>

<p><strong>Explanation:</strong></p>

<p><code>"..."</code> is a valid name for a directory in this problem.</p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= path.length &lt;= 3000</code></li> 
 <li><code>path</code> consists of English letters, digits, period <code>'.'</code>, slash <code>'/'</code> or <code>'_'</code>.</li> 
 <li><code>path</code> is a valid absolute Unix path.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Stack</details><br>

<div>👍 6150, 👎 1368<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题比较简单，利用栈先进后出的特性处理上级目录 `..`，最后组装化简后的路径即可。

**详细题解**：
  - [【练习】栈的经典习题](https://labuladong.online/algo/problem-set/stack/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

#include <string>
#include <vector>
#include <sstream>

class Solution {
public:
    std::string simplifyPath(std::string path) {
        std::vector<std::string> parts;
        std::istringstream ss(path);
        std::string part;

        // 借助栈计算最终的文件夹路径
        while (std::getline(ss, part, '/')) {
            if (part.empty() || part == ".") {
                // Skip empty parts and current directory symbol.
                continue;
            }
            if (part == "..") {
                // Go up one directory (pop from the stack) unless the stack is empty.
                if (!parts.empty()) parts.pop_back();
            } else {
                // Add the non-empty and non-".." part to the stack.
                parts.push_back(part);
            }
        }

        // 栈中存储的文件夹组成路径
        std::string res;
        for (const auto& p : parts) {
            res += "/" + p;
        }

        // If the result is empty, it means the path is root directory.
        return res.empty() ? "/" : res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def simplifyPath(self, path: str) -> str:
        parts = path.split("/")
        stk = []
        # 借助栈计算最终的文件夹路径
        for part in parts:
            if part == "" or part == ".":
                continue
            if part == "..":
                if stk:
                    stk.pop()
                continue
            stk.append(part)
        # 栈中存储的文件夹组成路径
        res = ""
        while stk:
            res = "/" + stk.pop() + res
        return res if res else "/"
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stk = new Stack<>();
        // 借助栈计算最终的文件夹路径
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stk.isEmpty()) stk.pop();
                continue;
            }
            stk.push(part);
        }
        // 栈中存储的文件夹组成路径
        String res = "";
        while (!stk.isEmpty()) {
            res = "/" + stk.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func simplifyPath(path string) string {
    parts := strings.Split(path, "/")
    stk := []string{}
    // 借助栈计算最终的文件夹路径
    for _, part := range parts {
        if part == "" || part == "." {
            continue
        }
        if part == ".." {
            if len(stk) > 0 {
                stk = stk[:len(stk)-1]
            }
            continue
        }
        stk = append(stk, part)
    }
    // 栈中存储的文件夹组成路径
    res := ""
    for _, dir := range stk {
        res += "/" + dir
    }
    if res == "" {
        return "/"
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var simplifyPath = function(path) {
    const parts = path.split("/");
    const stk = [];
    // 借助栈计算最终的文件夹路径
    for (const part of parts) {
        if (part === "" || part === ".") {
            continue;
        }
        if (part === "..") {
            if (stk.length > 0) stk.pop();
            continue;
        }
        stk.push(part);
    }
    // 栈中存储的文件夹组成路径
    let res = "";
    while (stk.length > 0) {
        res = "/" + stk.pop() + res;
    }
    return res === "" ? "/" : res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_simplify-path"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_simplify-path"></div></div>
</details><hr /><br />

</div>
</details>
</div>

