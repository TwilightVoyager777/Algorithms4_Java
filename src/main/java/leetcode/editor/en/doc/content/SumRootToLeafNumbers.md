<p>You are given the <code>root</code> of a binary tree containing digits from <code>0</code> to <code>9</code> only.</p>

<p>Each root-to-leaf path in the tree represents a number.</p>

<ul> 
 <li>For example, the root-to-leaf path <code>1 -&gt; 2 -&gt; 3</code> represents the number <code>123</code>.</li> 
</ul>

<p>Return <em>the total sum of all root-to-leaf numbers</em>. Test cases are generated so that the answer will fit in a <strong>32-bit</strong> integer.</p>

<p>A <strong>leaf</strong> node is a node with no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num1tree.jpg" style="width: 212px; height: 182px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> 25
<strong>Explanation:</strong>
The root-to-leaf path <span><code>1-&gt;2</code></span> represents the number <span><code>12</code></span>.
The root-to-leaf path <span><code>1-&gt;3</code></span> represents the number <span><code>13</code></span>.
Therefore, sum = 12 + 13 = <span><code>25</code></span>.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg" style="width: 292px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [4,9,0,5,1]
<strong>Output:</strong> 1026
<strong>Explanation:</strong>
The root-to-leaf path <span><code>4-&gt;9-&gt;5</code></span> represents the number 495.
The root-to-leaf path <span><code>4-&gt;9-&gt;1</code></span> represents the number 491.
The root-to-leaf path <span><code>4-&gt;0</code></span> represents the number 40.
Therefore, sum = 495 + 491 + 40 = <span><code>1026</code></span>.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>The depth of the tree will not exceed <code>10</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 8513, 👎 154<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

你想，让我获取所有路径数字之和，那我递归遍历一遍二叉树，沿路记录下来路径上的数字，到叶子节点的时候求和，不就完事了？

**详细题解**：
  - [【练习】用「遍历」思维解题 I](https://labuladong.online/algo/problem-set/binary-tree-traverse-i/)

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
    int sumNumbers(TreeNode* root) {
        // 遍历一遍二叉树就能出结果
        string path = "";
        int res = 0;
        traverse(root, path, res);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root, string& path, int& res) {
        if (root == nullptr) {
            return;
        }
        // 前序遍历位置，记录节点值
        path += to_string(root->val);
        if (root->left == nullptr && root->right == nullptr) {
            // 到达叶子节点，累加路径和
            res += stoi(path);
        }
        // 二叉树递归框架，遍历左右子树
        traverse(root->left, path, res);
        traverse(root->right, path, res);

        // 后续遍历位置，撤销节点值
        path.erase(path.length() - 1, 1);
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
        self.path = ""
        self.res = 0

    def sumNumbers(self, root: TreeNode) -> int:
        # 遍历一遍二叉树就能出结果
        self.traverse(root)
        return self.res

    # 二叉树遍历函数
    def traverse(self, root):
        if root is None:
            return
        # 前序遍历位置，记录节点值
        self.path += str(root.val)
        if root.left is None and root.right is None:
            # 到达叶子节点，累加路径和
            self.res += int(self.path)
        # 二叉树递归框架，遍历左右子树
        self.traverse(root.left)
        self.traverse(root.right)

        # 后续遍历位置，撤销节点值
        self.path = self.path[:-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    StringBuilder path = new StringBuilder();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        // 遍历一遍二叉树就能出结果
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置，记录节点值
        path.append(root.val);
        if (root.left == null && root.right == null) {
            // 到达叶子节点，累加路径和
            res += Integer.parseInt(path.toString());
        }
        // 二叉树递归框架，遍历左右子树
        traverse(root.left);
        traverse(root.right);

        // 后续遍历位置，撤销节点值
        path.deleteCharAt(path.length() - 1);

    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func sumNumbers(root *TreeNode) int {
    var res int
    var path string
    // 遍历一遍二叉树就能出结果
    traverse(root, &path, &res)
    return res
}

// 二叉树遍历函数
func traverse(root *TreeNode, path *string, res *int) {
    if root == nil {
        return
    }
    // 前序遍历位置，记录节点值
    *path += strconv.Itoa(root.Val)
    if root.Left == nil && root.Right == nil {
        // 到达叶子节点，累加路径和
        num, _ := strconv.Atoi(*path)
        *res += num
    }
    // 二叉树递归框架，遍历左右子树
    traverse(root.Left, path, res)
    traverse(root.Right, path, res)

    // 后续遍历位置，撤销节点值
    *path = (*path)[:len(*path)-1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var sumNumbers = function(root) {
    let path = [];
    let res = 0;

    // 遍历一遍二叉树就能出结果
    traverse(root);
    return res;

    // 二叉树遍历函数
    function traverse(root) {
        if (root === null) {
            return;
        }
        // 前序遍历位置，记录节点值
        path.push(root.val);
        if (root.left === null && root.right === null) {
            // 到达叶子节点，累加路径和
            res += parseInt(path.join(''));
        }
        // 二叉树递归框架，遍历左右子树
        traverse(root.left);
        traverse(root.right);

        // 后续遍历位置，撤销节点值
        path.pop();
    }
};
```

</div></div>
</div></div>

</div>
</details>
</div>

