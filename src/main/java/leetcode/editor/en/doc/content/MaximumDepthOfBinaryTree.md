<p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree's <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;" /> 
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 13635, 👎 269<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-tree-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

[我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树问题虽然简单，但是暗含了动态规划和回溯算法等高级算法的思想。

下面提供两种思路的解法代码。

**详细题解**：
  - [二叉树系列算法核心纲领](https://labuladong.online/algo/essential-technique/binary-tree-summary/)

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

// 遍历的思路
class Solution {

    // 记录最大深度
    int res = 0;

    // 记录遍历到的节点的深度
    int depth = 0;

public:
    int maxDepth(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }

        // 前序遍历位置（进入节点）增加深度
        depth++;
        // 遍历到叶子节点时记录最大深度
        if (root->left == nullptr && root->right == nullptr) {
            res = std::max(res, depth);
        }
        traverse(root->left);
        traverse(root->right);

        // 后序遍历位置（离开节点）减少深度
        depth--;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 遍历的思路
class Solution:

    def __init__(self):
        # 记录遍历到的节点的深度
        self.depth = 0
        # 记录最大深度
        self.res = 0

    def maxDepth(self, root: TreeNode) -> int:
        self.traverse(root)
        return self.res

    # 遍历二叉树
    def traverse(self, root: TreeNode):
        if root is None:
            return

        # 前序遍历位置（进入节点）增加深度
        self.depth += 1
        # 遍历到叶子节点时记录最大深度
        if root.left is None and root.right is None:
            self.res = max(self.res, self.depth)
        self.traverse(root.left)
        self.traverse(root.right)

        # 后序遍历位置（离开节点）减少深度
        self.depth -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 遍历的思路
class Solution {

    // 记录遍历到的节点的深度
    int depth = 0;

    // 记录最大深度
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置（进入节点）增加深度
        depth++;
        // 遍历到叶子节点时记录最大深度
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置（离开节点）减少深度
        depth--;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func maxDepth(root *TreeNode) int {
    // 记录遍历到的节点的深度
    depth := 0
    // 记录最大深度
    res := 0
    
    traverse(root, &depth, &res)
    return res
}

// 遍历二叉树
func traverse(root *TreeNode, depth *int, res *int) {
    if root == nil {
        return
    }

    // 前序遍历位置（进入节点）增加深度
    *depth++
    // 遍历到叶子节点时记录最大深度
    if root.Left == nil && root.Right == nil {
        *res = max(*res, *depth)
    }
    traverse(root.Left, depth, res)
    traverse(root.Right, depth, res)

    // 后序遍历位置（离开节点）减少深度
    *depth--
}

// 遍历的思路
func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 遍历的思路
var maxDepth = function(root) {
    // 记录遍历到的节点的深度
    let depth = 0;
    // 记录最大深度
    let res = 0;

    // 遍历二叉树
    var traverse = function(node) {
        if (node === null) {
            return;
        }

        // 前序遍历位置（进入节点）增加深度
        depth++;
        // 遍历到叶子节点时记录最大深度
        if (node.left === null && node.right === null) {
            res = Math.max(res, depth);
        }
        traverse(node.left);
        traverse(node.right);

        // 后序遍历位置（离开节点）减少深度
        depth--;
    };

    traverse(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_mydata-maxdepth1"  category="tutorial" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth1"></div></div>
</details><hr /><br />

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_mydata-maxdepth2"  category="tutorial" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth2"></div></div>
</details><hr /><br />

</div>
</details>
</div>



