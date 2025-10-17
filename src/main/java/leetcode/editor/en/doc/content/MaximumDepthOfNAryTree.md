<p>Given a n-ary tree, find its maximum depth.</p>

<p>The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p><em>Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).</em></p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png" style="width: 296px; height: 241px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The total number of nodes is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li>The depth of the n-ary tree is less than or equal to <code>1000</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search</details><br>

<div>👍 2850, 👎 95<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题可以同时使用两种思维模式，我把两种解法都写一下。

可以对照 [✔ ✨104. 二叉树的最大深度](/problems/maximum-depth-of-binary-tree/) 题的解法。

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

// 分解问题的思路
class Solution {
public:
    int maxDepth(Node* root) {
        if (root == nullptr) {
            return 0;
        }
        int subTreeMaxDepth = 0;
        for (Node* child : root->children) {
            subTreeMaxDepth = std::max(subTreeMaxDepth, maxDepth(child));
        }
        return 1 + subTreeMaxDepth;
    }
};

// 遍历的思路
class Solution2 {
public:
    int maxDepth(Node* root) {
        traverse(root);
        return res;
    }

private:
    // 记录递归遍历到的深度
    int depth = 0;
    // 记录最大的深度
    int res = 0;

    void traverse(Node* root) {
        if (root == nullptr) {
            return;
        }
        // 前序遍历位置
        depth++;
        res = std::max(res, depth);

        for (Node* child : root->children) {
            traverse(child);
        }
        // 后序遍历位置
        depth--;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 分解问题的思路
class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if root is None:
            return 0
        subTreeMaxDepth = 0
        for child in root.children:
            subTreeMaxDepth = max(subTreeMaxDepth, self.maxDepth(child))
        return 1 + subTreeMaxDepth

# 遍历的思路
class Solution2:
    def __init__(self):
        # 记录递归遍历到的深度
        self.depth = 0
        # 记录最大的深度
        self.res = 0

    def maxDepth(self, root: 'Node') -> int:
        self.traverse(root)
        return self.res

    def traverse(self, root: 'Node'):
        if root is None:
            return
        # 前序遍历位置
        self.depth += 1
        self.res = max(self.res, self.depth)

        for child in root.children:
            self.traverse(child)
        # 后序遍历位置
        self.depth -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 分解问题的思路
class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int subTreeMaxDepth = 0;
        for (Node child : root.children) {
            subTreeMaxDepth = Math.max(subTreeMaxDepth, maxDepth(child));
        }
        return 1 + subTreeMaxDepth;
    }
}

// 遍历的思路
class Solution2 {
    public int maxDepth(Node root) {
        traverse(root);
        return res;
    }

    // 记录递归遍历到的深度
    int depth = 0;
    // 记录最大的深度
    int res = 0;

    void traverse(Node root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        depth++;
        res = Math.max(res, depth);

        for (Node child : root.children) {
            traverse(child);
        }
        // 后序遍历位置
        depth--;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 分解问题的思路
func maxDepth(root *Node) int {
    if root == nil {
        return 0
    }
    subTreeMaxDepth := 0
    for _, child := range root.Children {
        subTreeMaxDepth = max(subTreeMaxDepth, maxDepth(child))
    }
    return 1 + subTreeMaxDepth
}

// 遍历的思路
func maxDepthTraversal(root *Node) int {
    var res int
    traverse(root, 0, &res)
    return res
}

// 记录递归遍历到的深度
// 记录最大的深度
func traverse(root *Node, depth int, res *int) {
    if root == nil {
        return
    }
    // 前序遍历位置
    currentDepth := depth + 1
    *res = max(*res, currentDepth)

    for _, child := range root.Children {
        traverse(child, currentDepth, res)
    }
    // 后序遍历位置
    // Note: In Go, there's no need to manually decrease the depth as it's not stored in a global variable.
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 分解问题的思路
var maxDepth = function(root) {
    if (root === null) {
        return 0;
    }
    let subTreeMaxDepth = 0;
    for (let child of root.children) {
        subTreeMaxDepth = Math.max(subTreeMaxDepth, maxDepth(child));
    }
    return 1 + subTreeMaxDepth;
};

// 遍历的思路
var maxDepth2 = function(root) {
    // 记录递归遍历到的深度
    let depth = 0;
    // 记录最大的深度
    let res = 0;

    var traverse = function(root) {
        if (root === null) {
            return;
        }
        // 前序遍历位置
        depth++;
        res = Math.max(res, depth);

        for (let child of root.children) {
            traverse(child);
        }
        // 后序遍历位置
        depth--;
    };

    traverse(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_maximum-depth-of-n-ary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_maximum-depth-of-n-ary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

