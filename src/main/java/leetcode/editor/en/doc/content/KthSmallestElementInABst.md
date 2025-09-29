<p>Given the <code>root</code> of a binary search tree, and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>smallest value (<strong>1-indexed</strong>) of all the values of the nodes in the tree</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg" style="width: 212px; height: 301px;" /> 
<pre>
<strong>Input:</strong> root = [3,1,4,null,2], k = 1
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg" style="width: 382px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,null,1], k = 3
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is <code>n</code>.</li> 
 <li><code>1 &lt;= k &lt;= n &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?</p>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Search Tree | Binary Tree</details><br>

<div>👍 12358, 👎 251<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part1/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

BST 的中序遍历结果是有序的（升序），所以用一个外部变量记录中序遍历结果第 `k` 个元素即是第 `k` 小的元素。

**详细题解**：
  - [二叉搜索树心法（特性篇）](https://labuladong.online/algo/data-structure/bst-part1/)

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
    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode* root, int k) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left, k);

        // 中序代码位置
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root->val;
            return;
        }

        traverse(root->right, k);
    }

public:
    int kthSmallest(TreeNode* root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
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
    def __init__(self):
        # 记录结果
        self.res = 0
        # 记录当前元素的排名
        self.rank = 0

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # 利用 BST 的中序遍历特性
        self.traverse(root, k)
        return self.res

    def traverse(self, root, k):
        if not root:
            return
        self.traverse(root.left, k)

        # 中序代码位置
        self.rank += 1
        if k == self.rank:
            # 找到第 k 小的元素
            self.res = root.val
            return

        self.traverse(root.right, k)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        // 中序代码位置
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func kthSmallest(root *TreeNode, k int) int {
    // 记录结果
    res := 0
    // 记录当前元素的排名
    rank := 0
    var traverse func(root *TreeNode)

    traverse = func(root *TreeNode) {
        if root == nil {
            return
        }
        traverse(root.Left)

        // 中序代码位置
        rank++
        if k == rank {
            // 找到第 k 小的元素
            res = root.Val
            return
        }

        traverse(root.Right)
    }

    // 利用 BST 的中序遍历特性
    traverse(root)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var kthSmallest = function(root, k) {
    // 记录结果
    let res = 0;
    // 记录当前元素的排名
    let rank = 0;
    var traverse = function(root) {
        if (root === null) {
            return;
        }
        traverse(root.left);

        // 中序代码位置
        rank++;
        if (k === rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }

        traverse(root.right);
    }

    // 利用 BST 的中序遍历特性
    traverse(root);
    return res;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_kth-smallest-element-in-a-bst"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_kth-smallest-element-in-a-bst"></div></div>
</details><hr /><br />

</div>
</details>
</div>

