<p>Given the <code>root</code> of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.</p>

<p>As a reminder, a <em>binary search tree</em> is a tree that satisfies these constraints:</p>

<ul> 
 <li>The left subtree of a node contains only nodes with keys <strong>less than</strong> the node's key.</li> 
 <li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node's key.</li> 
 <li>Both the left and right subtrees must also be binary search trees.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/05/02/tree.png" style="width: 500px; height: 341px;" /> 
<pre>
<strong>Input:</strong> root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
<strong>Output:</strong> [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [0,null,1]
<strong>Output:</strong> [1,null,1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
 <li>All the values in the tree are <strong>unique</strong>.</li> 
 <li><code>root</code> is guaranteed to be a valid binary search tree.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Note:</strong> This question is the same as 1038: <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/" target="_blank">https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/</a></p>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Search Tree | Binary Tree</details><br>

<div>👍 5371, 👎 181<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part1/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

维护一个外部累加变量 `sum`，在遍历 BST 的过程中增加 `sum`，同时把 `sum` 赋值给 BST 中的每一个节点，就将 BST 转化成累加树了。

但是注意顺序，正常的中序遍历顺序是先左子树后右子树，这里需要反过来，先右子树后左子树。

**详细题解**：
  - [二叉搜索树心法（特性篇）](https://labuladong.online/algo/data-structure/bst-part1/)

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
    TreeNode* convertBST(TreeNode* root) {
        traverse(root);
        return root;
    }

private:
    // 记录累加和
    int sum = 0;
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->right);
        // 维护累加和
        sum += root->val;
        // 将 BST 转化成累加树
        root->val = sum;
        traverse(root->left);
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
            # 记录累加和
            self.sum = 0
            
        def convertBST(self, root):
            self.traverse(root)
            return root

        def traverse(self, root):
            if root is None:
                return
            self.traverse(root.right)
            # 维护累加和
            self.sum += root.val
            # 将 BST 转化成累加树
            root.val = self.sum
            self.traverse(root.left)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    // 记录累加和
    int sum = 0;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化成累加树
        root.val = sum;
        traverse(root.left);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func convertBST(root *TreeNode) *TreeNode {
    // 记录累加和
    sum := 0
    // define a closure for traverse
	traverse := func(root *TreeNode) {}
	traverse = func(root *TreeNode) {
		if root == nil {
			return
		}
		traverse(root.Right)
		// 维护累加和
		sum += root.Val
		// 将 BST 转化成累加树
		root.Val = sum
		traverse(root.Left)
	}
    traverse(root)
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var convertBST = function(root){
    var sum = 0;

    var traverse = function(root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化成累加树
        root.val = sum;
        traverse(root.left);
    } 

    traverse(root);
    return root;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_convert-bst-to-greater-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_convert-bst-to-greater-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

