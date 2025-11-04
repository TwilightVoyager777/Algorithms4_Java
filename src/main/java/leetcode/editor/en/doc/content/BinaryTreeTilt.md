<p>Given the <code>root</code> of a binary tree, return <em>the sum of every tree node's <strong>tilt</strong>.</em></p>

<p>The <strong>tilt</strong> of a tree node is the <strong>absolute difference</strong> between the sum of all left subtree node <strong>values</strong> and all right subtree node <strong>values</strong>. If a node does not have a left child, then the sum of the left subtree node <strong>values</strong> is treated as <code>0</code>. The rule is similar if the node does not have a right child.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/20/tilt1.jpg" style="width: 712px; height: 182px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
Tilt of node 2 : |0-0| = 0 (no children)
Tilt of node 3 : |0-0| = 0 (no children)
Tilt of node 1 : |2-3| = 1 (left subtree is just left child, so sum is 2; right subtree is just right child, so sum is 3)
Sum of every tilt : 0 + 0 + 1 = 1
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/20/tilt2.jpg" style="width: 800px; height: 203px;" /> 
<pre>
<strong>Input:</strong> root = [4,2,9,3,5,null,7]
<strong>Output:</strong> 15
<strong>Explanation:</strong> 
Tilt of node 3 : |0-0| = 0 (no children)
Tilt of node 5 : |0-0| = 0 (no children)
Tilt of node 7 : |0-0| = 0 (no children)
Tilt of node 2 : |3-5| = 2 (left subtree is just left child, so sum is 3; right subtree is just right child, so sum is 5)
Tilt of node 9 : |0-7| = 7 (no left child, so sum is 0; right subtree is just right child, so sum is 7)
Tilt of node 4 : |(3+5+2)-(9+7)| = |10-16| = 6 (left subtree values are 3, 5, and 2, which sums to 10; right subtree values are 9 and 7, which sums to 16)
Sum of every tilt : 0 + 0 + 0 + 2 + 7 + 6 = 15
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/20/tilt3.jpg" style="width: 800px; height: 293px;" /> 
<pre>
<strong>Input:</strong> root = [21,7,14,1,1,2,2,3,3]
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 2354, 👎 2245<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这里要用到前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过的后序位置的妙用。

`sum` 函数记录二叉树的节点之和，在后序位置顺便计算二叉树的「坡度」即可。

**详细题解**：
  - [【练习】利用后序位置解题 I](https://labuladong.online/algo/problem-set/binary-tree-post-order-i/)

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
    int findTilt(TreeNode* root) {
        sum(root);
        return res;
    }

private:
    int res = 0;

    // 定义：输入一棵二叉树，返回这棵二叉树所有元素的和
    int sum(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }

        int leftSum = sum(root->left);
        int rightSum = sum(root->right);
        // 后序位置
        res += abs(leftSum - rightSum);
        return leftSum + rightSum + root->val;
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
        self.res = 0

    # 定义：输入一棵二叉树，返回这棵二叉树所有元素的和
    def sum(self, root: TreeNode) -> int:
        if root is None:
            return 0

        left_sum = self.sum(root.left)
        right_sum = self.sum(root.right)
        # 后序位置
        self.res += abs(left_sum - right_sum)
        return left_sum + right_sum + root.val

    def findTilt(self, root: TreeNode) -> int:
        self.sum(root)
        return self.res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findTilt(TreeNode root) {
        sum(root);
        return res;
    }

    int res = 0;

    // 定义：输入一棵二叉树，返回这棵二叉树所有元素的和
    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        // 后序位置
        res += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func findTilt(root *TreeNode) int {
    var res int
    sum(root, &res)
    return res
}

// 定义：输入一棵二叉树，返回这棵二叉树所有元素的和
func sum(root *TreeNode, res *int) int {
    if root == nil {
        return 0
    }

    leftSum := sum(root.Left, res)
    rightSum := sum(root.Right, res)
    // 后序位置
    *res += abs(leftSum - rightSum)
    return leftSum + rightSum + root.Val
}

func abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var findTilt = function(root) {
    let res = 0;

    // 定义：输入一棵二叉树，返回这棵二叉树所有元素的和
    function sum(root) {
        if (root === null) {
            return 0;
        }

        let leftSum = sum(root.left);
        let rightSum = sum(root.right);
        // 后序位置
        res += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

    sum(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_binary-tree-tilt"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-tilt"></div></div>
</details><hr /><br />

</div>
</details>
</div>



