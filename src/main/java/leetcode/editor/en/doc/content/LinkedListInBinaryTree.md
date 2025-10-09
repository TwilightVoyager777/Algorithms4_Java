<p>Given a binary tree <code>root</code> and a&nbsp;linked list with&nbsp;<code>head</code>&nbsp;as the first node.&nbsp;</p>

<p>Return True if all the elements in the linked list starting from the <code>head</code> correspond to some <em>downward path</em> connected in the binary tree&nbsp;otherwise return False.</p>

<p>In this context downward path means a path that starts at some node and goes downwards.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/02/12/sample_1_1720.png" style="width: 220px; height: 280px;" /></strong></p>

<pre>
<strong>Input:</strong> head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
<strong>Output:</strong> true
<strong>Explanation:</strong> Nodes in blue form a subpath in the binary Tree.  
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/02/12/sample_2_1720.png" style="width: 220px; height: 280px;" /></strong></p>

<pre>
<strong>Input:</strong> head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no path in the binary tree that contains all the elements of the linked list from <span><code>head</code></span>.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree will be in the range <code>[1, 2500]</code>.</li> 
 <li>The number of nodes in the list will be in the range <code>[1, 100]</code>.</li> 
 <li><code>1 &lt;= Node.val&nbsp;&lt;= 100</code>&nbsp;for each node in the linked list and binary tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 2998, 👎 89<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

本质上，`isSubPath` 就是在遍历二叉树的所有节点，对每个节点用 `check` 函数判断是否能够将链表嵌进去。

**详细题解**：
  - [【练习】用「遍历」思维解题 III](https://labuladong.online/algo/problem-set/binary-tree-traverse-iii/)

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
    bool isSubPath(ListNode* head, TreeNode* root) {
        // base case
        if (head == nullptr) return true;
        if (root == nullptr) return false;
        // 当找到一个二叉树节点的值等于链表头结点时
        if (head->val == root->val) {
            // 判断是否能把链表嵌进去
            if (check(head, root)) {
                return true;
            }
        }
        // 继续去遍历其他节点尝试嵌入链表
        return isSubPath(head, root->left) || isSubPath(head, root->right);
    }

    // 检查是否能够将链表嵌入二叉树
    bool check(ListNode* head, TreeNode* root) {
        if (head == nullptr) return true;
        if (root == nullptr) return false;

        if (head->val == root->val) {
            // 在子树上嵌入子链表
            return check(head->next, root->left) || check(head->next, root->right);
        }

        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isSubPath(self, head: ListNode, root: TreeNode) -> bool:
        # base case
        if head is None:
            return True
        if root is None:
            return False
        # 当找到一个二叉树节点的值等于链表头结点时
        if head.val == root.val:
            # 判断是否能把链表嵌进去
            if self.check(head, root):
                return True
        # 继续去遍历其他节点尝试嵌入链表
        return self.isSubPath(head, root.left) or self.isSubPath(head, root.right)

    # 检查是否能够将链表嵌入二叉树
    def check(self, head: ListNode, root: TreeNode) -> bool:
        if head is None:
            return True
        if root is None:
            return False

        if head.val == root.val:
            # 在子树上嵌入子链表
            return self.check(head.next, root.left) or self.check(head.next, root.right)

        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // base case
        if (head == null) return true;
        if (root == null) return false;
        // 当找到一个二叉树节点的值等于链表头结点时
        if (head.val == root.val) {
            // 判断是否能把链表嵌进去
            if (check(head, root)) {
                return true;
            }
        }
        // 继续去遍历其他节点尝试嵌入链表
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // 检查是否能够将链表嵌入二叉树
    boolean check(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (head.val == root.val) {
            // 在子树上嵌入子链表
            return check(head.next, root.left) || check(head.next, root.right);
        }

        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isSubPath(head *ListNode, root *TreeNode) bool {
    // base case
    if head == nil {
        return true
    }
    if root == nil {
        return false
    }
    // 当找到一个二叉树节点的值等于链表头结点时
    if head.Val == root.Val {
        // 判断是否能把链表嵌进去
        if check(head, root) {
            return true
        }
    }
    // 继续去遍历其他节点尝试嵌入链表
    return isSubPath(head, root.Left) || isSubPath(head, root.Right)
}

// 检查是否能够将链表嵌入二叉树
func check(head *ListNode, root *TreeNode) bool {
    if head == nil {
        return true
    }
    if root == nil {
        return false
    }

    if head.Val == root.Val {
        // 在子树上嵌入子链表
        return check(head.Next, root.Left) || check(head.Next, root.Right)
    }

    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isSubPath = function(head, root) {
    // base case
    if (head === null) return true;
    if (root === null) return false;
    // 当找到一个二叉树节点的值等于链表头结点时
    if (head.val === root.val) {
        // 判断是否能把链表嵌进去
        if (check(head, root)) {
            return true;
        }
    }
    // 继续去遍历其他节点尝试嵌入链表
    return isSubPath(head, root.left) || isSubPath(head, root.right);
};

// 检查是否能够将链表嵌入二叉树
var check = function(head, root) {
    if (head === null) return true;
    if (root === null) return false;

    if (head.val === root.val) {
        // 在子树上嵌入子链表
        return check(head.next, root.left) || check(head.next, root.right);
    }

    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_linked-list-in-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-in-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

