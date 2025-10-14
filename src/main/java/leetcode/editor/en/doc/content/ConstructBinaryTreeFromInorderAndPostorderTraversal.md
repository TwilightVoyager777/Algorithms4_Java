<p>Given two integer arrays <code>inorder</code> and <code>postorder</code> where <code>inorder</code> is the inorder traversal of a binary tree and <code>postorder</code> is the postorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" /> 
<pre>
<strong>Input:</strong> inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
<strong>Output:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> inorder = [-1], postorder = [-1]
<strong>Output:</strong> [-1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= inorder.length &lt;= 3000</code></li> 
 <li><code>postorder.length == inorder.length</code></li> 
 <li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li> 
 <li><code>inorder</code> and <code>postorder</code> consist of <strong>unique</strong> values.</li> 
 <li>Each value of <code>postorder</code> also appears in <code>inorder</code>.</li> 
 <li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li> 
 <li><code>postorder</code> is <strong>guaranteed</strong> to be the postorder traversal of the tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | Divide and Conquer | Tree | Binary Tree</details><br>

<div>👍 8549, 👎 150<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/binary-tree-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

**构造二叉树，第一件事一定是找根节点，然后想办法构造左右子树**。

二叉树的后序和中序遍历结果的特点如下：

![](https://labuladong.online/algo/images/binary-tree-ii/5.jpeg)

后序遍历结果最后一个就是根节点的值，然后再根据中序遍历结果确定左右子树的节点。

![](https://labuladong.online/algo/images/binary-tree-ii/6.jpeg)

结合这个图看代码辅助理解。

**详细题解**：
  - [二叉树心法（构造篇）](https://labuladong.online/algo/data-structure/binary-tree-part2/)
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

class Solution {
    // 存储 inorder 中值到索引的映射
    unordered_map<int, int> valToIndex;

public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for (int i = 0; i < inorder.size(); i++) {
            valToIndex[inorder[i]] = i;
        }
        return build(inorder, 0, inorder.size() - 1,
                     postorder, 0, postorder.size() - 1);
    }

    // 定义：中序遍历数组为 inorder[inStart..inEnd]，
    // 后序遍历数组为 postorder[postStart..postEnd]，
    // build 函数构造这个二叉树并返回该二叉树的根节点
    TreeNode* build(vector<int>& inorder, int inStart, int inEnd,
                    vector<int>& postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return nullptr;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex[rootVal];
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode* root = new TreeNode(rootVal);

        // 递归构造左右子树
        root->left = build(inorder, inStart, index - 1,
                           postorder, postStart, postStart + leftSize - 1);
        
        root->right = build(inorder, index + 1, inEnd,
                            postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 存储 inorder 中值到索引的映射
    val_to_index = {}

    def buildTree(self, inorder, postorder):
        for i in range(len(inorder)):
            self.val_to_index[inorder[i]] = i
        return self.build(inorder, 0, len(inorder) - 1,
                          postorder, 0, len(postorder) - 1)

    # 定义：中序遍历数组为 inorder[inStart..inEnd]，
    # 后序遍历数组为 postorder[postStart..postEnd]，
    # build 函数构造这个二叉树并返回该二叉树的根节点
    def build(self, inorder, in_start, in_end,
              postorder, post_start, post_end):

        if in_start > in_end:
            return None
        # root 节点对应的值就是后序遍历数组的最后一个元素
        root_val = postorder[post_end]
        # rootVal 在中序遍历数组中的索引
        index = self.val_to_index[root_val]
        # 左子树的节点个数
        left_size = index - in_start
        root = TreeNode(root_val) # <extend up -200>![](https://labuladong.online/algo/images/binary-tree-ii/6.jpeg) #
        # 递归构造左右子树
        root.left = self.build(inorder, in_start, index - 1,
                               postorder, post_start, post_start + left_size - 1)
        
        root.right = self.build(inorder, index + 1, in_end,
                                postorder, post_start + left_size, post_end - 1)
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }

    // 定义：中序遍历数组为 inorder[inStart..inEnd]，
    // 后序遍历数组为 postorder[postStart..postEnd]，
    // build 函数构造这个二叉树并返回该二叉树的根节点
    TreeNode build(int[] inorder, int inStart, int inEnd,
                int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);/**<extend up -200>![](https://labuladong.online/algo/images/binary-tree-ii/6.jpeg) */
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                         postorder, postStart, postStart + leftSize - 1);
        
        root.right = build(inorder, index + 1, inEnd,
                          postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func buildTree(inorder []int, postorder []int) *TreeNode {
    // 存储 inorder 中值到索引的映射
    indexMap := make(map[int]int)
    for i, v := range inorder {
        indexMap[v] = i
    }
    return build(inorder, 0, len(inorder)-1, postorder, 0, len(postorder)-1, indexMap)
}


// build 函数的定义：
// 后序遍历数组为 postorder[postStart..postEnd]，
// 中序遍历数组为 inorder[inStart..inEnd]，
// 构造二叉树，返回该二叉树的根节点
func build(inorder []int, inStart int, inEnd int, postorder []int, postStart int, postEnd int, indexMap map[int]int) *TreeNode {
    if inStart > inEnd {
        return nil
    }
    // root 节点对应的值就是后序遍历数组的最后一个元素
    rootVal := postorder[postEnd]
    // rootVal 在中序遍历数组中的索引
    index := indexMap[rootVal]
    // 左子树的节点个数
    leftSize := index - inStart
    
    root := &TreeNode{Val: rootVal}
    // 递归构造左右子树
    root.Left = build(inorder, inStart, index-1, postorder, postStart, postStart+leftSize-1, indexMap)
    root.Right = build(inorder, index+1, inEnd, postorder, postStart+leftSize, postEnd-1, indexMap)
    
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var buildTree = function(inorder, postorder) {
    // 存储 inorder 中值到索引的映射
    let valToIndex = new Map();
    for (let i = 0; i < inorder.length; i++) {
        valToIndex.set(inorder[i], i);
    }

    // 定义：中序遍历数组为 inorder[inStart..inEnd]，
    // 后序遍历数组为 postorder[postStart..postEnd]，
    // build 函数构造这个二叉树并返回该二叉树的根节点
    var build = function(inorder, inStart, inEnd, postorder, postStart, postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        let rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        let index = valToIndex.get(rootVal);
        // 左子树的节点个数
        let leftSize = index - inStart;
        let root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_construct-binary-tree-from-inorder-and-postorder-traversal"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_construct-binary-tree-from-inorder-and-postorder-traversal"></div></div>
</details><hr /><br />

</div>
</details>
</div>

