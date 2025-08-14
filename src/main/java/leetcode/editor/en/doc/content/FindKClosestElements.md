<p>Given a <strong>sorted</strong> integer array <code>arr</code>, two integers <code>k</code> and <code>x</code>, return the <code>k</code> closest integers to <code>x</code> in the array. The result should also be sorted in ascending order.</p>

<p>An integer <code>a</code> is closer to <code>x</code> than an integer <code>b</code> if:</p>

<ul> 
 <li><code>|a - x| &lt; |b - x|</code>, or</li> 
 <li><code>|a - x| == |b - x|</code> and <code>a &lt; b</code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">arr = [1,2,3,4,5], k = 4, x = 3</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1,2,3,4]</span></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">arr = [1,1,2,3,4,5], k = 4, x = -1</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1,1,2,3]</span></p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= arr.length</code></li> 
 <li><code>1 &lt;= arr.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>arr</code> is sorted in <strong>ascending</strong> order.</li> 
 <li><code>-10<sup>4</sup> &lt;= arr[i], x &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers | Binary Search | Sliding Window | Sorting | Heap (Priority Queue)</details><br>

<div>👍 8780, 👎 840<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

我们就说一个最简单直接的方式：用 [二分查找算法详解](https://labuladong.online/algo/essential-technique/binary-search-framework/) 中介绍的搜索左侧边界的二分查找算法找到 `x` 的位置，然后用 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中解决 [✔ ✨5. 最长回文子串](/problems/longest-palindromic-substring/) 的从中间向两端的双指针算法找到这 `k` 个元素。

为什么是搜索左侧边界的二分搜索？可以仔细看下前文 [二分查找算法详解](https://labuladong.online/algo/essential-technique/binary-search-framework/)，有提到左侧边界二分搜索的几种理解方式。

另外，因为题目要求返回的结果必须按升序排序，所以我们必须用 `LinkedList` 来从两端添加结果，使得结果有序。

**详细题解**：
  - [【练习】二分搜索算法经典习题](https://labuladong.online/algo/problem-set/binary-search/)

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
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        // 二分搜索找到 x 的位置
        int p = left_bound(arr, x);
        // 两端都开的区间 (left, right)
        int left = p - 1, right = p;
        vector<int> res;
        // 扩展区间，直到区间内包含 k 个元素
        while (right - left - 1 < k) {
            if (left == -1) {
                right++;
            } else if (right == arr.size()) {
                left--;
            } else if (x - arr[left] > arr[right] - x) {
                right++;
            } else {
                left--;
            }
        }
        for (int i = left + 1; i < right; i++) {
            res.push_back(arr[i]);
        }
        return res;
    }

    // 搜索左侧边界的二分搜索
    int left_bound(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # 二分搜索找到 x 的位置
        p = self.left_bound(arr, x)
        # 两端都开的区间 (left, right)
        left, right = p - 1, p
        res = []
        # 扩展区间，直到区间内包含 k 个元素
        while right - left - 1 < k:
            if left == -1:
                right += 1
            elif right == len(arr):
                left -= 1
            elif x - arr[left] > arr[right] - x:
                right += 1
            else:
                left -= 1
        for i in range(left + 1, right):
            res.append(arr[i])
        return res

    # 搜索左侧边界的二分搜索
    def left_bound(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)

        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                right = mid
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid
        return left
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分搜索找到 x 的位置
        int p = left_bound(arr, x);
        // 两端都开的区间 (left, right)
        int left = p - 1, right = p;
        ArrayList<Integer> res = new ArrayList<>();
        // 扩展区间，直到区间内包含 k 个元素
        while (right - left - 1 < k) {
            if (left == -1) {
                right++;
            } else if (right == arr.length) {
                left--;
            } else if (x - arr[left] > arr[right] - x) {
                right++;
            } else {
                left--;
            }
        }
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    // 搜索左侧边界的二分搜索
    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func findClosestElements(arr []int, k int, x int) []int {
    // 二分搜索找到 x 的位置
    p := leftBound(arr, x)
    // 两端都开的区间 (left, right)
    left, right := p-1, p
    res := []int{}
    // 扩展区间，直到区间内包含 k 个元素
    for right-left-1 < k {
        if left == -1 {
            right++
        } else if right == len(arr) {
            left--
        } else if x-arr[left] > arr[right]-x {
            right++
        } else {
            left--
        }
    }
    for i := left + 1; i < right; i++ {
        res = append(res, arr[i])
    }
    return res
}

// 搜索左侧边界的二分搜索
func leftBound(nums []int, target int) int {
    left, right := 0, len(nums)

    for left < right {
        mid := left + (right-left)/2
        if nums[mid] == target {
            right = mid
        } else if nums[mid] < target {
            left = mid + 1
        } else if nums[mid] > target {
            right = mid
        }
    }
    return left
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var findClosestElements = function(arr, k, x) {
    // 二分搜索找到 x 的位置
    var p = left_bound(arr, x);
    // 两端都开的区间 (left, right)
    var left = p - 1, right = p;
    var res = [];
    // 扩展区间，直到区间内包含 k 个元素
    while (right - left - 1 < k) {
        if (left === -1) {
            right++;
        } else if (right === arr.length) {
            left--;
        } else if (x - arr[left] > arr[right] - x) {
            right++;
        } else {
            left--;
        }
    }
    for (var i = left + 1; i < right; i++) {
        res.push(arr[i]);
    }
    return res;
};

// 搜索左侧边界的二分搜索
var left_bound = function(nums, target) {
    var left = 0;
    var right = nums.length;

    while (left < right) {
        var mid = left + Math.floor((right - left) / 2);
        if (nums[mid] === target) {
            right = mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return left;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_find-k-closest-elements"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-k-closest-elements"></div></div>
</details><hr /><br />

</div>
</details>
</div>

