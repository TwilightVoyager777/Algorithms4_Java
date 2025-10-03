<p>Given a <strong>binary tree</strong> <code>root</code>, return <em>the maximum sum of all keys of <strong>any</strong> sub-tree which is also a Binary Search Tree (BST)</em>.</p>

<p>Assume a BST is defined as follows:</p>

<ul> 
 <li>The left subtree of a node contains only nodes with keys <strong>less than</strong> the node's key.</li> 
 <li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node's key.</li> 
 <li>Both the left and right subtrees must also be binary search trees.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/01/30/sample_1_1709.png" style="width: 320px; height: 250px;" /></p>

<pre>
<strong>Input:</strong> root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
<strong>Output:</strong> 20
<strong>Explanation:</strong> Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/01/30/sample_2_1709.png" style="width: 134px; height: 180px;" /></p>

<pre>
<strong>Input:</strong> root = [4,3,null,1,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [-4,-2,-5]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All values are negatives. Return an empty BST.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 4 * 10<sup>4</sup>]</code>.</li> 
 <li><code>-4 * 10<sup>4</sup> &lt;= Node.val &lt;= 4 * 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Dynamic Programming | Tree | Depth-First Search | Binary Search Tree | Binary Tree</details><br>

<div>👍 2888, 👎 198<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part4/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

二叉树相关题目最核心的思路是明确当前节点需要做的事情是什么，那么我们想计算子树中 BST 的最大和，站在当前节点的视角，需要做什么呢？

1、我肯定得知道左右子树是不是合法的 BST，如果这俩儿子有一个不是 BST，以我为根的这棵树肯定不会是 BST，对吧。

2、如果左右子树都是合法的 BST，我得瞅瞅左右子树加上自己还是不是合法的 BST 了。因为按照 BST 的定义，当前节点的值应该大于左子树的最大值，小于右子树的最小值，否则就破坏了 BST 的性质。

3、因为题目要计算最大的节点之和，如果左右子树加上我自己还是一棵合法的 BST，也就是说以我为根的整棵树是一棵 BST，那我需要知道我们这棵 BST 的所有节点值之和是多少，方便和别的 BST 争个高下，对吧。

简单说就是要知道以下具体信息：

1、左右子树是否是 BST。

2、左子树的最大值和右子树的最小值。

3、左右子树的节点值之和。

想要获得子树的信息，就要用到前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过的后序位置的妙用了。

我们定义一个 `findMaxMinSum` 函数，`findMaxMinSum(root)` 返回一个大小为 4 的 int 数组，我们暂且称它为 `res`，其中：

`res[0]` 记录以 `root` 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；

`res[1]` 记录以 `root` 为根的二叉树所有节点中的最小值；

`res[2]` 记录以 `root` 为根的二叉树所有节点中的最大值；

`res[3]` 记录以 `root` 为根的二叉树所有节点值之和。

按照上述思路理解代码。

**详细题解**：
  - [二叉搜索树心法（后序篇）](https://labuladong.online/algo/data-structure/bst-part4/)

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
    // 全局变量，记录 BST 最大节点之和
    int maxSum = 0;

public:
    // 主函数
    int maxSumBST(TreeNode* root) {
        findMaxMinSum(root);
        return maxSum;
    }

    vector<int> findMaxMinSum(TreeNode* root) {
        // base case
        if (root == nullptr) {
            return vector<int>{
                1, INT_MAX, INT_MIN, 0
            };
        }

        // 递归计算左右子树
        vector<int> left = findMaxMinSum(root->left);
        vector<int> right = findMaxMinSum(root->right);

        // ******后序遍历位置******
        vector<int> res(4);
        // 这个 if 在判断以 root 为根的二叉树是不是 BST
        if (left[0] == 1 && right[0] == 1 &&
                root->val > left[2] && root->val < right[1]) {
            // 以 root 为根的二叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = min(left[1], root->val);
            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = max(right[2], root->val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root->val;
            // 更新全局变量
            maxSum = max(maxSum, res[3]);
        } else {
            // 以 root 为根的二叉树不是 BST
            res[0] = 0;
            // 其他的值都没必要计算了，因为用不到
        }
        // ************************

        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 全局变量，记录 BST 最大节点之和
    def __init__(self):
        self.maxSum = 0

    # 主函数
    def maxSumBST(self, root: TreeNode) -> int:
        self.findMaxMinSum(root)
        return self.maxSum

    def findMaxMinSum(self, root: TreeNode) -> list:
        # base case
        if root is None:
            return [1, float('inf'), float('-inf'), 0]

        # 递归计算左右子树
        left = self.findMaxMinSum(root.left)
        right = self.findMaxMinSum(root.right)

        # ******后序遍历位置******
        res = [0] * 4
        # 这个 if 在判断以 root 为根的二叉树是不是 BST
        if left[0] == 1 and right[0] == 1 and root.val > left[2] and root.val < right[1]:
            # 以 root 为根的二叉树是 BST
            res[0] = 1
            # 计算以 root 为根的这棵 BST 的最小值
            res[1] = min(left[1], root.val)
            # 计算以 root 为根的这棵 BST 的最大值
            res[2] = max(right[2], root.val)
            # 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root.val
            # 更新全局变量
            self.maxSum = max(self.maxSum, res[3])
        else:
            # 以 root 为根的二叉树不是 BST
            res[0] = 0
            # 其他的值都没必要计算了，因为用不到
        # ************************

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 全局变量，记录 BST 最大节点之和
    int maxSum = 0;

    // 主函数
    public int maxSumBST(TreeNode root) {
        findMaxMinSum(root);
        return maxSum;
    }

    int[] findMaxMinSum(TreeNode root) {
        // base case
        if (root == null) {
            return new int[] {
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }

        // 递归计算左右子树
        int[] left = findMaxMinSum(root.left);
        int[] right = findMaxMinSum(root.right);

        // ******后序遍历位置******
        int[] res = new int[4];
        // 这个 if 在判断以 root 为根的二叉树是不是 BST
        if (left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]) {
            // 以 root 为根的二叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 以 root 为根的二叉树不是 BST
            res[0] = 0;
            // 其他的值都没必要计算了，因为用不到
        }
        // ************************

        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 主函数
func maxSumBST(root *TreeNode) int {
    // 全局变量，记录 BST 最大节点之和
    maxSum := 0
    findMaxMinSum(root, &maxSum)
    return maxSum
}

func findMaxMinSum(root *TreeNode, maxSum *int) []int {
    // base case
    if root == nil {
        return []int{1, math.MaxInt32, math.MinInt32, 0}
    }

    // 递归计算左右子树
    left := findMaxMinSum(root.Left, maxSum)
    right := findMaxMinSum(root.Right, maxSum)

    // ******后序遍历位置******
    res := make([]int, 4)
    // 这个 if 在判断以 root 为根的二叉树是不是 BST
    if left[0] == 1 && right[0] == 1 && 
        root.Val > left[2] && root.Val < right[1] {
        // 以 root 为根的二叉树是 BST
        res[0] = 1
        // 计算以 root 为根的这棵 BST 的最小值
        res[1] = min(left[1], root.Val)
        // 计算以 root 为根的这棵 BST 的最大值
        res[2] = max(right[2], root.Val)
        // 计算以 root 为根的这棵 BST 所有节点之和
        res[3] = left[3] + right[3] + root.Val
        // 更新全局变量
        *maxSum = max(*maxSum, res[3])
    } else {
        // 以 root 为根的二叉树不是 BST
        res[0] = 0
        // 其他的值都没必要计算了，因为用不到
    }
    // ************************

    return res
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
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

var maxSumBST = function(root) {
    // 全局变量，记录 BST 最大节点之和
    let maxSum = 0;

    // 主函数
    var findMaxMinSum = function(root) {
        // base case
        if (root === null) {
            return [1, Infinity, -Infinity, 0];
        }

        // 递归计算左右子树
        let left = findMaxMinSum(root.left);
        let right = findMaxMinSum(root.right);

        // ******后序遍历位置******
        let res = new Array(4);

        // 这个 if 在判断以 root 为根的二叉树是不是 BST
        if (left[0] === 1 && right[0] === 1 &&
            root.val > left[2] && root.val < right[1]) {
            // 以 root 为根的二叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 以 root 为根的二叉树不是 BST
            res[0] = 0;
            // 其他的值都没必要计算了，因为用不到
        }
        // ************************

        return res;
    };

    findMaxMinSum(root);
    return maxSum;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_maximum-sum-bst-in-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_maximum-sum-bst-in-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

