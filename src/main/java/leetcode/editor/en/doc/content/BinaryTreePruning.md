<p>Given the <code>root</code> of a binary tree, return <em>the same tree where every subtree (of the given tree) not containing a </em><code>1</code><em> has been removed</em>.</p>

<p>A subtree of a node <code>node</code> is <code>node</code> plus every node that is a descendant of <code>node</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_2.png" style="width: 500px; height: 140px;" /> 
<pre>
<strong>Input:</strong> root = [1,null,0,0,1]
<strong>Output:</strong> [1,null,0,null,1]
<strong>Explanation:</strong> 
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_1.png" style="width: 500px; height: 115px;" /> 
<pre>
<strong>Input:</strong> root = [1,0,1,0,0,0,1]
<strong>Output:</strong> [1,null,1,null,1]
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/05/1028.png" style="width: 500px; height: 134px;" /> 
<pre>
<strong>Input:</strong> root = [1,1,0,1,1,0,1,0]
<strong>Output:</strong> [1,1,0,1,1,null,1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 200]</code>.</li> 
 <li><code>Node.val</code> is either <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 4638, 👎 121<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

建议先做一下 [✔ ✨543. 二叉树的直径](/problems/diameter-of-binary-tree/) 和 [✨687. 最长同值路径](/problems/longest-univalue-path/)，理解后序遍历位置的特殊性。

这道题的难点在于要一直剪枝，直到没有值为 0 的叶子节点为止，只有从后序遍历位置自底向上处理才能获得最高的效率。

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
    // 定义：输入一棵二叉树，返回的二叉树叶子节点都是 1
    TreeNode* pruneTree(TreeNode* root) {
        if (root == nullptr) {
            return nullptr;
        }
        // 二叉树递归框架
        root->left = pruneTree(root->left);
        root->right = pruneTree(root->right);

        // 后序遍历位置，判断自己是否是值为 0 的叶子节点
        if (root->val == 0 && root->left == nullptr && root->right == nullptr) {
            // 返回值会被父节点接收，相当于把自己删掉了
            return nullptr;
        }
        // 如果不是，正常返回
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
    # 定义：输入一棵二叉树，返回的二叉树叶子节点都是 1
    def pruneTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None
        # 二叉树递归框架
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)

        # 后序遍历位置，判断自己是否是值为 0 的叶子节点
        if root.val == 0 and root.left is None and root.right is None:
            # 返回值会被父节点接收，相当于把自己删掉了
            return None
        # 如果不是，正常返回
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：输入一棵二叉树，返回的二叉树叶子节点都是 1
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 二叉树递归框架
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 后序遍历位置，判断自己是否是值为 0 的叶子节点
        if (root.val == 0 && root.left == null && root.right == null) {
            // 返回值会被父节点接收，相当于把自己删掉了
            return null;
        }
        // 如果不是，正常返回
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：输入一棵二叉树，返回的二叉树叶子节点都是 1
func pruneTree(root *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    // 二叉树递归框架
    root.Left = pruneTree(root.Left)
    root.Right = pruneTree(root.Right)

    // 后序遍历位置，判断自己是否是值为 0 的叶子节点
    if root.Val == 0 && root.Left == nil && root.Right == nil {
        // 返回值会被父节点接收，相当于把自己删掉了
        return nil
    }
    // 如果不是，正常返回
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：输入一棵二叉树，返回的二叉树叶子节点都是 1
var pruneTree = function(root) {
    if (root === null) {
        return null;
    }
    // 二叉树递归框架
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);

    // 后序遍历位置，判断自己是否是值为 0 的叶子节点
    if (root.val === 0 && root.left === null && root.right === null) {
        // 返回值会被父节点接收，相当于把自己删掉了
        return null;
    }
    // 如果不是，正常返回
    return root;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_binary-tree-pruning"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-pruning"></div></div>
</details><hr /><br />

</div>
</details>
</div>

