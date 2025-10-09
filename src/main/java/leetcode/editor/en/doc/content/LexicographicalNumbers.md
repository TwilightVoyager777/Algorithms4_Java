<p>Given an integer <code>n</code>, return all the numbers in the range <code>[1, n]</code> sorted in lexicographical order.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and uses <code>O(1)</code> extra space.&nbsp;</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> n = 13
<strong>Output:</strong> [1,10,11,12,13,2,3,4,5,6,7,8,9]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> [1,2]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Depth-First Search | Trie</details><br>

<div>👍 3091, 👎 213<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这个题还挺有意思，要不是它把这道题放在 DFS 的题目分类里面，可能还不太好发现这是一个 DFS 的题目。

既然题目提示你这是个 DFS 的题目了，你心里那棵递归树出来没有？如果没有，建议去看看前文 [二叉树视角学习递归思维](https://labuladong.online/algo/essential-technique/binary-tree-summary/)。

它的递归树大概是这样生长的：

首先看 1 这个节点，1 可以生出二位数 10, 11, 12...

其中 10 又可以生出 100, 101, 102...，11 又可以生出 110, 111, 112...

这棵多叉树是不是就出来了？每个节点最多可以生出 10 个节点，这就是一个十叉树。

还是想不出来？看可视化面板。实际的解法代码需要以 1~9 分别作为根节点，画 9 棵多叉树，**这里仅仅以 1 为根节点画递归树，方便你理解**：

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_lexicographical-numbers-example"  category="tutorial" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_lexicographical-numbers-example"></div></div>
</details><hr /><br />

我们只需要以前序顺序遍历这棵多叉树，收集所有小于 `n` 的节点，就可以得到题目想要的答案。

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

#include <vector>

class Solution {

    std::vector<int> res;

public:
    std::vector<int> lexicalOrder(int n) {
        // 总共有 9 棵多叉树，从 1 开始
        for (int i = 1; i < 10; i++) {
            traverse(i, n);
        }
        return res;
    }

    // 多叉树遍历框架，前序位置收集所有小于 n 的节点
    void traverse(int root, int n) {
        if (root > n) {
            return;
        }
        res.push_back(root);

        for (int child = root * 10; child < root * 10 + 10; child++) {
            traverse(child, n);
        }
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
        self.res = []

    def lexicalOrder(self, n: int) -> List[int]:
        # 总共有 9 棵多叉树，从 1 开始
        for i in range(1, 10):
            self.traverse(i, n)
        return self.res

    # 多叉树遍历框架，前序位置收集所有小于 n 的节点
    def traverse(self, root: int, n: int) -> None:
        if root > n:
            return
        self.res.append(root)
        for child in range(root * 10, root * 10 + 10):
            if child > n:
                break
            self.traverse(child, n)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        // 总共有 9 棵多叉树，从 1 开始
        for (int i = 1; i < 10; i++) {
            traverse(i, n);
        }
        return res;
    }

    // 多叉树遍历框架，前序位置收集所有小于 n 的节点
    void traverse(int root, int n) {
        if (root > n) {
            return;
        }
        res.add(root);

        for (int child = root * 10; child < root * 10 + 10; child++) {
            traverse(child, n);
        }
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func lexicalOrder(n int) []int {
    var res []int
    // 总共有 9 棵多叉树，从 1 开始
    for i := 1; i < 10; i++ {
        traverse(i, n, &res)
    }
    return res
}

// 多叉树遍历框架，前序位置收集所有小于 n 的节点
func traverse(root, n int, res *[]int) {
    if root > n {
        return
    }
    *res = append(*res, root)

    for child := root * 10; child < root*10+10; child++ {
        traverse(child, n, res)
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var lexicalOrder = function(n) {
    let res = [];
    
    // 总共有 9 棵多叉树，从 1 开始
    for (let i = 1; i < 10; i++) {
        traverse(i, n);
    }
    return res;

    // 多叉树遍历框架，前序位置收集所有小于 n 的节点
    function traverse(root, n) {
        if (root > n) {
            return;
        }
        res.push(root);

        for (let child = root * 10; child < root * 10 + 10; child++) {
            traverse(child, n);
        }
    }
};
```

</div></div>
</div></div>

</div>
</details>
</div>

