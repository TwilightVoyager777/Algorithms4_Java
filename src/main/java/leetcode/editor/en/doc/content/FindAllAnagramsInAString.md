<p>Given two strings <code>s</code> and <code>p</code>, return an array of all the start indices of <code>p</code>'s <span data-keyword="anagram">anagrams</span> in <code>s</code>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "cbaebabacd", p = "abc"
<strong>Output:</strong> [0,6]
<strong>Explanation:</strong>
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "abab", p = "ab"
<strong>Output:</strong> [0,1,2]
<strong>Explanation:</strong>
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>s</code> and <code>p</code> consist of lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | String | Sliding Window</details><br>

<div>👍 12854, 👎 361<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题和 [✔ ✨567. 字符串的排列](/problems/permutation-in-string/) 一样，只不过找到一个合法异位词（排列）之后将它的起始索引加入结果列表即可。

滑动窗口算法难度略高，具体的算法原理以及算法模板见详细题解。

**详细题解**：
  - [滑动窗口算法核心代码模板](https://labuladong.online/algo/essential-technique/sliding-window-framework/)

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
#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string t) {
        unordered_map<char, int> need;
        unordered_map<char, int> window;
        for (char c : t) {
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        vector<int> res;
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.size()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.push_back(left);
                }
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
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

from collections import deque, Counter
from typing import List

class Solution:
    # 查找字符串中所有字母异位词
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        p_count = Counter(p)
        s_count = Counter()
        
        # 滑动窗口模板
        for i in range(len(s)):
            # 扩大窗口，更新窗口最值
            s_count[s[i]] += 1
            if i >= len(p):
                # 缩小窗口，更新窗口最值
                if s_count[s[i - len(p)]] == 1:
                    del s_count[s[i - len(p)]]
                else:
                    s_count[s[i - len(p)]] -= 1
            # 在窗口收缩判断完之后才更新答案
            if s_count == p_count:
                res.append(i - len(p) + 1)
        return res

class MonotonicQueue:
    # 单调队列的通用实现，可以高效维护最大值和最小值
    # 由于我这里考虑了泛型和通用性，所以提交的性能会略差，你可自行精简
    def __init__(self):
        self.deque = deque()
    
    def push(self, value: int):
        while self.deque and self.deque[-1] < value:
            self.deque.pop()
        self.deque.append(value)
    
    def pop(self, value: int):
        if self.deque and self.deque[0] == value:
            self.deque.popleft()
    
    def max(self) -> int:
        return self.deque[0]
    
    def min(self) -> int:
        return self.deque[-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
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

func findAnagrams(s string, t string) []int {
    need := make(map[rune]int)
    window := make(map[rune]int)
    for _, c := range t {
        need[c] = need[c] + 1
    }

    left, right, valid := 0, 0, 0
    // 记录结果
    res := []int{}
    for right < len(s) {
        c := rune(s[right])
        right++
        // 进行窗口内数据的一系列更新
        if _, ok := need[c]; ok {
            window[c] = window[c] + 1
            if window[c] == need[c] {
                valid++
            }
        }
        // 判断左侧窗口是否要收缩
        for right-left >= len(t) {
            // 当窗口符合条件时，把起始索引加入 res
            if valid == len(need) {
                res = append(res, left)
            }
            d := rune(s[left])
            left++
            // 进行窗口内数据的一系列更新
            if _, ok := need[d]; ok {
                if window[d] == need[d] {
                    valid--
                }
                window[d] = window[d] - 1
            }
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

var findAnagrams = function(s, t) {
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    // 记录结果
    let res = [];
    while (right < s.length) {
        let c = s[right];
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }
        // 判断左侧窗口是否要收缩
        while (right - left >= t.length) {
            // 当窗口符合条件时，把起始索引加入 res
            if (valid === need.size) {
                res.push(left);
            }
            let d = s[left];
            left++;
            // 进行窗口内数据的一系列更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d)) {
                    valid--;
                }
                window.set(d, window.get(d) - 1);
            }
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_find-all-anagrams-in-a-string"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-all-anagrams-in-a-string"></div></div>
</details><hr /><br />

</div>
</details>
</div>

