<p>Given the <code>root</code> of a binary tree, return <em>the sum of values of nodes with an <strong>even-valued grandparent</strong></em>. If there are no nodes with an <strong>even-valued grandparent</strong>, return <code>0</code>.</p>

<p>A <strong>grandparent</strong> of a node is the parent of its parent if it exists.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/even1-tree.jpg" style="width: 504px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
<strong>Output:</strong> 18
<strong>Explanation:</strong> The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/even2-tree.jpg" style="width: 64px; height: 65px;" /> 
<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 2814, 👎 78<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

很简单，遍历一遍二叉树，对于节点值为偶数的节点，累加它的孙子节点的值即可。

**详细题解**：
  - [【练习】用「遍历」思维解题 II](https://labuladong.online/algo/problem-set/binary-tree-traverse-ii/)

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
    int sumEvenGrandparent(TreeNode* root) {
        traverse(root);
        return sum;
    }

    int sum = 0;

    // 二叉树的遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        if (root->val % 2 == 0) {
            // 累加左子树孙子节点的值
            if (root->left != nullptr) {
                if (root->left->left != nullptr) {
                    sum += root->left->left->val;
                }
                if (root->left->right != nullptr) {
                    sum += root->left->right->val;
                }
            }

            // 累加右子树孙子节点的值
            if (root->right != nullptr) {
                if (root->right->left != nullptr) {
                    sum += root->right->left->val;
                }
                if (root->right->right != nullptr) {
                    sum += root->right->right->val;
                }
            }
        }

        // 二叉树的遍历框架
        traverse(root->left);
        traverse(root->right);
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
        self.sum = 0

    def sumEvenGrandparent(self, root: TreeNode) -> int:
        self.traverse(root)
        return self.sum

    # 二叉树的遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        if root.val % 2 == 0:
            # 累加左子树孙子节点的值
            if root.left is not None:
                if root.left.left is not None:
                    self.sum += root.left.left.val
                if root.left.right is not None:
                    self.sum += root.left.right.val

            # 累加右子树孙子节点的值
            if root.right is not None:
                if root.right.left is not None:
                    self.sum += root.right.left.val
                if root.right.right is not None:
                    self.sum += root.right.right.val

        # 二叉树的遍历框架
        self.traverse(root.left)
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return sum;
    }

    int sum = 0;

    // 二叉树的遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0) {
            // 累加左子树孙子节点的值
            if (root.left != null) {
                if (root.left.left != null) {
                    sum += root.left.left.val;
                }
                if (root.left.right != null) {
                    sum += root.left.right.val;
                }
            }

            // 累加右子树孙子节点的值
            if (root.right != null) {
                if (root.right.left != null) {
                    sum += root.right.left.val;
                }
                if (root.right.right != null) {
                    sum += root.right.right.val;
                }
            }
        }

        // 二叉树的遍历框架
        traverse(root.left);
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func sumEvenGrandparent(root *TreeNode) int {
    var sum int
    traverse(root, &sum)
    return sum
}

// 二叉树的遍历函数
func traverse(root *TreeNode, sum *int) {
    if root == nil {
        return
    }
    if root.Val % 2 == 0 {
        // 累加左子树孙子节点的值
        if root.Left != nil {
            if root.Left.Left != nil {
                *sum += root.Left.Left.Val
            }
            if root.Left.Right != nil {
                *sum += root.Left.Right.Val
            }
        }
        
        // 累加右子树孙子节点的值
        if root.Right != nil {
            if root.Right.Left != nil {
                *sum += root.Right.Left.Val
            }
            if root.Right.Right != nil {
                *sum += root.Right.Right.Val
            }
        }
    }
    
    // 二叉树的遍历框架
    traverse(root.Left, sum)
    traverse(root.Right, sum)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var sumEvenGrandparent = function(root) {
    let sum = 0;

    // 二叉树的遍历函数
    function traverse(root) {
        if (root === null) {
            return;
        }
        if (root.val % 2 === 0) {
            // 累加左子树孙子节点的值
            if (root.left !== null) {
                if (root.left.left !== null) {
                    sum += root.left.left.val;
                }
                if (root.left.right !== null) {
                    sum += root.left.right.val;
                }
            }

            // 累加右子树孙子节点的值
            if (root.right !== null) {
                if (root.right.left !== null) {
                    sum += root.right.left.val;
                }
                if (root.right.right !== null) {
                    sum += root.right.right.val;
                }
            }
        }

        // 二叉树的遍历框架
        traverse(root.left);
        traverse(root.right);
    }

    traverse(root);
    return sum;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_sum-of-nodes-with-even-valued-grandparent"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_sum-of-nodes-with-even-valued-grandparent"></div></div>
</details><hr /><br />

</div>
</details>
</div>

