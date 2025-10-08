<p>Given the <code>root</code> of a binary tree with unique values and the values of two different nodes of the tree <code>x</code> and <code>y</code>, return <code>true</code> <em>if the nodes corresponding to the values </em><code>x</code><em> and </em><code>y</code><em> in the tree are <strong>cousins</strong>, or </em><code>false</code><em> otherwise.</em></p>

<p>Two nodes of a binary tree are <strong>cousins</strong> if they have the same depth with different parents.</p>

<p>Note that in a binary tree, the root node is at the depth <code>0</code>, and children of each depth <code>k</code> node are at the depth <code>k + 1</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/12/q1248-01.png" style="width: 304px; height: 270px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4], x = 4, y = 3
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/12/q1248-02.png" style="width: 334px; height: 266px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,null,4,null,5], x = 5, y = 4
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/13/q1248-03.png" style="width: 267px; height: 258px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,null,4], x = 2, y = 3
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[2, 100]</code>.</li> 
 <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
 <li>Each node has a <strong>unique</strong> value.</li> 
 <li><code>x != y</code></li> 
 <li><code>x</code> and <code>y</code> are exist in the tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 4272, 👎 229<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

遍历找到 x，y 的深度和父节点，对比即可。

**详细题解**：
  - [【练习】用「遍历」思维解题 II](https://labuladong.online/algo/problem-set/binary-tree-traverse-ii/)

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

class Solution {
public:
    TreeNode* parentX = nullptr;
    TreeNode* parentY = nullptr;
    int depthX = 0, depthY = 0;
    int x, y;

    bool isCousins(TreeNode* root, int x, int y) {
        this->x = x;
        this->y = y;
        traverse(root, 0, nullptr);
        if (depthX == depthY && parentX != parentY) {
            // 判断 x，y 是否是表兄弟节点
            return true;
        }
        return false;
    }

    void traverse(TreeNode* root, int depth, TreeNode* parent) {
        if (root == nullptr) {
            return;
        }
        if (root->val == x) {
            // 找到 x，记录它的深度和父节点
            parentX = parent;
            depthX = depth;
        }
        if (root->val == y) {
            // 找到 y，记录它的深度和父节点
            parentY = parent;
            depthY = depth;
        }
        traverse(root->left, depth + 1, root);
        traverse(root->right, depth + 1, root);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def __init__(self):
        self.parentX = None
        self.parentY = None
        self.depthX = 0
        self.depthY = 0
        self.x = 0
        self.y = 0

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x = x
        self.y = y
        self.traverse(root, 0, None)
        if self.depthX == self.depthY and self.parentX != self.parentY:
            # 判断 x，y 是否是表兄弟节点
            return True
        return False

    def traverse(self, root: TreeNode, depth: int, parent: TreeNode) -> None:
        if root is None:
            return
        if root.val == self.x:
            # 找到 x，记录它的深度和父节点
            self.parentX = parent
            self.depthX = depth
        if root.val == self.y:
            # 找到 y，记录它的深度和父节点
            self.parentY = parent
            self.depthY = depth
        self.traverse(root.left, depth + 1, root)
        self.traverse(root.right, depth + 1, root)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    TreeNode parentX = null;
    TreeNode parentY = null;
    int depthX = 0, depthY = 0;
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        traverse(root, 0, null);
        if (depthX == depthY && parentX != parentY) {
            // 判断 x，y 是否是表兄弟节点
            return true;
        }
        return false;
    }

    public void traverse(TreeNode root, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            // 找到 x，记录它的深度和父节点
            parentX = parent;
            depthX = depth;
        }
        if (root.val == y) {
            // 找到 y，记录它的深度和父节点
            parentY = parent;
            depthY = depth;
        }
        traverse(root.left, depth + 1, root);
        traverse(root.right, depth + 1, root);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isCousins(root *TreeNode, x int, y int) bool {
    var parentX, parentY *TreeNode
    var depthX, depthY int
    traverse(root, 0, nil, x, y, &parentX, &parentY, &depthX, &depthY)
    if depthX == depthY && parentX != parentY {
        // 判断 x，y 是否是表兄弟节点
        return true
    }
    return false
}

func traverse(root *TreeNode, depth int, parent *TreeNode, x int, y int, parentX, parentY **TreeNode, depthX, depthY *int) {
    if root == nil {
        return
    }
    if root.Val == x {
        // 找到 x，记录它的深度和父节点
        *parentX = parent
        *depthX = depth
    }
    if root.Val == y {
        // 找到 y，记录它的深度和父节点
        *parentY = parent
        *depthY = depth
    }
    traverse(root.Left, depth+1, root, x, y, parentX, parentY, depthX, depthY)
    traverse(root.Right, depth+1, root, x, y, parentX, parentY, depthX, depthY)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isCousins = function(root, x, y) {
    let parentX = null, parentY = null;
    let depthX = 0, depthY = 0;

    function traverse(root, depth, parent) {
        if (root === null) {
            return;
        }
        if (root.val === x) {
            // 找到 x，记录它的深度和父节点
            parentX = parent;
            depthX = depth;
        }
        if (root.val === y) {
            // 找到 y，记录它的深度和父节点
            parentY = parent;
            depthY = depth;
        }
        traverse(root.left, depth + 1, root);
        traverse(root.right, depth + 1, root);
    }

    traverse(root, 0, null);
    // 判断 x，y 是否是表兄弟节点
    return depthX === depthY && parentX !== parentY;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_cousins-in-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_cousins-in-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

