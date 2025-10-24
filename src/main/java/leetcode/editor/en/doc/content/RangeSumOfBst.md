<p>Given the <code>root</code> node of a binary search tree and two integers <code>low</code> and <code>high</code>, return <em>the sum of values of all nodes with a value in the <strong>inclusive</strong> range </em><code>[low, high]</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg" style="width: 400px; height: 222px;" /> 
<pre>
<strong>Input:</strong> root = [10,5,15,3,7,null,18], low = 7, high = 15
<strong>Output:</strong> 32
<strong>Explanation:</strong> Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg" style="width: 400px; height: 335px;" /> 
<pre>
<strong>Input:</strong> root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
<strong>Output:</strong> 23
<strong>Explanation:</strong> Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 2 * 10<sup>4</sup>]</code>.</li> 
 <li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= low &lt;= high &lt;= 10<sup>5</sup></code></li> 
 <li>All <code>Node.val</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Search Tree | Binary Tree</details><br>

<div>👍 7193, 👎 389<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题可以同时使用这两种思维模式。

遍历的思路就是单纯用 `traverse` 函数遍历一遍 BST，找到落在区间的元素。分解问题的思路关键是要明确函数定义，然后利用这个定义。

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

// 遍历的思路
class Solution {
    int sum = 0;

public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        if (root == nullptr) return 0;
        // 遍历一遍 BST 计算区间元素和
        traverse(root, low, high);
        return sum;
    }

    void traverse(TreeNode* root, int low, int high) {
        if (root == nullptr) {
            return;
        }
        if (root->val < low) {
            // 目标区间在右子树
            traverse(root->right, low, high);
        } else if (root->val > high) {
            // 目标区间在左子树
            traverse(root->left, low, high);
        } else {
            // root.val 落在目标区间，累加 sum
            sum += root->val;
            // 继续遍历左右子树
            traverse(root->right, low, high);
            traverse(root->left, low, high);
        }
    }
};

// 分解问题的思路
class Solution2 {
public:
    // 定义：输入一个 BST，计算值落在 [low, high] 之间的元素之和
    int rangeSumBST(TreeNode* root, int low, int high) {
        if (root == nullptr) return 0;
        if (root->val < low) {
            // 目标区间在右子树
            return rangeSumBST(root->right, low, high);
        } else if (root->val > high) {
            // 目标区间在左子树
            return rangeSumBST(root->left, low, high);
        } else {
            // 以 root 为根的这棵 BST 落在 [low, high] 之间的元素之和，
            // 等于 root.val 加上左右子树落在区间的元素之和
            return root->val
                    + rangeSumBST(root->left, low, high)
                    + rangeSumBST(root->right, low, high);
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 遍历的思路
    def __init__(self):
        self.sum = 0

    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return 0
        # 遍历一遍 BST 计算区间元素和
        self.traverse(root, low, high)
        return self.sum

    def traverse(self, root: TreeNode, low: int, high: int):
        if root is None:
            return
        if root.val < low:
            # 目标区间在右子树
            self.traverse(root.right, low, high)
        elif root.val > high:
            # 目标区间在左子树
            self.traverse(root.left, low, high)
        else:
            # root.val 落在目标区间，累加 sum
            self.sum += root.val
            # 继续遍历左右子树
            self.traverse(root.right, low, high)
            self.traverse(root.left, low, high)

class Solution2:
    # 分解问题的思路
    # 定义：输入一个 BST，计算值落在 [low, high] 之间的元素之和
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return 0
        if root.val < low:
            # 目标区间在右子树
            return self.rangeSumBST(root.right, low, high)
        elif root.val > high:
            # 目标区间在左子树
            return self.rangeSumBST(root.left, low, high)
        else:
            # 以 root 为根的这棵 BST 落在 [low, high] 之间的元素之和，
            # 等于 root.val 加上左右子树落在区间的元素之和
            return root.val + self.rangeSumBST(root.left, low, high) + self.rangeSumBST(root.right, low, high)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 遍历的思路
class Solution {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        // 遍历一遍 BST 计算区间元素和
        traverse(root, low, high);
        return sum;
    }

    void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val < low) {
            // 目标区间在右子树
            traverse(root.right, low, high);
        } else if (root.val > high) {
            // 目标区间在左子树
            traverse(root.left, low, high);
        } else {
            // root.val 落在目标区间，累加 sum
            sum += root.val;
            // 继续遍历左右子树
            traverse(root.right, low, high);
            traverse(root.left, low, high);
        }
    }
}

// 分解问题的思路
class Solution2 {
    // 定义：输入一个 BST，计算值落在 [low, high] 之间的元素之和
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) {
            // 目标区间在右子树
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            // 目标区间在左子树
            return rangeSumBST(root.left, low, high);
        } else {
            // 以 root 为根的这棵 BST 落在 [low, high] 之间的元素之和，
            // 等于 root.val 加上左右子树落在区间的元素之和
            return root.val
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 遍历的思路


func rangeSumBST(root *TreeNode, low int, high int) int {
    var sum int
    if root == nil {
        return 0
    }
    // 遍历一遍 BST 计算区间元素和
    traverse(root, low, high, &sum)
    return sum
}

func traverse(root *TreeNode, low int, high int, sum *int) {
    if root == nil {
        return
    }
    if root.Val < low {
        // 目标区间在右子树
        traverse(root.Right, low, high, sum)
    } else if root.Val > high {
        // 目标区间在左子树
        traverse(root.Left, low, high, sum)
    } else {
        // root.val 落在目标区间，累加 sum
        *sum += root.Val
        // 继续遍历左右子树
        traverse(root.Right, low, high, sum)
        traverse(root.Left, low, high, sum)
    }
}

// 分解问题的思路
func rangeSumBST2(root *TreeNode, low int, high int) int {
    // 定义：输入一个 BST，计算值落在 [low, high] 之间的元素之和
    if root == nil {
        return 0
    }
    if root.Val < low {
        // 目标区间在右子树
        return rangeSumBST2(root.Right, low, high)
    } else if root.Val > high {
        // 目标区间在左子树
        return rangeSumBST2(root.Left, low, high)
    } else {
        // 以 root 为根的这棵 BST 落在 [low, high] 之间的元素之和，
        // 等于 root.val 加上左右子树落在区间的元素之和
        return root.Val + rangeSumBST2(root.Left, low, high) + rangeSumBST2(root.Right, low, high)
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 遍历的思路
var rangeSumBST = function(root, low, high) {
    let sum = 0;

    // 遍历一遍 BST 计算区间元素和
    var traverse = function(root, low, high) {
        if (root === null) {
            return;
        }
        if (root.val < low) {
            // 目标区间在右子树
            traverse(root.right, low, high);
        } else if (root.val > high) {
            // 目标区间在左子树
            traverse(root.left, low, high);
        } else {
            // root.val 落在目标区间，累加 sum
            sum += root.val;
            // 继续遍历左右子树
            traverse(root.right, low, high);
            traverse(root.left, low, high);
        }
    };

    traverse(root, low, high);
    return sum;
};

// 分解问题的思路
var rangeSumBST2 = function(root, low, high) {
    // 定义：输入一个 BST，计算值落在 [low, high] 之间的元素之和
    if (root === null) return 0;
    if (root.val < low) {
        // 目标区间在右子树
        return rangeSumBST2(root.right, low, high);
    } else if (root.val > high) {
        // 目标区间在左子树
        return rangeSumBST2(root.left, low, high);
    } else {
        // 以 root 为根的这棵 BST 落在 [low, high] 之间的元素之和，
        // 等于 root.val 加上左右子树落在区间的元素之和
        return root.val
                + rangeSumBST2(root.left, low, high)
                + rangeSumBST2(root.right, low, high);
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_range-sum-of-bst"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_range-sum-of-bst"></div></div>
</details><hr /><br />

</div>
</details>
</div>

