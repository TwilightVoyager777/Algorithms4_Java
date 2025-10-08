<p>Given the <code>root</code> of a binary tree and two integers <code>val</code> and <code>depth</code>, add a row of nodes with value <code>val</code> at the given depth <code>depth</code>.</p>

<p>Note that the <code>root</code> node is at depth <code>1</code>.</p>

<p>The adding rule is:</p>

<ul> 
 <li>Given the integer <code>depth</code>, for each not null tree node <code>cur</code> at the depth <code>depth - 1</code>, create two tree nodes with value <code>val</code> as <code>cur</code>'s left subtree root and right subtree root.</li> 
 <li><code>cur</code>'s original left subtree should be the left subtree of the new left subtree root.</li> 
 <li><code>cur</code>'s original right subtree should be the right subtree of the new right subtree root.</li> 
 <li>If <code>depth == 1</code> that means there is no depth <code>depth - 1</code> at all, then create a tree node with value <code>val</code> as the new root of the whole original tree, and the original tree is the new root's left subtree.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/15/addrow-tree.jpg" style="width: 500px; height: 231px;" /> 
<pre>
<strong>Input:</strong> root = [4,2,6,3,1,5], val = 1, depth = 2
<strong>Output:</strong> [4,1,1,2,null,null,6,3,1,5]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/11/add2-tree.jpg" style="width: 500px; height: 277px;" /> 
<pre>
<strong>Input:</strong> root = [4,2,null,3,1], val = 1, depth = 3
<strong>Output:</strong> [4,2,null,1,1,3,null,null,1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li>The depth of the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>-10<sup>5</sup> &lt;= val &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= depth &lt;= the depth of tree + 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 3640, 👎 270<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

用 `traverse` 函数遍历到对应行，进行插入即可。

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

class Solution {
private:
    int targetVal, targetDepth;

public:
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        targetVal = val;
        targetDepth = depth;
        // 插入到第一行的话特殊对待一下
        if (targetDepth == 1) {
            TreeNode* newRoot = new TreeNode(targetVal);
            newRoot->left = root;
            return newRoot;
        }
        // 遍历二叉树，走到对应行进行插入
        traverse(root);

        return root;
    }

private:
    int curDepth = 0;

    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        // 前序遍历
        curDepth++;
        if (curDepth == targetDepth - 1) {
            // 进行插入
            TreeNode* newLeft = new TreeNode(targetVal);
            TreeNode* newRight = new TreeNode(targetVal);
            newLeft->left = root->left;
            newRight->right = root->right;
            root->left = newLeft;
            root->right = newRight;
        }

        traverse(root->left);
        traverse(root->right);

        // 后序遍历
        curDepth--;
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
        self.targetVal = 0
        self.targetDepth = 0

    def addOneRow(self, root: TreeNode, val: int, depth: int) -> TreeNode:
        self.targetVal = val
        self.targetDepth = depth
        # 插入到第一行的话特殊对待一下
        if self.targetDepth == 1:
            newRoot = TreeNode(self.targetVal)
            newRoot.left = root
            return newRoot
        # 遍历二叉树，走到对应行进行插入
        self.traverse(root, 1)

        return root

    def traverse(self, root: TreeNode, curDepth: int):
        if root is None:
            return
        # 前序遍历
        if curDepth == self.targetDepth - 1:
            # 进行插入
            newLeft = TreeNode(self.targetVal)
            newRight = TreeNode(self.targetVal)
            newLeft.left = root.left
            newRight.right = root.right
            root.left = newLeft
            root.right = newRight
        # Recursively traverse the left and right subtree
        self.traverse(root.left, curDepth + 1)
        self.traverse(root.right, curDepth + 1)
        # 后序遍历
        # Note: The original Java code does not have any action in the post-order position,
        # but we keep the comment for consistency.
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    private int targetVal, targetDepth;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        targetVal = val;
        targetDepth = depth;
        // 插入到第一行的话特殊对待一下
        if (targetDepth == 1) {
            TreeNode newRoot = new TreeNode(targetVal);
            newRoot.left = root;
            return newRoot;
        }
        // 遍历二叉树，走到对应行进行插入
        traverse(root);

        return root;
    }

    private int curDepth = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历
        curDepth++;
        if (curDepth == targetDepth - 1) {
            // 进行插入
            TreeNode newLeft = new TreeNode(targetVal);
            TreeNode newRight = new TreeNode(targetVal);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }

        traverse(root.left);
        traverse(root.right);

        // 后序遍历
        curDepth--;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func addOneRow(root *TreeNode, val int, depth int) *TreeNode {
    targetVal := val
    targetDepth := depth
    // 插入到第一行的话特殊对待一下
    if targetDepth == 1 {
        newRoot := &TreeNode{Val: targetVal}
        newRoot.Left = root
        return newRoot
    }
    // 遍历二叉树，走到对应行进行插入
    traverse(root, targetVal, targetDepth, 1)
    return root
}

// 二叉树遍历函数
func traverse(root *TreeNode, targetVal, targetDepth, curDepth int) {
    if root == nil {
        return
    }
    // 前序遍历
    if curDepth == targetDepth-1 {
        // 进行插入
        newLeft := &TreeNode{Val: targetVal}
        newRight := &TreeNode{Val: targetVal}
        newLeft.Left = root.Left
        newRight.Right = root.Right
        root.Left = newLeft
        root.Right = newRight
    }
    traverse(root.Left, targetVal, targetDepth, curDepth+1)
    traverse(root.Right, targetVal, targetDepth, curDepth+1)
    // 后序遍历
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var addOneRow = function(root, val, depth) {
    // 插入到第一行的话特殊对待一下
    if (depth === 1) {
        let newRoot = new TreeNode(val);
        newRoot.left = root;
        return newRoot;
    }
    
    // 遍历二叉树，走到对应行进行插入
    traverse(root, 1, depth, val);

    return root;
};

function traverse(root, curDepth, targetDepth, val) {
    if (root === null) {
        return;
    }
    // 前序遍历
    if (curDepth === targetDepth - 1) {
        // 进行插入
        let newLeft = new TreeNode(val);
        let newRight = new TreeNode(val);
        newLeft.left = root.left;
        newRight.right = root.right;
        root.left = newLeft;
        root.right = newRight;
    } else {
        traverse(root.left, curDepth + 1, targetDepth, val);
        traverse(root.right, curDepth + 1, targetDepth, val);
    }
    // 后序遍历
    // Note: There's no need to decrement curDepth here as it's handled by the function's recursive call stack.
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_add-one-row-to-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_add-one-row-to-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

