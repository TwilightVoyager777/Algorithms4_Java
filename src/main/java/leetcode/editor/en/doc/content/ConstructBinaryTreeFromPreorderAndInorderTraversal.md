<p>Given two integer arrays <code>preorder</code> and <code>inorder</code> where <code>preorder</code> is the preorder traversal of a binary tree and <code>inorder</code> is the inorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" /> 
<pre>
<strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
<strong>Output:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> preorder = [-1], inorder = [-1]
<strong>Output:</strong> [-1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= preorder.length &lt;= 3000</code></li> 
 <li><code>inorder.length == preorder.length</code></li> 
 <li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li> 
 <li><code>preorder</code> and <code>inorder</code> consist of <strong>unique</strong> values.</li> 
 <li>Each value of <code>inorder</code> also appears in <code>preorder</code>.</li> 
 <li><code>preorder</code> is <strong>guaranteed</strong> to be the preorder traversal of the tree.</li> 
 <li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | Divide and Conquer | Tree | Binary Tree</details><br>

<div>👍 16264, 👎 596<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/binary-tree-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

**构造二叉树，第一件事一定是找根节点，然后想办法构造左右子树**。

二叉树的前序和中序遍历结果的特点如下：

![](https://labuladong.online/algo/images/binary-tree-ii/1.jpeg)

前序遍历结果第一个就是根节点的值，然后再根据中序遍历结果确定左右子树的节点。

![](https://labuladong.online/algo/images/binary-tree-ii/4.jpeg)

结合这个图看代码辅助理解。

**详细题解**：
  - [二叉树心法（构造篇）](https://labuladong.online/algo/data-structure/binary-tree-part2/)
  - [【练习】用「分解问题」思维解题 I](https://labuladong.online/algo/problem-set/binary-tree-divide-i/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>
</div><div class="tab-content">
<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
    }

    // 定义：前序遍历数组为 preorder[preStart..preEnd]
    // 中序遍历数组为 inorder[inStart..inEnd]
    // 构造这个二叉树并返回该二叉树的根节点
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);/**<extend up -200>![](https://labuladong.online/algo/images/binary-tree-ii/4.jpeg) */
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
```

</div></div>
</div></div>

</div>
</details>
</div>

