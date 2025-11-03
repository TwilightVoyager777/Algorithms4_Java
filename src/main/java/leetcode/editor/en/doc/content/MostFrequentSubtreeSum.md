<p>Given the <code>root</code> of a binary tree, return the most frequent <strong>subtree sum</strong>. If there is a tie, return all the values with the highest frequency in any order.</p>

<p>The <strong>subtree sum</strong> of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/24/freq1-tree.jpg" style="width: 207px; height: 183px;" /> 
<pre>
<strong>Input:</strong> root = [5,2,-3]
<strong>Output:</strong> [2,-3,4]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/24/freq2-tree.jpg" style="width: 207px; height: 183px;" /> 
<pre>
<strong>Input:</strong> root = [5,2,-5]
<strong>Output:</strong> [2]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 2352, 👎 329<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维，同时要利用后序位置来计算答案。

`sum` 函数根据子树的元素和推导出原树的所有元素和，只不过在后序遍历位置添加一些统计工作，便于找出出现频率最高的子树和。

**详细题解**：
  - [【练习】利用后序位置解题 I](https://labuladong.online/algo/problem-set/binary-tree-post-order-i/)

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
#include <unordered_map>
using namespace std;

class Solution {
    // sum -> count
    unordered_map<int, int> sumToCount;

public:
    vector<int> findFrequentTreeSum(TreeNode* root) {
        // 遍历二叉树，记录所有子树和及出现频率
        sum(root);
        // 找到最大的出现频率
        int maxCount = 0;
        for (auto& count : sumToCount) {
            maxCount = max(maxCount, count.second);
        }
        // 找到最大出现频率对应的的子树和
        vector<int> res;
        for (auto& key : sumToCount) {
            if (key.second == maxCount) {
                res.push_back(key.first);
            }
        }
        // The following comment is from the original Java code and is included for consistency.
        // It does not apply to C++ code since we are using a vector instead of an array.
        // 转化为 Java 数组
        // Note: In C++, the vector 'res' is directly returned and does not require conversion.
        return res;
    }

    // 定义：输入一个节点，返回以该节点为根的二叉树所有节点之和
    int sum(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftSum = sum(root->left);
        int rightSum = sum(root->right);
        int res = root->val + leftSum + rightSum;

        // 后序遍历位置，顺手记录子树和对应的频率
        sumToCount[res] = sumToCount.count(res) ? sumToCount[res] + 1 : 1;
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # sum -> count
    def __init__(self):
        self.sum_to_count = {}

    def findFrequentTreeSum(self, root):
        # traverse the binary tree and record all subtree sums and their frequencies
        self.sum(root)
        # find the highest frequency
        max_count = max(self.sum_to_count.values(), default=0)
        # find the subtree sums that have the highest frequency
        res = [key for key, count in self.sum_to_count.items() if count == max_count]
        # convert to a python list
        return res

    # definition: given a node, return the sum of all nodes in the subtree rooted at that node
    def sum(self, root):
        if not root:
            return 0
        left_sum = self.sum(root.left)
        right_sum = self.sum(root.right)
        res = root.val + left_sum + right_sum
        # postorder traversal position, record the frequency of the subtree sum
        self.sum_to_count[res] = self.sum_to_count.get(res, 0) + 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // sum -> count
    HashMap<Integer, Integer> sumToCount = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        // 遍历二叉树，记录所有子树和及出现频率
        sum(root);
        // 找到最大的出现频率
        int maxCount = 0;
        for (int count : sumToCount.values()) {
            maxCount = Math.max(maxCount, count);
        }
        // 找到最大出现频率对应的的子树和
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer key : sumToCount.keySet()) {
            if (sumToCount.get(key) == maxCount) {
                res.add(key);
            }
        }
        // 转化为 Java 数组
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    // 定义：输入一个节点，返回以该节点为根的二叉树所有节点之和
    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int res = root.val + leftSum + rightSum;

        // 后序遍历位置，顺手记录子树和对应的频率
        sumToCount.put(res, sumToCount.getOrDefault(res, 0) + 1);
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var sumToCount map[int]int

func findFrequentTreeSum(root *TreeNode) []int {
    sumToCount = make(map[int]int)
    
    // 遍历二叉树，记录所有子树和及出现频率
    sum(root)
    
    // 找到最大的出现频率
    maxCount := 0
    for _, count := range sumToCount {
        if count > maxCount {
            maxCount = count
        }
    }
    
    // 找到最大出现频率对应的的子树和
    var res []int
    for key, count := range sumToCount {
        if count == maxCount {
            res = append(res, key)
        }
    }
    
    return res
}

// 定义：输入一个节点，返回以该节点为根的二叉树所有节点之和
func sum(root *TreeNode) int {
    if root == nil {
        return 0
    }
    leftSum := sum(root.Left)
    rightSum := sum(root.Right)
    subtreeSum := root.Val + leftSum + rightSum
    
    // 后序遍历位置，顺手记录子树和对应的频率
    sumToCount[subtreeSum]++
    
    return subtreeSum
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var findFrequentTreeSum = function(root) {
    // sum -> count
    let sumToCount = new Map();

    // 定义：输入一个节点，返回以该节点为根的二叉树所有节点之和
    var sum = function(root) {
        if (root === null) {
            return 0;
        }
        let leftSum = sum(root.left);
        let rightSum = sum(root.right);
        let res = root.val + leftSum + rightSum;

        // 后序遍历位置，顺手记录子树和对应的频率
        sumToCount.set(res, (sumToCount.get(res) || 0) + 1);
        return res;
    };

    // 遍历二叉树，记录所有子树和及出现频率
    sum(root);

    // 找到最大的出现频率
    let maxCount = 0;
    for (let count of sumToCount.values()) {
        maxCount = Math.max(maxCount, count);
    }

    // 找到最大出现频率对应的的子树和
    let res = [];
    for (let [key, value] of sumToCount.entries()) {
        if (value === maxCount) {
            res.push(key);
        }
    }

    // 转化为 Java 数组
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_most-frequent-subtree-sum"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_most-frequent-subtree-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>

