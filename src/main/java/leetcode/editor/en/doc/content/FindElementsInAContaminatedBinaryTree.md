<p>Given a binary tree with the following rules:</p>

<ol> 
 <li><code>root.val == 0</code></li> 
 <li>For any <code>treeNode</code>: 
  <ol type="a"> 
   <li>If <code>treeNode.val</code> has a value <code>x</code> and <code>treeNode.left != null</code>, then <code>treeNode.left.val == 2 * x + 1</code></li> 
   <li>If <code>treeNode.val</code> has a value <code>x</code> and <code>treeNode.right != null</code>, then <code>treeNode.right.val == 2 * x + 2</code></li> 
  </ol> </li> 
</ol>

<p>Now the binary tree is contaminated, which means all <code>treeNode.val</code> have been changed to <code>-1</code>.</p>

<p>Implement the <code>FindElements</code> class:</p>

<ul> 
 <li><code>FindElements(TreeNode* root)</code> Initializes the object with a contaminated binary tree and recovers it.</li> 
 <li><code>bool find(int target)</code> Returns <code>true</code> if the <code>target</code> value exists in the recovered binary tree.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/06/untitled-diagram-4-1.jpg" style="width: 320px; height: 119px;" /> 
<pre>
<strong>Input</strong>
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
<strong>Output</strong>
[null,false,true]
<strong>Explanation</strong>
FindElements findElements = new FindElements([-1,null,-1]); 
findElements.find(1); // return False 
findElements.find(2); // return True </pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/06/untitled-diagram-4.jpg" style="width: 400px; height: 198px;" /> 
<pre>
<strong>Input</strong>
["FindElements","find","find","find"]
[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
<strong>Output</strong>
[null,true,true,false]
<strong>Explanation</strong>
FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
findElements.find(1); // return True
findElements.find(3); // return True
findElements.find(5); // return False</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/07/untitled-diagram-4-1-1.jpg" style="width: 306px; height: 274px;" /> 
<pre>
<strong>Input</strong>
["FindElements","find","find","find","find"]
[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
<strong>Output</strong>
[null,true,false,false,true]
<strong>Explanation</strong>
FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
findElements.find(2); // return True
findElements.find(3); // return False
findElements.find(4); // return False
findElements.find(5); // return True
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>TreeNode.val == -1</code></li> 
 <li>The height of the binary tree is less than or equal to <code>20</code></li> 
 <li>The total number of nodes is between <code>[1, 10<sup>4</sup>]</code></li> 
 <li>Total calls of <code>find()</code> is between <code>[1, 10<sup>4</sup>]</code></li> 
 <li><code>0 &lt;= target &lt;= 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Tree | Depth-First Search | Breadth-First Search | Design | Binary Tree</details><br>

<div>👍 1419, 👎 126<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

还原二叉树的时候只需要遍历所有节点，通过函数参数传递每个节点的值；由于节点的个数规模不算大，所以可以直接用一个 HashSet 缓存所有节点值，实现 `find` 函数的功能。

当然，题目给的这种二叉树节点的取值规律非常像用数组存储完全二叉树的场景，所以你应该可以通过 `target` 推算出来它在第几层的什么位置，不过我这里就不实现了，类似的题目你可以参考  [✨1104. 二叉树寻路](/problems/path-in-zigzag-labelled-binary-tree/) 和 [✨662. 二叉树最大宽度](/problems/maximum-width-of-binary-tree/)。

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

#include <unordered_set>

// Make sure TreeNode is defined before including this code block.

class FindElements {
    // 帮助 find 函数快速判断
    std::unordered_set<int> values;

public:
    FindElements(TreeNode* root) {
        // 还原二叉树中的值
        traverse(root, 0);
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root, int val) {
        if (root == nullptr) {
            return;
        }
        root->val = val;
        values.insert(val);

        traverse(root->left, 2 * val + 1);
        traverse(root->right, 2 * val + 2);
    }

    bool find(int target) {
        return values.count(target) > 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class FindElements:
    # 帮助 find 函数快速判断
    def __init__(self, root):
        # 还原二叉树中的值
        self.values = set()
        self.traverse(root, 0)

    # 二叉树遍历函数
    def traverse(self, root, val):
        if root is None:
            return
        root.val = val
        self.values.add(val)

        self.traverse(root.left, 2 * val + 1)
        self.traverse(root.right, 2 * val + 2)

    def find(self, target):
        return target in self.values
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class FindElements {
    // 帮助 find 函数快速判断
    HashSet<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        // 还原二叉树中的值
        traverse(root, 0);

    }

    // 二叉树遍历函数
    void traverse(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        root.val = val;
        values.add(val);

        traverse(root.left, 2 * val + 1);
        traverse(root.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type FindElements struct {
    // 帮助 find 函数快速判断
    values map[int]bool
}

func Constructor(root *TreeNode) FindElements {
    // 还原二叉树中的值
    fe := FindElements{values: make(map[int]bool)}
    fe.traverse(root, 0)
    return fe
}

// 二叉树遍历函数
func (this *FindElements) traverse(root *TreeNode, val int) {
    if root == nil {
        return
    }
    root.Val = val
    this.values[val] = true

    this.traverse(root.Left, 2*val + 1)
    this.traverse(root.Right, 2*val + 2)
}

func (this *FindElements) Find(target int) bool {
    return this.values[target]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var FindElements = function(root) {
    // 帮助 find 函数快速判断
    this.values = new Set();

    // 还原二叉树中的值
    this.traverse = function(root, val) {
        if (root === null) {
            return;
        }
        root.val = val;
        this.values.add(val);

        this.traverse(root.left, 2 * val + 1);
        this.traverse(root.right, 2 * val + 2);
    };

    this.traverse(root, 0);
};

// 二叉树遍历函数
FindElements.prototype.find = function(target) {
    return this.values.has(target);
};
```

</div></div>
</div></div>

</div>
</details>
</div>

