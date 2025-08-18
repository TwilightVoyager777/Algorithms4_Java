<p>Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (<code>push</code>, <code>peek</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyQueue</code> class:</p>

<ul> 
 <li><code>void push(int x)</code> Pushes element x to the back of the queue.</li> 
 <li><code>int pop()</code> Removes the element from the front of the queue and returns it.</li> 
 <li><code>int peek()</code> Returns the element at the front of the queue.</li> 
 <li><code>boolean empty()</code> Returns <code>true</code> if the queue is empty, <code>false</code> otherwise.</li> 
</ul>

<p><strong>Notes:</strong></p>

<ul> 
 <li>You must use <strong>only</strong> standard operations of a stack, which means only <code>push to top</code>, <code>peek/pop from top</code>, <code>size</code>, and <code>is empty</code> operations are valid.</li> 
 <li>Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 1, 1, false]

<strong>Explanation</strong>
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= x &lt;= 9</code></li> 
 <li>At most <code>100</code>&nbsp;calls will be made to <code>push</code>, <code>pop</code>, <code>peek</code>, and <code>empty</code>.</li> 
 <li>All the calls to <code>pop</code> and <code>peek</code> are valid.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow-up:</strong> Can you implement the queue such that each operation is <strong><a href="https://en.wikipedia.org/wiki/Amortized_analysis" target="_blank">amortized</a></strong> <code>O(1)</code> time complexity? In other words, performing <code>n</code> operations will take overall <code>O(n)</code> time even if one of those operations may take longer.</p>

<details><summary><strong>Related Topics</strong></summary>Stack | Design | Queue</details><br>

<div>👍 8263, 👎 465<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/stack-queue/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

对于一个正常的的队列，它的 `pop/push` 等方法都是 `O(1)` 的复杂度。如果题目非要让我们用栈的 API 模拟队列的 API 肯定可以做到，但复杂度肯定会高一些。

最简单的一个思路，我们使用两个栈 `s1, s2` 就能实现一个队列的功能。

当调用 `push` 让元素入队时，只要把元素压入 `s1` 即可，时间复杂度 `O(1)`：

![](https://labuladong.online/algo/images/stack-queue/3.jpg)

使用 `peek` 或 `pop` 操作队头的元素时，若 `s2` 为空，可以把 `s1` 的所有元素取出再添加进 `s2`，**这时候 `s2` 中元素就是先进先出顺序了**，不过这样移动所有元素的复杂度是 `O(n)`：

![](https://labuladong.online/algo/images/stack-queue/4.jpg)

**详细题解**：
  - [队列实现栈以及栈实现队列](https://labuladong.online/algo/data-structure/stack-queue/)

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

class MyQueue {
private:
    stack<int> s1, s2;

public:
    MyQueue() {
        // Constructor initializes two stacks
    }

    // 添加元素到队尾
    void push(int x) {
        s1.push(x);
    }

    // 删除队头元素并返回
    int pop() {
        // 先调用 peek 保证 s2 非空
        peek();
        int topElement = s2.top();
        s2.pop();
        return topElement;
    }

    // 返回队头元素
    int peek() {
        if (s2.empty()) {
            // 把 s1 元素压入 s2
            while (!s1.empty()) {
                s2.push(s1.top());
                s1.pop();
            }
        }
        return s2.top();
    }

    // 判断队列是否为空
    bool empty() {
        return s1.empty() && s2.empty();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class MyQueue:
    def __init__(self):
        self.s1 = []
        self.s2 = []

    # 添加元素到队尾
    def push(self, x: int) -> None:
        self.s1.append(x)

    # 删除队头元素并返回
    def pop(self) -> int:
        # 先调用 peek 保证 s2 非空
        self.peek()
        return self.s2.pop()

    # 返回队头元素
    def peek(self) -> int:
        if not self.s2:
            # 把 s1 元素压入 s2
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]

    # 判断队列是否为空
    def empty(self) -> bool:
        return not self.s1 and not self.s2
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class MyQueue {
    private Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    
    // 添加元素到队尾
    public void push(int x) {
        s1.push(x);
    }

    // 删除队头元素并返回
    public int pop() {
        // 先调用 peek 保证 s2 非空
        peek();
        return s2.pop();
    }

    // 返回队头元素
    public int peek() {
        if (s2.isEmpty())
            // 把 s1 元素压入 s2
            while (!s1.isEmpty())
                s2.push(s1.pop());
        return s2.peek();
    }

    // 判断队列是否为空
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type MyQueue struct {
    s1, s2 []int
}

func Constructor() MyQueue {
    return MyQueue{
        s1: []int{},
        s2: []int{},
    }
}

// 添加元素到队尾
func (this *MyQueue) Push(x int) {
    this.s1 = append(this.s1, x)
}

// 删除队头元素并返回
func (this *MyQueue) Pop() int {
    // 先调用 peek 保证 s2 非空
    this.Peek()
    x := this.s2[len(this.s2)-1]
    this.s2 = this.s2[:len(this.s2)-1]
    return x
}

// 返回队头元素
func (this *MyQueue) Peek() int {
    if len(this.s2) == 0 {
        // 把 s1 元素压入 s2
        for len(this.s1) > 0 {
            size := len(this.s1)
            this.s2 = append(this.s2, this.s1[size-1])
            this.s1 = this.s1[:size-1]
        }
    }
    return this.s2[len(this.s2)-1]
}

// 判断队列是否为空
func (this *MyQueue) Empty() bool {
    return len(this.s1) == 0 && len(this.s2) == 0
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var MyQueue = function() {
    this.s1 = [];
    this.s2 = [];
};

// 添加元素到队尾
MyQueue.prototype.push = function(x) {
    this.s1.push(x);
};

// 删除队头元素并返回
MyQueue.prototype.pop = function() {
    // 先调用 peek 保证 s2 非空
    this.peek();
    return this.s2.pop();
};

// 返回队头元素
MyQueue.prototype.peek = function() {
    if (this.s2.length === 0) {
        // 把 s1 元素压入 s2
        while (this.s1.length > 0) {
            this.s2.push(this.s1.pop());
        }
    }
    return this.s2[this.s2.length - 1];
};

// 判断队列是否为空
MyQueue.prototype.empty = function() {
    return this.s1.length === 0 && this.s2.length === 0;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

