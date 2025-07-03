<p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library's sort function.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,0,2,1,1,0]
<strong>Output:</strong> [0,0,1,1,2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,0,1]
<strong>Output:</strong> [0,1,2]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 300</code></li> 
 <li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers | Sorting</details><br>

<div>👍 20247, 👎 720<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题有意思，如果仅仅是写一个正确的解法，可以有很多种方法，比如经典的 [计数排序](https://labuladong.online/algo/data-structure-basic/counting-sort/)。但是如果要求只遍历数组一次，那么就有些技巧性了。

我们在 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中其实讲过类似的题目，就是 [✨27. 移除元素](/problems/remove-element/) 和 [✨283. 移动零](/problems/move-zeroes/)。

只不过前面那两道题只是把数组的元素分为两部分：一部分是符合要求的，另一部分是不符合要求的。这种场景可以用快慢指针来解决：

维护一个慢指针，保持慢指针左侧是符合要求的元素，快指针在前面探路，把符合要求的元素交换到慢指针的位置。

而这道题是把数组的元素分为三部分：一部分是 0，一部分是 1，一部分是 2。

```
[2,0,2,1,1,0]
```

套用之前的 `moveZeroes` 函数思路当然也可以解决这道题，但要遍历两次数组，第一次把 2 移动到数组的末尾：

```
[0,1,1,0,2,2]
```

第二次把 1 移动到末尾，只不过这个末尾不是数组的末尾，而是 2 的前面一位索引，稍微改改前文的代码并不难做到：

```
[0,0,1,1,2,2]
```

这个常规解法留给大家自己实现，我来讲一种只遍历一次数组的思路。

看到三种元素的分类问题，我首先会想到两端向中心的双指针。

之前的快慢指针场景，是慢指针左侧维护一个索引区间，快指针在前面探路；

那么这道题是不是可以在左右分别用指针 `p0, p2` 维护 0 的区间和 2 的区间，让第三个指针 `p` 遍历数组，把遇到的元素分类到左右两个区间中，最后中间剩下的也就是元素 1 了。

这个思路只遍历一次就能得出结果，下面就来实现，具体代码可以有多种写法，我提供一种自认为比较清晰的，详情看代码和注释。

**详细题解**：
  - [【练习】数组双指针经典习题](https://labuladong.online/algo/problem-set/array-two-pointers/)

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
    void sortColors(vector<int>& nums) {
        // 注意区间的开闭，初始化时区间内应该没有元素
        // 所以我们定义 [0，p0) 是元素 0 的区间，(p2, nums.length - 1] 是 2 的区间
        int p0 = 0, p2 = nums.size() - 1;
        int p = 0;
        // 由于 p2 是开区间，所以 p <= p2
        while (p <= p2) {
            if (nums[p] == 0) {
                swap(nums, p0, p);
                p0++;
            } else if (nums[p] == 2) {
                swap(nums, p2, p);
                p2--;
            } else if (nums[p] == 1) {
                p++;
            }

            // 因为小于 p0 都是 0，所以 p 不要小于 p0
            if (p < p0) {
                p = p0;
            }
        }
    }

private:
    void swap(vector<int>& nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        # 注意区间的开闭，初始化时区间内应该没有元素
        # 所以我们定义 [0，p0) 是元素 0 的区间，(p2, nums.length - 1] 是 2 的区间
        p0 = 0
        p2 = len(nums) - 1
        p = 0
        # 由于 p2 是开区间，所以 p <= p2
        while p <= p2:
            if nums[p] == 0:
                self.swap(nums, p0, p)
                p0 += 1
            elif nums[p] == 2:
                self.swap(nums, p2, p)
                p2 -= 1
            elif nums[p] == 1:
                p += 1

            # 因为小于 p0 都是 0，所以 p 不要小于 p0
            if p < p0:
                p = p0

    def swap(self, nums: List[int], i: int, j: int) -> None:
        nums[i], nums[j] = nums[j], nums[i]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void sortColors(int[] nums) {
        // 注意区间的开闭，初始化时区间内应该没有元素
        // 所以我们定义 [0，p0) 是元素 0 的区间，(p2, nums.length - 1] 是 2 的区间
        int p0 = 0, p2 = nums.length - 1;
        int p = 0;
        // 由于 p2 是开区间，所以 p <= p2
        while (p <= p2) {
            if (nums[p] == 0) {
                swap(nums, p0, p);
                p0++;
            } else if (nums[p] == 2) {
                swap(nums, p2, p);
                p2--;
            } else if (nums[p] == 1) {
                p++;
            }

            // 因为小于 p0 都是 0，所以 p 不要小于 p0
            if (p < p0) {
                p = p0;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func sortColors(nums []int) {
    // 注意区间的开闭，初始化时区间内应该没有元素
    // 所以我们定义 [0，p0) 是元素 0 的区间，(p2, nums.length - 1] 是 2 的区间
    p0, p2 := 0, len(nums)-1
    p := 0
    // 由于 p2 是开区间，所以 p <= p2
    for p <= p2 {
        if nums[p] == 0 {
            swap(nums, p0, p)
            p0++
        } else if nums[p] == 2 {
            swap(nums, p2, p)
            p2--
        } else if nums[p] == 1 {
            p++
        }

        // 因为小于 p0 都是 0，所以 p 不要小于 p0
        if p < p0 {
            p = p0
        }
    }
}

func swap(nums []int, i, j int) {
    nums[i], nums[j] = nums[j], nums[i]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var sortColors = function(nums) {
    // 注意区间的开闭，初始化时区间内应该没有元素
    // 所以我们定义 [0，p0) 是元素 0 的区间，(p2, nums.length - 1] 是 2 的区间
    let p0 = 0, p2 = nums.length - 1;
    let p = 0;
    // 由于 p2 是开区间，所以 p <= p2
    while (p <= p2) {
        if (nums[p] === 0) {
            swap(nums, p0, p);
            p0++;
        } else if (nums[p] === 2) {
            swap(nums, p2, p);
            p2--;
        } else if (nums[p] === 1) {
            p++;
        }

        // 因为小于 p0 都是 0，所以 p 不要小于 p0
        if (p < p0) {
            p = p0;
        }
    }
};

var swap = function(nums, i, j) {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

