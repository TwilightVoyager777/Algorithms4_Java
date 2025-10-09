<p>Given the <code>root</code> of a binary tree, return the leftmost value in the last row of the tree.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/14/tree1.jpg" style="width: 302px; height: 182px;" /> 
<pre>
<strong>Input:</strong> root = [2,1,3]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/14/tree2.jpg" style="width: 432px; height: 421px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,null,5,6,null,null,7]
<strong>Output:</strong> 7
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 3948, 👎 300<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

二叉树递归框架代码是先递归左子树，后递归右子树，所以到最大深度时第一次遇到的节点就是左下角的节点。

当然，这题也可以用 BFS 层序遍历来做，留给你思考吧。

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

class Solution {
    // 记录二叉树的最大深度
    int maxDepth = 0;
    // 记录 traverse 递归遍历到的深度
    int depth = 0;
    TreeNode* res = nullptr;

public:
    int findBottomLeftValue(TreeNode* root) {
        traverse(root);
        return res->val;
    }

private:
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        // 前序遍历位置
        depth++;
        if (depth > maxDepth) {
            // 到最大深度时第一次遇到的节点就是左下角的节点
            maxDepth = depth;
            res = root;
        }
        traverse(root->left);
        traverse(root->right);
        // 后序遍历位置
        depth--;
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
        # 记录二叉树的最大深度
        self.maxDepth = 0
        # 记录 traverse 递归遍历到的深度
        self.depth = 0
        self.res = None

    def findBottomLeftValue(self, root: TreeNode) -> int:
        self.traverse(root)
        return self.res.val

    def traverse(self, root: TreeNode):
        if root is None:
            return
        # 前序遍历位置
        self.depth += 1
        if self.depth > self.maxDepth:
            # 到最大深度时第一次遇到的节点就是左下角的节点
            self.maxDepth = self.depth
            self.res = root
        self.traverse(root.left)
        self.traverse(root.right)
        # 后序遍历位置
        self.depth -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录二叉树的最大深度
    int maxDepth = 0;
    // 记录 traverse 递归遍历到的深度
    int depth = 0;
    TreeNode res = null;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res.val;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        depth++;
        if (depth > maxDepth) {
            // 到最大深度时第一次遇到的节点就是左下角的节点
            maxDepth = depth;
            res = root;
        }
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func findBottomLeftValue(root *TreeNode) int {
    // 记录二叉树的最大深度
    var maxDepth int
    // 记录 traverse 递归遍历到的深度
    var depth int
    var res *TreeNode

    traverse(root, &depth, &maxDepth, &res)
    return res.Val
}

// 二叉树遍历函数
func traverse(root *TreeNode, depth *int, maxDepth *int, res **TreeNode) {
    if root == nil {
        return
    }
    // 前序遍历位置
    *depth++
    if *depth > *maxDepth {
        // 到最大深度时第一次遇到的节点就是左下角的节点
        *maxDepth = *depth
        *res = root
    }
    traverse(root.Left, depth, maxDepth, res)
    traverse(root.Right, depth, maxDepth, res)
    // 后序遍历位置
    *depth--
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var findBottomLeftValue = function(root) {
    // 记录二叉树的最大深度
    let maxDepth = 0;
    // 记录 traverse 递归遍历到的深度
    let depth = 0;
    let res = null;

    function traverse(root) {
        if (root === null) {
            return;
        }
        // 前序遍历位置
        depth++;
        if (depth > maxDepth) {
            // 到最大深度时第一次遇到的节点就是左下角的节点
            maxDepth = depth;
            res = root;
        }
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }

    traverse(root);
    return res.val;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_find-bottom-left-tree-value"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-bottom-left-tree-value"></div></div>
</details><hr /><br />

</div>
</details>
</div>

