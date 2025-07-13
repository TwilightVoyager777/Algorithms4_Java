<p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible</em> <span data-keyword="subset"><em>subsets</em></span> <em>(the power set)</em>.</p>

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Backtracking | Bit Manipulation</details><br>

<div>👍 18355, 👎 311<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

有两种方法解决这道题，这里主要说回溯算法思路，因为比较通用，可以套前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 写过回溯算法模板。

本质上子集问题就是遍历这样用一棵回溯树：

![](https://labuladong.online/algo/images/subset/1.jpg)

**详细题解**：
  - [球盒模型：回溯算法穷举的两种视角](https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/)
  - [回溯算法秒杀所有排列/组合/子集问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)

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
private:
    vector<vector<int>> res;
    // 记录回溯算法的递归路径
    vector<int> track;

public:
    // 主函数
    vector<vector<int>> subsets(vector<int>& nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(vector<int>& nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.push_back(track);

        // 回溯算法标准框架
        for (int i = start; i < nums.size(); i++) {
            // 做选择
            track.push_back(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.pop_back();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    
    def __init__(self):
        self.res = []
        # 记录回溯算法的递归路径
        self.track = []

    # 主函数
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.backtrack(nums, 0)
        return self.res
    
    # 回溯算法核心函数，遍历子集问题的回溯树
    def backtrack(self, nums: List[int], start: int) -> None:
        
        # 前序位置，每个节点的值都是一个子集
        self.res.append(list(self.track))
        
        # 回溯算法标准框架
        for i in range(start, len(nums)):
            # 做选择
            self.track.append(nums[i])
            # 通过 start 参数控制树枝的遍历，避免产生重复的子集
            self.backtrack(nums, i + 1)
            # 撤销选择
            self.track.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
        
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func subsets(nums []int) [][]int {
    var res [][]int
    // 记录回溯算法的递归路径
    var track []int
    
    // 回溯算法核心函数，遍历子集问题的回溯树
    var backtrack func(int)
    backtrack = func(start int) {
        // 前序位置，每个节点的值都是一个子集
        res = append(res, append([]int(nil), track...))
        
        // 回溯算法标准框架
        for i := start; i < len(nums); i++ {
            // 做选择
            track = append(track, nums[i])
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i + 1)
            // 撤销选择
            track = track[:len(track)-1]
        }
    }

    backtrack(0)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var subsets = function(nums) {
    // 用于存储结果
    const res = [];
    // 用于记录回溯路径
    const track = [];
    
    // 回溯算法核心函数，遍历子集问题的回溯树
    const backtrack = (start) => {
        // 前序遍历位置，每个节点的值都是一个子集
        res.push([...track]);
        
        // 回溯算法标准框架
        for (let i = start; i < nums.length; i++) {
            // 做选择
            track.push(nums[i]);
            // 回溯遍历下一层节点
            backtrack(i + 1);
            // 撤销选择
            track.pop();
        }
    };
    
    backtrack(0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_subsets"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_subsets"></div></div>
</details><hr /><br />

</div>
</details>
</div>

