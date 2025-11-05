<p>Given the <code>root</code> of a binary tree, find the maximum value <code>v</code> for which there exist <strong>different</strong> nodes <code>a</code> and <code>b</code> where <code>v = |a.val - b.val|</code> and <code>a</code> is an ancestor of <code>b</code>.</p>

<p>A node <code>a</code> is an ancestor of <code>b</code> if either: any child of <code>a</code> is equal to <code>b</code>&nbsp;or any child of <code>a</code> is an ancestor of <code>b</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree.jpg" style="width: 400px; height: 390px;" /> 
<pre>
<strong>Input:</strong> root = [8,3,10,1,6,null,14,null,null,4,7,13]
<strong>Output:</strong> 7
<strong>Explanation: </strong>We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree-1.jpg" style="width: 250px; height: 349px;" /> 
<pre>
<strong>Input:</strong> root = [1,null,2,null,0,3]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[2, 5000]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 5068, 👎 169<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题要用到 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 中强调的二叉树后序位置的特殊性。

站在某个节点，你如何判断以这个节点为根的二叉树中的最大差值？换句话说，你需要知道哪些信息，才能算出来这个最大差值？

思考这个问题很有必要，你必须先知道怎么算，才能写递归函数去实现你的思路。

这个问题的答案是，每个节点需要知道左右子树的最小值和最大值，然后就能算出「以自己为祖先」的最大差值。

每个节点都知道以自己为祖先的最大差值，那么所有这些差值中最大的那个就是整棵树的最大差值，这个取最大值的过程需要在后序遍历的位置进行，直接看解法代码理解吧。

**详细题解**：
  - [【练习】利用后序位置解题 II](https://labuladong.online/algo/problem-set/binary-tree-post-order-ii/)

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
    int maxAncestorDiff(TreeNode* root) {
        getMinMax(root);
        return res;
    }

private:
    int res = 0;

    // 定义：输入一棵二叉树，返回该二叉树中节点的最小值和最大值，
    // 第一个元素是最小值，第二个值是最大值
    vector<int> getMinMax(TreeNode* root) {
        if (root == nullptr) {
            return {INT_MAX, INT_MIN};
        }
        vector<int> leftMinMax = getMinMax(root->left);
        vector<int> rightMinMax = getMinMax(root->right);
        // 以 root 为根的这棵树的最大值和最小值可以通过左右子树的最大最小值推导出来
        int rootMin = min({root->val, leftMinMax[0], rightMinMax[0]});
        int rootMax = max({root->val, leftMinMax[1], rightMinMax[1]});
        // 在后序位置顺便判断所有差值的最大值
        res = max({res, rootMax - root->val, root->val - rootMin});

        return {rootMin, rootMax};
    }

    int min(initializer_list<int> vals) {
        return *min_element(vals.begin(), vals.end());
    }

    int max(initializer_list<int> vals) {
        return *max_element(vals.begin(), vals.end());
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def maxAncestorDiff(self, root: TreeNode) -> int:
        self.getMinMax(root)
        return self.res

    res = 0

    # 定义：输入一棵二叉树，返回该二叉树中节点的最小值和最大值，
    # 第一个元素是最小值，第二个值是最大值
    def getMinMax(self, root: TreeNode) -> List[int]:
        if root is None:
            return [float('inf'), float('-inf')]
        leftMinMax = self.getMinMax(root.left)
        rightMinMax = self.getMinMax(root.right)
        # 以 root 为根的这棵树的最大值和最小值可以通过左右子树的最大最小值推导出来
        rootMin = min(root.val, leftMinMax[0], rightMinMax[0])
        rootMax = max(root.val, leftMinMax[1], rightMinMax[1])
        # 在后序位置顺便判断所有差值的最大值
        self.res = max(self.res, rootMax - root.val, root.val - rootMin)

        return [rootMin, rootMax]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        getMinMax(root);
        return res;
    }

    int res = 0;

    // 定义：输入一棵二叉树，返回该二叉树中节点的最小值和最大值，
    // 第一个元素是最小值，第二个值是最大值
    int[] getMinMax(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] leftMinMax = getMinMax(root.left);
        int[] rightMinMax = getMinMax(root.right);
        // 以 root 为根的这棵树的最大值和最小值可以通过左右子树的最大最小值推导出来
        int rootMin = min(root.val, leftMinMax[0], rightMinMax[0]);
        int rootMax = max(root.val, leftMinMax[1], rightMinMax[1]);
        // 在后序位置顺便判断所有差值的最大值
        res = max(res, rootMax - root.val, root.val - rootMin);

        return new int[]{rootMin, rootMax};
    }

    int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func maxAncestorDiff(root *TreeNode) int {
    res := 0
    getMinMax(root, &res)
    return res
}

// 定义：输入一棵二叉树，返回该二叉树中节点的最小值和最大值，
// 第一个元素是最小值，第二个值是最大值
func getMinMax(root *TreeNode, res *int) (int, int) {
    if root == nil {
        return int(^uint(0) >> 1), -int(^uint(0) >> 1) - 1 // Integer.MAX_VALUE, Integer.MIN_VALUE in Go
    }
    leftMin, leftMax := getMinMax(root.Left, res)
    rightMin, rightMax := getMinMax(root.Right, res)
    // 以 root 为根的这棵树的最大值和最小值可以通过左右子树的最大最小值推导出来
    rootMin := min(root.Val, leftMin, rightMin)
    rootMax := max(root.Val, leftMax, rightMax)
    // 在后序位置顺便判断所有差值的最大值
    *res = max(*res, rootMax-root.Val, root.Val-rootMin)

    return rootMin, rootMax
}

func min(a, b, c int) int {
    if a < b {
        if a < c {
            return a
        }
        return c
    }
    if b < c {
        return b
    }
    return c
}

func max(a, b, c int) int {
    if a > b {
        if a > c {
            return a
        }
        return c
    }
    if b > c {
        return b
    }
    return c
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var maxAncestorDiff = function(root) {
    let res = 0;

    // 定义：输入一棵二叉树，返回该二叉树中节点的最小值和最大值，
    // 第一个元素是最小值，第二个值是最大值
    function getMinMax(root) {
        if (root === null) {
            return [Number.MAX_VALUE, Number.MIN_VALUE];
        }
        let leftMinMax = getMinMax(root.left);
        let rightMinMax = getMinMax(root.right);
        // 以 root 为根的这棵树的最大值和最小值可以通过左右子树的最大最小值推导出来
        let rootMin = Math.min(root.val, leftMinMax[0], rightMinMax[0]);
        let rootMax = Math.max(root.val, leftMinMax[1], rightMinMax[1]);
        // 在后序位置顺便判断所有差值的最大值
        res = Math.max(res, rootMax - root.val, root.val - rootMin);

        return [rootMin, rootMax];
    }

    function min(a, b, c) {
        return Math.min(Math.min(a, b), c);
    }

    function max(a, b, c) {
        return Math.max(Math.max(a, b), c);
    }

    getMinMax(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_maximum-difference-between-node-and-ancestor"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_maximum-difference-between-node-and-ancestor"></div></div>
</details><hr /><br />

</div>
</details>
</div>

