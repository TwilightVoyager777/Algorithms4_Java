<p>You are given the <code>root</code> of a <strong>binary tree</strong> with <code>n</code> nodes. Each node is uniquely assigned a value from <code>1</code> to <code>n</code>. You are also given an integer <code>startValue</code> representing the value of the start node <code>s</code>, and a different integer <code>destValue</code> representing the value of the destination node <code>t</code>.</p>

<p>Find the <strong>shortest path</strong> starting from node <code>s</code> and ending at node <code>t</code>. Generate step-by-step directions of such path as a string consisting of only the <strong>uppercase</strong> letters <code>'L'</code>, <code>'R'</code>, and <code>'U'</code>. Each letter indicates a specific direction:</p>

<ul> 
 <li><code>'L'</code> means to go from a node to its <strong>left child</strong> node.</li> 
 <li><code>'R'</code> means to go from a node to its <strong>right child</strong> node.</li> 
 <li><code>'U'</code> means to go from a node to its <strong>parent</strong> node.</li> 
</ul>

<p>Return <em>the step-by-step directions of the <strong>shortest path</strong> from node </em><code>s</code><em> to node</em> <code>t</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/15/eg1.png" style="width: 214px; height: 163px;" /> 
<pre>
<strong>Input:</strong> root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
<strong>Output:</strong> "UURL"
<strong>Explanation:</strong> The shortest path is: 3 → 1 → 5 → 2 → 6.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/15/eg2.png" style="width: 74px; height: 102px;" /> 
<pre>
<strong>Input:</strong> root = [2,1], startValue = 2, destValue = 1
<strong>Output:</strong> "L"
<strong>Explanation:</strong> The shortest path is: 2 → 1.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is <code>n</code>.</li> 
 <li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= Node.val &lt;= n</code></li> 
 <li>All the values in the tree are <strong>unique</strong>.</li> 
 <li><code>1 &lt;= startValue, destValue &lt;= n</code></li> 
 <li><code>startValue != destValue</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 3211, 👎 166<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维模式。

这题的思路比较巧妙，主要分三步：

1、分别记录从根节点到 `startValue` 和 `destValue` 的路径 `startPath` 和 `destPath`。

2、然后去除 `startPath` 和 `destPath` 的公共前缀。

3、最后将 `startPath` 全部变成 `U`，把 `startPath` 和 `destPath` 接在一起，就是题目要求的路径了。

**详细题解**：
  - [【练习】用「遍历」思维解题 III](https://labuladong.online/algo/problem-set/binary-tree-traverse-iii/)

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
using namespace std;

class Solution {
public:
    string getDirections(TreeNode* root, int startValue, int destValue) {
        this->startValue = startValue;
        this->destValue = destValue;
        // 寻找走到 startValue 和 destValue 的方向路径
        traverse(root);
        // 去除两个方向路径的公共前缀
        int p = 0, m = startPath.size(), n = destPath.size();
        while (p < m && p < n && startPath[p] == destPath[p]) {
            p++;
        }
        startPath = startPath.substr(p);
        destPath = destPath.substr(p);
        // 将走向 startValue 的方向路径全部变成 U
        startPath = string(startPath.size(), 'U');
        // 组合 startPath 和 destPath 就得到了答案
        return startPath + destPath;
    }

private:
    string path;
    string startPath, destPath;
    int startValue, destValue;

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        if (root->val == startValue) {
            startPath = path;
        } else if (root->val == destValue) {
            destPath = path;
        }
        // 二叉树遍历框架
        path.push_back('L');
        traverse(root->left);
        path.pop_back();
        path.push_back('R');
        traverse(root->right);
        path.pop_back();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def getDirections(self, root: TreeNode, startValue: int, destValue: int) -> str:
        self.startValue = startValue
        self.destValue = destValue
        # 寻找走到 startValue 和 destValue 的方向路径
        self.traverse(root)
        # 去除两个方向路径的公共前缀
        p = 0
        m = len(self.startPath)
        n = len(self.destPath)
        while p < m and p < n and self.startPath[p] == self.destPath[p]:
            p += 1
        self.startPath = self.startPath[p:]
        self.destPath = self.destPath[p:]
        # 将走向 startValue 的方向路径全部变成 U
        self.startPath = 'U' * len(self.startPath)
        # 组合 startPath 和 destPath 就得到了答案
        return self.startPath + self.destPath

    def __init__(self):
        self.path = ''
        self.startPath = ''
        self.destPath = ''
        self.startValue = 0
        self.destValue = 0

    # 二叉树遍历函数
    def traverse(self, root):
        if root is None:
            return
        if root.val == self.startValue:
            self.startPath = self.path
        elif root.val == self.destValue:
            self.destPath = self.path

        # 二叉树遍历框架
        self.path += 'L'
        self.traverse(root.left)
        self.path = self.path[:-1]

        self.path += 'R'
        self.traverse(root.right)
        self.path = self.path[:-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;
        // 寻找走到 startValue 和 destValue 的方向路径
        traverse(root);
        // 去除两个方向路径的公共前缀
        int p = 0, m = startPath.length(), n = destPath.length();
        while (p < m && p < n
                && startPath.charAt(p) == destPath.charAt(p)) {
            p++;
        }
        startPath = startPath.substring(p);
        destPath = destPath.substring(p);
        // 将走向 startValue 的方向路径全部变成 U
        startPath = "U".repeat(startPath.length());
        // 组合 startPath 和 destPath 就得到了答案
        return startPath + destPath;
    }

    StringBuilder path = new StringBuilder();
    String startPath, destPath;
    int startValue, destValue;

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val == startValue) {
            startPath = path.toString();
        } else if (root.val == destValue) {
            destPath = path.toString();
        }

        // 二叉树遍历框架
        path.append('L');
        traverse(root.left);
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func getDirections(root *TreeNode, startValue int, destValue int) string {
    var startPath, destPath string
    var path []byte

    // 寻找走到 startValue 和 destValue 的方向路径
    traverse(root, startValue, destValue, &path, &startPath, &destPath)

    // 去除两个方向路径的公共前缀
    p, m, n := 0, len(startPath), len(destPath)
    for p < m && p < n && startPath[p] == destPath[p] {
        p++
    }
    startPath = startPath[p:]
    destPath = destPath[p:]

    // 将走向 startValue 的方向路径全部变成 U
    startPath = strings.Repeat("U", len(startPath))

    // 组合 startPath 和 destPath 就得到了答案
    return startPath + destPath
}

// 二叉树遍历函数
func traverse(root *TreeNode, startValue, destValue int, path *[]byte, startPath, destPath *string) {
    if root == nil {
        return
    }
    if root.Val == startValue {
        *startPath = string(*path)
    } else if root.Val == destValue {
        *destPath = string(*path)
    }

    // 二叉树遍历框架
    *path = append(*path, 'L')
    traverse(root.Left, startValue, destValue, path, startPath, destPath)
    *path = (*path)[:len(*path)-1]

    *path = append(*path, 'R')
    traverse(root.Right, startValue, destValue, path, startPath, destPath)
    *path = (*path)[:len(*path)-1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var getDirections = function(root, startValue, destValue) {
    let startPath, destPath;
    let path = [];

    // 二叉树遍历函数
    const traverse = (root) => {
        if (root === null) {
            return;
        }
        if (root.val === startValue) {
            startPath = path.join('');
        } else if (root.val === destValue) {
            destPath = path.join('');
        }

        // 二叉树遍历框架
        path.push('L');
        traverse(root.left);
        path.pop();

        path.push('R');
        traverse(root.right);
        path.pop();
    };

    // 寻找走到 startValue 和 destValue 的方向路径
    traverse(root);

    // 去除两个方向路径的公共前缀
    let p = 0, m = startPath.length, n = destPath.length;
    while (p < m && p < n && startPath[p] === destPath[p]) {
        p++;
    }
    startPath = startPath.substring(p);
    destPath = destPath.substring(p);

    // 将走向 startValue 的方向路径全部变成 U
    startPath = 'U'.repeat(startPath.length);

    // 组合 startPath 和 destPath 就得到了答案
    return startPath + destPath;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_step-by-step-directions-from-a-binary-tree-node-to-another"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_step-by-step-directions-from-a-binary-tree-node-to-another"></div></div>
</details><hr /><br />

</div>
</details>
</div>

