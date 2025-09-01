<p>Given the <code>root</code> of a binary tree, return <em>the length of the <strong>diameter</strong> of the tree</em>.</p>

<p>The <strong>diameter</strong> of a binary tree is the <strong>length</strong> of the longest path between any two nodes in a tree. This path may or may not pass through the <code>root</code>.</p>

<p>The <strong>length</strong> of a path between two nodes is represented by the number of edges between them.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,5]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 3 is the length of the path [4,2,1,3] or [5,2,1,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 15048, 👎 1188<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-tree-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

所谓二叉树的直径，就是左右子树的最大深度之和，那么直接的想法是对每个节点计算左右子树的最大高度，得出每个节点的直径，从而得出最大的那个直径。

但是由于 `maxDepth` 也是递归函数，所以上述方式时间复杂度较高。

这题类似 [$ ✨366. 寻找二叉树的叶子节点](/problems/find-leaves-of-binary-tree/)，需要灵活运用二叉树的后序遍历，在 `maxDepth` 的后序遍历位置顺便计算最大直径。

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

class Solution {
    int maxDiameter = 0;

public:
    int diameterOfBinaryTree(TreeNode* root) {
        maxDepth(root);
        return maxDiameter;
    }

private:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // 后序遍历位置顺便计算最大直径
        maxDiameter = std::max(maxDiameter, leftMax + rightMax);
        return 1 + std::max(leftMax, rightMax);
    }
};

// 这是一种简单粗暴，但是效率不高的解法
class BadSolution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        // 计算出左右子树的最大高度
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // root 这个节点的直径
        int res = leftMax + rightMax;
        // 递归遍历 root.left 和 root.right 两个子树
        return std::max(res,
                std::max(diameterOfBinaryTree(root->left),
                        diameterOfBinaryTree(root->right)));
    }

private:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        return 1 + std::max(leftMax, rightMax);
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
        self.maxDiameter = 0

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.maxDepth(root)
        return self.maxDiameter

    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 后序遍历位置顺便计算最大直径
        self.maxDiameter = max(self.maxDiameter, leftMax + rightMax)
        return 1 + max(leftMax, rightMax)

# 这是一种简单粗暴，但是效率不高的解法
class BadSolution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        # 计算出左右子树的最大高度
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # root 这个节点的直径
        res = leftMax + rightMax
        # 递归遍历 root.left 和 root.right 两个子树
        return max(res,
                   max(self.diameterOfBinaryTree(root.left),
                       self.diameterOfBinaryTree(root.right)))

    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        return 1 + max(leftMax, rightMax)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序遍历位置顺便计算最大直径
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}

// 这是一种简单粗暴，但是效率不高的解法
class BadSolution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算出左右子树的最大高度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // root 这个节点的直径
        int res = leftMax + rightMax;
        // 递归遍历 root.left 和 root.right 两个子树
        return Math.max(res,
                Math.max(diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right)));
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func diameterOfBinaryTree(root *TreeNode) int {
    var maxDiameter int
    maxDepth(root, &maxDiameter)
    return maxDiameter
}

func maxDepth(root *TreeNode, maxDiameter *int) int {
    if root == nil {
        return 0
    }
    leftMax := maxDepth(root.Left, maxDiameter)
    rightMax := maxDepth(root.Right, maxDiameter)
    // 后序遍历位置顺便计算最大直径
    *maxDiameter = max(*maxDiameter, leftMax+rightMax)
    return 1 + max(leftMax, rightMax)
}

// 这是一种简单粗暴，但是效率不高的解法
func badDiameterOfBinaryTree(root *TreeNode) int {
    if root == nil {
        return 0
    }
    // 计算出左右子树的最大高度
    leftMax := badMaxDepth(root.Left)
    rightMax := badMaxDepth(root.Right)
    // root 这个节点的直径
    res := leftMax + rightMax
    // 递归遍历 root.left 和 root.right 两个子树
    return max(res, max(badDiameterOfBinaryTree(root.Left), badDiameterOfBinaryTree(root.Right)))
}

func badMaxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    leftMax := badMaxDepth(root.Left)
    rightMax := badMaxDepth(root.Right)
    return 1 + max(leftMax, rightMax)
}

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

var diameterOfBinaryTree = function(root) {
    let maxDiameter = 0;

    function maxDepth(root) {
        if (root === null) {
            return 0;
        }
        let leftMax = maxDepth(root.left);
        let rightMax = maxDepth(root.right);
        // 后序遍历位置顺便计算最大直径
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }

    maxDepth(root);
    return maxDiameter;
};

// 这是一种简单粗暴，但是效率不高的解法
var badDiameterOfBinaryTree = function(root) {
    if (root === null) {
        return 0;
    }
    // 计算出左右子树的最大高度
    let leftMax = maxDepth(root.left);
    let rightMax = maxDepth(root.right);
    // root 这个节点的直径
    let res = leftMax + rightMax;
    // 递归遍历 root.left 和 root.right 两个子树
    return Math.max(res,
        Math.max(diameterOfBinaryTree(root.left),
            diameterOfBinaryTree(root.right)));

    function maxDepth(root) {
        if (root === null) {
            return 0;
        }
        let leftMax = maxDepth(root.left);
        let rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_mydata-diameter-of-binary-tree"  category="tutorial" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-diameter-of-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

