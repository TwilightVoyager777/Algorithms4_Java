<p>For a binary tree <strong>T</strong>, we can define a <strong>flip operation</strong> as follows: choose any node, and swap the left and right child subtrees.</p>

<p>A binary tree <strong>X</strong>&nbsp;is <em>flip equivalent</em> to a binary tree <strong>Y</strong> if and only if we can make <strong>X</strong> equal to <strong>Y</strong> after some number of flip operations.</p>

<p>Given the roots of two binary trees <code>root1</code> and <code>root2</code>, return <code>true</code> if the two trees are flip equivalent or <code>false</code> otherwise.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="Flipped Trees Diagram" src="https://assets.leetcode.com/uploads/2018/11/29/tree_ex.png" style="width: 500px; height: 220px;" /> 
<pre>
<strong>Input:</strong> root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
<strong>Output:</strong> true
<strong>Explanation: </strong>We flipped at nodes with values 1, 3, and 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root1 = [], root2 = []
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root1 = [], root2 = [1]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in each tree is in the range <code>[0, 100]</code>.</li> 
 <li>Each tree will have <strong>unique node values</strong> in the range <code>[0, 99]</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 2868, 👎 121<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。

如何分解这个问题呢？原问题是两棵二叉树是否是翻转等价的，只要两棵树的根节点能够匹配，那我们就可以去考察这两个根节点的左右子树（共四棵）是否是翻转等价的。

对子树把翻转和不翻转两种情况全都穷举一遍，只要有一种情况能够匹配，就说明整棵树是翻转等价的，具体实现见代码。

**详细题解**：
  - [【练习】用「分解问题」思维解题 II](https://labuladong.online/algo/problem-set/binary-tree-divide-ii/)

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
    // 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
    bool flipEquiv(TreeNode* root1, TreeNode* root2) {
        // 判断 root1 和 root2 两个节点是否能够匹配
        if (root1 == nullptr && root2 == nullptr) {
            return true;
        }
        if (root1 == nullptr || root2 == nullptr) {
            return false;
        }
        if (root1->val != root2->val) {
            return false;
        }
        // 根据函数定义，判断子树是否能够匹配
        // 不翻转、翻转两种情况满足一种即可算是匹配
        return (
                // 不翻转子树
                flipEquiv(root1->left, root2->left) && flipEquiv(root1->right, root2->right)
        ) || (
                // 反转子树
                flipEquiv(root1->left, root2->right) && flipEquiv(root1->right, root2->left)
        );
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
    def flipEquiv(self, root1: TreeNode, root2: TreeNode) -> bool:
        # 判断 root1 和 root2 两个节点是否能够匹配
        if root1 is None and root2 is None:
            return True
        if root1 is None or root2 is None:
            return False
        if root1.val != root2.val:
            return False
        # 根据函数定义，判断子树是否能够匹配
        # 不翻转、翻转两种情况满足一种即可算是匹配
        return (
                # 不翻转子树
                self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right)
        ) or (
                # 反转子树
                self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left)
        )
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // 判断 root1 和 root2 两个节点是否能够匹配
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        // 根据函数定义，判断子树是否能够匹配
        // 不翻转、翻转两种情况满足一种即可算是匹配
        return (
                // 不翻转子树
                flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
        ) || (
                // 反转子树
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
        );
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
func flipEquiv(root1 *TreeNode, root2 *TreeNode) bool {
    // 判断 root1 和 root2 两个节点是否能够匹配
    if root1 == nil && root2 == nil {
        return true
    }
    if root1 == nil || root2 == nil {
        return false
    }
    if root1.Val != root2.Val {
        return false
    }
    // 根据函数定义，判断子树是否能够匹配
    // 不翻转、翻转两种情况满足一种即可算是匹配
    // 不翻转子树
    // 反转子树
    return (flipEquiv(root1.Left, root2.Left) && flipEquiv(root1.Right, root2.Right)) ||
           (flipEquiv(root1.Left, root2.Right) && flipEquiv(root1.Right, root2.Left))
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var flipEquiv = function(root1, root2) {
    // 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
    // 判断 root1 和 root2 两个节点是否能够匹配
    if (root1 == null && root2 == null) {
        return true;
    }
    if (root1 == null || root2 == null) {
        return false;
    }
    if (root1.val != root2.val) {
        return false;
    }
    // 根据函数定义，判断子树是否能够匹配
    // 不翻转、翻转两种情况满足一种即可算是匹配
    return (
            // 不翻转子树
            flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
    ) || (
            // 反转子树
            flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
    );
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_flip-equivalent-binary-trees"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_flip-equivalent-binary-trees"></div></div>
</details><hr /><br />

</div>
</details>
</div>

