<p>Given a binary tree <code>root</code>, a node <em>X</em> in the tree is named&nbsp;<strong>good</strong> if in the path from root to <em>X</em> there are no nodes with a value <em>greater than</em> X.</p>

<p>Return the number of <strong>good</strong> nodes in the binary tree.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/04/02/test_sample_1.png" style="width: 263px; height: 156px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [3,1,4,3,null,1,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Nodes in blue are <strong>good</strong>.
Root Node (3) is always a good node.
Node 4 -&gt; (3,4) is the maximum value in the path starting from the root.
Node 5 -&gt; (3,4,5) is the maximum value in the path
Node 3 -&gt; (3,1,3) is the maximum value in the path.</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/04/02/test_sample_2.png" style="width: 157px; height: 161px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [3,3,null,4,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> Node 2 -&gt; (3, 3, 2) is not good, because "3" is higher than it.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Root is considered as <strong>good</strong>.</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the binary tree is in the range&nbsp;<code>[1, 10^5]</code>.</li> 
 <li>Each node's value is between <code>[-10^4, 10^4]</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 6221, 👎 206<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维，利用函数参数给子树传递信息。

函数参数 `pathMax` 记录从根节点到当前节点路径中的最大值，通过比较 `root.val` 和 `pathMax` 比较就可判断 `root` 节点是不是「好节点」。然后再把 `pathMax` 传递到子树中继续判断其他节点。

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
    int goodNodes(TreeNode* root) {
        traverse(root, root->val);
        return count;
    }

private:
    int count = 0;

    // 二叉树遍历函数，pathMax 参数记录从根节点到当前节点路径中的最大值
    void traverse(TreeNode* root, int pathMax) {
        if (root == nullptr) {
            return;
        }
        if (pathMax <= root->val) {
            // 找到一个「好节点」
            count++;
        }
        // 更新路径上的最大值
        pathMax = max(pathMax, root->val);

        traverse(root->left, pathMax);
        traverse(root->right, pathMax);
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
        self.count = 0

    def goodNodes(self, root: TreeNode) -> int:
        self.traverse(root, root.val)
        return self.count

    # 二叉树遍历函数，pathMax 参数记录从根节点到当前节点路径中的最大值
    def traverse(self, root: TreeNode, pathMax: int):
        if root is None:
            return
        if pathMax <= root.val:
            # 找到一个「好节点」
            self.count += 1
        # 更新路径上的最大值
        pathMax = max(pathMax, root.val)

        self.traverse(root.left, pathMax)
        self.traverse(root.right, pathMax)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return count;
    }

    int count = 0;

    // 二叉树遍历函数，pathMax 参数记录从根节点到当前节点路径中的最大值
    void traverse(TreeNode root, int pathMax) {
        if (root == null) {
            return;
        }
        if (pathMax <= root.val) {
            // 找到一个「好节点」
            count++;
        }
        // 更新路径上的最大值
        pathMax = Math.max(pathMax, root.val);

        traverse(root.left, pathMax);
        traverse(root.right, pathMax);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func goodNodes(root *TreeNode) int {
    count := 0
    traverse(root, root.Val, &count)
    return count
}

// 二叉树遍历函数，pathMax 参数记录从根节点到当前节点路径中的最大值
func traverse(root *TreeNode, pathMax int, count *int) {
    if root == nil {
        return
    }
    if pathMax <= root.Val {
        // 找到一个「好节点」
        *count++
    }
    // 更新路径上的最大值
    newPathMax := max(pathMax, root.Val)

    traverse(root.Left, newPathMax, count)
    traverse(root.Right, newPathMax, count)
}

// Helper function to find the maximum of two integers
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

var goodNodes = function(root) {
    let count = 0;

    // 二叉树遍历函数，pathMax 参数记录从根节点到当前节点路径中的最大值
    var traverse = function(node, pathMax) {
        if (node === null) {
            return;
        }
        if (pathMax <= node.val) {
            // 找到一个「好节点」
            count++;
        }
        // 更新路径上的最大值
        pathMax = Math.max(pathMax, node.val);

        traverse(node.left, pathMax);
        traverse(node.right, pathMax);
    };

    traverse(root, root.val);
    return count;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_count-good-nodes-in-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_count-good-nodes-in-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

