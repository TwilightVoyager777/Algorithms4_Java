<p>You are given two binary trees <code>root1</code> and <code>root2</code>.</p>

<p>Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.</p>

<p>Return <em>the merged tree</em>.</p>

<p><strong>Note:</strong> The merging process must start from the root nodes of both trees.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/merge.jpg" style="width: 600px; height: 163px;" /> 
<pre>
<strong>Input:</strong> root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
<strong>Output:</strong> [3,4,5,5,4,null,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root1 = [1], root2 = [1,2]
<strong>Output:</strong> [2,2]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in both trees is in the range <code>[0, 2000]</code>.</li> 
 <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 9014, 👎 317<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题可以同时用到两种思维模式。

虽然输入的是两棵树的根节点，但它们的操作是同步的，所以可以看做是在遍历 `root1` 这一棵二叉树，顺便把 `root2` 的节点合并过来。下面我给出两种思维模式的解法代码，具体看注释吧。

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
    // 分解问题的思维模式
    // 定义：输入两棵树的根节点，返回合并后的树的根节点
public:
    TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
        // 如果一棵树非空，那么合并后就是另一棵树
        if (root1 == nullptr) {
            return root2;
        }
        if (root2 == nullptr) {
            return root1;
        }
        // 两棵树都有的节点，叠加节点值
        root1->val += root2->val;
        // 利用函数定义，子树合并后接到
        root1->left = mergeTrees(root1->left, root2->left);
        root1->right = mergeTrees(root1->right, root2->right);

        return root1;
    }
};

class Solution2 {
    // 遍历的思维模式
public:
    TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
        if (root1 == nullptr) {
            return root2;
        }
        // 遍历 root1，顺便把 root2 的节点合并过来
        traverse(root1, root2);
        return root1;
    }

    void traverse(TreeNode* root1, TreeNode* root2) {
        if (root1 == nullptr || root2 == nullptr) {
            return;
        }

        if (root1 != nullptr && root2 != nullptr) {
            // 两棵树都有的节点，叠加节点值
            root1->val += root2->val;
        }

        // 如果 root1 没有子树而 root2 有，那么就把 root2 的子树接到 root1 上
        // 注意接完之后把 root2 的子树置为 null，免得错误计算节点累加值
        if (root1->left == nullptr && root2->left != nullptr) {
            root1->left = root2->left;
            root2->left = nullptr;
        }
        if (root1->right == nullptr && root2->right != nullptr) {
            root1->right = root2->right;
            root2->right = nullptr;
        }

        // 递归遍历左右子节点，root2 的节点也跟着同步移动
        traverse(root1->left, root2->left);
        traverse(root1->right, root2->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 分解问题的思维模式
    # 定义：输入两棵树的根节点，返回合并后的树的根节点
    def mergeTrees(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        # 如果一棵树非空，那么合并后就是另一棵树
        if root1 is None:
            return root2
        if root2 is None:
            return root1
        # 两棵树都有的节点，叠加节点值
        root1.val += root2.val
        # 利用函数定义，子树合并后接到
        root1.left = self.mergeTrees(root1.left, root2.left)
        root1.right = self.mergeTrees(root1.right, root2.right)
        return root1


class Solution2:

    # 遍历的思维模式
    def mergeTrees(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        if root1 is None:
            return root2
        # 遍历 root1，顺便把 root2 的节点合并过来
        self.traverse(root1, root2)
        return root1

    def traverse(self, root1: TreeNode, root2: TreeNode):
        if root1 is None or root2 is None:
            return
        if root1 is not None and root2 is not None:
            # 两棵树都有的节点，叠加节点值
            root1.val += root2.val
        # 如果 root1 没有子树而 root2 有，那么就把 root2 的子树接到 root1 上
        # 注意接完之后把 root2 的子树置为 null，免得错误计算节点累加值
        if root1.left is None and root2.left is not None:
            root1.left = root2.left
            root2.left = None
        if root1.right is None and root2.right is not None:
            root1.right = root2.right
            root2.right = None
        # 递归遍历左右子节点，root2 的节点也跟着同步移动
        self.traverse(root1.left, root2.left)
        self.traverse(root1.right, root2.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 分解问题的思维模式
    // 定义：输入两棵树的根节点，返回合并后的树的根节点
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果一棵树非空，那么合并后就是另一棵树
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 两棵树都有的节点，叠加节点值
        root1.val += root2.val;
        // 利用函数定义，子树合并后接到
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}

class Solution2 {
    
    // 遍历的思维模式
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        // 遍历 root1，顺便把 root2 的节点合并过来
        traverse(root1, root2);
        return root1;
    }

    void traverse(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return;
        }

        if (root1 != null && root2 != null) {
            // 两棵树都有的节点，叠加节点值
            root1.val += root2.val;
        }

        // 如果 root1 没有子树而 root2 有，那么就把 root2 的子树接到 root1 上
        // 注意接完之后把 root2 的子树置为 null，免得错误计算节点累加值
        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
            root2.left = null;
        }
        if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
            root2.right = null;
        }

        // 递归遍历左右子节点，root2 的节点也跟着同步移动
        traverse(root1.left, root2.left);
        traverse(root1.right, root2.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 分解问题的思维模式
// 定义：输入两棵树的根节点，返回合并后的树的根节点
func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
    // 如果一棵树非空，那么合并后就是另一棵树
    if root1 == nil {
        return root2
    }
    if root2 == nil {
        return root1
    }
    // 两棵树都有的节点，叠加节点值
    root1.Val += root2.Val
    // 利用函数定义，子树合并后接到
    root1.Left = mergeTrees(root1.Left, root2.Left)
    root1.Right = mergeTrees(root1.Right, root2.Right)

    return root1
}

// 遍历的思维模式
func mergeTreesTraversal(root1 *TreeNode, root2 *TreeNode) *TreeNode {
    if root1 == nil {
        return root2
    }
    // 遍历 root1，顺便把 root2 的节点合并过来
    traverse(root1, root2)
    return root1
}

// 遍历函数
func traverse(root1 *TreeNode, root2 *TreeNode) {
    if root1 == nil || root2 == nil {
        return
    }

    // 两棵树都有的节点，叠加节点值
    root1.Val += root2.Val

    // 如果 root1 没有子树而 root2 有，那么就把 root2 的子树接到 root1 上
    // 注意接完之后把 root2 的子树置为 null，免得错误计算节点累加值
    if root1.Left == nil && root2.Left != nil {
        root1.Left = root2.Left
    }
    if root1.Right == nil && root2.Right != nil {
        root1.Right = root2.Right
    }

    // 递归遍历左右子节点，root2 的节点也跟着同步移动
    traverse(root1.Left, root2.Left)
    traverse(root1.Right, root2.Right)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var mergeTrees = function(root1, root2) {
    // 分解问题的思维模式
    // 定义：输入两棵树的根节点，返回合并后的树的根节点
    // 如果一棵树非空，那么合并后就是另一棵树
    if (root1 == null) {
        return root2;
    }
    if (root2 == null) {
        return root1;
    }
    // 两棵树都有的节点，叠加节点值
    root1.val += root2.val;
    // 利用函数定义，子树合并后接到
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);

    return root1;
};

var mergeTreesTraversal = function(root1, root2) {
    // 遍历的思维模式
    // 如果一棵树非空，那么合并后就是另一棵树
    if (root1 == null) {
        return root2;
    }
    // 遍历 root1，顺便把 root2 的节点合并过来
    traverse(root1, root2);
    return root1;
};

function traverse(root1, root2) {
    if (root1 == null || root2 == null) {
        return;
    }

    if (root1 != null && root2 != null) {
        // 两棵树都有的节点，叠加节点值
        root1.val += root2.val;
    }

    // 如果 root1 没有子树而 root2 有，那么就把 root2 的子树接到 root1 上
    // 注意接完之后把 root2 的子树置为 null，免得错误计算节点累加值
    if (root1.left == null && root2.left != null) {
        root1.left = root2.left;
        root2.left = null;
    }
    if (root1.right == null && root2.right != null) {
        root1.right = root2.right;
        root2.right = null;
    }

    // 递归遍历左右子节点，root2 的节点也跟着同步移动
    traverse(root1.left, root2.left);
    traverse(root1.right, root2.right);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_merge-two-binary-trees"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_merge-two-binary-trees"></div></div>
</details><hr /><br />

</div>
</details>
</div>

