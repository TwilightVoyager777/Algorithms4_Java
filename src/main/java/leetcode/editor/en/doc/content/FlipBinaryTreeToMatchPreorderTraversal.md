<p>You are given the <code>root</code> of a binary tree with <code>n</code> nodes, where each node is uniquely assigned a value from <code>1</code> to <code>n</code>. You are also given a sequence of <code>n</code> values <code>voyage</code>, which is the <strong>desired</strong> <a href="https://en.wikipedia.org/wiki/Tree_traversal#Pre-order" target="_blank"><strong>pre-order traversal</strong></a> of the binary tree.</p>

<p>Any node in the binary tree can be <strong>flipped</strong> by swapping its left and right subtrees. For example, flipping node 1 will have the following effect:</p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/15/fliptree.jpg" style="width: 400px; height: 187px;" /> 
<p>Flip the <strong>smallest</strong> number of nodes so that the <strong>pre-order traversal</strong> of the tree <strong>matches</strong> <code>voyage</code>.</p>

<p>Return <em>a list of the values of all <strong>flipped</strong> nodes. You may return the answer in <strong>any order</strong>. If it is <strong>impossible</strong> to flip the nodes in the tree to make the pre-order traversal match </em><code>voyage</code><em>, return the list </em><code>[-1]</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-01.png" style="width: 150px; height: 205px;" /> 
<pre>
<strong>Input:</strong> root = [1,2], voyage = [2,1]
<strong>Output:</strong> [-1]
<strong>Explanation:</strong> It is impossible to flip the nodes such that the pre-order traversal matches voyage.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-02.png" style="width: 150px; height: 142px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3], voyage = [1,3,2]
<strong>Output:</strong> [1]
<strong>Explanation:</strong> Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal matches voyage.</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/02/1219-02.png" style="width: 150px; height: 142px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3], voyage = [1,2,3]
<strong>Output:</strong> []
<strong>Explanation:</strong> The tree's pre-order traversal already matches voyage, so no nodes need to be flipped.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is <code>n</code>.</li> 
 <li><code>n == voyage.length</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= Node.val, voyage[i] &lt;= n</code></li> 
 <li>All the values in the tree are <strong>unique</strong>.</li> 
 <li>All the values in <code>voyage</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 990, 👎 282<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

用 `traverse` 函数遍历整棵二叉树，对比前序遍历结果，如果节点的值对不上，就无解；如果子树对不上 `voyage`，就尝试翻转子树。

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

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> flipMatchVoyage(TreeNode* root, vector<int>& voyage) {
        this->voyage = voyage;
        // 遍历的过程中尝试进行反转
        traverse(root);

        if (canFlip) {
            return res;
        }
        return {-1};
    }

private:
    vector<int> res;
    int i = 0;
    vector<int> voyage;
    bool canFlip = true;

    void traverse(TreeNode* root) {
        if (root == nullptr || !canFlip) {
            return;
        }
        if (root->val != voyage[i++]) {
            // 节点的 val 对不上，必然无解
            canFlip = false;
            return;
        }
        if (root->left != nullptr && root->left->val != voyage[i]) {
            // 前序遍历结果不对，尝试翻转左右子树
            TreeNode* temp = root->left;
            root->left = root->right;
            root->right = temp;
            // 记录翻转节点
            res.push_back(root->val);
        }

        traverse(root->left);
        traverse(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def flipMatchVoyage(self, root: TreeNode, voyage: List[int]) -> List[int]:
        self.res = []
        self.i = 0
        self.can_flip = True
        
        def dfs(node):
            # 遍历的过程中尝试进行反转
            if not node or not self.can_flip:
                return True
            if node.val != voyage[self.i]:
                # 节点的 val 对不上，必然无解
                self.can_flip = False
                return False
            self.i += 1
            # Only flip if there's a left child and the next value in voyage doesn't match the left child's value
            if node.left and node.left.val != voyage[self.i]:
                # 前序遍历结果不对，尝试翻转左右子树
                self.res.append(node.val)
                node.left, node.right = node.right, node.left
            # 记录翻转节点
            # Note: This comment was not in the original Java code, but added to match the pattern of comments. 
            # If this was not intended, it can be removed.
            return dfs(node.left) and dfs(node.right)
        
        if dfs(root):
            return self.res
        else:
            return [-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        // 遍历的过程中尝试进行反转
        traverse(root);

        if (canFlip) {
            return res;
        }
        return Arrays.asList(-1);
    }


    List<Integer> res = new LinkedList<>();
    int i = 0;
    int[] voyage;
    boolean canFlip = true;

    void traverse(TreeNode root) {
        if (root == null || !canFlip) {
            return;
        }
        if (root.val != voyage[i++]) {
            // 节点的 val 对不上，必然无解
            canFlip = false;
            return;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            // 前序遍历结果不对，尝试翻转左右子树
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            // 记录翻转节点
            res.add(root.val);
        }

        traverse(root.left);
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func flipMatchVoyage(root *TreeNode, voyage []int) []int {
    res := []int{}
    i := 0
    canFlip := true

    // 遍历的过程中尝试进行反转
    traverse(root, voyage, &i, &res, &canFlip)

    if canFlip {
        return res
    }
    return []int{-1}
}

// 二叉树遍历函数
func traverse(root *TreeNode, voyage []int, i *int, res *[]int, canFlip *bool) {
    if root == nil || !*canFlip {
        return
    }
    if root.Val != voyage[*i] {
        // 节点的 val 对不上，必然无解
        *canFlip = false
        return
    }
    *i++
    if root.Left != nil && root.Left.Val != voyage[*i] {
        // 前序遍历结果不对，尝试翻转左右子树
        root.Left, root.Right = root.Right, root.Left
        // 记录翻转节点
        *res = append(*res, root.Val)
    }

    traverse(root.Left, voyage, i, res, canFlip)
    traverse(root.Right, voyage, i, res, canFlip)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var flipMatchVoyage = function(root, voyage) {
    this.voyage = voyage;
    this.res = [];
    this.i = 0;
    this.canFlip = true;

    var traverse = function(root) {
        // 遍历的过程中尝试进行反转
        if (root === null || !this.canFlip) {
            return;
        }
        if (root.val !== this.voyage[this.i++]) {
            // 节点的 val 对不上，必然无解
            this.canFlip = false;
            return;
        }
        if (root.left !== null && root.left.val !== this.voyage[this.i]) {
            // 前序遍历结果不对，尝试翻转左右子树
            let temp = root.left;
            root.left = root.right;
            root.right = temp;
            // 记录翻转节点
            this.res.push(root.val);
        }

        traverse.call(this, root.left);
        traverse.call(this, root.right);
    };

    traverse.call(this, root);

    if (this.canFlip) {
        return this.res;
    }
    return [-1];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_flip-binary-tree-to-match-preorder-traversal"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_flip-binary-tree-to-match-preorder-traversal"></div></div>
</details><hr /><br />

</div>
</details>
</div>

