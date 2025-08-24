<p>There are <code>n</code> cars at given miles away from the starting mile 0, traveling to reach the mile <code>target</code>.</p>

<p>You are given two integer arrays&nbsp;<code>position</code> and <code>speed</code>, both of length <code>n</code>, where <code>position[i]</code> is the starting mile of the <code>i<sup>th</sup></code> car and <code>speed[i]</code> is the speed of the <code>i<sup>th</sup></code> car in miles per hour.</p>

<p>A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.</p>

<p>A <strong>car fleet</strong> is a single car or a group of cars driving next to each other. The speed of the car fleet is the <strong>minimum</strong> speed of any car in the fleet.</p>

<p>If a car catches up to a car fleet at the mile <code>target</code>, it will still be considered as part of the car fleet.</p>

<p>Return the number of car fleets that will arrive at the destination.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul> 
 <li>The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at <code>target</code>.</li> 
 <li>The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.</li> 
 <li>The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches <code>target</code>.</li> 
</ul>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">target = 10, position = [3], speed = [3]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p> There is only one car, hence there is only one fleet.

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">target = 100, position = [0,2,4], speed = [4,2,1]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul> 
 <li>The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.</li> 
 <li>Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches <code>target</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == position.length == speed.length</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt; target &lt;= 10<sup>6</sup></code></li> 
 <li><code>0 &lt;= position[i] &lt; target</code></li> 
 <li>All the values of <code>position</code> are <strong>unique</strong>.</li> 
 <li><code>0 &lt; speed[i] &lt;= 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Stack | Sorting | Monotonic Stack</details><br>

<div>👍 4049, 👎 1162<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察「单调栈」结构的使用。是否能够形成车队，取决于下述规律：

**如果车 `x` 排在 车 `y` 后面，且 `x` 到达终点所需时间比 `y` 少，则 `x` 必然会被 `y` 卡住，形成车队**。

所以本题的思路是先根据每辆车的起始位置 `position` 排序，然后计算出时间数组 `time`。

假设计算出的 `time` 数组为 `[12, 3, 7, 1, 2]`，那么观察数组的单调性变化，最后肯定会形成三个车队，他们到达终点的时间分别是 12, 7, 2。

可以利用单调栈结构模拟得出结果，不过效率稍微低一些。也可以倒序遍历数组得出递增子序列，子序列的长度即答案。

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
#include <algorithm>
using namespace std;

class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n = position.size();
        vector<vector<int>> cars(n, vector<int>(2));
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        // 按照初始位置，从小到大排序
        sort(cars.begin(), cars.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        
        // 计算每辆车到达终点的时间
        vector<double> time(n);
        for (int i = 0; i < n; i++) {
            int pos = cars[i][0];
            int vel = cars[i][1];
            time[i] = (double)(target - pos) / vel;
        }
        
        // 使用单调栈计算车队的数量
        // 避免使用栈模拟，倒序遍历取递增序列就是答案
        int res = 0;
        double maxTime = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (time[i] > maxTime) {
                maxTime = time[i];
                res++;
            }
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
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(position)
        cars = []
        for i in range(n):
            cars.append([position[i], speed[i]])
        # 按照初始位置，从小到大排序
        cars.sort(key=lambda x: x[0])
        # 计算每辆车到达终点的时间
        time = []
        for i in range(n):
            car = cars[i]
            time.append((target - car[0]) / car[1])
        
        # 使用单调栈计算车队的数量
        # (This part is commented out in the original Java code, so it's also commented out here)
        # stk = []
        # for t in time:
        #     while stk and t >= stk[-1]:
        #         stk.pop()
        #     stk.append(t)
        # return len(stk)

        # 避免使用栈模拟，倒序遍历取递增序列就是答案
        res = 0
        max_time = 0
        for i in range(n - 1, -1, -1):
            if time[i] > max_time:
                max_time = time[i]
                res += 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        // 按照初始位置，从小到大排序
        Arrays.sort(cars, (int[] a, int[] b) -> {
            return Integer.compare(a[0], b[0]);
        });
        // 计算每辆车到达终点的时间
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            int[] car = cars[i];
            time[i] = (double) (target - car[0]) / car[1];
        }

        // 使用单调栈计算车队的数量
        // Stack<Double> stk = new Stack<>();
        // for (double t : time) {
        //     while (!stk.isEmpty() && t >= stk.peek()) {
        //         stk.pop();
        //     }
        //     stk.push(t);
        // }
        // return stk.size();

        // 避免使用栈模拟，倒序遍历取递增序列就是答案
        int res = 0;
        double maxTime = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (time[i] > maxTime) {
                maxTime = time[i];
                res++;
            }
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

func carFleet(target int, position []int, speed []int) int {
    n := len(position)
    cars := make([][2]int, n)
    for i := 0; i < n; i++ {
        cars[i][0] = position[i]
        cars[i][1] = speed[i]
    }
    // 按照初始位置，从小到大排序
    sort.Slice(cars, func(i, j int) bool {
        return cars[i][0] < cars[j][0]
    })
    // 计算每辆车到达终点的时间
    time := make([]float64, n)
    for i := 0; i < n; i++ {
        car := cars[i]
        time[i] = float64(target - car[0]) / float64(car[1])
    }

    // 使用单调栈计算车队的数量
    // Stack<Double> stk = new Stack<>();
    // for (double t : time) {
    //     while (!stk.isEmpty() && t >= stk.peek()) {
    //         stk.pop();
    //     }
    //     stk.push(t);
    // }
    // return stk.size();

    // 避免使用栈模拟，倒序遍历取递增序列就是答案
    res := 0
    maxTime := 0.0
    for i := n - 1; i >= 0; i-- {
        if time[i] > maxTime {
            maxTime = time[i]
            res++
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var carFleet = function(target, position, speed) {
    let n = position.length;
    let cars = new Array(n).fill(0).map(() => new Array(2));
    for (let i = 0; i < n; i++) {
        cars[i][0] = position[i];
        cars[i][1] = speed[i];
    }
    // 按照初始位置，从小到大排序
    cars.sort((a, b) => a[0] - b[0]);
    // 计算每辆车到达终点的时间
    let time = new Array(n);
    for (let i = 0; i < n; i++) {
        let car = cars[i];
        time[i] = (target - car[0]) / car[1];
    }

    // 使用单调栈计算车队的数量
    // Stack<Double> stk = new Stack<>();
    // for (double t : time) {
    //     while (!stk.isEmpty() && t >= stk.peek()) {
    //         stk.pop();
    //     }
    //     stk.push(t);
    // }
    // return stk.size();

    // 避免使用栈模拟，倒序遍历取递增序列就是答案
    let res = 0;
    let maxTime = 0;
    for (let i = n - 1; i >= 0; i--) {
        if (time[i] > maxTime) {
            maxTime = time[i];
            res++;
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_car-fleet"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_car-fleet"></div></div>
</details><hr /><br />

</div>
</details>
</div>

