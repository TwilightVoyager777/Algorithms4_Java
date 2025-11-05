<p>Given the <code>root</code> of a binary tree, the depth of each node is <strong>the shortest distance to the root</strong>.</p>

<p>Return <em>the smallest subtree</em> such that it contains <strong>all the deepest nodes</strong> in the original tree.</p>

<p>A node is called <strong>the deepest</strong> if it has the largest depth possible among any node in the entire tree.</p>

<p>The <strong>subtree</strong> of a node is a tree consisting of that node, plus the set of all descendants of that node.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/01/sketch1.png" style="width: 600px; height: 510px;" /> 
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4]
<strong>Output:</strong> [2,7,4]
<strong>Explanation:</strong> We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest nodes of the tree.
Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them, so we return it.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> [1]
<strong>Explanation:</strong> The root is the deepest node in the tree.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [0,1,3,null,2]
<strong>Output:</strong> [2]
<strong>Explanation:</strong> The deepest node in the tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree will be in the range <code>[1, 500]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 500</code></li> 
 <li>The values of the nodes in the tree are <strong>unique</strong>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Note:</strong> This question is the same as 1123: <a href="https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/" target="_blank">https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/</a></p>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 2812, 👎 383<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维，而且涉及处理子树，需要用后序遍历。

说到底，这道题就是让你求那些「最深」的叶子节点的最近公共祖先，可以看下前文 [二叉树最近公共祖先](https://labuladong.online/algo/practice-in-action/lowest-common-ancestor-summary/)。

你想想，一个节点需要知道哪些信息，才能确定自己是最深叶子节点的最近公共祖先？

它需要知道自己的左右子树的最大深度：如果左右子树一样深，那么当前节点就是最近公共祖先；如果左右子树不一样深，那么最深叶子节点的最近公共祖先肯定在左右子树上。

所以我们新建一个 `Result` 类，存放左右子树的最大深度及叶子节点的最近公共祖先节点，其余逻辑类似 [✔ ✨104. 二叉树的最大深度](/problems/maximum-depth-of-binary-tree/)。

**详细题解**：
  - [【练习】利用后序位置解题 II](https://labuladong.online/algo/problem-set/binary-tree-post-order-ii/)

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
    struct Result {
        TreeNode* node;
        int depth;

        Result(TreeNode* node, int depth) {
            // 记录最近公共祖先节点 node
            this->node = node;
            // 记录以 node 为根的二叉树最大深度
            this->depth = depth;
        }
    };

public:
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        Result res = maxDepth(root);
        return res.node;
    }

private:
    // 定义：输入一棵二叉树，返回该二叉树的最大深度以及最深叶子节点的最近公共祖先节点
    Result maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return Result(nullptr, 0);
        }
        Result left = maxDepth(root->left);
        Result right = maxDepth(root->right);
        if (left.depth == right.depth) {
            // 当左右子树的最大深度相同时，这个根节点是新的最近公共祖先
            // 以当前 root 节点为根的子树深度是子树深度 + 1
            return Result(root, left.depth + 1);
        }
        // 左右子树的深度不同，则最近公共祖先在 depth 较大的一边
        Result res = left.depth > right.depth ? left : right;
        // 正确维护二叉树的最大深度
        res.depth++;

        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    class Result:
        def __init__(self, node, depth):
            # 记录最近公共祖先节点 node
            self.node = node
            # 记录以 node 为根的二叉树最大深度
            self.depth = depth

    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        res = self.maxDepth(root)
        return res.node

    # 定义：输入一棵二叉树，返回该二叉树的最大深度以及最深叶子节点的最近公共祖先节点
    def maxDepth(self, root: TreeNode) -> 'Solution.Result':
        if root is None:
            return self.Result(None, 0)
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        if left.depth == right.depth:
            # 当左右子树的最大深度相同时，这个根节点是新的最近公共祖先
            # 以当前 root 节点为根的子树深度是子树深度 + 1
            return self.Result(root, left.depth + 1)
        # 左右子树的深度不同，则最近公共祖先在 depth 较大的一边
        res = left if left.depth > right.depth else right
        # 正确维护二叉树的最大深度
        res.depth += 1

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    class Result {
        public TreeNode node;
        public int depth;

        public Result(TreeNode node, int depth) {
            // 记录最近公共祖先节点 node
            this.node = node;
            // 记录以 node 为根的二叉树最大深度
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Result res = maxDepth(root);
        return res.node;
    }

    // 定义：输入一棵二叉树，返回该二叉树的最大深度以及最深叶子节点的最近公共祖先节点
    Result maxDepth(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        Result left = maxDepth(root.left);
        Result right = maxDepth(root.right);
        if (left.depth == right.depth) {
            // 当左右子树的最大深度相同时，这个根节点是新的最近公共祖先
            // 以当前 root 节点为根的子树深度是子树深度 + 1
            return new Result(root, left.depth + 1);
        }
        // 左右子树的深度不同，则最近公共祖先在 depth 较大的一边
        Result res = left.depth > right.depth ? left : right;
        // 正确维护二叉树的最大深度
        res.depth++;

        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type Result struct {
    node  *TreeNode
    depth int
    // 记录最近公共祖先节点 node
    // 记录以 node 为根的二叉树最大深度
}

func subtreeWithAllDeepest(root *TreeNode) *TreeNode {
    res := maxDepth(root)
    return res.node
}

// 定义：输入一棵二叉树，返回该二叉树的最大深度以及最深叶子节点的最近公共祖先节点
func maxDepth(root *TreeNode) Result {
    if root == nil {
        return Result{nil, 0}
    }
    left := maxDepth(root.Left)
    right := maxDepth(root.Right)
    if left.depth == right.depth {
        // 当左右子树的最大深度相同时，这个根节点是新的最近公共祖先
        // 以当前 root 节点为根的子树深度是子树深度 + 1
        return Result{root, left.depth + 1}
    }
    // 左右子树的深度不同，则最近公共祖先在 depth 较大的一边
    res := left
    if right.depth > left.depth {
        res = right
    }
    // 正确维护二叉树的最大深度
    res.depth++

    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var subtreeWithAllDeepest = function(root) {
    class Result {
        constructor(node, depth) {
            // 记录最近公共祖先节点 node
            this.node = node;
            // 记录以 node 为根的二叉树最大深度
            this.depth = depth;
        }
    }

    // 定义：输入一棵二叉树，返回该二叉树的最大深度以及最深叶子节点的最近公共祖先节点
    var maxDepth = function(root) {
        if (root === null) {
            return new Result(null, 0);
        }
        let left = maxDepth(root.left);
        let right = maxDepth(root.right);
        if (left.depth === right.depth) {
            // 当左右子树的最大深度相同时，这个根节点是新的最近公共祖先
            // 以当前 root 节点为根的子树深度是子树深度 + 1
            return new Result(root, left.depth + 1);
        }
        // 左右子树的深度不同，则最近公共祖先在 depth 较大的一边
        let res = left.depth > right.depth ? left : right;
        // 正确维护二叉树的最大深度
        res.depth++;

        return res;
    }

    let res = maxDepth(root);
    return res.node;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_smallest-subtree-with-all-the-deepest-nodes"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_smallest-subtree-with-all-the-deepest-nodes"></div></div>
</details><hr /><br />

</div>
</details>
</div>

