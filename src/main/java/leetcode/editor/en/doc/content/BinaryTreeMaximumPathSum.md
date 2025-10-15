<p>A <strong>path</strong> in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence <strong>at most once</strong>. Note that the path does not need to pass through the root.</p>

<p>The <strong>path sum</strong> of a path is the sum of the node's values in the path.</p>

<p>Given the <code>root</code> of a binary tree, return <em>the maximum <strong>path sum</strong> of any <strong>non-empty</strong> path</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The optimal path is 2 -&gt; 1 -&gt; 3 with a path sum of 2 + 1 + 3 = 6.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" /> 
<pre>
<strong>Input:</strong> root = [-10,9,20,null,null,15,7]
<strong>Output:</strong> 42
<strong>Explanation:</strong> The optimal path is 15 -&gt; 20 -&gt; 7 with a path sum of 15 + 20 + 7 = 42.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 3 * 10<sup>4</sup>]</code>.</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Dynamic Programming | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 18021, 👎 780<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。

这题需要巧用二叉树的后序遍历，可以先去做一下 [✔ ✨543. 二叉树的直径](/problems/diameter-of-binary-tree/) 和 [✨366. 寻找二叉树的叶子节点](/problems/find-leaves-of-binary-tree/)。

`oneSideMax` 函数和上述几道题中都用到的 `maxDepth` 函数非常类似，只不过 `maxDepth` 计算最大深度，`oneSideMax` 计算「单边」最大路径和：

![](https://labuladong.online/algo/images/brief-extra/124.png)

然后在后序遍历的时候顺便计算题目要求的最大路径和。

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
    int res = INT_MIN;

public:
    int maxPathSum(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        // 计算单边路径和时顺便计算最大路径和
        oneSideMax(root);
        return res;
    }

    // 定义：计算从根节点 root 为起点的最大单边路径和
    int oneSideMax(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMaxSum = std::max(0, oneSideMax(root->left));
        int rightMaxSum = std::max(0, oneSideMax(root->right));
        // 后序遍历位置，顺便更新最大路径和
        int pathMaxSum = root->val + leftMaxSum + rightMaxSum;
        res = std::max(res, pathMaxSum);
        // 实现函数定义，左右子树的最大单边路径和加上根节点的值
        // 就是从根节点 root 为起点的最大单边路径和
        return std::max(leftMaxSum, rightMaxSum) + root->val;
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
        self.res = float('-inf')

    def maxPathSum(self, root: TreeNode) -> int:
        if root is None:
            return 0
        # 计算单边路径和时顺便计算最大路径和
        self.oneSideMax(root)
        return self.res

    # 定义：计算从根节点 root 为起点的最大单边路径和
    def oneSideMax(self, root: TreeNode) -> int:
        if root is None:
            return 0
        left_max_sum = max(0, self.oneSideMax(root.left))
        right_max_sum = max(0, self.oneSideMax(root.right))
        # 后序遍历位置，顺便更新最大路径和
        path_max_sum = root.val + left_max_sum + right_max_sum
        self.res = max(self.res, path_max_sum)
        # 实现函数定义，左右子树的最大单边路径和加上根节点的值
        # 就是从根节点 root 为起点的最大单边路径和
        return max(left_max_sum, right_max_sum) + root.val
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算单边路径和时顺便计算最大路径和
        oneSideMax(root);
        return res;
    }

    // 定义：计算从根节点 root 为起点的最大单边路径和
    int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = Math.max(0, oneSideMax(root.left));
        int rightMaxSum = Math.max(0, oneSideMax(root.right));
        // 后序遍历位置，顺便更新最大路径和
        int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
        res = Math.max(res, pathMaxSum);
        // 实现函数定义，左右子树的最大单边路径和加上根节点的值
        // 就是从根节点 root 为起点的最大单边路径和
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func maxPathSum(root *TreeNode) int {
    res := math.MinInt32
    if root == nil {
        return 0
    }
    // 计算单边路径和时顺便计算最大路径和
    oneSideMax(root, &res)
    return res
}

// 定义：计算从根节点 root 为起点的最大单边路径和
func oneSideMax(root *TreeNode, res *int) int {
    if root == nil {
        return 0
    }
    leftMaxSum := max(0, oneSideMax(root.Left, res))
    rightMaxSum := max(0, oneSideMax(root.Right, res))
    // 后序遍历位置，顺便更新最大路径和
    pathMaxSum := root.Val + leftMaxSum + rightMaxSum
    *res = max(*res, pathMaxSum)
    // 实现函数定义，左右子树的最大单边路径和加上根节点的值
    // 就是从根节点 root 为起点的最大单边路径和
    return max(leftMaxSum, rightMaxSum) + root.Val
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var maxPathSum = function(root) {
    let res = Number.MIN_SAFE_INTEGER;

    // 定义：计算从根节点 root 为起点的最大单边路径和
    function oneSideMax(root) {
        if (root === null) {
            return 0;
        }
        let leftMaxSum = Math.max(0, oneSideMax(root.left));
        let rightMaxSum = Math.max(0, oneSideMax(root.right));
        // 后序遍历位置，顺便更新最大路径和
        let pathMaxSum = root.val + leftMaxSum + rightMaxSum;
        res = Math.max(res, pathMaxSum);
        // 实现函数定义，左右子树的最大单边路径和加上根节点的值
        // 就是从根节点 root 为起点的最大单边路径和
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }

    // 计算单边路径和时顺便计算最大路径和
    if (root === null) {
        return 0;
    }
    oneSideMax(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_binary-tree-maximum-path-sum"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-maximum-path-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>

