<p>Given the <code>root</code> of a binary tree, each node in the tree has a distinct value.</p>

<p>After deleting all nodes with a value in <code>to_delete</code>, we are left with a forest (a disjoint union of trees).</p>

<p>Return the roots of the trees in the remaining forest. You may return the result in any order.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/07/01/screen-shot-2019-07-01-at-53836-pm.png" style="width: 237px; height: 150px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6,7], to_delete = [3,5]
<strong>Output:</strong> [[1,2,null,4],[6],[7]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2,4,null,3], to_delete = [3]
<strong>Output:</strong> [[1,2,4]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the given tree is at most <code>1000</code>.</li> 
 <li>Each node has a distinct value between <code>1</code> and <code>1000</code>.</li> 
 <li><code>to_delete.length &lt;= 1000</code></li> 
 <li><code>to_delete</code> contains distinct values between <code>1</code> and <code>1000</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 4747, 👎 144<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。

首先，如果在递归过程中修改二叉树结构，必须要让父节点接收递归函数的返回值，因为子树不管删成啥样，都要接到父节点上。

而且，[手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说了可以通过函数参数传递父节点传递的数据，所以可以在前序位置判断是否得到了一个新的根节点。

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

#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    unordered_set<int> delSet;
    // 记录森林的根节点
    vector<TreeNode*> res;

    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        for (int d : to_delete) {
            delSet.insert(d);
        }
        doDelete(root, false);
        return res;
    }

private:
    // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
    TreeNode* doDelete(TreeNode* root, bool hasParent) {
        if (root == nullptr) {
            return nullptr;
        }
        // 判断是否需要被删除
        bool deleted = delSet.count(root->val);
        if (!deleted && !hasParent) {
            // 没有父节点且不需要被删除，就是一个新的根节点
            res.push_back(root);
        }
        // 去左右子树进行删除
        root->left = doDelete(root->left, !deleted);
        root->right = doDelete(root->right, !deleted);
        // 如果需要被删除，返回 null 给父节点
        return deleted ? nullptr : root;
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
        self.delSet = set()
        # 记录森林的根节点
        self.res = []

    def delNodes(self, root, to_delete):
        if root is None:
            return []
        for d in to_delete:
            self.delSet.add(d)
        self.doDelete(root, False)
        return self.res

    # 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
    def doDelete(self, root, hasParent):
        if root is None:
            return None
        # 判断是否需要被删除
        deleted = root.val in self.delSet
        if not deleted and not hasParent:
            # 没有父节点且不需要被删除，就是一个新的根节点
            self.res.append(root)
        # 去左右子树进行删除
        root.left = self.doDelete(root.left, not deleted)
        root.right = self.doDelete(root.right, not deleted)
        # 如果需要被删除，返回 null 给父节点
        return None if deleted else root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    Set<Integer> delSet = new HashSet<>();
    // 记录森林的根节点
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new LinkedList<>();
        for (int d : to_delete) {
            delSet.add(d);
        }
        doDelete(root, false);
        return res;
    }

    // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
    private TreeNode doDelete(TreeNode root, boolean hasParent) {
        if (root == null) {
            return null;
        }
        // 判断是否需要被删除
        boolean deleted = delSet.contains(root.val);
        if (!deleted && !hasParent) {
            // 没有父节点且不需要被删除，就是一个新的根节点
            res.add(root);
        }
        // 去左右子树进行删除
        root.left = doDelete(root.left, !deleted);
        root.right = doDelete(root.right, !deleted);
        // 如果需要被删除，返回 null 给父节点
        return deleted ? null : root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
    delSet := make(map[int]bool)
    for _, d := range to_delete {
        delSet[d] = true
    }
    res := make([]*TreeNode, 0)
    doDelete(root, false, &res, delSet)
    return res
}

// 记录森林的根节点
// 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
func doDelete(root *TreeNode, hasParent bool, res *[]*TreeNode, delSet map[int]bool) *TreeNode {
    if root == nil {
        return nil
    }
    // 判断是否需要被删除
    deleted := delSet[root.Val]
    if !deleted && !hasParent {
        // 没有父节点且不需要被删除，就是一个新的根节点
        *res = append(*res, root)
    }
    // 去左右子树进行删除
    root.Left = doDelete(root.Left, !deleted, res, delSet)
    root.Right = doDelete(root.Right, !deleted, res, delSet)
    // 如果需要被删除，返回 null 给父节点
    if deleted {
        return nil
    }
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var delNodes = function(root, to_delete) {
    let delSet = new Set(to_delete);
    // 记录森林的根节点
    let res = [];

    function doDelete(root, hasParent) {
        // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
        if (root === null) {
            return null;
        }
        // 判断是否需要被删除
        let deleted = delSet.has(root.val);
        if (!deleted && !hasParent) {
            // 没有父节点且不需要被删除，就是一个新的根节点
            res.push(root);
        }
        // 去左右子树进行删除
        root.left = doDelete(root.left, !deleted);
        root.right = doDelete(root.right, !deleted);
        // 如果需要被删除，返回 null 给父节点
        return deleted ? null : root;
    }

    doDelete(root, false);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_delete-nodes-and-return-forest"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_delete-nodes-and-return-forest"></div></div>
</details><hr /><br />

</div>
</details>
</div>

