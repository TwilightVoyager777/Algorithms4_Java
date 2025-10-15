<p>Given the <code>root</code> of a binary tree, <em>check whether it is a mirror of itself</em> (i.e., symmetric around its center).</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg" style="width: 354px; height: 291px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,2,3,4,4,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg" style="width: 308px; height: 258px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,2,null,3,null,3]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you solve it both recursively and iteratively?

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 16469, 👎 433<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维模式。

这道题有点像 [✨100.相同的树](/problems/same-tree/)，你可以对比一下两道题的代码，**只不过本题不是让你比较两棵树是否相同，而是让你比较两棵子树是否对称**。

那么分解问题的思路就很明显了，判断两棵树是否镜像对称，只要判断两棵子树都是镜像对称的就行了。

如果用迭代的方式，可以使用 BFS 层序遍历，把每一层的节点求出来，然后用左右双指针判断每一层是否是对称的。

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
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr) return true;
        // 检查两棵子树是否对称
        return check(root->left, root->right);
    }

    // 定义：判断输入的两棵树是否是镜像对称的
    bool check(TreeNode* left, TreeNode* right) {
        if (left == nullptr || right == nullptr) {
            return left == right;
        }
        // 两个根节点需要相同
        if (left->val != right->val) return false;
        // 左右子树也需要镜像对称
        return check(left->right, right->left) && check(left->left, right->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        # 检查两棵子树是否对称
        return self.check(root.left, root.right)

    # 定义：判断输入的两棵树是否是镜像对称的
    def check(self, left: TreeNode, right: TreeNode) -> bool:
        if left is None or right is None:
            return left == right
        # 两个根节点需要相同
        if left.val != right.val:
            return False
        # 左右子树也需要镜像对称
        return self.check(left.right, right.left) and self.check(left.left, right.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 检查两棵子树是否对称
        return check(root.left, root.right);
    }

    // 定义：判断输入的两棵树是否是镜像对称的
    boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        // 两个根节点需要相同
        if (left.val != right.val) return false;
        // 左右子树也需要镜像对称
        return check(left.right, right.left) && check(left.left, right.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isSymmetric(root *TreeNode) bool {
    if root == nil {
        return true
    }
    // 检查两棵子树是否对称
    return check(root.Left, root.Right)
}

// 定义：判断输入的两棵树是否是镜像对称的
func check(left, right *TreeNode) bool {
    if left == nil || right == nil {
        return left == right
    }
    // 两个根节点需要相同
    if left.Val != right.Val {
        return false
    }
    // 左右子树也需要镜像对称
    return check(left.Right, right.Left) && check(left.Left, right.Right)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isSymmetric = function(root) {
    if (root === null) return true;
    // 检查两棵子树是否对称
    return check(root.left, root.right);

    // 定义：判断输入的两棵树是否是镜像对称的
    function check(left, right) {
        if (left === null || right === null) {
            return left === right;
        }
        // 两个根节点需要相同
        if (left.val !== right.val) return false;
        // 左右子树也需要镜像对称
        return check(left.right, right.left) && check(left.left, right.right);
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_symmetric-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_symmetric-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

