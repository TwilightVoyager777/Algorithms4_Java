<p>Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return <em>the <strong>root node reference</strong> (possibly updated) of the BST</em>.</p>

<p>Basically, the deletion can be divided into two stages:</p>

<ol> 
 <li>Search for a node to remove.</li> 
 <li>If the node is found, delete the node.</li> 
</ol>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/04/del_node_1.jpg" style="width: 800px; height: 214px;" /> 
<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,7], key = 3
<strong>Output:</strong> [5,4,6,2,null,null,7]
<strong>Explanation:</strong> Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/04/del_node_supp.jpg" style="width: 350px; height: 255px;" />
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,7], key = 0
<strong>Output:</strong> [5,3,6,2,4,null,7]
<strong>Explanation:</strong> The tree does not contain a node with value = 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [], key = 0
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li>Each node has a <strong>unique</strong> value.</li> 
 <li><code>root</code> is a valid binary search tree.</li> 
 <li><code>-10<sup>5</sup> &lt;= key &lt;= 10<sup>5</sup></code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Could you solve it with time complexity <code>O(height of tree)</code>?</p>

<details><summary><strong>Related Topics</strong></summary>Tree | Binary Search Tree | Binary Tree</details><br>

<div>👍 10069, 👎 368<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

删除比插入和搜索都要复杂一些，分三种情况：

**情况 1**：`A` 恰好是末端节点，两个子节点都为空，那么它可以当场去世了：

![](https://labuladong.online/algo/images/bst/bst_deletion_case_1.png)

**情况 2**：`A` 只有一个非空子节点，那么它要让这个孩子接替自己的位置：

![](https://labuladong.online/algo/images/bst/bst_deletion_case_2.png)

**情况 3**：`A` 有两个子节点，麻烦了，为了不破坏 BST 的性质，`A` 必须找到左子树中最大的那个节点或者右子树中最小的那个节点来接替自己，我的解法是用右子树中最小节点来替换：

![](https://labuladong.online/algo/images/bst/bst_deletion_case_3.png)

**详细题解**：
  - [二叉搜索树心法（基操篇）](https://labuladong.online/algo/data-structure/bst-part2/)

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
    // 定义：在以 root 为根的 BST 中删除值为 key 的节点，返回完成删除后的根节点
    TreeNode* deleteNode(TreeNode* root, int key) {
        if (root == nullptr) return nullptr;
        if (root->val == key) {
            // 这两个 if 把情况 1 和 2 都正确处理了
            if (root->left == nullptr) return root->right;
            if (root->right == nullptr) return root->left;
            // 处理情况 3
            // 获得右子树最小的节点
            TreeNode* minNode = getMin(root->right);
            // 删除右子树最小的节点
            root->right = deleteNode(root->right, minNode->val);
            // 用右子树最小的节点替换 root 节点
            minNode->left = root->left;
            minNode->right = root->right;
            root = minNode;
        } else if (root->val > key) {
            root->left = deleteNode(root->left, key);
        } else if (root->val < key) {
            root->right = deleteNode(root->right, key);
        }
        return root;
    }

    TreeNode* getMin(TreeNode* node) {
        // BST 最左边的就是最小的
        while (node->left != nullptr) node = node->left;
        return node;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 定义：在以 root 为根的 BST 中删除值为 key 的节点，返回完成删除后的根节点
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if root == None:
            return None
        if root.val == key:
            # 这两个 if 把情况 1 和 2 都正确处理了
            if root.left == None:
                return root.right
            if root.right == None:
                return root.left
            # 处理情况 3
            # 获得右子树最小的节点
            minNode = self.getMin(root.right)
            # 删除右子树最小的节点
            root.right = self.deleteNode(root.right, minNode.val)
            # 用右子树最小的节点替换 root 节点
            minNode.left = root.left
            minNode.right = root.right
            root = minNode
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        return root

    def getMin(self, node: TreeNode) -> TreeNode:
        # BST 最左边的就是最小的
        while node.left != None:
            node = node.left
        return node
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 这两个 if 把情况 1 和 2 都正确处理了
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 处理情况 3
            // 获得右子树最小的节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：在以 root 为根的 BST 中删除值为 key 的节点，返回完成删除后的根节点
func deleteNode(root *TreeNode, key int) *TreeNode {
    if root == nil {
        return nil
    }
    if root.Val == key {
        // 这两个 if 把情况 1 和 2 都正确处理了
        if root.Left == nil {
            return root.Right
        }
        if root.Right == nil {
            return root.Left
        }
        // 处理情况 3
        // 获得右子树最小的节点
        minNode := getMin(root.Right)
        // 删除右子树最小的节点
        root.Right = deleteNode(root.Right, minNode.Val)
        // 用右子树最小的节点替换 root 节点
        minNode.Left = root.Left
        minNode.Right = root.Right
        root = minNode
    } else if root.Val > key {
        root.Left = deleteNode(root.Left, key)
    } else if root.Val < key {
        root.Right = deleteNode(root.Right, key)
    }
    return root
}

// 获得二叉搜索树中最小的节点
func getMin(node *TreeNode) *TreeNode {
    // BST 最左边的就是最小的
    for node.Left != nil {
        node = node.Left
    }
    return node
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：在以 root 为根的 BST 中删除值为 key 的节点，返回完成删除后的根节点
var deleteNode = function(root, key) {
    if (root == null) return null;
    if (root.val == key) {
        // 这两个 if 把情况 1 和 2 都正确处理了
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // 处理情况 3
        // 获得右子树最小的节点
        let minNode = getMin(root.right);
        // 删除右子树最小的节点
        root.right = deleteNode(root.right, minNode.val);
        // 用右子树最小的节点替换 root 节点
        minNode.left = root.left;
        minNode.right = root.right;
        root = minNode;
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}

// 获得 BST 中最小的节点。
var getMin = function(node) {
    // BST 最左边的就是最小的
    while (node.left != null) node = node.left;
    return node;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_delete-node-in-a-bst"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_delete-node-in-a-bst"></div></div>
</details><hr /><br />

</div>
</details>
</div>

