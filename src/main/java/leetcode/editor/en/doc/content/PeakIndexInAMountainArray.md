<p>You are given an integer <strong>mountain</strong> array <code>arr</code> of length <code>n</code> where the values increase to a <strong>peak element</strong> and then decrease.</p>

<p>Return the index of the peak element.</p>

<p>Your task is to solve it in <code>O(log(n))</code> time complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">arr = [0,1,0]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">arr = [0,2,1,0]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">arr = [0,10,5,2]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>3 &lt;= arr.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li> 
 <li><code>arr</code> is <strong>guaranteed</strong> to be a mountain array.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Binary Search</details><br>

<div>👍 8145, 👎 1936<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

[二分搜索框架详解](https://labuladong.online/algo/essential-technique/binary-search-framework/) 的经典应用，不过这道题和 [✔ ✨162. 寻找峰值](/problems/find-peak-element/) 差不多，直接把 162 题的解法复制过来即可通过。

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

#include <vector>
using namespace std;

class Solution {
public:
    int peakIndexInMountainArray(vector<int>& nums) {
        // 取两端都闭的二分搜索
        int left = 0, right = nums.size() - 1;
        // 因为题目必然有解，所以设置 left == right 为结束条件
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // mid 本身就是峰值或其左侧有一个峰值
                right = mid;
            } else {
                // mid 右侧有一个峰值
                left = mid + 1;
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
    # 取两端都闭的二分搜索
    def peakIndexInMountainArray(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        # 因为题目必然有解，所以设置 left == right 为结束条件
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[mid + 1]:
                # mid 本身就是峰值或其左侧有一个峰值
                right = mid
            else:
                # mid 右侧有一个峰值
                left = mid + 1
        return left
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        // 取两端都闭的二分搜索
        int left = 0, right = nums.length - 1;
        // 因为题目必然有解，所以设置 left == right 为结束条件
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // mid 本身就是峰值或其左侧有一个峰值
                right = mid;
            } else {
                // mid 右侧有一个峰值
                left = mid + 1;
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

func peakIndexInMountainArray(nums []int) int {
    // 取两端都闭的二分搜索
    left, right := 0, len(nums)-1
    // 因为题目必然有解，所以设置 left == right 为结束条件
    for left < right {
        mid := left + (right-left)/2
        if nums[mid] > nums[mid+1] {
            // mid 本身就是峰值或其左侧有一个峰值
            right = mid
        } else {
            // mid 右侧有一个峰值
            left = mid + 1
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

var peakIndexInMountainArray = function(nums) {
    // 取两端都闭的二分搜索
    let left = 0, right = nums.length - 1;
    // 因为题目必然有解，所以设置 left == right 为结束条件
    while (left < right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] > nums[mid + 1]) {
            // mid 本身就是峰值或其左侧有一个峰值
            right = mid;
        } else {
            // mid 右侧有一个峰值
            left = mid + 1;
        }
    }
    return left;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_peak-index-in-a-mountain-array"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_peak-index-in-a-mountain-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>

