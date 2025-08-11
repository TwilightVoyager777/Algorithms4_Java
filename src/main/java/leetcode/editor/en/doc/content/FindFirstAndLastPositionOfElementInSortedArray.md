<p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>

<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
<strong>Output:</strong> [3,4]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
<strong>Output:</strong> [-1,-1]
</pre>
<p><strong class="example">Example 3:</strong></p> 
<pre><strong>Input:</strong> nums = [], target = 0
<strong>Output:</strong> [-1,-1]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li> 
 <li><code>nums</code> is a non-decreasing array.</li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Binary Search</details><br>

<div>👍 22205, 👎 591<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-search-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

二分搜索的难点就在于如何搜索左侧边界和右侧边界，代码的边界的控制非常考验你的微操，这也是很多人知道二分搜索原理但是很难写对代码的原因。

[二分搜索框架详解](https://labuladong.online/algo/essential-technique/binary-search-framework/) 专门花了很大篇幅讨论如何写对二分搜索算法，总结来说：

写对二分搜索的关键在于搞清楚搜索边界，到底是开区间还是闭区间？到底应该往左侧收敛还是应该往右侧收敛？

深入的探讨请看详细题解。

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
    vector<int> searchRange(vector<int>& nums, int target) {
        return {left_bound(nums, target), right_bound(nums, target)};
    }

    int left_bound(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.size() || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int right_bound(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.left_bound(nums, target), self.right_bound(nums, target)]

    def left_bound(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        # 搜索区间为 [left, right]
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                # 搜索区间变为 [mid+1, right]
                left = mid + 1
            elif nums[mid] > target:
                # 搜索区间变为 [left, mid-1]
                right = mid - 1
            elif nums[mid] == target:
                # 收缩右侧边界
                right = mid - 1
        # 检查出界情况
        if left >= len(nums) or nums[left] != target: # <extend up -300>![](https://labuladong.online/algo/images/binary-search/2.jpg) #
            return -1
        return left

    def right_bound(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            elif nums[mid] == target:
                # 这里改成收缩左侧边界即可
                left = mid + 1
        # 这里改为检查 right 越界的情况，见下图
        if right < 0 or nums[right] != target: # <extend up -300>![](https://labuladong.online/algo/images/binary-search/4.jpg) #
            return -1
        return right
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {/**<extend up -300>![](https://labuladong.online/algo/images/binary-search/2.jpg) */
            return -1;
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {/**<extend up -300>![](https://labuladong.online/algo/images/binary-search/4.jpg) */
            return -1;
        }
        return right;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// leftBound 查找左侧边界
// find the left boundary
func leftBound(nums []int, target int) int {
    left, right := 0, len(nums)-1
    // 搜索区间为 [left, right]
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < target {
            // 搜索区间变为 [mid+1, right]
            left = mid + 1
        } else if nums[mid] > target {
            // 搜索区间变为 [left, mid-1]
            right = mid - 1
        } else {
            // 收缩右侧边界
            right = mid - 1
        }
    }
    // 检查出界情况
    if left >= len(nums) || nums[left] != target {
        return -1
    }
    return left
}

// rightBound 查找右侧边界
// find the right boundary
func rightBound(nums []int, target int) int {
    left, right := 0, len(nums)-1
    // 搜索区间为 [left, right]
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < target {
            left = mid + 1
        } else if nums[mid] > target {
            right = mid - 1
        } else {
            // 这里改成收缩左侧边界即可
            left = mid + 1
        }
    }
    // 这里改为检查 right 越界的情况，见下图
    if right < 0 || nums[right] != target {
        return -1
    }
    return right
}

// searchRange 查找目标值的范围
// find the range of the target value
func searchRange(nums []int, target int) []int {
    return []int{leftBound(nums, target), rightBound(nums, target)}
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var searchRange = function(nums, target) {
    // 返回目标值的搜索范围
    return [left_bound(nums, target), right_bound(nums, target)];
};

function left_bound(nums, target) {
    let left = 0, right = nums.length - 1;
    // 搜索区间为 [left, right]
    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] < target) {
            // 搜索区间变为 [mid+1, right]
            left = mid + 1;
        } else if (nums[mid] > target) {
            // 搜索区间变为 [left, mid-1]
            right = mid - 1;
        } else if (nums[mid] === target) {
            // 收缩右侧边界
            right = mid - 1;
        }
    }
    // 检查出界情况
    if (left >= nums.length || nums[left] !== target) {
        return -1;
    }
    return left;
}

function right_bound(nums, target) {
    let left = 0, right = nums.length - 1;
    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] === target) {
            // 这里改成收缩左侧边界即可
            left = mid + 1;
        }
    }
    // 这里改为检查 right 越界的情况，见下图
    if (right < 0 || nums[right] !== target) {
        return -1;
    }
    return right;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_find-first-and-last-position-of-element-in-sorted-array"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-first-and-last-position-of-element-in-sorted-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>

