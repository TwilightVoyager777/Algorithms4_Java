<p>You are given the <code>root</code> of a binary tree where each node has a value in the range <code>[0, 25]</code> representing the letters <code>'a'</code> to <code>'z'</code>.</p>

<p>Return <em>the <strong>lexicographically smallest</strong> string that starts at a leaf of this tree and ends at the root</em>.</p>

<p>As a reminder, any shorter prefix of a string is <strong>lexicographically smaller</strong>.</p>

<ul> 
 <li>For example, <code>"ab"</code> is lexicographically smaller than <code>"aba"</code>.</li> 
</ul>

<p>A leaf of a node is a node that has no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/30/tree1.png" style="width: 534px; height: 358px;" /> 
<pre>
<strong>Input:</strong> root = [0,1,2,3,4,3,4]
<strong>Output:</strong> "dba"
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/30/tree2.png" style="width: 534px; height: 358px;" /> 
<pre>
<strong>Input:</strong> root = [25,1,3,1,3,0,2]
<strong>Output:</strong> "adz"
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/01/tree3.png" style="height: 490px; width: 468px;" /> 
<pre>
<strong>Input:</strong> root = [2,2,1,null,1,0,null,0]
<strong>Output:</strong> "abc"
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 8500]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 25</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Backtracking | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 2383, 👎 336<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

代码看起来虽然多，但思路非常简单：用 `path` 维护递归遍历的路径，到达叶子节点的时候判断字典序最小的路径。

不要忘了在叶子节点的时候也要正确维护 `path` 变量，而且要把 StringBuilder 中的字符串反转才是题目想要的答案。

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

#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string smallestFromLeaf(TreeNode* root) {
        traverse(root);
        return res;
    }
    
    // 遍历过程中的路径
    string path;
    string res;

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        if (root->left == nullptr && root->right == nullptr) {
            // 找到叶子结点，比较字典序最小的路径
            // 结果字符串是从叶子向根，所以需要反转
            path.push_back('a' + root->val);
            reverse(path.begin(), path.end());
            
            if (res.empty() || res > path) {
                // 如果字典序更小，则更新 res
                res = path;
            }
            
            // 恢复，正确维护 path 中的元素
            reverse(path.begin(), path.end());
            path.pop_back();
            return;
        }
        
        // 前序位置
        path.push_back('a' + root->val);
        
        traverse(root->left);
        traverse(root->right);
        
        // 后序位置
        path.pop_back();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def smallestFromLeaf(self, root: TreeNode) -> str:
        self.traverse(root)
        return self.res
    
    # 遍历过程中的路径
    path = ""
    res = None

    # 二叉树遍历函数
    def traverse(self, root):
        if root is None:
            return
        if root.left is None and root.right is None:
            # 找到叶子结点，比较字典序最小的路径
            # 结果字符串是从叶子向根，所以需要反转
            self.path = chr(ord('a') + root.val) + self.path

            s = self.path
            if self.res is None or self.res > s:
                # 如果字典序更小，则更新 res
                self.res = s

            # 恢复，正确维护 path 中的元素
            self.path = self.path[1:]
            return
        # 前序位置
        self.path = chr(ord('a') + root.val) + self.path

        self.traverse(root.left)
        self.traverse(root.right)

        # 后序位置
        self.path = self.path[1:]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }
    // 遍历过程中的路径
    StringBuilder path = new StringBuilder();
    String res = null;

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 找到叶子结点，比较字典序最小的路径
            // 结果字符串是从叶子向根，所以需要反转
            path.append((char) ('a' + root.val));
            path.reverse();

            String s = path.toString();
            if (res == null || res.compareTo(s) > 0) {
                // 如果字典序更小，则更新 res
                res = s;
            }

            // 恢复，正确维护 path 中的元素
            path.reverse();
            path.deleteCharAt(path.length() - 1);
            return;
        }
        // 前序位置
        path.append((char) ('a' + root.val));

        traverse(root.left);
        traverse(root.right);

        // 后序位置
        path.deleteCharAt(path.length() - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func smallestFromLeaf(root *TreeNode) string {
    var path []byte
    var res string
    traverse(root, &path, &res)
    return res
}

// 遍历过程中的路径

// 二叉树遍历函数
func traverse(root *TreeNode, path *[]byte, res *string) {
    if root == nil {
        return
    }
    if root.Left == nil && root.Right == nil {
        // 找到叶子结点，比较字典序最小的路径
        // 结果字符串是从叶子向根，所以需要反转
        *path = append(*path, byte('a'+root.Val))
        reverse(path)

        s := string(*path)
        if *res == "" || *res > s {
            // 如果字典序更小，则更新 res
            *res = s
        }

        // 恢复，正确维护 path 中的元素
        reverse(path)
        *path = (*path)[:len(*path)-1]
        return
    }
    // 前序位置
    *path = append(*path, byte('a'+root.Val))

    traverse(root.Left, path, res)
    traverse(root.Right, path, res)

    // 后序位置
    *path = (*path)[:len(*path)-1]
}

func reverse(path *[]byte) {
    for i, j := 0, len(*path)-1; i < j; i, j = i+1, j-1 {
        (*path)[i], (*path)[j] = (*path)[j], (*path)[i]
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var smallestFromLeaf = function(root) {
    // 遍历过程中的路径
    let path = [];
    let res = null;

    // 二叉树遍历函数
    var traverse = function(root) {
        if (root === null) {
            return;
        }
        if (root.left === null && root.right === null) {
            // 找到叶子结点，比较字典序最小的路径
            // 结果字符串是从叶子向根，所以需要反转
            path.push(String.fromCharCode('a'.charCodeAt(0) + root.val));
            path.reverse();

            let s = path.join('');
            if (res === null || res.localeCompare(s) > 0) {
                // 如果字典序更小，则更新 res
                res = s;
            }

            // 恢复，正确维护 path 中的元素
            path.reverse();
            path.pop();
            return;
        }
        // 前序位置
        path.push(String.fromCharCode('a'.charCodeAt(0) + root.val));

        traverse(root.left);
        traverse(root.right);

        // 后序位置
        path.pop();
    };

    traverse(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_smallest-string-starting-from-leaf"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_smallest-string-starting-from-leaf"></div></div>
</details><hr /><br />

</div>
</details>
</div>

