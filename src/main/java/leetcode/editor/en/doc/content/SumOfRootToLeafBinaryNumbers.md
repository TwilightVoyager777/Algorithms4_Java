<p>You are given the <code>root</code> of a binary tree where each node has a value <code>0</code> or <code>1</code>. Each root-to-leaf path represents a binary number starting with the most significant bit.</p>

<ul> 
 <li>For example, if the path is <code>0 -&gt; 1 -&gt; 1 -&gt; 0 -&gt; 1</code>, then this could represent <code>01101</code> in binary, which is <code>13</code>.</li> 
</ul>

<p>For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return <em>the sum of these numbers</em>.</p>

<p>The test cases are generated so that the answer fits in a <strong>32-bits</strong> integer.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/04/04/sum-of-root-to-leaf-binary-numbers.png" style="width: 400px; height: 263px;" /> 
<pre>
<strong>Input:</strong> root = [1,0,1,0,1,0,1]
<strong>Output:</strong> 22
<strong>Explanation: </strong>(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [0]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li> 
 <li><code>Node.val</code> is <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 3428, 👎 193<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

用 `path` 变量维护每一条从根节点到叶子节点的路径形成的二进制数，到了叶子节点之后将这条路径的二进制数累加到 `res` 中即可。

**详细题解**：
  - [【练习】用「遍历」思维解题 I](https://labuladong.online/algo/problem-set/binary-tree-traverse-i/)

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
    int sumRootToLeaf(TreeNode* root) {
        traverse(root);
        return res;
    }

private:
    int path = 0;
    int res = 0;

    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        if (root->left == nullptr && root->right == nullptr) {
            // 叶子节点
            res += path << 1 | root->val;
            return;
        }
        // 前序位置
        path = (path << 1) | root->val;
        traverse(root->left);
        traverse(root->right);
        // 后序位置
        path = path >> 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        self.path = 0
        self.res = 0
        self.traverse(root)
        return self.res

    def traverse(self, root: TreeNode):
        if root is None:
            return
        if root.left is None and root.right is None:
            # 叶子节点
            self.res += self.path << 1 | root.val
            return
        # 前序位置
        self.path = self.path << 1 | root.val
        self.traverse(root.left)
        self.traverse(root.right)
        # 后序位置
        self.path = self.path >> 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    int path = 0;
    int res = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            res += path << 1 | root.val;
            return;
        }
        // 前序位置
        path = path << 1 | root.val;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        path = path >> 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func sumRootToLeaf(root *TreeNode) int {
    var res int
    var path int
    traverse(root, &path, &res)
    return res
}

func traverse(root *TreeNode, path *int, res *int) {
    if root == nil {
        return
    }
    if root.Left == nil && root.Right == nil {
        // 叶子节点
        *res += *path<<1 | root.Val
        return
    }
    // 前序位置
    *path = *path<<1 | root.Val
    traverse(root.Left, path, res)
    traverse(root.Right, path, res)
    // 后序位置
    *path = *path >> 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var sumRootToLeaf = function(root) {
    let res = 0;

    function traverse(root, path) {
        if (root === null) {
            return;
        }
        if (root.left === null && root.right === null) {
            // 叶子节点
            res += (path << 1) | root.val;
            return;
        }
        // 前序位置
        traverse(root.left, (path << 1) | root.val);
        traverse(root.right, (path << 1) | root.val);
        // 后序位置
        // Note: In JavaScript, there is no need to reset path as it's passed by value
    }

    traverse(root, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_sum-of-root-to-leaf-binary-numbers"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_sum-of-root-to-leaf-binary-numbers"></div></div>
</details><hr /><br />

</div>
</details>
</div>

