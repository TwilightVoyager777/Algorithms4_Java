<p>You are given the <code>head</code> of a linked list with <code>n</code> nodes.</p>

<p>For each node in the list, find the value of the <strong>next greater node</strong>. That is, for each node, find the value of the first node that is next to it and has a <strong>strictly larger</strong> value than it.</p>

<p>Return an integer array <code>answer</code> where <code>answer[i]</code> is the value of the next greater node of the <code>i<sup>th</sup></code> node (<strong>1-indexed</strong>). If the <code>i<sup>th</sup></code> node does not have a next greater node, set <code>answer[i] = 0</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/05/linkedlistnext1.jpg" style="width: 304px; height: 133px;" /> 
<pre>
<strong>Input:</strong> head = [2,1,5]
<strong>Output:</strong> [5,5,0]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/05/linkedlistnext2.jpg" style="width: 500px; height: 113px;" /> 
<pre>
<strong>Input:</strong> head = [2,7,4,3,5]
<strong>Output:</strong> [7,0,5,5,0]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is <code>n</code>.</li> 
 <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= Node.val &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Linked List | Stack | Monotonic Stack</details><br>

<div>👍 3452, 👎 124<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题输入的是一条单链表，我们把它转化成数组，方便用索引访问即可直接套用 [单调栈模板](https://labuladong.online/algo/data-structure/monotonic-stack/) 中的 `nextGreaterElement` 函数逻辑。

**详细题解**：
  - [【练习】单调栈的几种变体及经典习题](https://labuladong.online/algo/problem-set/monotonic-stack/)

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
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> nextLargerNodes(ListNode* head) {
        // 把单链表转化成数组，方便通过索引访问
        vector<int> nums;
        for (ListNode* p = head; p != nullptr; p = p->next) {
            nums.push_back(p->val);
        }
        // 存放答案的数组
        vector<int> res(nums.size());
        stack<int> stk;
        // 单调栈模板，求下一个更大元素，从后往前遍历
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stk.empty() && stk.top() <= nums[i]) {
                stk.pop();
            }
            // 本题要求没有下一个更大元素时返回 0
            res[i] = stk.empty() ? 0 : stk.top();
            stk.push(nums[i]);
        }
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
    def nextLargerNodes(self, head: ListNode) -> List[int]:
        # 把单链表转化成数组，方便通过索引访问
        nums = []
        p = head
        while p:
            nums.append(p.val)
            p = p.next
        
        # 存放答案的数组
        res = [0] * len(nums)
        stk = []
        
        # 单调栈模板，求下一个更大元素，从后往前遍历
        for i in range(len(nums) - 1, -1, -1):
            while stk and stk[-1] <= nums[i]:
                stk.pop()
            # 本题要求没有下一个更大元素时返回 0
            res[i] = 0 if not stk else stk[-1]
            stk.append(nums[i])
        
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // 把单链表转化成数组，方便通过索引访问
        ArrayList<Integer> nums = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            nums.add(p.val);
        }
        // 存放答案的数组
        int[] res = new int[nums.size()];
        Stack<Integer> stk = new Stack<>();
        // 单调栈模板，求下一个更大元素，从后往前遍历
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums.get(i)) {
                stk.pop();
            }
            // 本题要求没有下一个更大元素时返回 0
            res[i] = stk.isEmpty() ? 0 : stk.peek();
            stk.push(nums.get(i));
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func nextLargerNodes(head *ListNode) []int {
    // 把单链表转化成数组，方便通过索引访问
    nums := []int{}
    for p := head; p != nil; p = p.Next {
        nums = append(nums, p.Val)
    }
    // 存放答案的数组
    res := make([]int, len(nums))
    stk := []int{}
    // 单调栈模板，求下一个更大元素，从后往前遍历
    for i := len(nums) - 1; i >= 0; i-- {
        for len(stk) > 0 && stk[len(stk)-1] <= nums[i] {
            stk = stk[:len(stk)-1]
        }
        // 本题要求没有下一个更大元素时返回 0
        res[i] = 0
        if len(stk) > 0 {
            res[i] = stk[len(stk)-1]
        }
        stk = append(stk, nums[i])
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var nextLargerNodes = function(head) {
    // 把单链表转化成数组，方便通过索引访问
    let nums = [];
    for (let p = head; p !== null; p = p.next) {
        nums.push(p.val);
    }
    // 存放答案的数组
    let res = new Array(nums.length).fill(0);
    let stk = [];
    // 单调栈模板，求下一个更大元素，从后往前遍历
    for (let i = nums.length - 1; i >= 0; i--) {
        while (stk.length > 0 && stk[stk.length - 1] <= nums[i]) {
            stk.pop();
        }
        // 本题要求没有下一个更大元素时返回 0
        res[i] = stk.length === 0 ? 0 : stk[stk.length - 1];
        stk.push(nums[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_next-greater-node-in-linked-list"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_next-greater-node-in-linked-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>

