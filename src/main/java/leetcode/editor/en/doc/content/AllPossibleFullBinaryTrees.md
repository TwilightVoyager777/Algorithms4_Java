<p>Given an integer <code>n</code>, return <em>a list of all possible <strong>full binary trees</strong> with</em> <code>n</code> <em>nodes</em>. Each node of each tree in the answer must have <code>Node.val == 0</code>.</p>

<p>Each element of the answer is the root node of one possible tree. You may return the final list of trees in <strong>any order</strong>.</p>

<p>A <strong>full binary tree</strong> is a binary tree where each node has exactly <code>0</code> or <code>2</code> children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/22/fivetrees.png" style="width: 700px; height: 400px;" /> 
<pre>
<strong>Input:</strong> n = 7
<strong>Output:</strong> [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> [[0,0,0]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 20</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Dynamic Programming | Tree | Recursion | Memoization | Binary Tree</details><br>

<div>👍 5200, 👎 367<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

注意：国外和国内关于完全二叉树、满二叉树的定义有区别，我在 [二叉树基础知识](https://labuladong.online/algo/data-structure-basic/binary-tree-basic/) 有介绍。不过这些文学词汇并不重要，重要的是算法思维，所以我们按照题目说的来就好。

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。

如果你想生成一棵 `n` 个节点的满二叉树，首先要固定根节点，然后组装左右子树，根节点加上左右子树节点之和应该等于 `n`。

我们定义 `helper` 能够生成节点数为 `n` 的所有可能的二叉树，然后利用这个定义生成左右子树，然后通过子树组装出结果即可。

**详细题解**：
  - [【练习】用「分解问题」思维解题 I](https://labuladong.online/algo/problem-set/binary-tree-divide-i/)

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

#include <vector>
#include <list>

class Solution {
    // 备忘录，记录 n 个节点能够组合成的所有可能二叉树
    vector<list<TreeNode*>> memo;

public:
    vector<TreeNode*> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            // 题目描述的满二叉树不可能是偶数个节点
            return vector<TreeNode*>();
        }
        memo.resize(n + 1);
        return build(n);
    }

private:
    // 定义：输入一个 n，生成节点树为 n 的所有可能的满二叉树
    vector<TreeNode*> build(int n) {
        vector<TreeNode*> res;
        // base case
        if (n == 1) {
            res.push_back(new TreeNode(0));
            return res;
        }
        if (!memo[n].empty()) {
            // 避免冗余计算
            return vector<TreeNode*>(memo[n].begin(), memo[n].end());
        }

        // 递归生成所有符合条件的左右子树
        for (int i = 1; i < n; i += 2) {
            int j = n - i - 1;
            // 利用函数定义，生成左右子树
            vector<TreeNode*> leftSubTrees = build(i);
            vector<TreeNode*> rightSubTrees = build(j);
            // 左右子树的不同排列也能构成不同的二叉树
            for (TreeNode* left : leftSubTrees) {
                for (TreeNode* right : rightSubTrees) {
                    // 生成根节点
                    TreeNode* root = new TreeNode(0);
                    // 组装出一种可能的二叉树形状
                    root->left = left;
                    root->right = right;
                    // 加入结果列表
                    res.push_back(root);
                }
            }
        }
        // 存入备忘录
        memo[n] = list<TreeNode*>(res.begin(), res.end());
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
    # 备忘录，记录 n 个节点能够组合成的所有可能二叉树
    memo = {}

    def allPossibleFBT(self, n: int) -> List[TreeNode]:
        if n % 2 == 0:
            # 题目描述的满二叉树不可能是偶数个节点
            return []
        self.memo = {1: [TreeNode(0)]}
        return self.build(n)

    # 定义：输入一个 n，生成节点树为 n 的所有可能的满二叉树
    def build(self, n: int) -> List[TreeNode]:
        if n in self.memo:
            # 避免冗余计算
            return self.memo[n]
        res = []
        # base case
        if n == 1:
            return [TreeNode(0)]

        # 递归生成所有符合条件的左右子树
        for i in range(1, n, 2):
            j = n - i - 1
            # 利用函数定义，生成左右子树
            leftSubTrees = self.build(i)
            rightSubTrees = self.build(j)
            # 左右子树的不同排列也能构成不同的二叉树
            for left in leftSubTrees:
                for right in rightSubTrees:
                    # 生成根节点
                    root = TreeNode(0)
                    # 组装出一种可能的二叉树形状
                    root.left = left
                    root.right = right
                    # 加入结果列表
                    res.append(root)
        # 存入备忘录
        self.memo[n] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 备忘录，记录 n 个节点能够组合成的所有可能二叉树
    List<TreeNode>[] memo;

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            // 题目描述的满二叉树不可能是偶数个节点
            return new LinkedList<>();
        }
        memo = new LinkedList[n + 1];
        return build(n);
    }

    // 定义：输入一个 n，生成节点树为 n 的所有可能的满二叉树
    public List<TreeNode> build(int n) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (memo[n] != null) {
            // 避免冗余计算
            return memo[n];
        }

        // 递归生成所有符合条件的左右子树
        for (int i = 1; i < n; i += 2) {
            int j = n - i - 1;
            // 利用函数定义，生成左右子树
            List<TreeNode> leftSubTrees = build(i);
            List<TreeNode> rightSubTrees = build(j);
            // 左右子树的不同排列也能构成不同的二叉树
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    // 生成根节点
                    TreeNode root = new TreeNode(0);
                    // 组装出一种可能的二叉树形状
                    root.left = left;
                    root.right = right;
                    // 加入结果列表
                    res.add(root);
                }
            }
        }
        // 存入备忘录
        memo[n] = res;
        return res;
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type Solution struct {
    // 备忘录，记录 n 个节点能够组合成的所有可能二叉树
    memo map[int][]*TreeNode
}

func Constructor() Solution {
    return Solution{memo: make(map[int][]*TreeNode)}
}

func allPossibleFBT(n int) []*TreeNode {
    s := Constructor()
    return s.allPossibleFBT(n)
}

func (s *Solution) allPossibleFBT(n int) []*TreeNode {
    if n%2 == 0 {
        // 题目描述的满二叉树不可能是偶数个节点
        return []*TreeNode{}
    }
    return s.build(n)
}

// 定义：输入一个 n，生成节点树为 n 的所有可能的满二叉树
func (s *Solution) build(n int) []*TreeNode {
    var res []*TreeNode
    // base case
    if n == 1 {
        res = append(res, &TreeNode{Val: 0})
        return res
    }
    if res, found := s.memo[n]; found {
        // 避免冗余计算
        return res
    }

    // 递归生成所有符合条件的左右子树
    for i := 1; i < n; i += 2 {
        j := n - i - 1
        // 利用函数定义，生成左右子树
        leftSubTrees := s.build(i)
        rightSubTrees := s.build(j)
        // 左右子树的不同排列也能构成不同的二叉树
        for _, left := range leftSubTrees {
            for _, right := range rightSubTrees {
                // 生成根节点
                root := &TreeNode{Val: 0}
                // 组装出一种可能的二叉树形状
                root.Left = left
                root.Right = right
                // 加入结果列表
                res = append(res, root)
            }
        }
    }
    // 存入备忘录
    s.memo[n] = res
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var allPossibleFBT = function(n) {
    // 备忘录，记录 n 个节点能够组合成的所有可能二叉树
    let memo = new Array(n + 1).fill(null);

    // 定义：输入一个 n，生成节点树为 n 的所有可能的满二叉树
    var build = function(n) {
        let res = [];
        // base case
        if (n === 1) {
            res.push(new TreeNode(0));
            return res;
        }
        if (memo[n] !== null) {
            // 避免冗余计算
            return memo[n];
        }

        // 递归生成所有符合条件的左右子树
        for (let i = 1; i < n; i += 2) {
            let j = n - i - 1;
            // 利用函数定义，生成左右子树
            let leftSubTrees = build(i);
            let rightSubTrees = build(j);
            // 左右子树的不同排列也能构成不同的二叉树
            for (let left of leftSubTrees) {
                for (let right of rightSubTrees) {
                    // 生成根节点
                    let root = new TreeNode(0);
                    // 组装出一种可能的二叉树形状
                    root.left = left;
                    root.right = right;
                    // 加入结果列表
                    res.push(root);
                }
            }
        }
        // 存入备忘录
        memo[n] = res;
        return res;
    };

    if (n % 2 === 0) {
        // 题目描述的满二叉树不可能是偶数个节点
        return [];
    }
    return build(n);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_all-possible-full-binary-trees"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_all-possible-full-binary-trees"></div></div>
</details><hr /><br />

</div>
</details>
</div>

