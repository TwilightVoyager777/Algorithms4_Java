<p>Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.</p>

<p>Implement the <code>MinStack</code> class:</p>

<ul> 
 <li><code>MinStack()</code> initializes the stack object.</li> 
 <li><code>void push(int val)</code> pushes the element <code>val</code> onto the stack.</li> 
 <li><code>void pop()</code> removes the element on the top of the stack.</li> 
 <li><code>int top()</code> gets the top element of the stack.</li> 
 <li><code>int getMin()</code> retrieves the minimum element in the stack.</li> 
</ul>

<p>You must implement a solution with <code>O(1)</code> time complexity for each function.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

<strong>Output</strong>
[null,null,null,null,-3,null,0,-2]

<strong>Explanation</strong>
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li> 
 <li>Methods <code>pop</code>, <code>top</code> and <code>getMin</code> operations will always be called on <strong>non-empty</strong> stacks.</li> 
 <li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>getMin</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Stack | Design</details><br>

<div>👍 15354, 👎 961<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

[根据我们之前亲自动手实现的栈](https://labuladong.online/algo/data-structure-basic/queue-stack-basic/)，我们知道栈是一种操作受限的数据结构，只能从栈顶插入或弹出元素，所以对于标准的栈来说，如果想实现本题的 `getMin` 方法，只能老老实实把所有元素弹出来然后找最小值。**想提高时间效率，那肯定要通过空间换时间的思路**。

不过在具体说解法之前，我想聊一下动态集合中维护最值的问题。这类问题看似简单，但实际上是个很棘手的问题。其实本题就是如下一个场景：

假设你有若干数字，你用一个 `min` 变量维护了其中的最小值，如果现在给这些数字中添加一个新数字，那么只要比较这个新数字和 `min` 的大小就可以得出最新的最小值。但如果现在从这些数字钟删除一个数字，你还能用 `min` 变量得到最小值吗？答案是不能，因为如果这个被删除的数字恰好是最小值，那么新的 `min` 变量应该更新为第二小的元素对吧，但是我没有记录第二小的元素是多少，所以只能把所有数字重新遍历一遍。

明确了难点再回到本题，就可以对症下药了。删除栈顶元素的时候，不确定新的最小值是多少，但楼下那哥们知道啊，他当时入栈时的最小值，就是现在的最小值呗。

所以这道题的关键就是，**每个元素入栈时，还要记下来当前栈中的最小值**。比方说，可以用一个额外的栈 `minStk` 来记录栈中每个元素入栈时的栈中的最小元素是多少，这样每次删除元素时就能快速得到剩余栈中的最小元素了。

![](https://labuladong.online/algo/images/brief-extra/155.jpeg)

当然，我们还可以做一些优化，减少 `minStk` 中存储的元素个数，我把原始解法和优化解法都写出来了，供参考。

> PS：这道题并不难，但我还是很细致地分析了，希望你深刻理解其中的难点。下一步可以做一下 [✨239. 滑动窗口最大值](/problems/sliding-window-maximum/)，请仔细观察和思考，队列结构是如何解决这个难点的。

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

// 原始思路
class MinStack1 {
    // 记录栈中的所有元素
    stack<int> stk;
    // 阶段性记录栈中的最小元素
    stack<int> minStk;

public:
    void push(int val) {
        stk.push(val);
        // 维护 minStk 栈顶为全栈最小元素
        if (minStk.empty() || val <= minStk.top()) {
            // 新插入的这个元素就是全栈最小的
            minStk.push(val);
        } else {
            // 插入的这个元素比较大
            minStk.push(minStk.top());
        }
    }
    
    void pop() {
        stk.pop();
        minStk.pop();
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        // minStk 栈顶为全栈最小元素
        return minStk.top();
    }
};

// 优化版
class MinStack {
    // 记录栈中的所有元素
    stack<int> stk;
    // 阶段性记录栈中的最小元素
    stack<int> minStk;

public:
    void push(int val) {
        stk.push(val);
        // 维护 minStk 栈顶为全栈最小元素
        if (minStk.empty() || val <= minStk.top()) {
            // 新插入的这个元素就是全栈最小的
            minStk.push(val);
        }
    }

    void pop() {
        // 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
        if (stk.top() == minStk.top()) {
            // 弹出的元素是全栈最小的
            minStk.pop();
        }
        stk.pop();
    }

    int top() {
        return stk.top();
    }

    int getMin() {
        // minStk 栈顶为全栈最小元素
        return minStk.top();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 原始思路
class MinStack1:
    def __init__(self):
        # 记录栈中的所有元素
        self.stk = []
        # 阶段性记录栈中的最小元素
        self.minStk = []

    def push(self, val: int) -> None:
        self.stk.append(val)
        # 维护 minStk 栈顶为全栈最小元素
        if not self.minStk or val <= self.minStk[-1]:
            # 新插入的这个元素就是全栈最小的
            self.minStk.append(val)
        else:
            # 插入的这个元素比较大
            self.minStk.append(self.minStk[-1])

    def pop(self) -> None:
        self.stk.pop()
        self.minStk.pop()

    def top(self) -> int:
        return self.stk[-1]

    def getMin(self) -> int:
        # minStk 栈顶为全栈最小元素
        return self.minStk[-1]

# 优化版
class MinStack:
    def __init__(self):
        # 记录栈中的所有元素
        self.stk = []
        # 阶段性记录栈中的最小元素
        self.minStk = []

    def push(self, val: int) -> None:
        self.stk.append(val)
        # 维护 minStk 栈顶为全栈最小元素
        if not self.minStk or val <= self.minStk[-1]:
            # 新插入的这个元素就是全栈最小的
            self.minStk.append(val)

    def pop(self) -> None:
        # 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
        if self.stk[-1] == self.minStk[-1]:
            # 弹出的元素是全栈最小的
            self.minStk.pop()
        self.stk.pop()

    def top(self) -> int:
        return self.stk[-1]

    def getMin(self) -> int:
        # minStk 栈顶为全栈最小元素
        return self.minStk[-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 原始思路
class MinStack1 {
    // 记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    // 阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();

    public void push(int val) {
        stk.push(val);
        // 维护 minStk 栈顶为全栈最小元素
        if (minStk.isEmpty() || val <= minStk.peek()) {
            // 新插入的这个元素就是全栈最小的
            minStk.push(val);
        } else {
            // 插入的这个元素比较大
            minStk.push(minStk.peek());
        }
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        // minStk 栈顶为全栈最小元素
        return minStk.peek();
    }
}
// 优化版
class MinStack {
    // 记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    // 阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();

    public void push(int val) {
        stk.push(val);
        // 维护 minStk 栈顶为全栈最小元素
        if (minStk.isEmpty() || val <= minStk.peek()) {
            // 新插入的这个元素就是全栈最小的
            minStk.push(val);
        }
    }

    public void pop() {
        // 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
        if (stk.peek().equals(minStk.peek())) {
            // 弹出的元素是全栈最小的
            minStk.pop();
        }
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        // minStk 栈顶为全栈最小元素
        return minStk.peek();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 原始思路
type MinStack1 struct {
    // 记录栈中的所有元素
    stk    []int
    // 阶段性记录栈中的最小元素
    minStk []int
}

func Constructor1() MinStack1 {
    return MinStack1{}
}

func (this *MinStack1) Push(val int) {
    this.stk = append(this.stk, val)
    // 维护 minStk 栈顶为全栈最小元素
    if len(this.minStk) == 0 || val <= this.minStk[len(this.minStk)-1] {
        // 新插入的这个元素就是全栈最小的
        this.minStk = append(this.minStk, val)
    } else {
        // 插入的这个元素比较大
        this.minStk = append(this.minStk, this.minStk[len(this.minStk)-1])
    }
}

func (this *MinStack1) Pop() {
    this.stk = this.stk[:len(this.stk)-1]
    this.minStk = this.minStk[:len(this.minStk)-1]
}

func (this *MinStack1) Top() int {
    return this.stk[len(this.stk)-1]
}

func (this *MinStack1) GetMin() int {
    // minStk 栈顶为全栈最小元素
    return this.minStk[len(this.minStk)-1]
}

// 优化版
type MinStack struct {
    // 记录栈中的所有元素
    stk    []int
    // 阶段性记录栈中的最小元素
    minStk []int
}

func Constructor() MinStack {
    return MinStack{}
}

func (this *MinStack) Push(val int) {
    this.stk = append(this.stk, val)
    // 维护 minStk 栈顶为全栈最小元素
    if len(this.minStk) == 0 || val <= this.minStk[len(this.minStk)-1] {
        // 新插入的这个元素就是全栈最小的
        this.minStk = append(this.minStk, val)
    }
}

func (this *MinStack) Pop() {
    // 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
    if this.stk[len(this.stk)-1] == this.minStk[len(this.minStk)-1] {
        // 弹出的元素是全栈最小的
        this.minStk = this.minStk[:len(this.minStk)-1]
    }
    this.stk = this.stk[:len(this.stk)-1]
}

func (this *MinStack) Top() int {
    return this.stk[len(this.stk)-1]
}

func (this *MinStack) GetMin() int {
    // minStk 栈顶为全栈最小元素
    return this.minStk[len(this.minStk)-1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 原始思路
var MinStack1 = function() {
    // 记录栈中的所有元素
    this.stk = [];
    // 阶段性记录栈中的最小元素
    this.minStk = [];
};

MinStack1.prototype.push = function(val) {
    this.stk.push(val);
    // 维护 minStk 栈顶为全栈最小元素
    if (this.minStk.length === 0 || val <= this.minStk[this.minStk.length - 1]) {
        // 新插入的这个元素就是全栈最小的
        this.minStk.push(val);
    } else {
        // 插入的这个元素比较大
        this.minStk.push(this.minStk[this.minStk.length - 1]);
    }
};

MinStack1.prototype.pop = function() {
    this.stk.pop();
    this.minStk.pop();
};

MinStack1.prototype.top = function() {
    return this.stk[this.stk.length - 1];
};

MinStack1.prototype.getMin = function() {
    // minStk 栈顶为全栈最小元素
    return this.minStk[this.minStk.length - 1];
};

// 优化版
var MinStack = function() {
    // 记录栈中的所有元素
    this.stk = [];
    // 阶段性记录栈中的最小元素
    this.minStk = [];
};

MinStack.prototype.push = function(val) {
    this.stk.push(val);
    // 维护 minStk 栈顶为全栈最小元素
    if (this.minStk.length === 0 || val <= this.minStk[this.minStk.length - 1]) {
        // 新插入的这个元素就是全栈最小的
        this.minStk.push(val);
    }
};

MinStack.prototype.pop = function() {
    // 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
    if (this.stk[this.stk.length - 1] === this.minStk[this.minStk.length - 1]) {
        // 弹出的元素是全栈最小的
        this.minStk.pop();
    }
    this.stk.pop();
};

MinStack.prototype.top = function() {
    return this.stk[this.stk.length - 1];
};

MinStack.prototype.getMin = function() {
    // minStk 栈顶为全栈最小元素
    return this.minStk[this.minStk.length - 1];
};
```

</div></div>
</div></div>

</div>
</details>
</div>

