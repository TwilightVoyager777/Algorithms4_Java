<p>In an infinite binary tree where every node has two children, the nodes are labelled in row order.</p>

<p>In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/06/24/tree.png" style="width: 300px; height: 138px;" /></p>

<p>Given the <code>label</code> of a node in this tree, return the labels in the path from the root of the tree to the&nbsp;node with that <code>label</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> label = 14
<strong>Output:</strong> [1,3,4,14]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> label = 26
<strong>Output:</strong> [1,2,6,10,26]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= label &lt;= 10^6</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Math | Tree | Binary Tree</details><br>

<div>👍 1530, 👎 328<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果你看过前文 [二叉堆（优先级队列）原理及实现](https://labuladong.online/algo/data-structure-basic/binary-heap-basic/)，就知道这种完全二叉树可以通过索引来模拟左右指针以及父节点指针。

具体来说，先假设全都是从左到右排列，没有之字形排列的这个条件：

![](https://labuladong.online/algo/images/brief-extra/1104.png)

如果我想求到达某一个 `label` 节点的路径，那么我一直对 `label` 除以 2 就行了（忽略余数）。

你比如我想求到达 13 的路径，就是 13, 6, 3, 1，然后反转一下就行了。大致的代码逻辑如下：

```java
ArrayList<Integer> path = new ArrayList<>();
while (label >= 1) {
    path.add(label);
    label = label / 2;
}
// 反转成从根节点到目标节点的路径
Collections.reverse(path);
```

现在虽然是之字形排列，但稍加修改就可以适应这个变化：

![](https://labuladong.online/algo/images/brief-extra/tree.png)

13 的父节点不是 6 了，而是 7 - (6 - 4) = 5。

这个 7 和 4 是哪里来的？就是 6 这一行的最小节点值和最大节点值，而对于完全二叉树，每一行的最大最小值可以通过计算 2 的指数算出来的。

理解了上述思路，就能看懂解法代码了。

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

class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        vector<int> path;
        while (label >= 1) {
            path.push_back(label);
            int depth = log2(label);
            vector<int> range = getLevelRange(depth);
            // 由于之字形分布，根据上层的节点取值范围，修正父节点
            label = range[1] - (label - range[0]);
            label /= 2;
        }
        // 反转成从根节点到目标节点的路径
        reverse(path.begin(), path.end());
        return path;
    }

private:
    // 获取第 n 层节点的取值范围
    vector<int> getLevelRange(int n) {
        int p = pow(2, n);
        return {p, 2 * p - 1};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import math
from typing import List

class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:
        path = []
        while label >= 1:
            path.append(label)
            label = label // 2

            if label == 0:
                break

            depth = self.log(label)
            range_ = self.getLevelRange(depth)
            # 由于之字形分布，根据上层的节点取值范围，修正父节点
            label = range_[1] - (label - range_[0])
        
        # 反转成从根节点到目标节点的路径
        path.reverse()
        return path

    # 获取第 n 层节点的取值范围
    def getLevelRange(self, n: int) -> List[int]:
        p = 2 ** n
        return [p, 2 * p - 1]

    def log(self, x: int) -> int:
        if x == 0:
            return 0
        return int(math.log(x) / math.log(2))
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> path = new ArrayList<>();
        while (label >= 1) {
            path.add(label);
            label = label / 2;

            int depth = log(label);
            int[] range = getLevelRange(depth);
            // 由于之字形分布，根据上层的节点取值范围，修正父节点
            label = range[1] - (label - range[0]);
        }
        // 反转成从根节点到目标节点的路径
        Collections.reverse(path);
        return path;
    }

    // 获取第 n 层节点的取值范围
    private int[] getLevelRange(int n) {
        int p = (int) Math.pow(2, n);
        return new int[]{p, 2 * p - 1};
    }

    int log(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func pathInZigZagTree(label int) []int {
    var path []int
    for label >= 1 {
        path = append(path, label)
        label = label / 2

        depth := log(label)
        rangeVals := getLevelRange(depth)
        // 由于之字形分布，根据上层的节点取值范围，修正父节点
        label = rangeVals[1] - (label - rangeVals[0])
    }
    // 反转成从根节点到目标节点的路径
    reverse(path)
    return path
}

// 获取第 n 层节点的取值范围
func getLevelRange(n int) []int {
    p := int(math.Pow(2, float64(n)))
    return []int{p, 2*p - 1}
}

func log(x int) int {
    return int(math.Log(float64(x)) / math.Log(2))
}

func reverse(nums []int) {
    for i, j := 0, len(nums)-1; i < j; i, j = i+1, j-1 {
        nums[i], nums[j] = nums[j], nums[i]
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var pathInZigZagTree = function(label) {
    let path = [];
    while (label >= 1) {
        path.push(label);
        label = Math.floor(label / 2);

        let depth = log(label);
        let range = getLevelRange(depth);
        // 由于之字形分布，根据上层的节点取值范围，修正父节点
        label = range[1] - (label - range[0]);
    }
    // 反转成从根节点到目标节点的路径
    path.reverse();
    return path;
};

// 获取第 n 层节点的取值范围
function getLevelRange(n) {
    let p = Math.pow(2, n);
    return [p, 2 * p - 1];
}

function log(x) {
    return Math.floor(Math.log(x) / Math.log(2));
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_path-in-zigzag-labelled-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_path-in-zigzag-labelled-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

