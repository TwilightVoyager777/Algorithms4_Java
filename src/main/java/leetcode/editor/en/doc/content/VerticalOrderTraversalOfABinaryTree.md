<p>Given the <code>root</code> of a binary tree, calculate the <strong>vertical order traversal</strong> of the binary tree.</p>

<p>For each node at position <code>(row, col)</code>, its left and right children will be at positions <code>(row + 1, col - 1)</code> and <code>(row + 1, col + 1)</code> respectively. The root of the tree is at <code>(0, 0)</code>.</p>

<p>The <strong>vertical order traversal</strong> of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.</p>

<p>Return <em>the <strong>vertical order traversal</strong> of the binary tree</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree1.jpg" style="width: 431px; height: 304px;" /> 
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> [[9],[3,15],[20],[7]]
<strong>Explanation:</strong>
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree2.jpg" style="width: 512px; height: 304px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6,7]
<strong>Output:</strong> [[4],[2],[1,5,6],[3],[7]]
<strong>Explanation:</strong>
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/29/vtree3.jpg" style="width: 512px; height: 304px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,6,5,7]
<strong>Output:</strong> [[4],[2],[1,5,6],[3],[7]]
<strong>Explanation:</strong>
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Tree | Depth-First Search | Breadth-First Search | Sorting | Binary Tree</details><br>

<div>👍 8407, 👎 4384<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

看这题的难度是困难，但你别被吓住了，我们从简单的开始，如果以整棵树的根节点为坐标 `(0, 0)`，你如何打印出其他节点的坐标？

很简单，写出如下代码遍历一遍二叉树即可：

```java
void traverse(TreeNode root, int row, int col) {
    if (root == null) {
        return;
    }
    print(row, col);
    traverse(root.left, row + 1, col - 1);
    traverse(root.right, row + 1, col + 1);
}
```

然后就简单了，把这些坐标收集起来，依据题目要求进行排序，组装成题目要求的返回数据格式即可。

**详细题解**：
  - [【练习】用「遍历」思维解题 II](https://labuladong.online/algo/problem-set/binary-tree-traverse-ii/)

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
    // 记录每个节点和对应的坐标 (row, col)
    struct Triple {
        int row, col;
        TreeNode* node;

        Triple(TreeNode* node, int row, int col) {
            this->node = node;
            this->row = row;
            this->col = col;
        }
    };

public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        // 遍历二叉树，并且为所有节点生成对应的坐标
        traverse(root, 0, 0);
        // 根据题意，根据坐标值对所有节点进行排序：
        // 按照 col 从小到大排序，col 相同的话按 row 从小到大排序，
        // 如果 col 和 row 都相同，按照 node.val 从小到大排序。
        sort(nodes.begin(), nodes.end(), [](Triple a, Triple b) {
            if (a.col == b.col && a.row == b.row) {
                return a.node->val < b.node->val;
            }
            if (a.col == b.col) {
                return a.row < b.row;
            }
            return a.col < b.col;
        });
        // 将排好序的节点组装成题目要求的返回格式
        vector<vector<int>> res;
        // 记录上一列编号，初始化一个特殊值
        int preCol = INT_MIN;
        for (int i = 0; i < nodes.size(); i++) {
            Triple cur = nodes[i];
            if (cur.col != preCol) {
                // 开始记录新的一列
                res.push_back(vector<int>());
                preCol = cur.col;
            }
            res.back().push_back(cur.node->val);
        }

        return res;
    }

private:
    vector<Triple> nodes;
    // 二叉树遍历函数，记录所有节点对应的坐标
    void traverse(TreeNode* root, int row, int col) {
        if (root == nullptr) {
            return;
        }
        // 记录坐标
        nodes.push_back(Triple(root, row, col));
        // 二叉树遍历框架
        traverse(root->left, row + 1, col - 1);
        traverse(root->right, row + 1, col + 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 记录每个节点和对应的坐标 (row, col)
    class Triple:
        def __init__(self, node, row, col):
            self.node = node
            self.row = row
            self.col = col

    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        # 遍历二叉树，并且为所有节点生成对应的坐标
        self.traverse(root, 0, 0)
        # 根据题意，根据坐标值对所有节点进行排序：
        # 按照 col 从小到大排序，col 相同的话按 row 从小到大排序，
        # 如果 col 和 row 都相同，按照 node.val 从小到大排序。
        self.nodes.sort(key=lambda x: (x.col, x.row, x.node.val))
        # 将排好序的节点组装成题目要求的返回格式
        res = collections.deque()
        # 记录上一列编号，初始化一个特殊值
        preCol = float('-inf')
        for cur in self.nodes:
            if cur.col != preCol:
                # 开始记录新的一列
                res.append(collections.deque())
                preCol = cur.col
            res[-1].append(cur.node.val)

        return [list(col) for col in res]

    def __init__(self):
        self.nodes = []
        
    # 二叉树遍历函数，记录所有节点对应的坐标
    def traverse(self, root: TreeNode, row: int, col: int):
        if root is None:
            return
        # 记录坐标
        self.nodes.append(self.Triple(root, row, col))
        # 二叉树遍历框架
        self.traverse(root.left, row + 1, col - 1)
        self.traverse(root.right, row + 1, col + 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录每个节点和对应的坐标 (row, col)
    class Triple {
        public int row, col;
        public TreeNode node;

        public Triple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 遍历二叉树，并且为所有节点生成对应的坐标
        traverse(root, 0, 0);
        // 根据题意，根据坐标值对所有节点进行排序：
        // 按照 col 从小到大排序，col 相同的话按 row 从小到大排序，
        // 如果 col 和 row 都相同，按照 node.val 从小到大排序。
        Collections.sort(nodes, (Triple a, Triple b) -> {
            if (a.col == b.col && a.row == b.row) {
                return a.node.val - b.node.val;
            }
            if (a.col == b.col) {
                return a.row - b.row;
            }
            return a.col - b.col;
        });
        // 将排好序的节点组装成题目要求的返回格式
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 记录上一列编号，初始化一个特殊值
        int preCol = Integer.MIN_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            Triple cur = nodes.get(i);
            if (cur.col != preCol) {
                // 开始记录新的一列
                res.addLast(new LinkedList<>());
                preCol = cur.col;
            }
            res.getLast().add(cur.node.val);
        }

        return res;
    }

    ArrayList<Triple> nodes = new ArrayList<>();
    // 二叉树遍历函数，记录所有节点对应的坐标
    void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        // 记录坐标
        nodes.add(new Triple(root, row, col));
        // 二叉树遍历框架
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import (
    "sort"
)



// 记录每个节点和对应的坐标 (row, col)
type Triple struct {
    row, col int
    node     *TreeNode
}

func verticalTraversal(root *TreeNode) [][]int {
    var nodes []Triple
    // 遍历二叉树，并且为所有节点生成对应的坐标
    traverse(root, 0, 0, &nodes)
    // 根据题意，根据坐标值对所有节点进行排序：
    // 按照 col 从小到大排序，col 相同的话按 row 从小到大排序，
    // 如果 col 和 row 都相同，按照 node.val 从小到大排序。
    sort.Slice(nodes, func(i, j int) bool {
        if nodes[i].col == nodes[j].col && nodes[i].row == nodes[j].row {
            return nodes[i].node.Val < nodes[j].node.Val
        }
        if nodes[i].col == nodes[j].col {
            return nodes[i].row < nodes[j].row
        }
        return nodes[i].col < nodes[j].col
    })
    // 将排好序的节点组装成题目要求的返回格式
    var res [][]int
    // 记录上一列编号，初始化一个特殊值
    preCol := int(^uint(0) >> 1) // equivalent to Integer.MIN_VALUE in Java
    for _, cur := range nodes {
        if cur.col != preCol {
            // 开始记录新的一列
            res = append(res, []int{})
            preCol = cur.col
        }
        res[len(res)-1] = append(res[len(res)-1], cur.node.Val)
    }

    return res
}

// 二叉树遍历函数，记录所有节点对应的坐标
func traverse(root *TreeNode, row, col int, nodes *[]Triple) {
    if root == nil {
        return
    }
    // 记录坐标
    *nodes = append(*nodes, Triple{row, col, root})
    // 二叉树遍历框架
    traverse(root.Left, row+1, col-1, nodes)
    traverse(root.Right, row+1, col+1, nodes)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Triple {
    // 记录每个节点和对应的坐标 (row, col)
    constructor(node, row, col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

var verticalTraversal = function(root) {
    const nodes = [];
    // 遍历二叉树，并且为所有节点生成对应的坐标
    traverse(root, 0, 0, nodes);

    // 根据题意，根据坐标值对所有节点进行排序：
    // 按照 col 从小到大排序，col 相同的话按 row 从小到大排序，
    // 如果 col 和 row 都相同，按照 node.val 从小到大排序。
    nodes.sort((a, b) => {
        if (a.col === b.col && a.row === b.row) {
            return a.node.val - b.node.val;
        }
        if (a.col === b.col) {
            return a.row - b.row;
        }
        return a.col - b.col;
    });

    // 将排好序的节点组装成题目要求的返回格式
    const res = [];
    // 记录上一列编号，初始化一个特殊值
    let preCol = -Infinity;
    for (let i = 0; i < nodes.length; i++) {
        const cur = nodes[i];
        if (cur.col !== preCol) {
            // 开始记录新的一列
            res.push([]);
            preCol = cur.col;
        }
        res[res.length - 1].push(cur.node.val);
    }

    return res;
};

// 二叉树遍历函数，记录所有节点对应的坐标
function traverse(root, row, col, nodes) {
    if (root === null) {
        return;
    }
    // 记录坐标
    nodes.push(new Triple(root, row, col));
    // 二叉树遍历框架
    traverse(root.left, row + 1, col - 1, nodes);
    traverse(root.right, row + 1, col + 1, nodes);
}
```

</div></div>
</div></div>

</div>
</details>
</div>

