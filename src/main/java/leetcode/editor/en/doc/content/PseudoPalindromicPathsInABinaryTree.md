<p>Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be <strong>pseudo-palindromic</strong> if at least one permutation of the node values in the path is a palindrome.</p>

<p><em>Return the number of <strong>pseudo-palindromic</strong> paths going from the root node to leaf nodes.</em></p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/05/06/palindromic_paths_1.png" style="width: 300px; height: 201px;" /></p>

<pre>
<strong>Input:</strong> root = [2,3,1,3,1,null,1]
<strong>Output:</strong> 2 
<strong>Explanation:</strong> The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/05/07/palindromic_paths_2.png" style="width: 300px; height: 314px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [2,1,1,1,3,null,null,null,null,null,1]
<strong>Output:</strong> 1 
<strong>Explanation:</strong> The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [9]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li> 
 <li><code>1 &lt;= Node.val &lt;= 9</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Bit Manipulation | Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 3319, 👎 131<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

遍历一遍二叉树就能得到每条路径上的数字，但这题的考点在于，如何判断一组数字是否存在一个回文串组合？

稍加思考不难想到：**如果一组数字中，只有最多一个数字出现的次数为奇数，剩余数字的出现次数均为偶数，那么这组数字可以组成一个回文串**。

题目说了 `1 <= root.val <= 9`，所以我们可以用一个大小为 10 的 `count` 数组做计数器来记录每条路径上的元素出现次数，到达叶子节点之后根据元素出现的次数判断是否可以构成回文串。

当然，我们也可以用更巧妙的位运算来实现上述逻辑：

1、首先用到异或运算的特性，1 ^ 1 = 0, 0 ^ 0 = 0, 1 ^ 0 = 1。

2、其次用到 `n & (n - 1)` 去除二进制最后一个 1 的技巧，详见 [东哥教你几招常用的位运算技巧](https://labuladong.online/algo/frequency-interview/bitwise-operation/)。

我同时实现了这两种方法，供你参考。

**详细题解**：
  - [【练习】用「遍历」思维解题 I](https://labuladong.online/algo/problem-set/binary-tree-traverse-i/)

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
    int pseudoPalindromicPaths(TreeNode* root) {
        traverse(root);
        return res;
    }
    
    // 计数数组，题目说了 1 <= root.val <= 9
    int count[10] = {0};
    int res = 0;

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        if (root->left == nullptr && root->right == nullptr) {
            // 遇到叶子节点，判断路径是否是伪回文串
            count[root->val]++;
            
            // 如果路径上出现奇数次的数字个数大于 1，
            // 则不可能组成回文串，反之则可以组成回文串
            int odd = 0;
            for (int n : count) {
                if (n % 2 == 1) {
                    odd++;
                }
            }
            if (odd <= 1) {
                res++;
            }
            count[root->val]--;
            return;
        }

        count[root->val]++;
        // 二叉树遍历框架
        traverse(root->left);
        traverse(root->right);

        count[root->val]--;
    }
};

// 用位运算代替数组计数，进一步提升效率
class Solution2 {
public:
    int pseudoPalindromicPaths(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 用位运算记录路径上的元素
    int count = 0;
    int res = 0;

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        if (root->left == nullptr && root->right == nullptr) {
            // 遇到叶子节点，判断路径是否是伪回文串
            count = count ^ (1 << root->val);
            
            // 判断二进制中只有一位 1，原理见 https://labuladong.online/algo/frequency-interview/bitwise-operation/
            if ((count & (count - 1)) == 0) {
                res++;
            }
            count = count ^ (1 << root->val);
            return;
        }
        count = count ^ (1 << root->val);
        // 二叉树遍历框架
        traverse(root->left);
        traverse(root->right);

        count = count ^ (1 << root->val);
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
        self.count = [0] * 10
        self.res = 0

    def pseudoPalindromicPaths(self, root: TreeNode) -> int:
        self.traverse(root)
        return self.res

    # 二叉树遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        if root.left is None and root.right is None:
            # 遇到叶子节点，判断路径是否是伪回文串
            self.count[root.val] += 1
            # 如果路径上出现奇数次的数字个数大于 1，
            # 则不可能组成回文串，反之则可以组成回文串
            odd = 0
            for n in self.count:
                if n % 2 == 1:
                    odd += 1
            if odd <= 1:
                self.res += 1
            self.count[root.val] -= 1
            return

        self.count[root.val] += 1
        # 二叉树遍历框架
        self.traverse(root.left)
        self.traverse(root.right)

        self.count[root.val] -= 1

# 用位运算代替数组计数，进一步提升效率
class Solution2:
    def __init__(self):
        self.count = 0
        self.res = 0

    def pseudoPalindromicPaths(self, root: TreeNode) -> int:
        self.traverse(root)
        return self.res

    # 二叉树遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        if root.left is None and root.right is None:
            # 遇到叶子节点，判断路径是否是伪回文串
            self.count ^= (1 << root.val)
            # 判断二进制中只有一位 1，原理见 https://labuladong.online/algo/frequency-interview/bitwise-operation/
            if (self.count & (self.count - 1)) == 0:
                self.res += 1
            self.count ^= (1 << root.val)
            return
        self.count ^= (1 << root.val)
        # 二叉树遍历框架
        self.traverse(root.left)
        self.traverse(root.right)

        self.count ^= (1 << root.val)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return res;
    }
    // 计数数组，题目说了 1 <= root.val <= 9
    int[] count = new int[10];
    int res = 0;

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 遇到叶子节点，判断路径是否是伪回文串
            count[root.val]++;
            // 如果路径上出现奇数次的数字个数大于 1，
            // 则不可能组成回文串，反之则可以组成回文串
            int odd = 0;
            for (int n : count) {
                if (n % 2 == 1) {
                    odd++;
                }
            }
            if (odd <= 1) {
                res++;
            }
            count[root.val]--;
            return;
        }

        count[root.val]++;
        // 二叉树遍历框架
        traverse(root.left);
        traverse(root.right);

        count[root.val]--;
    }
}

// 用位运算代替数组计数，进一步提升效率
class Solution2 {
    public int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return res;
    }

    // 用位运算记录路径上的元素
    int count = 0;
    int res = 0;

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 遇到叶子节点，判断路径是否是伪回文串
            count = count ^ (1 << root.val);
            // 判断二进制中只有一位 1，原理见 https://labuladong.online/algo/frequency-interview/bitwise-operation/
            if ((count & (count - 1)) == 0) {
                res++;
            }
            count = count ^ (1 << root.val);
            return;
        }
        count = count ^ (1 << root.val);
        // 二叉树遍历框架
        traverse(root.left);
        traverse(root.right);

        count = count ^ (1 << root.val);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// Solution 1
func pseudoPalindromicPaths(root *TreeNode) int {
    // 计数数组，题目说了 1 <= root.val <= 9
    var res int
    count := make([]int, 10)
    traverse(root, count, &res)
    return res
}

// 二叉树遍历函数
func traverse(root *TreeNode, count []int, res *int) {
    if root == nil {
        return
    }
    if root.Left == nil && root.Right == nil {
        // 遇到叶子节点，判断路径是否是伪回文串
        count[root.Val]++
        // 如果路径上出现奇数次的数字个数大于 1，
        // 则不可能组成回文串，反之则可以组成回文串
        odd := 0
        for _, n := range count {
            if n%2 == 1 {
                odd++
            }
        }
        if odd <= 1 {
            *res++
        }
        count[root.Val]--
        return
    }

    count[root.Val]++
    // 二叉树遍历框架
    traverse(root.Left, count, res)
    traverse(root.Right, count, res)

    count[root.Val]--
}

// Solution 2
func pseudoPalindromicPaths2(root *TreeNode) int {
    // 用位运算代替数组计数，进一步提升效率
    var res int
    // 用位运算记录路径上的元素
    var count int
    traverse2(root, &count, &res)
    return res
}

// 二叉树遍历函数
func traverse2(root *TreeNode, count *int, res *int) {
    if root == nil {
        return
    }
    if root.Left == nil && root.Right == nil {
        // 遇到叶子节点，判断路径是否是伪回文串
        *count ^= 1 << root.Val
        // 判断二进制中只有一位 1，原理见 https://labuladong.online/algo/frequency-interview/bitwise-operation/
        if *count & (*count - 1) == 0 {
            *res++
        }
        *count ^= 1 << root.Val
        return
    }
    *count ^= 1 << root.Val
    // 二叉树遍历框架
    traverse2(root.Left, count, res)
    traverse2(root.Right, count, res)

    *count ^= 1 << root.Val
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var pseudoPalindromicPaths = function(root) {
    // 计数数组，题目说了 1 <= root.val <= 9
    let count = new Array(10).fill(0);
    let res = 0;

    // 二叉树遍历函数
    var traverse = function(root) {
        if (root === null) {
            return;
        }
        if (root.left === null && root.right === null) {
            // 遇到叶子节点，判断路径是否是伪回文串
            count[root.val]++;
            // 如果路径上出现奇数次的数字个数大于 1，
            // 则不可能组成回文串，反之则可以组成回文串
            let odd = 0;
            for (let n of count) {
                if (n % 2 === 1) {
                    odd++;
                }
            }
            if (odd <= 1) {
                res++;
            }
            count[root.val]--;
            return;
        }

        count[root.val]++;
        // 二叉树遍历框架
        traverse(root.left);
        traverse(root.right);

        count[root.val]--;
    }

    traverse(root);
    return res;
};

// 用位运算代替数组计数，进一步提升效率
var pseudoPalindromicPaths2 = function(root) {
    // 用位运算记录路径上的元素
    let count = 0;
    let res = 0;

    // 二叉树遍历函数
    var traverse = function(root) {
        if (root === null) {
            return;
        }
        if (root.left === null && root.right === null) {
            // 遇到叶子节点，判断路径是否是伪回文串
            count = count ^ (1 << root.val);
            // 判断二进制中只有一位 1，原理见 https://labuladong.online/algo/frequency-interview/bitwise-operation/
            if ((count & (count - 1)) === 0) {
                res++;
            }
            count = count ^ (1 << root.val);
            return;
        }
        count = count ^ (1 << root.val);
        // 二叉树遍历框架
        traverse(root.left);
        traverse(root.right);

        count = count ^ (1 << root.val);
    }

    traverse(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_pseudo-palindromic-paths-in-a-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_pseudo-palindromic-paths-in-a-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

