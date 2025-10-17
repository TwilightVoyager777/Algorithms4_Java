<p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>all <strong>root-to-leaf</strong> paths where the sum of the node values in the path equals </em><code>targetSum</code><em>. Each path should be returned as a list of the node <strong>values</strong>, not node references</em>.</p>

<p>A <strong>root-to-leaf</strong> path is a path starting from the root and ending at any leaf node. A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg" style="width: 500px; height: 356px;" /> 
<pre>
<strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>Output:</strong> [[5,4,11,2],[5,8,4,5]]
<strong>Explanation:</strong> There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" style="width: 212px; height: 181px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3], targetSum = 5
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2], targetSum = 0
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
 <li><code>-1000 &lt;= targetSum &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Backtracking | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 8458, 👎 168<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题可以同时运用两种思维。

遍历的思维很简单，只要遍历一遍二叉树，就可以把所有符合条件的路径找出来。为了维护经过的路径，在进入递归的时候要在 `path` 列表添加节点，结束递归的时候删除节点，类似 [回溯算法](https://labuladong.online/algo/essential-technique/backtrack-framework/)。

分解问题的思路也不难，你计算以 `root` 为根的二叉树中和为 `sum` 的路径，不就可以分解成计算以 `root.left, root.right` 为根的二叉树中所有和为 `sum - root.val` 的路径，然后再加上 `root` 节点吗？

我这里同时写出了遍历思路和分解问题思路的解法，供大家参考。

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

class Solution {
    vector<vector<int>> res;

public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if (root == nullptr) return res;
        traverse(root, sum, vector<int>());
        return res;
    }

private:
    // 遍历二叉树
    void traverse(TreeNode* root, int sum, vector<int> path) {
        if (root == nullptr) return;

        int remain = sum - root->val;

        if (root->left == nullptr && root->right == nullptr) {
            if (remain == 0) {
                // 找到一条路径
                path.push_back(root->val);
                res.push_back(path);
                path.pop_back();
            }
            return;
        }

        // 维护路径列表
        path.push_back(root->val);
        traverse(root->left, remain, path);
        path.pop_back();

        path.push_back(root->val);
        traverse(root->right, remain, path);
        path.pop_back();
    }
};

// 分解问题的思维模式
class Solution2 {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> rootAnswers;
        if (root == nullptr) {
            return rootAnswers;
        }

        // 如果是叶子节点并且值等于 targetSum，则找到一条路径
        if (root->left == nullptr && root->right == nullptr && root->val == targetSum) {
            vector<int> path;
            path.push_back(root->val);
            rootAnswers.push_back(path);
            return rootAnswers;
        }

        // 分别递归左右子树，找到子树中和为 targetSum - root.val 的路径
        vector<vector<int>> leftAnswers = pathSum(root->left, targetSum - root->val);
        vector<vector<int>> rightAnswers = pathSum(root->right, targetSum - root->val);

        // 左右子树的路径加上根节点，就是和为 targetSum 的路径
        for (auto& answer : leftAnswers) {
            // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.insert(answer.begin(), root->val);
            rootAnswers.push_back(answer);
        }
        for (auto& answer : rightAnswers) {
            // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.insert(answer.begin(), root->val);
            rootAnswers.push_back(answer);
        }

        return rootAnswers;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

from typing import List, Optional
from collections import deque

class Solution:
    def __init__(self):
        self.res = []

    def pathSum(self, root: Optional[TreeNode], sum: int) -> List[List[int]]:
        if root is None:
            return self.res
        self.traverse(root, sum, deque())
        return self.res

    # 遍历二叉树
    def traverse(self, root: Optional[TreeNode], sum: int, path: deque) -> None:
        if root is None:
            return

        remain = sum - root.val

        if root.left is None and root.right is None:
            if remain == 0:
                # 找到一条路径
                path.append(root.val)
                self.res.append(list(path))
                path.pop()
            return

        # 维护路径列表
        path.append(root.val)
        self.traverse(root.left, remain, path)
        path.pop()

        path.append(root.val)
        self.traverse(root.right, remain, path)
        path.pop()

# 分解问题的思维模式
class Solution2:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        if root is None:
            return self.res
        
        # 如果是叶子节点并且值等于 targetSum，则找到一条路径
        if root.left is None and root.right is None and root.val == targetSum:
            return [[root.val]]

        # 分别递归左右子树，找到子树中和为 targetSum - root.val 的路径
        left_answers = self.pathSum(root.left, targetSum - root.val)
        right_answers = self.pathSum(root.right, targetSum - root.val)

        # 左右子树的路径加上根节点，就是和为 targetSum 的路径
        for answer in left_answers:
            # 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.insert(0, root.val)
            self.res.append(answer)
        
        for answer in right_answers:
            # 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.insert(0, root.val)
            self.res.append(answer)

        return self.res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        traverse(root, sum, new LinkedList<>());
        return res;
    }

    // 遍历二叉树
    private void traverse(TreeNode root, int sum, LinkedList<Integer> path) {
        if (root == null) return;

        int remain = sum - root.val;

        if (root.left == null && root.right == null) {
            if (remain == 0) {
                // 找到一条路径
                path.addLast(root.val);
                res.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }

        // 维护路径列表
        path.addLast(root.val);
        traverse(root.left, remain, path);
        path.removeLast();

        path.addLast(root.val);
        traverse(root.right, remain, path);
        path.removeLast();
    }
}

// 分解问题的思维模式
class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rootAnswers = new LinkedList<>();
        if (root == null) {
            return rootAnswers;
        }

        // 如果是叶子节点并且值等于 targetSum，则找到一条路径
        if (root.left == null && root.right == null && root.val == targetSum) {
            LinkedList<Integer> path = new LinkedList<>();
            path.add(root.val);
            rootAnswers.add(path);
            return rootAnswers;
        }

        // 分别递归左右子树，找到子树中和为 targetSum - root.val 的路径
        List<List<Integer>> leftAnswers = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> rightAnswers = pathSum(root.right, targetSum - root.val);

        // 左右子树的路径加上根节点，就是和为 targetSum 的路径
        for (List<Integer> answer : leftAnswers) {
            // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.add(0, root.val);
            rootAnswers.add(answer);
        }
        for (List<Integer> answer : rightAnswers) {
            // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.add(0, root.val);
            rootAnswers.add(answer);
        }

        return rootAnswers;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func pathSum(root *TreeNode, sum int) [][]int {
    var res [][]int
    if root == nil {
        return res
    }
    traverse(root, sum, []int{}, &res)
    return res
}

// 遍历二叉树
func traverse(root *TreeNode, sum int, path []int, res *[][]int) {
    if root == nil {
        return
    }

    remain := sum - root.Val

    if root.Left == nil && root.Right == nil {
        if remain == 0 {
            // 找到一条路径
            path = append(path, root.Val)
            *res = append(*res, append([]int{}, path...))
            path = path[:len(path)-1]
        }
        return
    }

    // 维护路径列表
    path = append(path, root.Val)
    traverse(root.Left, remain, path, res)
    path = path[:len(path)-1]

    path = append(path, root.Val)
    traverse(root.Right, remain, path, res)
    path = path[:len(path)-1]
}

// 分解问题的思维模式
func pathSum2(root *TreeNode, targetSum int) [][]int {
    var rootAnswers [][]int
    if root == nil {
        return rootAnswers
    }

    // 如果是叶子节点并且值等于 targetSum，则找到一条路径
    if root.Left == nil && root.Right == nil && root.Val == targetSum {
        path := []int{root.Val}
        rootAnswers = append(rootAnswers, path)
        return rootAnswers
    }

    // 分别递归左右子树，找到子树中和为 targetSum - root.val 的路径
    leftAnswers := pathSum2(root.Left, targetSum-root.Val)
    rightAnswers := pathSum2(root.Right, targetSum-root.Val)

    // 左右子树的路径加上根节点，就是和为 targetSum 的路径
    for _, answer := range leftAnswers {
        // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
        answer = append([]int{root.Val}, answer...)
        rootAnswers = append(rootAnswers, answer)
    }
    for _, answer := range rightAnswers {
        // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
        answer = append([]int{root.Val}, answer...)
        rootAnswers = append(rootAnswers, answer)
    }

    return rootAnswers
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var pathSum = function(root, sum) {
    let res = [];

    // 遍历二叉树
    var traverse = function(root, sum, path) {
        if (root == null) return;

        let remain = sum - root.val;

        if (root.left == null && root.right == null) {
            if (remain == 0) {
                // 找到一条路径
                path.push(root.val);
                res.push([...path]);
                path.pop();
            }
            return;
        }

        // 维护路径列表
        path.push(root.val);
        traverse(root.left, remain, path);
        path.pop();

        path.push(root.val);
        traverse(root.right, remain, path);
        path.pop();
    }

    if (root == null) return res;
    traverse(root, sum, []);
    return res;
};

// 分解问题的思维模式
var pathSum2 = function(root, targetSum) {
    let rootAnswers = [];
    if (root == null) {
        return rootAnswers;
    }

    // 如果是叶子节点并且值等于 targetSum，则找到一条路径
    if (root.left == null && root.right == null && root.val == targetSum) {
        let path = [];
        path.push(root.val);
        rootAnswers.push(path);
        return rootAnswers;
    }

    // 分别递归左右子树，找到子树中和为 targetSum - root.val 的路径
    let leftAnswers = pathSum2(root.left, targetSum - root.val);
    let rightAnswers = pathSum2(root.right, targetSum - root.val);

    // 左右子树的路径加上根节点，就是和为 targetSum 的路径
    for (let answer of leftAnswers) {
        // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
        answer.unshift(root.val);
        rootAnswers.push(answer);
    }
    for (let answer of rightAnswers) {
        // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
        answer.unshift(root.val);
        rootAnswers.push(answer);
    }

    return rootAnswers;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_path-sum-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_path-sum-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

