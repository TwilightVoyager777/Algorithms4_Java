<p>You are given the <code>root</code> node of a binary search tree (BST) and a <code>value</code> to insert into the tree. Return <em>the root node of the BST after the insertion</em>. It is <strong>guaranteed</strong> that the new value does not exist in the original BST.</p>

<p><strong>Notice</strong>&nbsp;that there may exist&nbsp;multiple valid ways for the&nbsp;insertion, as long as the tree remains a BST after insertion. You can return <strong>any of them</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/insertbst.jpg" style="width: 752px; height: 221px;" /> 
<pre>
<strong>Input:</strong> root = [4,2,7,1,3], val = 5
<strong>Output:</strong> [4,2,7,1,3,5]
<strong>Explanation:</strong> Another accepted tree is:
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/bst.jpg" style="width: 352px; height: 301px;" />
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [40,20,60,10,30,50,70], val = 25
<strong>Output:</strong> [40,20,60,10,30,50,70,null,null,25]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
<strong>Output:</strong> [4,2,7,1,3,5]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in&nbsp;the tree will be in the range <code>[0,&nbsp;10<sup>4</sup>]</code>.</li> 
 <li><code>-10<sup>8</sup> &lt;= Node.val &lt;= 10<sup>8</sup></code></li> 
 <li>All the values <code>Node.val</code> are <strong>unique</strong>.</li> 
 <li><code>-10<sup>8</sup> &lt;= val &lt;= 10<sup>8</sup></code></li> 
 <li>It's <strong>guaranteed</strong> that <code>val</code> does not exist in the original BST.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Binary Search Tree | Binary Tree</details><br>

<div>👍 6277, 👎 186<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果要递归地插入或者删除二叉树节点，递归函数一定要有返回值，而且返回值要被正确的接收。

插入的过程可以分两部分：

1、寻找正确的插入位置，类似 [✨700. 二叉搜索树中的搜索](/problems/search-in-a-binary-search-tree/)。

2、把元素插进去，这就要把新节点以返回值的方式接到父节点上。

**详细题解**：
  - [二叉搜索树心法（基操篇）](https://labuladong.online/algo/data-structure/bst-part2/)

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

// 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if (root == nullptr) {
            // 找到空位置插入新节点
            return new TreeNode(val);
        }

        // 去右子树找插入位置
        if (root->val < val) {
            root->right = insertIntoBST(root->right, val);
        }
        // 去左子树找插入位置
        if (root->val > val) {
            root->left = insertIntoBST(root->left, val);
        }
        // 返回 root，上层递归会接收返回值作为子节点
        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
class Solution:
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            # 找到空位置插入新节点
            return TreeNode(val)
        # 去右子树找插入位置
        if root.val < val:
            root.right = self.insertIntoBST(root.right, val)
        # 去左子树找插入位置
        if root.val > val:
            root.left = self.insertIntoBST(root.left, val)
        # 返回 root，上层递归会接收返回值作为子节点
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        // BST 中一般不会插入已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
func insertIntoBST(root *TreeNode, val int) *TreeNode {
    if root == nil {
        // 找到空位置插入新节点
        return &TreeNode{Val: val}
    }
    // 去右子树找插入位置
    if root.Val < val {
        root.Right = insertIntoBST(root.Right, val)
    }
    // 去左子树找插入位置
    if root.Val > val {
        root.Left = insertIntoBST(root.Left, val)
    }
    // 返回 root，上层递归会接收返回值作为子节点
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
var insertIntoBST = function(root, val) {
    if (root === null) {
        // 找到空位置插入新节点
        return new TreeNode(val);
    }
    // 去右子树找插入位置
    if (root.val < val) {
        root.right = insertIntoBST(root.right, val);
    }
    // 去左子树找插入位置
    if (root.val > val) {
        root.left = insertIntoBST(root.left, val);
    }
    // 返回 root，上层递归会接收返回值作为子节点
    return root;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_insert-into-a-binary-search-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_insert-into-a-binary-search-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

