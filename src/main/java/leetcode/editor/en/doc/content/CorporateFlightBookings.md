<p>There are <code>n</code> flights that are labeled from <code>1</code> to <code>n</code>.</p>

<p>You are given an array of flight bookings <code>bookings</code>, where <code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code> represents a booking for flights <code>first<sub>i</sub></code> through <code>last<sub>i</sub></code> (<strong>inclusive</strong>) with <code>seats<sub>i</sub></code> seats reserved for <strong>each flight</strong> in the range.</p>

<p>Return <em>an array </em><code>answer</code><em> of length </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the total number of seats reserved for flight </em><code>i</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
<strong>Output:</strong> [10,55,45,25,25]
<strong>Explanation:</strong>
Flight labels:        1   2   3   4   5
Booking 1 reserved:  10  10
Booking 2 reserved:      20  20
Booking 3 reserved:      25  25  25  25
Total seats:         10  55  45  25  25
Hence, answer = [10,55,45,25,25]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> bookings = [[1,2,10],[2,2,15]], n = 2
<strong>Output:</strong> [10,25]
<strong>Explanation:</strong>
Flight labels:        1   2
Booking 1 reserved:  10  10
Booking 2 reserved:      15
Total seats:         10  25
Hence, answer = [10,25]

</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= bookings.length &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>bookings[i].length == 3</code></li> 
 <li><code>1 &lt;= first<sub>i</sub> &lt;= last<sub>i</sub> &lt;= n</code></li> 
 <li><code>1 &lt;= seats<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Prefix Sum</details><br>

<div>👍 1794, 👎 165<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/diff-array/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察差分数组技巧，差分数组技巧适用于频繁对数组区间进行增减的场景。

核心原理：

1、构造差分数组：

```java
int[] diff = new int[nums.length];
// 构造差分数组
diff[0] = nums[0];
for (int i = 1; i < nums.length; i++) {
    diff[i] = nums[i] - nums[i - 1];
}
```

![](https://labuladong.online/algo/images/difference/2.jpeg)

2、还原原始数组：

```java
int[] res = new int[diff.length];
// 根据差分数组构造结果数组
res[0] = diff[0];
for (int i = 1; i < diff.length; i++) {
    res[i] = res[i - 1] + diff[i];
}
```

2、进行区间增减，如果你想对区间 `nums[i..j]` 的元素全部加 3，那么只需要让 `diff[i] += 3`，然后再让 `diff[j+1] -= 3` 即可：

![](https://labuladong.online/algo/images/difference/3.jpeg)

本题就相当于给你输入一个长度为 `n` 的数组 `nums`，其中所有元素都是 0，然后让你进行一系列区间加减操作，可以套用差分数组技巧。

**详细题解**：
  - [小而美的算法技巧：差分数组](https://labuladong.online/algo/data-structure/diff-array/)

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
    vector<int> corpFlightBookings(vector<vector<int>>& bookings, int n) {
        // nums 初始化为全 0
        vector<int> nums(n, 0);
        // 构造差分解法
        Difference df(nums);

        for (const auto& booking : bookings) {
            // 注意转成数组索引要减一哦
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.increment(i, j, val);
        }
        // 返回最终的结果数组
        return df.result();
    }

private:
    class Difference {
        // 差分数组
        vector<int> diff;

    public:
        Difference(const vector<int>& nums) {
            assert(!nums.empty());
            diff.resize(nums.size());
            // 构造差分数组
            diff[0] = nums[0];
            for (size_t i = 1; i < nums.size(); ++i) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // 给闭区间 [i, j] 增加 val（可以是负数）
        void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.size()) {
                diff[j + 1] -= val;
            }
        }

        vector<int> result() {
            vector<int> res(diff.size());
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (size_t i = 1; i < diff.size(); ++i) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    };
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def corpFlightBookings(self, bookings, n):
        # nums 初始化为全 0
        nums = [0] * n
        # 构造差分解法
        df = self.Difference(nums)

        for booking in bookings:
            # 注意转成数组索引要减一哦
            i = booking[0] - 1
            j = booking[1] - 1
            val = booking[2]
            # 对区间 nums[i..j] 增加 val
            df.increment(i, j, val)
        # 返回最终的结果数组
        return df.result()

    class Difference:
        # 差分数组
        def __init__(self, nums):
            assert len(nums) > 0
            self.diff = [0] * len(nums)
            # 构造差分数组
            self.diff[0] = nums[0]
            for i in range(1, len(nums)):
                self.diff[i] = nums[i] - nums[i - 1]

        # 给闭区间 [i, j] 增加 val（可以是负数）
        def increment(self, i, j, val):
            self.diff[i] += val
            if j + 1 < len(self.diff):
                self.diff[j + 1] -= val

        def result(self):
            res = [0] * len(self.diff)
            # 根据差分数组构造结果数组
            res[0] = self.diff[0]
            for i in range(1, len(self.diff)):
                res[i] = res[i - 1] + self.diff[i]
            return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // nums 初始化为全 0
        int[] nums = new int[n];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            // 注意转成数组索引要减一哦
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.increment(i, j, val);
        }
        // 返回最终的结果数组
        return df.result();
    }

    class Difference {
        // 差分数组
        private int[] diff;

        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // 给闭区间 [i, j] 增加 val（可以是负数）
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func corpFlightBookings(bookings [][]int, n int) []int {
    // nums 初始化为全 0
    nums := make([]int, n)
    // 构造差分解法
    df := NewDifference(nums)

    for _, booking := range bookings {
        // 注意转成数组索引要减一哦
        i := booking[0] - 1
        j := booking[1] - 1
        val := booking[2]
        // 对区间 nums[i..j] 增加 val
        df.increment(i, j, val)
    }
    // 返回最终的结果数组
    return df.result()
}

type Difference struct {
    // 差分数组
    diff []int
}

func NewDifference(nums []int) *Difference {
    if len(nums) == 0 {
        panic("nums length must be greater than 0")
    }
    diff := make([]int, len(nums))
    // 构造差分数组
    diff[0] = nums[0]
    for i := 1; i < len(nums); i++ {
        diff[i] = nums[i] - nums[i-1]
    }
    return &Difference{diff}
}

// 给闭区间 [i, j] 增加 val（可以是负数）
func (d *Difference) increment(i, j, val int) {
    d.diff[i] += val
    if j+1 < len(d.diff) {
        d.diff[j+1] -= val
    }
}

func (d *Difference) result() []int {
    res := make([]int, len(d.diff))
    // 根据差分数组构造结果数组
    res[0] = d.diff[0]
    for i := 1; i < len(d.diff); i++ {
        res[i] = res[i-1] + d.diff[i]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var corpFlightBookings = function(bookings, n) {
    // nums 初始化为全 0
    let nums = new Array(n).fill(0);
    // 构造差分解法
    let df = new Difference(nums);

    for (let booking of bookings) {
        // 注意转成数组索引要减一哦
        let i = booking[0] - 1;
        let j = booking[1] - 1;
        let val = booking[2];
        // 对区间 nums[i..j] 增加 val
        df.increment(i, j, val);
    }
    // 返回最终的结果数组
    return df.result();
};

class Difference {
    // 差分数组
    constructor(nums) {
        this.diff = new Array(nums.length).fill(0);
        // 构造差分数组
        this.diff[0] = nums[0];
        for (let i = 1; i < nums.length; i++) {
            this.diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 给闭区间 [i, j] 增加 val（可以是负数）
    increment(i, j, val) {
        this.diff[i] += val;
        if (j + 1 < this.diff.length) {
            this.diff[j + 1] -= val;
        }
    }

    // 根据差分数组构造结果数组
    result() {
        let res = new Array(this.diff.length);
        res[0] = this.diff[0];
        for (let i = 1; i < this.diff.length; i++) {
            res[i] = res[i - 1] + this.diff[i];
        }
        return res;
    }
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_corporate-flight-bookings"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_corporate-flight-bookings"></div></div>
</details><hr /><br />

</div>
</details>
</div>

