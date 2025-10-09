<p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>the number of paths where the sum of the values&nbsp;along the path equals</em>&nbsp;<code>targetSum</code>.</p>

<p>The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 450px; height: 386px;" /> 
<pre>
<strong>Input:</strong> root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
<strong>Output:</strong> 3
<strong>Explanation:</strong> The paths that sum to 8 are shown.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 1000]</code>.</li> 
 <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li> 
 <li><code>-1000 &lt;= targetSum &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 11696, 👎 563<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维模式。

这题的难度应该设置为困难，因为这题及要求你准确理解二叉树的前序后序遍历，还要熟悉前缀和技巧，把前缀和技巧用到二叉树上。

你可以先看前文 [前缀和技巧](https://labuladong.online/algo/data-structure/prefix-sum/)，然后做一下 [✔ ✨560. 和为K的子数组](/problems/subarray-sum-equals-k/)，应该能够理解这道题的思路了。

你把二叉树看做是数组，利用前后序遍历来维护前缀和，看下图就能理解解法中几个关键变量的关系了：

![](https://labuladong.online/algo/images/brief-extra/437.jpeg)

**详细题解**：
  - [【练习】用「遍历」思维解题 III](https://labuladong.online/algo/problem-set/binary-tree-traverse-iii/)

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
    // 记录前缀和
    // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    unordered_map<long long, int> preSumCount;

    long long currentPathSum, targetSum;
    int res = 0;

public:
    int pathSum(TreeNode* root, int targetSum) {
        if (root == nullptr) {
            return 0;
        }
        this->currentPathSum = 0;
        this->targetSum = targetSum;
        this->preSumCount[0] = 1;
        traverse(root);
        return res;
    }

    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        // 前序遍历位置
        currentPathSum += root->val;
        // 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        // 就是路径和为 targetSum 的路径条数
        res += preSumCount[currentPathSum - targetSum];
        // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
        preSumCount[currentPathSum] += 1;

        traverse(root->left);
        traverse(root->right);

        // 后序遍历位置
        preSumCount[currentPathSum] -= 1;
        currentPathSum -= root->val;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 记录前缀和
    # 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    def __init__(self):
        self.preSumCount = {}
        self.path_sum = 0
        self.target_sum = 0
        self.res = 0

    def pathSum(self, root: TreeNode, targetSum: int) -> int:
        if root is None:
            return 0
        self.path_sum = 0
        self.target_sum = targetSum
        self.preSumCount[0] = 1
        self.traverse(root)
        return self.res

    def traverse(self, root: TreeNode):
        if root is None:
            return
        # 前序遍历位置
        self.path_sum += root.val
        # 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        # 就是路径和为 targetSum 的路径条数
        self.res += self.preSumCount.get(self.path_sum - self.target_sum, 0)
        # 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
        self.preSumCount[self.path_sum] = self.preSumCount.get(self.path_sum, 0) + 1

        self.traverse(root.left)
        self.traverse(root.right)

        # 后序遍历位置
        self.preSumCount[self.path_sum] = self.preSumCount.get(self.path_sum) - 1
        self.path_sum -= root.val
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录前缀和
    // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    HashMap<Long, Integer> preSumCount = new HashMap<>();

    long pathSum, targetSum;
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.pathSum = 0;
        this.targetSum = targetSum;
        this.preSumCount.put(0L, 1);
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        pathSum += root.val;
        // 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        // 就是路径和为 targetSum 的路径条数
        res += preSumCount.getOrDefault(pathSum - targetSum, 0);
        // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func pathSum(root *TreeNode, targetSum int) int {
    if root == nil {
        return 0
    }
    // 记录前缀和
    // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    preSumCount := make(map[int64]int)
    preSumCount[0] = 1
    return traverse(root, int64(targetSum), 0, preSumCount)
}

func traverse(root *TreeNode, targetSum, pathSum int64, preSumCount map[int64]int) int {
    if root == nil {
        return 0
    }

    // 前序遍历位置
    pathSum += int64(root.Val)
    // 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
    // 就是路径和为 targetSum 的路径条数
    res := preSumCount[pathSum-targetSum]
    // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
    preSumCount[pathSum] = preSumCount[pathSum] + 1

    res += traverse(root.Left, targetSum, pathSum, preSumCount)
    res += traverse(root.Right, targetSum, pathSum, preSumCount)

    // 后序遍历位置
    preSumCount[pathSum] = preSumCount[pathSum] - 1
    pathSum -= int64(root.Val)

    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var pathSum = function(root, targetSum) {
    // 记录前缀和
    // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    let preSumCount = new Map();
    let pathSum = 0;
    let res = 0;

    function traverse(root) {
        if (root === null) {
            return;
        }
        // 前序遍历位置
        pathSum += root.val;
        // 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        // 就是路径和为 targetSum 的路径条数
        res += (preSumCount.get(pathSum - targetSum) || 0);
        // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
        preSumCount.set(pathSum, (preSumCount.get(pathSum) || 0) + 1);

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        preSumCount.set(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }

    if (root === null) {
        return 0;
    }
    preSumCount.set(0, 1);
    traverse(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_path-sum-iii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_path-sum-iii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

