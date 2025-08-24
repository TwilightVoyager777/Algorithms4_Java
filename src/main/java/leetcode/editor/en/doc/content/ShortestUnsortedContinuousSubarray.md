<p>Given an integer array <code>nums</code>, you need to find one <b>continuous subarray</b> such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.</p>

<p>Return <em>the shortest such subarray and output its length</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,6,4,8,10,9,15]
<strong>Output:</strong> 5
<strong>Explanation:</strong> You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Can you solve it in 
<code>O(n)</code> time complexity?

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers | Stack | Greedy | Sorting | Monotonic Stack</details><br>

<div>👍 7922, 👎 272<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

最简单的解法是排序，排序之后很容易看出来哪一部分子数组乱序了。这里主要介绍一下单调栈的解法。

单调递增栈会筛选出递增的元素序列，换句话说，每加入一个新元素 `x`，就会弹出栈顶大于 `x` 的其他元素，直到栈顶元素小于 `x` 为止。

反过来，单调递减栈会筛选出递减的元素序列，换句话说，每加入一个新元素 `x`，就会弹出栈顶小于 `x` 的其他元素，直到栈顶元素大于 `x` 为止。

综上，如果正序遍历 `nums`，维护一个递增栈，那么弹出的元素就是乱序的元素；如果反向遍历 `nums`，维护一个递减栈，那么弹出的元素就是乱序的元素。

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

// 排序解法
class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        vector<int> temp = nums;
        sort(temp.begin(), temp.end());
        int left = INT_MAX, right = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            if (temp[i] != nums[i]) {
                left = i;
                break;
            }
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (temp[i] != nums[i]) {
                right = i;
                break;
            }
        }
        if (left == INT_MAX && right == INT_MIN) {
            // nums 本来就是有序的
            return 0;
        }
        return right - left + 1;
    }
};

// 单调栈解法
class Solution2 {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size();
        int left = INT_MAX, right = INT_MIN;
        // 递增栈，存储元素索引
        stack<int> incrStk;
        for (int i = 0; i < n; i++) {
            while (!incrStk.empty() && nums[incrStk.top()] > nums[i]) {
                // 弹出的元素都是乱序元素，其中最小的索引就是乱序子数组的左边界
                left = min(left, incrStk.top());
                incrStk.pop();
            }
            incrStk.push(i);
        }
        // 递减栈，存储元素索引
        stack<int> decrStk;
        for (int i = n - 1; i >= 0; i--) {
            while (!decrStk.empty() && nums[decrStk.top()] < nums[i]) {
                // 弹出的元素都是乱序元素，其中最大的索引就是乱序子数组的右边界
                right = max(right, decrStk.top());
                decrStk.pop();
            }
            decrStk.push(i);
        }
        if (left == INT_MAX && right == INT_MIN) {
            // 说明单调栈没有弹出任何元素，即 nums 本来就是有序的
            return 0;
        }
        return right - left + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 排序解法
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        temp = sorted(nums)
        left = float('inf')
        right = float('-inf')
        for i in range(len(nums)):
            if temp[i] != nums[i]:
                left = i
                break
        for i in range(len(nums) - 1, -1, -1):
            if temp[i] != nums[i]:
                right = i
                break
        if left == float('inf') and right == float('-inf'):
            # nums 本来就是有序的
            return 0
        return right - left + 1

# 单调栈解法
class Solution2:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        left = float('inf')
        right = float('-inf')
        # 递增栈，存储元素索引
        incr_stk = []
        for i in range(n):
            while incr_stk and nums[incr_stk[-1]] > nums[i]:
                # 弹出的元素都是乱序元素，其中最小的索引就是乱序子数组的左边界
                left = min(left, incr_stk.pop())
            incr_stk.append(i)
        # 递减栈，存储元素索引
        decr_stk = []
        for i in range(n - 1, -1, -1):
            while decr_stk and nums[decr_stk[-1]] < nums[i]:
                # 弹出的元素都是乱序元素，其中最大的索引就是乱序子数组的右边界
                right = max(right, decr_stk.pop())
            decr_stk.append(i)
        if left == float('inf') and right == float('-inf'):
            # 说明单调栈没有弹出任何元素，即 nums 本来就是有序的
            return 0
        return right - left + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 排序解法
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (temp[i] != nums[i]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (temp[i] != nums[i]) {
                right = i;
                break;
            }
        }
        if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
            // nums 本来就是有序的
            return 0;
        }
        return right - left + 1;
    }
}

// 单调栈解法
class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        // 递增栈，存储元素索引
        Stack<Integer> incrStk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!incrStk.isEmpty() && nums[incrStk.peek()] > nums[i]) {
                // 弹出的元素都是乱序元素，其中最小的索引就是乱序子数组的左边界
                left = Math.min(left, incrStk.pop());
            }
            incrStk.push(i);
        }
        // 递减栈，存储元素索引
        Stack<Integer> decrStk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!decrStk.isEmpty() && nums[decrStk.peek()] < nums[i]) {
                // 弹出的元素都是乱序元素，其中最大的索引就是乱序子数组的右边界
                right = Math.max(right, decrStk.pop());
            }
            decrStk.push(i);
        }
        if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
            // 说明单调栈没有弹出任何元素，即 nums 本来就是有序的
            return 0;
        }
        return right - left + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 排序解法
func findUnsortedSubarray(nums []int) int {
    temp := append([]int(nil), nums...)
    sort.Ints(temp)
    left, right := len(nums), -1
    for i := 0; i < len(nums); i++ {
        if temp[i] != nums[i] {
            left = i
            break
        }
    }
    for i := len(nums) - 1; i >= 0; i-- {
        if temp[i] != nums[i] {
            right = i
            break
        }
    }
    if left == len(nums) && right == -1 {
        // nums 本来就是有序的
        return 0
    }
    return right - left + 1
}

// 单调栈解法
func findUnsortedSubarray2(nums []int) int {
    n := len(nums)
    left, right := n, -1
    // 递增栈，存储元素索引
    incrStk := []int{}
    for i := 0; i < n; i++ {
        for len(incrStk) > 0 && nums[incrStk[len(incrStk)-1]] > nums[i] {
            // 弹出的元素都是乱序元素，其中最小的索引就是乱序子数组的左边界
            left = min(left, incrStk[len(incrStk)-1])
            incrStk = incrStk[:len(incrStk)-1]
        }
        incrStk = append(incrStk, i)
    }
    // 递减栈，存储元素索引
    decrStk := []int{}
    for i := n - 1; i >= 0; i-- {
        for len(decrStk) > 0 && nums[decrStk[len(decrStk)-1]] < nums[i] {
            // 弹出的元素都是乱序元素，其中最大的索引就是乱序子数组的右边界
            right = max(right, decrStk[len(decrStk)-1])
            decrStk = decrStk[:len(decrStk)-1]
        }
        decrStk = append(decrStk, i)
    }
    if left == n && right == -1 {
        // 说明单调栈没有弹出任何元素，即 nums 本来就是有序的
        return 0
    }
    return right - left + 1
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 排序解法
var findUnsortedSubarray = function(nums) {
    const temp = nums.slice();
    temp.sort((a, b) => a - b);
    let left = Number.MAX_VALUE, right = Number.MIN_VALUE;
    
    for (let i = 0; i < nums.length; i++) {
        if (temp[i] !== nums[i]) {
            left = i;
            break;
        }
    }
    
    for (let i = nums.length - 1; i >= 0; i--) {
        if (temp[i] !== nums[i]) {
            right = i;
            break;
        }
    }
    
    if (left === Number.MAX_VALUE && right === Number.MIN_VALUE) {
        // nums 本来就是有序的
        return 0;
    }
    return right - left + 1;
};

// 单调栈解法
var findUnsortedSubarray2 = function(nums) {
    const n = nums.length;
    let left = Number.MAX_VALUE, right = Number.MIN_VALUE;
    // 递增栈，存储元素索引
    const incrStk = [];
    
    for (let i = 0; i < n; i++) {
        while (incrStk.length && nums[incrStk[incrStk.length - 1]] > nums[i]) {
            // 弹出的元素都是乱序元素，其中最小的索引就是乱序子数组的左边界
            left = Math.min(left, incrStk.pop());
        }
        incrStk.push(i);
    }
    
    // 递减栈，存储元素索引
    const decrStk = [];
    
    for (let i = n - 1; i >= 0; i--) {
        while (decrStk.length && nums[decrStk[decrStk.length - 1]] < nums[i]) {
            // 弹出的元素都是乱序元素，其中最大的索引就是乱序子数组的右边界
            right = Math.max(right, decrStk.pop());
        }
        decrStk.push(i);
    }
    
    if (left === Number.MAX_VALUE && right === Number.MIN_VALUE) {
        // 说明单调栈没有弹出任何元素，即 nums 本来就是有序的
        return 0;
    }
    return right - left + 1;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

