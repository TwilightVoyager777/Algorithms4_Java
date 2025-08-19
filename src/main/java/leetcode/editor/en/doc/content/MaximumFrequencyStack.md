<p>Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.</p>

<p>Implement the <code>FreqStack</code> class:</p>

<ul> 
 <li><code>FreqStack()</code> constructs an empty frequency stack.</li> 
 <li><code>void push(int val)</code> pushes an integer <code>val</code> onto the top of the stack.</li> 
 <li><code>int pop()</code> removes and returns the most frequent element in the stack. 
  <ul> 
   <li>If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.</li> 
  </ul> </li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
<strong>Output</strong>
[null, null, null, null, null, null, null, 5, 7, 5, 4]

<strong>Explanation</strong>
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= val &lt;= 10<sup>9</sup></code></li> 
 <li>At most <code>2 * 10<sup>4</sup></code> calls will be made to <code>push</code> and <code>pop</code>.</li> 
 <li>It is guaranteed that there will be at least one element in the stack before calling <code>pop</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Stack | Design | Ordered Set</details><br>

<div>👍 4852, 👎 77<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路


**这种设计数据结构的问题，主要是要搞清楚问题的难点在哪里，然后结合各种基本数据结构的特性，高效实现题目要求的 API**。

那么，我们仔细思考一下 `push` 和 `pop` 方法，难点如下：

1、每次 `pop` 时，必须要知道频率最高的元素是什么。

2、如果频率最高的元素有多个，还得知道哪个是最近 `push` 进来的元素是哪个。

为了实现上述难点，我们要做到以下几点：

1、肯定要有一个变量 `maxFreq` 记录当前栈中最高的频率是多少。

2、我们得知道一个频率 `freq` 对应的元素有哪些，且这些元素要有时间顺序。

3、随着 `pop` 的调用，每个 `val` 对应的频率会变化，所以还得维持一个映射记录每个 `val` 对应的 `freq`。

综上，我们可以先实现 `FreqStack` 所需的数据结构：

```java
class FreqStack {
    // 记录 FreqStack 中元素的最大频率
    int maxFreq = 0;
    // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
    HashMap<Integer, Integer> valToFreq = new HashMap<>();
    // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
    HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();
}
```

其实这有点类似前文 [手把手实现 LFU 算法](https://labuladong.online/algo/frequency-interview/lfu/)，注意 `freqToVals` 中 `val` 列表用一个栈实现，如果一个 `freq` 对应的元素有多个，根据栈的特点，可以首先取出最近添加的元素。

具体看解法代码吧，要记住在 `push` 和 `pop` 方法中同时修改 `maxFreq`、`VF` 表、`FV` 表，否则容易出现 bug。

算法执行过程如下 GIF 所示：

![](https://labuladong.online/algo/images/freq-stack/1.gif)

**详细题解**：
  - [【练习】更多经典设计习题](https://labuladong.online/algo/problem-set/ds-design/)
  - [【练习】栈的经典习题](https://labuladong.online/algo/problem-set/stack/)

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

#include <unordered_map>
#include <stack>
using namespace std;

class FreqStack {
    // 记录 FreqStack 中元素的最大频率
    int maxFreq = 0;
    // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
    unordered_map<int, int> valToFreq;
    // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
    unordered_map<int, stack<int>> freqToVals;

public:
    void push(int val) {
        // 修改 VF 表：val 对应的 freq 加一
        int freq = valToFreq.count(val) ? valToFreq[val] + 1 : 1;
        valToFreq[val] = freq;
        // 修改 FV 表：在 freq 对应的列表加上 val
        freqToVals[freq].push(val);
        // 更新 maxFreq
        maxFreq = max(maxFreq, freq);
    }

    int pop() {
        // 修改 FV 表：pop 出一个 maxFreq 对应的元素 v
        int v = freqToVals[maxFreq].top();
        freqToVals[maxFreq].pop();
        // 修改 VF 表：v 对应的 freq 减一
        valToFreq[v]--;
        // 更新 maxFreq
        if (freqToVals[maxFreq].empty()) {
            // 如果 maxFreq 对应的元素空了
            maxFreq--;
        }
        return v;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class FreqStack:
    def __init__(self):
        # 记录 FreqStack 中元素的最大频率
        self.maxFreq = 0
        # 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
        self.valToFreq = {}
        # 记录频率 freq 对应的 val 列表，后文就称为 FV 表
        self.freqToVals = {}

    def push(self, val: int) -> None:
        # 修改 VF 表：val 对应的 freq 加一
        freq = self.valToFreq.get(val, 0) + 1
        self.valToFreq[val] = freq
        # 修改 FV 表：在 freq 对应的列表加上 val
        if freq not in self.freqToVals:
            self.freqToVals[freq] = []
        self.freqToVals[freq].append(val)
        # 更新 maxFreq
        self.maxFreq = max(self.maxFreq, freq)

    def pop(self) -> int:
        # 修改 FV 表：pop 出一个 maxFreq 对应的元素 v
        vals = self.freqToVals[self.maxFreq]
        v = vals.pop()
        # 修改 VF 表：v 对应的 freq 减一
        self.valToFreq[v] -= 1
        # 更新 maxFreq
        if not vals:
            # 如果 maxFreq 对应的元素空了
            self.maxFreq -= 1
        return v
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class FreqStack {
    // 记录 FreqStack 中元素的最大频率
    int maxFreq = 0;
    // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
    HashMap<Integer, Integer> valToFreq = new HashMap<>();
    // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
    HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();

    public void push(int val) {
        // 修改 VF 表：val 对应的 freq 加一
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        // 修改 FV 表：在 freq 对应的列表加上 val
        freqToVals.putIfAbsent(freq, new Stack<>());
        freqToVals.get(freq).push(val);
        // 更新 maxFreq
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        // 修改 FV 表：pop 出一个 maxFreq 对应的元素 v
        Stack<Integer> vals = freqToVals.get(maxFreq);
        int v = vals.pop();
        // 修改 VF 表：v 对应的 freq 减一
        int freq = valToFreq.get(v) - 1;
        valToFreq.put(v, freq);
        // 更新 maxFreq
        if (vals.isEmpty()) {
            // 如果 maxFreq 对应的元素空了
            maxFreq--;
        }
        return v;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type FreqStack struct {
    // 记录 FreqStack 中元素的最大频率
    maxFreq int
    // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
    valToFreq map[int]int
    // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
    freqToVals map[int][]int
}

func Constructor() FreqStack {
    return FreqStack{
        valToFreq:  make(map[int]int),
        freqToVals: make(map[int][]int),
    }
}

func (this *FreqStack) Push(val int) {
    // 修改 VF 表：val 对应的 freq 加一
    freq := this.valToFreq[val] + 1
    this.valToFreq[val] = freq
    // 修改 FV 表：在 freq 对应的列表加上 val
    this.freqToVals[freq] = append(this.freqToVals[freq], val)
    // 更新 maxFreq
    if freq > this.maxFreq {
        this.maxFreq = freq
    }
}

func (this *FreqStack) Pop() int {
    // 修改 FV 表：pop 出一个 maxFreq 对应的元素 v
    vals := this.freqToVals[this.maxFreq]
    v := vals[len(vals)-1]
    this.freqToVals[this.maxFreq] = vals[:len(vals)-1]
    // 修改 VF 表：v 对应的 freq 减一
    this.valToFreq[v]--
    // 更新 maxFreq
    if len(this.freqToVals[this.maxFreq]) == 0 {
        // 如果 maxFreq 对应的元素空了
        delete(this.freqToVals, this.maxFreq)
        this.maxFreq--
    }
    return v
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var FreqStack = function() {
    // 记录 FreqStack 中元素的最大频率
    this.maxFreq = 0;
    // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
    this.valToFreq = new Map();
    // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
    this.freqToVals = new Map();
};

FreqStack.prototype.push = function(val) {
    // 修改 VF 表：val 对应的 freq 加一
    let freq = (this.valToFreq.get(val) || 0) + 1;
    this.valToFreq.set(val, freq);
    // 修改 FV 表：在 freq 对应的列表加上 val
    if (!this.freqToVals.has(freq)) {
        this.freqToVals.set(freq, []);
    }
    this.freqToVals.get(freq).push(val);
    // 更新 maxFreq
    this.maxFreq = Math.max(this.maxFreq, freq);
};

FreqStack.prototype.pop = function() {
    // 修改 FV 表：pop 出一个 maxFreq 对应的元素 v
    let vals = this.freqToVals.get(this.maxFreq);
    let v = vals.pop();
    // 修改 VF 表：v 对应的 freq 减一
    let freq = this.valToFreq.get(v) - 1;
    this.valToFreq.set(v, freq);
    // 更新 maxFreq
    if (vals.length === 0) {
        // 如果 maxFreq 对应的元素空了
        this.maxFreq--;
    }
    return v;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

