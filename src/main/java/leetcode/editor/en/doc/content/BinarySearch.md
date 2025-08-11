<p>Given an array of integers <code>nums</code> which is sorted in ascending order, and an integer <code>target</code>, write a function to search <code>target</code> in <code>nums</code>. If <code>target</code> exists, then return its index. Otherwise, return <code>-1</code>.</p>

<p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 9
<strong>Output:</strong> 4
<strong>Explanation:</strong> 9 exists in nums and its index is 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 2
<strong>Output:</strong> -1
<strong>Explanation:</strong> 2 does not exist in nums so return -1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt; nums[i], target &lt; 10<sup>4</sup></code></li> 
 <li>All the integers in <code>nums</code> are <strong>unique</strong>.</li> 
 <li><code>nums</code> is sorted in ascending order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Binary Search</details><br>

<div>👍 12800, 👎 282<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-search-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

二分搜索的基本形式，不过并不实用，比如 `target` 重复出现多次，本算法得出的索引位置是不确定的。

更常见的二分搜索形式是搜索左侧边界和右侧边界，即对于 `target` 重复出现多次的情景，计算 `target` 的最小索引和最大索引。

这几种二分搜索的形式的详细探讨见详细题解。

**详细题解**：
  - [二分搜索算法核心代码模板](https://labuladong.online/algo/essential-technique/binary-search-framework/)

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
    // 标准的二分搜索框架，搜索目标元素的索引，若不存在则返回 -1
    int search(vector<int>& nums, int target) {
        int left = 0;
        // 注意
        int right = nums.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;   
            } else if (nums[mid] < target) {
                // 注意
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 注意
                right = mid - 1;
            }
        }
        return -1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 标准的二分搜索框架，搜索目标元素的索引，若不存在则返回 -1
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        # 注意
        right = len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                # 注意
                left = mid + 1
            elif nums[mid] > target:
                # 注意
                right = mid - 1
        return -1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 标准的二分搜索框架，搜索目标元素的索引，若不存在则返回 -1
    public int search(int[] nums, int target) {
        int left = 0;
        // 注意
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;   
            } else if (nums[mid] < target) {
                // 注意
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 注意
                right = mid - 1;
            }
        }
        return -1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 标准的二分搜索框架，搜索目标元素的索引，若不存在则返回 -1
func search(nums []int, target int) int {
    left := 0
    // 注意
    right := len(nums) - 1

    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] == target {
            return mid
        } else if nums[mid] < target {
            // 注意
            left = mid + 1
        } else if nums[mid] > target {
            // 注意
            right = mid - 1
        }
    }
    return -1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var search = function(nums, target) {
    // 标准的二分搜索框架，搜索目标元素的索引，若不存在则返回 -1
    let left = 0;
    // 注意
    let right = nums.length - 1;

    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] < target) {
            // 注意
            left = mid + 1;
        } else if (nums[mid] > target) {
            // 注意
            right = mid - 1;
        }
    }
    return -1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_binary-search"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-search"></div></div>
</details><hr /><br />

</div>
</details>
</div>

