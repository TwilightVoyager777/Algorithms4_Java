<p>Given an integer <code>n</code>, return <em>all the structurally unique <strong>BST'</strong>s (binary search trees), which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>. Return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" /> 
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> [[1]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 8</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Dynamic Programming | Backtracking | Tree | Binary Search Tree | Binary Tree</details><br>

<div>👍 7860, 👎 571<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part3/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

类似 [✨96. 不同的二叉搜索树](/problems/unique-binary-search-trees/)，这题的思路也是类似的，想要构造出所有合法 BST，分以下三步：

1、穷举 `root` 节点的所有可能。

2、递归构造出左右子树的所有合法 BST。

3、给 `root` 节点穷举所有左右子树的组合。

**详细题解**：
  - [二叉搜索树心法（构造篇）](https://labuladong.online/algo/data-structure/bst-part3/)

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
    // 主函数
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return vector<TreeNode*>{};
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    // 构造闭区间 [lo, hi] 组成的 BST
    vector<TreeNode*> build(int lo, int hi) {
        vector<TreeNode*> res;
        // base case
        if (lo > hi) {
            // 这里需要装一个 null 元素，这样才能让下面的两个内层 for 循环都能进入，正确地创建出叶子节点
            // 举例来说吧，什么时候会进到这个 if 语句？当你创建叶子节点的时候，对吧。
            // 那么如果你这里不加 null，直接返回空列表，那么下面的内层两个 for 循环都无法进入
            // 你的那个叶子节点就没有创建出来，看到了吗？所以这里要加一个 null，确保下面能把叶子节点做出来
            res.emplace_back(nullptr);
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有有效 BST。
            vector<TreeNode*> leftTree = build(lo, i - 1);
            vector<TreeNode*> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (auto left : leftTree) {
                for (auto right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode* root = new TreeNode(i);
                    root->left = left;
                    root->right = right;
                    res.emplace_back(root);
                }
            }
        }
        
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
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        # 构造闭区间 [1, n] 组成的 BST
        return self.build(1, n)

    # 构造闭区间 [lo, hi] 组成的 BST
    def build(self, lo: int, hi: int) -> List[TreeNode]:
        res = []
        # base case
        if lo > hi:
            # 这里需要装一个 null 元素，这样才能让下面的两个内层 for 循环都能进入，正确地创建出叶子节点
            # 举例来说吧，什么时候会进到这个 if 语句？当你创建叶子节点的时候，对吧。
            # 那么如果你这里不加 null，直接返回空列表，那么下面的内层两个 for 循环都无法进入
            # 你的那个叶子节点就没有创建出来，看到了吗？所以这里要加一个 null，确保下面能把叶子节点做出来
            res.append(None)
            return res

        # 1、穷举 root 节点的所有可能。
        for i in range(lo, hi + 1):
            # 2、递归构造出左右子树的所有有效 BST。
            leftTree = self.build(lo, i - 1)
            rightTree = self.build(i + 1, hi)
            # 3、给 root 节点穷举所有左右子树的组合。
            for left in leftTree:
                for right in rightTree:
                    # i 作为根节点 root 的值
                    root = TreeNode(i)
                    root.left = left
                    root.right = right
                    res.append(root)

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    // 构造闭区间 [lo, hi] 组成的 BST
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func generateTrees(n int) []*TreeNode {
    if n == 0 {
        return []*TreeNode{}
    }
    // 构造闭区间 [1, n] 组成的 BST
    return build(1, n)
}

// 构造闭区间 [lo, hi] 组成的 BST
func build(lo int, hi int) []*TreeNode {
    res := []*TreeNode{}
    // base case
    if lo > hi {
        // 这里需要装一个 null 元素，这样才能让下面的两个内层 for 循环都能进入，正确地创建出叶子节点
        // 举例来说吧，什么时候会进到这个 if 语句？当你创建叶子节点的时候，对吧。
        // 那么如果你这里不加 null，直接返回空列表，那么下面的内层两个 for 循环都无法进入
        // 你的那个叶子节点就没有创建出来，看到了吗？所以这里要加一个 null，确保下面能把叶子节点做出来
        res = append(res, nil)
        return res
    }

    // 1、穷举 root 节点的所有可能。
    for i := lo; i <= hi; i++ {
        // 2、递归构造出左右子树的所有有效 BST。
        leftTree := build(lo, i - 1)
        rightTree := build(i + 1, hi)
        // 3、给 root 节点穷举所有左右子树的组合。
        for _, left := range leftTree {
            for _, right := range rightTree {
                // i 作为根节点 root 的值
                root := &TreeNode{Val: i}
                root.Left = left
                root.Right = right
                res = append(res, root)
            }
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var generateTrees = function(n) {
    if (n === 0) return [];
    // 构造闭区间 [1, n] 组成的 BST
    return build(1, n);
};

// 构造闭区间 [lo, hi] 组成的 BST
var build = function(lo, hi) {
    let res = [];
    // base case
    if (lo > hi) {
        // 这里需要装一个 null 元素，这样才能让下面的两个内层 for 循环都能进入，正确地创建出叶子节点
        // 举例来说吧，什么时候会进到这个 if 语句？当你创建叶子节点的时候，对吧。
        // 那么如果你这里不加 null，直接返回空列表，那么下面的内层两个 for 循环都无法进入
        // 你的那个叶子节点就没有创建出来，看到了吗？所以这里要加一个 null，确保下面能把叶子节点做出来
        res.push(null);
        return res;
    }

    // 1、穷举 root 节点的所有可能。
    for (let i = lo; i <= hi; i++) {
        // 2、递归构造出左右子树的所有有效 BST。
        let leftTree = build(lo, i - 1);
        let rightTree = build(i + 1, hi);
        // 3、给 root 节点穷举所有左右子树的组合。
        for (let left of leftTree) {
            for (let right of rightTree) {
                // i 作为根节点 root 的值
                let root = new TreeNode(i);
                root.left = left;
                root.right = right;
                res.push(root);
            }
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_unique-binary-search-trees-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_unique-binary-search-trees-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

