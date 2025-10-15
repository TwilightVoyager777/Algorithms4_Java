<p>A <strong>maximum tree</strong> is a tree where every node has a value greater than any other value in its subtree.</p>

<p>You are given the <code>root</code> of a maximum binary tree and an integer <code>val</code>.</p>

<p>Just as in the <a href="https://leetcode.com/problems/maximum-binary-tree/" target="_blank">previous problem</a>, the given tree was constructed from a list <code>a</code> (<code>root = Construct(a)</code>) recursively with the following <code>Construct(a)</code> routine:</p>

<ul> 
 <li>If <code>a</code> is empty, return <code>null</code>.</li> 
 <li>Otherwise, let <code>a[i]</code> be the largest element of <code>a</code>. Create a <code>root</code> node with the value <code>a[i]</code>.</li> 
 <li>The left child of <code>root</code> will be <code>Construct([a[0], a[1], ..., a[i - 1]])</code>.</li> 
 <li>The right child of <code>root</code> will be <code>Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]])</code>.</li> 
 <li>Return <code>root</code>.</li> 
</ul>

<p>Note that we were not given <code>a</code> directly, only a root node <code>root = Construct(a)</code>.</p>

<p>Suppose <code>b</code> is a copy of <code>a</code> with the value <code>val</code> appended to it. It is guaranteed that <code>b</code> has unique values.</p>

<p>Return <code>Construct(b)</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/09/maxtree1.JPG" style="width: 376px; height: 235px;" /> 
<pre>
<strong>Input:</strong> root = [4,1,3,null,null,2], val = 5
<strong>Output:</strong> [5,4,null,1,3,null,null,2]
<strong>Explanation:</strong> a = [1,4,2,3], b = [1,4,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/09/maxtree21.JPG" style="width: 358px; height: 156px;" /> 
<pre>
<strong>Input:</strong> root = [5,2,4,null,1], val = 3
<strong>Output:</strong> [5,2,4,null,1,null,3]
<strong>Explanation:</strong> a = [2,1,5,4], b = [2,1,5,4,3]
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/09/maxtree3.JPG" style="width: 404px; height: 180px;" /> 
<pre>
<strong>Input:</strong> root = [5,2,3,null,1], val = 4
<strong>Output:</strong> [5,2,4,null,1,3]
<strong>Explanation:</strong> a = [2,1,5,3], b = [2,1,5,3,4]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 100]</code>.</li> 
 <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
 <li>All the values of the tree are <strong>unique</strong>.</li> 
 <li><code>1 &lt;= val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Binary Tree</details><br>

<div>👍 561, 👎 801<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。

做这道题之前，你一定要去做一下 [✔ ✨654. 最大二叉树](/problems/maximum-binary-tree/) 这道题，知道了构建最大二叉树的逻辑就很容易解决这道题了。

新增的 `val` 是添加在原始数组的最后的，根据构建最大二叉树的逻辑，正常来说最后的这个值一定是在右子树的，可以对右子树递归调用 `insertIntoMaxTree` 插入进去。

但是一种特殊情况是 `val` 比原始数组中的所有元素都大，那么根据构建最大二叉树的逻辑，原来的这棵树应该成为 `val` 节点的左子树。

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

class Solution {
public:
    TreeNode* insertIntoMaxTree(TreeNode* root, int val) {
        if (root == nullptr) {
            return new TreeNode(val);
        }
        if (root->val < val) {
            // 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            TreeNode* temp = root;
            root = new TreeNode(val);
            root->left = temp;
        } else {
            // 如果 val 不是最大的，那么就应该在右子树上，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            root->right = insertIntoMaxTree(root->right, val);
        }
        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def insertIntoMaxTree(self, root: TreeNode, val: int) -> TreeNode:
        if root is None:
            return TreeNode(val)
        if root.val < val:
            # 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
            # 因为 val 节点是接在原始数组 a 的最后一个元素
            temp = root
            root = TreeNode(val)
            root.left = temp
        else:
            # 如果 val 不是最大的，那么就应该在右子树上，
            # 因为 val 节点是接在原始数组 a 的最后一个元素
            root.right = self.insertIntoMaxTree(root.right, val)
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            // 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            TreeNode temp = root;
            root = new TreeNode(val);
            root.left = temp;
        } else {
            // 如果 val 不是最大的，那么就应该在右子树上，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func insertIntoMaxTree(root *TreeNode, val int) *TreeNode {
    if root == nil {
        return &TreeNode{Val: val}
    }
    if root.Val < val {
        // 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
        // 因为 val 节点是接在原始数组 a 的最后一个元素
        temp := root
        root = &TreeNode{Val: val}
        root.Left = temp
    } else {
        // 如果 val 不是最大的，那么就应该在右子树上，
        // 因为 val 节点是接在原始数组 a 的最后一个元素
        root.Right = insertIntoMaxTree(root.Right, val)
    }
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var insertIntoMaxTree = function(root, val) {
    if (root === null) {
        return new TreeNode(val);
    }
    if (root.val < val) {
        // 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
        // 因为 val 节点是接在原始数组 a 的最后一个元素
        let temp = root;
        root = new TreeNode(val);
        root.left = temp;
    } else {
        // 如果 val 不是最大的，那么就应该在右子树上，
        // 因为 val 节点是接在原始数组 a 的最后一个元素
        root.right = insertIntoMaxTree(root.right, val);
    }
    return root;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_maximum-binary-tree-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_maximum-binary-tree-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

