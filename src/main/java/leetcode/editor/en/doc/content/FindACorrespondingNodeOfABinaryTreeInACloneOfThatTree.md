<p>Given two binary trees <code>original</code> and <code>cloned</code> and given a reference to a node <code>target</code> in the original tree.</p>

<p>The <code>cloned</code> tree is a <strong>copy of</strong> the <code>original</code> tree.</p>

<p>Return <em>a reference to the same node</em> in the <code>cloned</code> tree.</p>

<p><strong>Note</strong> that you are <strong>not allowed</strong> to change any of the two trees or the <code>target</code> node and the answer <strong>must be</strong> a reference to a node in the <code>cloned</code> tree.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/02/21/e1.png" style="width: 544px; height: 426px;" /> 
<pre>
<strong>Input:</strong> tree = [7,4,3,null,null,6,19], target = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/02/21/e2.png" style="width: 221px; height: 159px;" /> 
<pre>
<strong>Input:</strong> tree = [7], target =  7
<strong>Output:</strong> 7
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/02/21/e3.png" style="width: 459px; height: 486px;" /> 
<pre>
<strong>Input:</strong> tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the <code>tree</code> is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li>The values of the nodes of the <code>tree</code> are unique.</li> 
 <li><code>target</code> node is a node from the <code>original</code> tree and is not <code>null</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Could you solve the problem if repeated values on the tree are allowed?</p>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 1801, 👎 2015<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题可以同时用到两种思维。

说白了，这道题就是让你从一棵二叉树中搜索一个目标节点，考虑到题目的 follow up 问你节点的值存在重复的情况，所以用对比节点引用的方式进行比较。

**详细题解**：
  - [【练习】同时运用两种思维解题](https://labuladong.online/algo/problem-set/binary-tree-combine-two-view/)

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

// 遍历的思路
class Solution {
public:
    // 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        this->target = target;
        traverse(original, cloned);
        return res;
    }

    TreeNode* target = nullptr, *res = nullptr;

    // 二叉树遍历函数
    void traverse(TreeNode* original, TreeNode* cloned) {
        if (original == nullptr || res != nullptr) {
            return;
        }
        if (original == target) {
            res = cloned;
            return;
        }
        // 二叉树遍历框架
        traverse(original->left, cloned->left);
        traverse(original->right, cloned->right);
    }
};

// 分解问题的思路
class Solution2 {
public:
    // 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        if (original == nullptr) {
            return nullptr;
        }
        // 找到目标节点
        if (target == original) {
            return cloned;
        }
        // 去左子树找
        TreeNode* left = getTargetCopy(original->left, cloned->left, target);
        if (left != nullptr) {
            return left;
        }
        // 左子树找不到的话去右子树找
        return getTargetCopy(original->right, cloned->right, target);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 遍历的思路
class Solution:
    # 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        self.target = target
        self.res = None
        self.traverse(original, cloned)
        return self.res

    # 二叉树遍历函数
    def traverse(self, original: TreeNode, cloned: TreeNode):
        if original is None or self.res is not None:
            return
        if original == self.target:
            self.res = cloned
            return
        # 二叉树遍历框架
        self.traverse(original.left, cloned.left)
        self.traverse(original.right, cloned.right)


# 分解问题的思路
class Solution2:
    # 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if original is None:
            return None
        # 找到目标节点
        if target == original:
            return cloned
        # 去左子树找
        left = self.getTargetCopy(original.left, cloned.left, target)
        if left is not None:
            return left
        # 左子树找不到的话去右子树找
        return self.getTargetCopy(original.right, cloned.right, target)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 遍历的思路
class Solution {
    // 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        traverse(original, cloned);
        return res;
    }

    TreeNode target, res;

    // 二叉树遍历函数
    void traverse(TreeNode original, TreeNode cloned) {
        if (original == null || res != null) {
            return;
        }
        if (original == target) {
            res = cloned;
            return;
        }
        // 二叉树遍历框架
        traverse(original.left, cloned.left);
        traverse(original.right, cloned.right);
    }
}

// 分解问题的思路
class Solution2 {
    // 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        // 找到目标节点
        if (target == original) {
            return cloned;
        }
        // 去左子树找
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        // 左子树找不到的话去右子树找
        return getTargetCopy(original.right, cloned.right, target);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 遍历的思路
func getTargetCopy(original *TreeNode, cloned *TreeNode, target *TreeNode) *TreeNode {
    // 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    var res *TreeNode
    // 二叉树遍历函数
    var traverse func(o *TreeNode, c *TreeNode)
    traverse = func(o *TreeNode, c *TreeNode) {
        if o == nil || res != nil {
            return
        }
        if o == target {
            res = c
            return
        }
        // 二叉树遍历框架
        traverse(o.Left, c.Left)
        traverse(o.Right, c.Right)
    }

    traverse(original, cloned)
    return res
}

// 分解问题的思路

func getTargetCopy2(original *TreeNode, cloned *TreeNode, target *TreeNode) *TreeNode {
    // 定义：找到 original 中 target 节点在 cloned 树中对应的节点
    if original == nil {
        return nil
    }
    // 找到目标节点
    if target == original {
        return cloned
    }
    // 去左子树找
    left := getTargetCopy2(original.Left, cloned.Left, target)
    if left != nil {
        return left
    }
    // 左子树找不到的话去右子树找
    return getTargetCopy2(original.Right, cloned.Right, target)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 遍历的思路
// 定义：找到 original 中 target 节点在 cloned 树中对应的节点
var getTargetCopy = function(original, cloned, target) {
    let res = null;

    // 二叉树遍历函数
    var traverse = function(original, cloned) {
        if (original == null || res != null) {
            return;
        }
        if (original === target) {
            res = cloned;
            return;
        }
        // 二叉树遍历框架
        traverse(original.left, cloned.left);
        traverse(original.right, cloned.right);
    };

    traverse(original, cloned);
    return res;
};

// 分解问题的思路
// 定义：找到 original 中 target 节点在 cloned 树中对应的节点
var getTargetCopy2 = function(original, cloned, target) {
    if (original == null) {
        return null;
    }
    // 找到目标节点
    if (target === original) {
        return cloned;
    }
    // 去左子树找
    let left = getTargetCopy2(original.left, cloned.left, target);
    if (left != null) {
        return left;
    }
    // 左子树找不到的话去右子树找
    return getTargetCopy2(original.right, cloned.right, target);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

