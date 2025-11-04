<p>Given a binary tree <code>root</code> and an integer <code>target</code>, delete all the <strong>leaf nodes</strong> with value <code>target</code>.</p>

<p>Note that once you delete a leaf node with value <code>target</code><strong>, </strong>if its parent node becomes a leaf node and has the value <code>target</code>, it should also be deleted (you need to continue doing that until you cannot).</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/01/09/sample_1_1684.png" style="width: 500px; height: 112px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [1,2,3,2,null,2,4], target = 2
<strong>Output:</strong> [1,null,3,null,4]
<strong>Explanation:</strong> Leaf nodes in green with value (target = 2) are removed (Picture in left). 
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/01/09/sample_2_1684.png" style="width: 400px; height: 154px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [1,3,3,3,2], target = 3
<strong>Output:</strong> [1,3,null,null,2]
</pre>

<p><strong class="example">Example 3:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/01/15/sample_3_1684.png" style="width: 500px; height: 166px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [1,2,null,2,null,2], target = 2
<strong>Output:</strong> [1]
<strong>Explanation:</strong> Leaf nodes in green with value (target = 2) are removed at each step.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 3000]</code>.</li> 
 <li><code>1 &lt;= Node.val, target &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 2859, 👎 56<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

删除指定值的叶子节点，其实就是遍历所有的叶子节点，然后判断是否需要删除；删除叶子节点也很简单，return null 让父节点接收即可。

**难点在于他这个删除操作是循环的，一直删到叶子结点不存在 `target` 为止**。这里要用到前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过的后序位置的妙用了：

一个节点要在后序位置接收左右子树的返回值，才能知道自己的叶子节点是否都被删掉了，以此判断自己是不是变成了叶子节点。

这个考点在 [✨814. 二叉树剪枝](/problems/binary-tree-pruning/) 中也有体现，没做过的读者建议去做一下，解法的关键点在于利用后序遍历特点，在后序遍历位置每个节点可以直到自己是否需要被删除。

**详细题解**：
  - [【练习】利用后序位置解题 I](https://labuladong.online/algo/problem-set/binary-tree-post-order-i/)

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
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        if (root == nullptr) return nullptr;
        // 二叉树递归框架
        // 如果左右子节点需要被删除，先递归删除它们
        root->left = removeLeafNodes(root->left, target);
        root->right = removeLeafNodes(root->right, target);
        // 后序遍历位置，此时节点 root 直到自己是否需要被删除
        if (root->val == target && root->left == nullptr && root->right == nullptr) {
            return nullptr;
        }
        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        if root is None:
            return None
        # 二叉树递归框架
        # 如果左右子节点需要被删除，先递归删除它们
        root.left = self.removeLeafNodes(root.left, target)
        root.right = self.removeLeafNodes(root.right, target)
        # 后序遍历位置，此时节点 root 直到自己是否需要被删除
        if root.val == target and root.left is None and root.right is None:
            return None
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        // 二叉树递归框架
        // 如果左右子节点需要被删除，先递归删除它们
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        // 后序遍历位置，此时节点 root 直到自己是否需要被删除
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func removeLeafNodes(root *TreeNode, target int) *TreeNode {
    if root == nil {
        return nil
    }
    // 二叉树递归框架
    // 如果左右子节点需要被删除，先递归删除它们
    root.Left = removeLeafNodes(root.Left, target)
    root.Right = removeLeafNodes(root.Right, target)
    // 后序遍历位置，此时节点 root 直到自己是否需要被删除
    if root.Val == target && root.Left == nil && root.Right == nil {
        return nil
    }
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var removeLeafNodes = function(root, target) {
    if (root === null) return null;
    // 二叉树递归框架
    // 如果左右子节点需要被删除，先递归删除它们
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    // 后序遍历位置，此时节点 root 直到自己是否需要被删除
    if (root.val === target && root.left === null && root.right === null) {
        return null;
    }
    return root;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_delete-leaves-with-a-given-value"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_delete-leaves-with-a-given-value"></div></div>
</details><hr /><br />

</div>
</details>
</div>

