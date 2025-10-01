<p>Given the <code>root</code> of a binary tree, return <em>the inorder traversal of its nodes' values</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1,3,2]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[4,2,6,5,7,1,3,9,8]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/tree_2.png" style="width: 350px; height: 286px;" /></p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = []</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?

<details><summary><strong>Related Topics</strong></summary>Stack | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 14489, 👎 867<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure-basic/binary-tree-traverse-basic/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

不要瞧不起二叉树的遍历问题，前文 [我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树的遍历代码是动态规划和回溯算法的祖宗。

动态规划思路的核心在于明确并利用函数的定义分解问题，中序遍历结果的特点是 `root.val` 在中间，左右子树在两侧：

![](https://labuladong.online/algo/images/binary-tree-ii/1.jpeg)

回溯算法的核心很简单，就是 `traverse` 函数遍历二叉树。

本题就分别用两种不同的思路来写代码，注意体会两种思路的区别所在。

**详细题解**：
  - [二叉树的递归/层序遍历](https://labuladong.online/algo/data-structure-basic/binary-tree-traverse-basic/)

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

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
std::vector<int> inorderTraversal(TreeNode* root) {
    std::vector<int> res;
    if (root == nullptr) {
        return res;
    }
    auto leftRes = inorderTraversal(root->left);
    res.insert(res.end(), leftRes.begin(), leftRes.end());
    res.push_back(root->val);
    auto rightRes = inorderTraversal(root->right);
    res.insert(res.end(), rightRes.begin(), rightRes.end());
    return res;
}

// 回溯算法思路
class Solution {
public:
    std::vector<int> res;

    // 返回前序遍历结果
    // Note: Despite the comment saying "preorder", this function actually returns inorder traversal result
    std::vector<int> inorderTraversal(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);
        // 中序遍历位置
        res.push_back(root->val);
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
    # 动态规划思路
    # 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if root is None:
            return res
        res.extend(self.inorderTraversal(root.left))
        res.append(root.val)
        res.extend(self.inorderTraversal(root.right))
        return res

    # 回溯算法思路
    res = []

    # 返回前序遍历结果
    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        self.traverse(root)
        return self.res

    # 二叉树遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        self.traverse(root.left)
        # 中序遍历位置
        self.res.append(root.val)
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 动态规划思路
    // 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    // 回溯算法思路
    LinkedList<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    public List<Integer> inorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
func inorderTraversal(root *TreeNode) []int {
    var res []int
    if root == nil {
        return res
    }
    res = append(res, inorderTraversal(root.Left)...)
    res = append(res, root.Val)
    res = append(res, inorderTraversal(root.Right)...)
    return res
}

// 回溯算法思路
// 返回前序遍历结果
func inorderTraversal2(root *TreeNode) []int {
    var res []int
    traverse(root, &res)
    return res
}

// 二叉树遍历函数
func traverse(root *TreeNode, res *[]int) {
    if root == nil {
        return
    }
    traverse(root.Left, res)
    // 中序遍历位置
    *res = append(*res, root.Val)
    traverse(root.Right, res)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
var inorderTraversal = function(root) {
    let res = [];
    if (root === null) {
        return res;
    }
    res = res.concat(inorderTraversal(root.left));
    res.push(root.val);
    res = res.concat(inorderTraversal(root.right));
    return res;
};

// 回溯算法思路
// 返回前序遍历结果
var inorderTraversal2 = function(root) {
    let res = [];
    traverse(root, res);
    return res;
};

// 二叉树遍历函数
var traverse = function(root, res) {
    if (root === null) {
        return;
    }
    traverse(root.left, res);
    // 中序遍历位置
    res.push(root.val);
    traverse(root.right, res);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_binary-tree-inorder-traversal"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-inorder-traversal"></div></div>
</details><hr /><br />

</div>
</details>
</div>

