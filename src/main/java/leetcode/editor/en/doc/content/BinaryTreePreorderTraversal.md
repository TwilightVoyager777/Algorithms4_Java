<p>Given the <code>root</code> of a binary tree, return <em>the preorder traversal of its nodes' values</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1,2,3]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1,2,4,5,6,7,3,8,9]</span></p>

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
<p><strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</p>

<details><summary><strong>Related Topics</strong></summary>Stack | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 8572, 👎 227<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-tree-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

不要瞧不起二叉树的前中后序遍历。

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，分别代表回溯算法和动态规划的底层思想。

本题用两种思维模式来解答，注意体会其中思维方式的差异。

**详细题解**：
  - [二叉树系列算法核心纲领](https://labuladong.online/algo/essential-technique/binary-tree-summary/)

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
    // 动态规划思路
    // 定义：输入一个节点，返回以该节点为根的二叉树的前序遍历结果
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) {
            return res;
        }
        // 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
        res.push_back(root->val);
        vector<int> left = preorderTraversal(root->left);
        vector<int> right = preorderTraversal(root->right);
        res.insert(res.end(), left.begin(), left.end());
        res.insert(res.end(), right.begin(), right.end());
        return res;
    }

    // 回溯算法思路
    vector<int> res;

    // 返回前序遍历结果
    vector<int> preorderTraversal2(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        // 前序遍历位置
        res.push_back(root->val);
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
    # 动态规划思路
    # 定义：输入一个节点，返回以该节点为根的二叉树的前序遍历结果
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if root is None:
            return res
        # 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
        res.append(root.val)
        res.extend(self.preorderTraversal(root.left))
        res.extend(self.preorderTraversal(root.right))
        return res

    # 回溯算法思路
    res = []

    # 返回前序遍历结果
    def preorderTraversal2(self, root: TreeNode) -> List[int]:
        self.res = []
        self.traverse(root)
        return self.res

    # 二叉树遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        # 前序遍历位置
        self.res.append(root.val)
        self.traverse(root.left)
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 动态规划思路
    // 定义：输入一个节点，返回以该节点为根的二叉树的前序遍历结果
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    // 回溯算法思路
    LinkedList<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    public List<Integer> preorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        res.add(root.val);
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

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的前序遍历结果
func preorderTraversal(root *TreeNode) []int {
    return dpPreorder(root)
}

// 辅助函数使用动态规划进行前序遍历
func dpPreorder(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }
    // 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
    result := []int{root.Val}
    result = append(result, dpPreorder(root.Left)...)
    result = append(result, dpPreorder(root.Right)...)
    return result
}

// 回溯算法思路
// 返回前序遍历结果
func preorderTraversal2(root *TreeNode) []int {
    res := []int{}
    traverse(root, &res)
    return res
}

// 二叉树遍历函数
// 使用辅助函数进行遍历，避免使用全局变量
func traverse(root *TreeNode, res *[]int) {
    if root == nil {
        return
    }
    // 前序遍历位置
    *res = append(*res, root.Val)
    traverse(root.Left, res)
    traverse(root.Right, res)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的前序遍历结果
var preorderTraversal = function(root) {
    let res = [];
    if (root === null) {
        return res;
    }
    // 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
    res.push(root.val);
    res = res.concat(preorderTraversal(root.left));
    res = res.concat(preorderTraversal(root.right));
    return res;
};

// 回溯算法思路
var preorderTraversal2 = function(root) {
    let res = [];
    // 返回前序遍历结果
    // 二叉树遍历函数
    var traverse = function(root) {
        if (root === null) {
            return;
        }
        // 前序遍历位置
        res.push(root.val);
        traverse(root.left);
        traverse(root.right);
    };
    traverse(root);
    return res;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

