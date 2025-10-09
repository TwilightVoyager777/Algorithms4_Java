<p>Two players play a turn based game on a binary tree. We are given the <code>root</code> of this binary tree, and the number of nodes <code>n</code> in the tree. <code>n</code> is odd, and each node has a distinct value from <code>1</code> to <code>n</code>.</p>

<p>Initially, the first player names a value <code>x</code> with <code>1 &lt;= x &lt;= n</code>, and the second player names a value <code>y</code> with <code>1 &lt;= y &lt;= n</code> and <code>y != x</code>. The first player colors the node with value <code>x</code> red, and the second player colors the node with value <code>y</code> blue.</p>

<p>Then, the players take turns starting with the first player. In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an <strong>uncolored</strong> neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)</p>

<p>If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends, and the winner is the player that colored more nodes.</p>

<p>You are the second player. If it is possible to choose such a <code>y</code> to ensure you win the game, return <code>true</code>. If it is not possible, return <code>false</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/08/01/1480-binary-tree-coloring-game.png" style="width: 500px; height: 310px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
<strong>Output:</strong> true
<strong>Explanation: </strong>The second player can choose the node with value 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2,3], n = 3, x = 1
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is <code>n</code>.</li> 
 <li><code>1 &lt;= x &lt;= n &lt;= 100</code></li> 
 <li><code>n</code> is odd.</li> 
 <li>1 &lt;= Node.val &lt;= n</li> 
 <li>All the values of the tree are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 1392, 👎 224<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题的关键是要观察规律，根据游戏规则，对方先选一个节点之后，你的最优策略就是紧贴着对方的那个节点选择，也就是说你应该选择节点 `x` 的左右子节点或者父节点。

做出以上三种选择，你可以占据二叉树的不同部分，如下图：

![](https://labuladong.online/algo/images/brief-extra/1145.png)

你如果想赢，必须占据超过 `n / 2` 的节点，也就是说，如果这三个蓝色区域中节点数最多的那个区域中的节点个数大于 `n / 2`，你能赢，否则你就输。

所以本题转化为计算二叉树节点个数的简单问题，具体看代码逻辑。

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
public:
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        TreeNode* node = find(root, x);
        int leftCount = count(node->left);
        int rightCount = count(node->right);
        int otherCount = n - 1 - leftCount - rightCount;

        return max(leftCount, max(rightCount, otherCount)) > n / 2;
    }

    // 定义：在以 root 为根的二叉树中搜索值为 x 的节点并返回
    TreeNode* find(TreeNode* root, int x) {
        if (root == nullptr) {
            return nullptr;
        }
        if (root->val == x) {
            return root;
        }
        // 去左子树找
        TreeNode* left = find(root->left, x);
        if (left != nullptr) {
            return left;
        }
        // 左子树找不到的话去右子树找
        return find(root->right, x);
    }

    // 定义：计算以 root 为根的二叉树的节点总数
    int count(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        return 1 + count(root->left) + count(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def btreeGameWinningMove(self, root: TreeNode, n: int, x: int) -> bool:
        node = self.find(root, x)
        left_count = self.count(node.left)
        right_count = self.count(node.right)
        other_count = n - 1 - left_count - right_count

        return max(left_count, max(right_count, other_count)) > n // 2

    # 定义：在以 root 为根的二叉树中搜索值为 x 的节点并返回
    def find(self, root: TreeNode, x: int) -> TreeNode:
        if root is None:
            return None
        if root.val == x:
            return root
        # 去左子树找
        left = self.find(root.left, x)
        if left is not None:
            return left
        # 左子树找不到的话去右子树找
        return self.find(root.right, x)

    # 定义：计算以 root 为根的二叉树的节点总数
    def count(self, root: TreeNode) -> int:
        if root is None:
            return 0
        return 1 + self.count(root.left) + self.count(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = find(root, x);
        int leftCount = count(node.left);
        int rightCount = count(node.right);
        int otherCount = n - 1 - leftCount - rightCount;

        return Math.max(leftCount, Math.max(rightCount, otherCount)) > n / 2;
    }

    // 定义：在以 root 为根的二叉树中搜索值为 x 的节点并返回
    TreeNode find(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return root;
        }
        // 去左子树找
        TreeNode left = find(root.left, x);
        if (left != null) {
            return left;
        }
        // 左子树找不到的话去右子树找
        return find(root.right, x);
    }

    // 定义：计算以 root 为根的二叉树的节点总数
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func btreeGameWinningMove(root *TreeNode, n int, x int) bool {
    node := find(root, x)
    leftCount := count(node.Left)
    rightCount := count(node.Right)
    otherCount := n - 1 - leftCount - rightCount

    return max(leftCount, max(rightCount, otherCount)) > n / 2
}

// 定义：在以 root 为根的二叉树中搜索值为 x 的节点并返回
func find(root *TreeNode, x int) *TreeNode {
    if root == nil {
        return nil
    }
    if root.Val == x {
        return root
    }
    // 去左子树找
    left := find(root.Left, x)
    if left != nil {
        return left
    }
    // 左子树找不到的话去右子树找
    return find(root.Right, x)
}

// 定义：计算以 root 为根的二叉树的节点总数
func count(root *TreeNode) int {
    if root == nil {
        return 0
    }
    return 1 + count(root.Left) + count(root.Right)
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

var btreeGameWinningMove = function(root, n, x) {
    // 定义：在以 root 为根的二叉树中搜索值为 x 的节点并返回
    var find = function(root, x) {
        if (root === null) {
            return null;
        }
        if (root.val === x) {
            return root;
        }
        // 去左子树找
        var left = find(root.left, x);
        if (left !== null) {
            return left;
        }
        // 左子树找不到的话去右子树找
        return find(root.right, x);
    };

    // 定义：计算以 root 为根的二叉树的节点总数
    var count = function(root) {
        if (root === null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    };

    var node = find(root, x);
    var leftCount = count(node.left);
    var rightCount = count(node.right);
    var otherCount = n - 1 - leftCount - rightCount;

    return Math.max(leftCount, Math.max(rightCount, otherCount)) > Math.floor(n / 2);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_binary-tree-coloring-game"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-coloring-game"></div></div>
</details><hr /><br />

</div>
</details>
</div>

