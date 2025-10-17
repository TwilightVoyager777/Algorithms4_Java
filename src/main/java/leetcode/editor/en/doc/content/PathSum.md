<p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <code>true</code> if the tree has a <strong>root-to-leaf</strong> path such that adding up all the values along the path equals <code>targetSum</code>.</p>

<p>A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg" style="width: 500px; height: 356px;" /> 
<pre>
<strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
<strong>Output:</strong> true
<strong>Explanation:</strong> The root-to-leaf path with the target sum is shown.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" /> 
<pre>
<strong>Input:</strong> root = [1,2,3], targetSum = 5
<strong>Output:</strong> false
<strong>Explanation:</strong> There are two root-to-leaf paths in the tree:
(1 --&gt; 2): The sum is 3.
(1 --&gt; 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [], targetSum = 0
<strong>Output:</strong> false
<strong>Explanation:</strong> Since the tree is empty, there are no root-to-leaf paths.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
 <li><code>-1000 &lt;= targetSum &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 10438, 👎 1198<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树的遍历代码是动态规划和回溯算法的祖宗。

[动态规划](https://labuladong.online/algo/essential-technique/dynamic-programming-framework/) 的关键在于明确递归函数的定义，把用子问题的结果推导出大问题的结果。

[回溯算法](https://labuladong.online/algo/essential-technique/backtrack-framework/) 就简单粗暴多了，就是单纯的遍历回溯树。

下面给出两种思路下的解法，请仔细体会。

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
    // 解法一、分解问题的思路
    // 定义：输入一个根节点，返回该根节点到叶子节点是否存在一条和为 targetSum 的路径
    bool hasPathSum(TreeNode* root, int targetSum) {
        // base case
        if (root == nullptr) {
            return false;
        }
        // root.left == root.right 等同于 root.left == null && root.right == null
        if (root->left == nullptr && root->right == nullptr && root->val == targetSum) {
            return true;
        }

        return hasPathSum(root->left, targetSum - root->val)
            || hasPathSum(root->right, targetSum - root->val);
    }

    // 解法二、遍历二叉树的思路
    int target;
    bool found = false;
    // 记录遍历过程中的路径和
    int curSum = 0;

    bool hasPathSum_2(TreeNode* root, int targetSum) {
        if (root == nullptr) {
            return false;
        }
        this->target = targetSum;
        traverse(root);
        return found;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        // 前序遍历位置
        curSum += root->val;
        if (root->left == nullptr && root->right == nullptr) {
            if (curSum == target) {
                found = true;
            }
        }

        traverse(root->left);
        traverse(root->right);

        // 后序遍历位置
        curSum -= root->val;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 解法一、分解问题的思路
    # 定义：输入一个根节点，返回该根节点到叶子节点是否存在一条和为 targetSum 的路径
    def hasPathSum(self, root: TreeNode, targetSum: int) -> bool:
        # base case
        if root is None:
            return False
        # root.left == root.right 等同于 root.left == null && root.right == null
        if root.left == root.right and root.val == targetSum:
            return True

        return self.hasPathSum(root.left, targetSum - root.val) or self.hasPathSum(root.right, targetSum - root.val)

    # 解法二、遍历二叉树的思路
    # 记录遍历过程中的路径和
    def hasPathSum_2(self, root: TreeNode, targetSum: int) -> bool:
        if root is None:
            return False
        self.target = targetSum
        self.found = False
        self.curSum = 0
        self.traverse(root)
        return self.found

    # 二叉树遍历函数
    def traverse(self, root: TreeNode) -> None:
        if root is None:
            return
        # 前序遍历位置
        self.curSum += root.val
        if root.left is None and root.right is None:
            if self.curSum == self.target:
                self.found = True

        self.traverse(root.left)
        self.traverse(root.right)

        # 后序遍历位置
        self.curSum -= root.val
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 解法一、分解问题的思路
    // 定义：输入一个根节点，返回该根节点到叶子节点是否存在一条和为 targetSum 的路径
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // base case
        if (root == null) {
            return false;
        }
        // root.left == root.right 等同于 root.left == null && root.right == null
        if (root.left == root.right && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    // 解法二、遍历二叉树的思路
    int target;
    boolean found = false;
    // 记录遍历过程中的路径和
    int curSum = 0;

    public boolean hasPathSum_2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.target = targetSum;
        traverse(root);
        return found;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == target) {
                found = true;
            }
        }

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        curSum -= root.val;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 解法一、分解问题的思路
// 定义：输入一个根节点，返回该根节点到叶子节点是否存在一条和为 targetSum 的路径
func hasPathSum(root *TreeNode, targetSum int) bool {
    // base case
    if root == nil {
        return false
    }
    // root.left == root.right 等同于 root.left == null && root.right == null
    if root.Left == root.Right && root.Val == targetSum {
        return true
    }

    return hasPathSum(root.Left, targetSum-root.Val) || hasPathSum(root.Right, targetSum-root.Val)
}

// 解法二、遍历二叉树的思路
func hasPathSum_2(root *TreeNode, targetSum int) bool {
    if root == nil {
        return false
    }
    found := false
    // 记录遍历过程中的路径和
    curSum := 0
    traverse(root, targetSum, &curSum, &found)
    return found
}

// 二叉树遍历函数
func traverse(root *TreeNode, target int, curSum *int, found *bool) {
    if root == nil {
        return
    }
    // 前序遍历位置
    *curSum += root.Val
    if root.Left == nil && root.Right == nil {
        if *curSum == target {
            *found = true
        }
    }

    traverse(root.Left, target, curSum, found)
    traverse(root.Right, target, curSum, found)

    // 后序遍历位置
    *curSum -= root.Val
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 解法一、分解问题的思路
// 定义：输入一个根节点，返回该根节点到叶子节点是否存在一条和为 targetSum 的路径
var hasPathSum = function(root, targetSum) {
    // base case
    if (root === null) {
        return false;
    }
    // root.left == root.right 等同于 root.left == null && root.right == null
    if (root.left === root.right && root.val === targetSum) {
        return true;
    }

    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
};

// 解法二、遍历二叉树的思路
var hasPathSum_2 = function(root, targetSum) {
    let target = targetSum;
    let found = false;
    // 记录遍历过程中的路径和
    let curSum = 0;

    // 二叉树遍历函数
    function traverse(root) {
        if (root === null) {
            return;
        }
        // 前序遍历位置
        curSum += root.val;
        if (root.left === null && root.right === null) {
            if (curSum === target) {
                found = true;
            }
        }

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        curSum -= root.val;
    }

    traverse(root);
    return found;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_path-sum"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_path-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>

