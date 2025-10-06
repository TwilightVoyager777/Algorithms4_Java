<p>Given the <code>root</code> of a binary tree, return <em>all root-to-leaf paths in <strong>any order</strong></em>.</p>

<p>A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/paths-tree.jpg" style="width: 207px; height: 293px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,null,5]
<strong>Output:</strong> ["1-&gt;2-&gt;5","1-&gt;3"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> ["1"]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 100]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Backtracking | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 7068, 👎 334<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

你让我求所有根节点到叶子节点的路径，那我遍历一遍二叉树肯定可以搞定，遍历到叶子节点的时候想办法把路径生成出来就行了。

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

#include <vector>
#include <string>
#include <sstream>

using namespace std;

class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        // 遍历一遍二叉树就能出结果了
        traverse(root);
        return res;
    }

private:
    // 记录 traverse 函数递归时的路径
    vector<string> path;
    // 记录所有从根节点到叶子节点的路径
    vector<string> res;

    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        // root 是叶子节点
        if (root->left == nullptr && root->right == nullptr) {
            path.push_back(to_string(root->val));
            // 将这条路径装入 res
            res.push_back(joinPath(path));
            path.pop_back();
            return;
        }
        // 前序遍历位置
        path.push_back(to_string(root->val));
        // 递归遍历左右子树
        traverse(root->left);
        traverse(root->right);
        // 后序遍历位置
        path.pop_back();
    }

    string joinPath(const vector<string>& path) {
        stringstream ss;
        for (size_t i = 0; i < path.size(); ++i) {
            ss << path[i];
            if (i < path.size() - 1) ss << "->";
        }
        return ss.str();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        # 遍历一遍二叉树就能出结果了
        self.traverse(root)
        return self.res

    def __init__(self):
        # 记录 traverse 函数递归时的路径
        self.path = []
        # 记录所有从根节点到叶子节点的路径
        self.res = []

    def traverse(self, root: TreeNode):
        if root is None:
            return
        # root 是叶子节点
        if root.left is None and root.right is None:
            self.path.append(str(root.val))
            # 将这条路径装入 res
            self.res.append("->".join(self.path))
            self.path.pop()
            return
        # 前序遍历位置
        self.path.append(str(root.val))
        # 递归遍历左右子树
        self.traverse(root.left)
        self.traverse(root.right)
        # 后序遍历位置
        self.path.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // 遍历一遍二叉树就能出结果了
        traverse(root);
        return res;
    }

    // 记录 traverse 函数递归时的路径
    LinkedList<String> path = new LinkedList<>();
    // 记录所有从根节点到叶子节点的路径
    LinkedList<String> res = new LinkedList<>();

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // root 是叶子节点
        if (root.left == null && root.right == null) {
            path.addLast(root.val + "");
            // 将这条路径装入 res
            res.addLast(String.join("->", path));
            path.removeLast();
            return;
        }
        // 前序遍历位置
        path.addLast(root.val + "");
        // 递归遍历左右子树
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        path.removeLast();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func binaryTreePaths(root *TreeNode) []string {
    // 遍历一遍二叉树就能出结果了
    var res []string
    var path []string
    traverse(root, &path, &res)
    return res
}

// 记录 traverse 函数递归时的路径
// 记录所有从根节点到叶子节点的路径
func traverse(root *TreeNode, path *[]string, res *[]string) {
    if root == nil {
        return
    }
    // root 是叶子节点
    if root.Left == nil && root.Right == nil {
        *path = append(*path, strconv.Itoa(root.Val))
        // 将这条路径装入 res
        *res = append(*res, strings.Join(*path, "->"))
        *path = (*path)[:len(*path)-1]
        return
    }
    // 前序遍历位置
    *path = append(*path, strconv.Itoa(root.Val))
    // 递归遍历左右子树
    traverse(root.Left, path, res)
    traverse(root.Right, path, res)
    // 后序遍历位置
    *path = (*path)[:len(*path)-1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var binaryTreePaths = function(root) {
    // 遍历一遍二叉树就能出结果了
    // 记录所有从根节点到叶子节点的路径
    const res = [];
    // 记录 traverse 函数递归时的路径
    function traverse(root, path) {
        if (root === null) {
            return;
        }
        // root 是叶子节点
        if (root.left === null && root.right === null) {
            path.push(root.val + "");
            // 将这条路径装入 res
            res.push(path.join("->"));
            path.pop();
            return;
        }
        // 前序遍历位置
        path.push(root.val + "");
        // 递归遍历左右子树
        traverse(root.left, path);
        traverse(root.right, path);
        // 后序遍历位置
        path.pop();
    }
    traverse(root, []);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_binary-tree-paths"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-paths"></div></div>
</details><hr /><br />

</div>
</details>
</div>

