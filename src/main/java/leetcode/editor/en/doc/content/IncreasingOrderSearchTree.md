<p>Given the <code>root</code> of a binary search tree, rearrange the tree in <strong>in-order</strong> so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg" style="width: 600px; height: 350px;" /> 
<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
<strong>Output:</strong> [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex2.jpg" style="width: 300px; height: 114px;" /> 
<pre>
<strong>Input:</strong> root = [5,1,7]
<strong>Output:</strong> [1,null,5,null,7]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the given tree will be in the range <code>[1, 100]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Stack | Tree | Depth-First Search | Binary Search Tree | Binary Tree</details><br>

<div>👍 4456, 👎 683<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题可以同时用到两种思维模式。

「遍历」的话很简单，你对 BST 做中序遍历，其结果就是有序的，重新构造出题目要求的这个类似链表的二叉树即可。

「分解问题」的思路也不难，你只要做过 [✔ ✨114. 二叉树展开为链表](/problems/flatten-binary-tree-to-linked-list/) 这道题，稍微改下解法就可以解决这道题了，明确 `increasingBST` 的定义，然后利用这个定义进行操作即可。

这里我给出分解问题的解法思路。

**详细题解**：
  - [【练习】同时运用两种思维解题](https://labuladong.online/algo/problem-set/binary-tree-combine-two-view/)

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
    // 输入一棵 BST，返回一个有序「链表」
    TreeNode* increasingBST(TreeNode* root) {
        if (root == nullptr) {
            return nullptr;
        }
        // 先把左右子树拉平
        TreeNode* left = increasingBST(root->left);
        root->left = nullptr;
        TreeNode* right = increasingBST(root->right);
        root->right = right;
        // 左子树为空的话，就不用处理了
        if (left == nullptr) {
            return root;
        }
        // 左子树非空，需要把根节点和右子树接到左子树末尾
        TreeNode* p = left;
        while (p->right != nullptr) {
            p = p->right;
        }
        p->right = root;

        return left;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 输入一棵 BST，返回一个有序「链表」
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None
        # 先把左右子树拉平
        left = self.increasingBST(root.left)
        root.left = None
        right = self.increasingBST(root.right)
        root.right = right
        # 左子树为空的话，就不用处理了
        if left is None:
            return root
        # 左子树非空，需要把根节点和右子树接到左子树末尾
        p = left
        while p is not None and p.right is not None:
            p = p.right
        p.right = root

        return left
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 输入一棵 BST，返回一个有序「链表」
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先把左右子树拉平
        TreeNode left = increasingBST(root.left);
        root.left = null;
        TreeNode right = increasingBST(root.right);
        root.right = right;
        // 左子树为空的话，就不用处理了
        if (left == null) {
            return root;
        }
        // 左子树非空，需要把根节点和右子树接到左子树末尾
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        p.right = root;

        return left;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 输入一棵 BST，返回一个有序「链表」
func increasingBST(root *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    // 先把左右子树拉平
    left := increasingBST(root.Left)
    root.Left = nil
    right := increasingBST(root.Right)
    root.Right = right
    // 左子树为空的话，就不用处理了
    if left == nil {
        return root
    }
    // 左子树非空，需要把根节点和右子树接到左子树末尾
    p := left
    for p != nil && p.Right != nil {
        p = p.Right
    }
    p.Right = root

    return left
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 输入一棵 BST，返回一个有序「链表」
var increasingBST = function(root) {
    if (root === null) {
        return null;
    }
    // 先把左右子树拉平
    let left = increasingBST(root.left);
    root.left = null;
    let right = increasingBST(root.right);
    root.right = right;
    // 左子树为空的话，就不用处理了
    if (left === null) {
        return root;
    }
    // 左子树非空，需要把根节点和右子树接到左子树末尾
    let p = left;
    while (p !== null && p.right !== null) {
        p = p.right;
    }
    p.right = root;

    return left;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_increasing-order-search-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_increasing-order-search-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

