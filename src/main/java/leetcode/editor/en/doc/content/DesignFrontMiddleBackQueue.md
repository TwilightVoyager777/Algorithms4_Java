<p>Design a queue that supports <code>push</code> and <code>pop</code> operations in the front, middle, and back.</p>

<p>Implement the <code>FrontMiddleBack</code> class:</p>

<ul> 
 <li><code>FrontMiddleBack()</code> Initializes the queue.</li> 
 <li><code>void pushFront(int val)</code> Adds <code>val</code> to the <strong>front</strong> of the queue.</li> 
 <li><code>void pushMiddle(int val)</code> Adds <code>val</code> to the <strong>middle</strong> of the queue.</li> 
 <li><code>void pushBack(int val)</code> Adds <code>val</code> to the <strong>back</strong> of the queue.</li> 
 <li><code>int popFront()</code> Removes the <strong>front</strong> element of the queue and returns it. If the queue is empty, return <code>-1</code>.</li> 
 <li><code>int popMiddle()</code> Removes the <strong>middle</strong> element of the queue and returns it. If the queue is empty, return <code>-1</code>.</li> 
 <li><code>int popBack()</code> Removes the <strong>back</strong> element of the queue and returns it. If the queue is empty, return <code>-1</code>.</li> 
</ul>

<p><strong>Notice</strong> that when there are <b>two</b> middle position choices, the operation is performed on the <strong>frontmost</strong> middle position choice. For example:</p>

<ul> 
 <li>Pushing <code>6</code> into the middle of <code>[1, 2, 3, 4, 5]</code> results in <code>[1, 2, <u>6</u>, 3, 4, 5]</code>.</li> 
 <li>Popping the middle from <code>[1, 2, <u>3</u>, 4, 5, 6]</code> returns <code>3</code> and results in <code>[1, 2, 4, 5, 6]</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong>
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]
<strong>Output:</strong>
[null, null, null, null, null, 1, 3, 4, 2, -1]

<strong>Explanation:</strong>
FrontMiddleBackQueue q = new FrontMiddleBackQueue();
q.pushFront(1);   // [<u>1</u>]
q.pushBack(2);    // [1, <u>2</u>]
q.pushMiddle(3);  // [1, <u>3</u>, 2]
q.pushMiddle(4);  // [1, <u>4</u>, 3, 2]
q.popFront();     // return 1 -&gt; [4, 3, 2]
q.popMiddle();    // return 3 -&gt; [4, 2]
q.popMiddle();    // return 4 -&gt; [2]
q.popBack();      // return 2 -&gt; []
q.popFront();     // return -1 -&gt; [] (The queue is empty)
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= val &lt;= 10<sup>9</sup></code></li> 
 <li>At most&nbsp;<code>1000</code>&nbsp;calls will be made to&nbsp;<code>pushFront</code>,&nbsp;<code>pushMiddle</code>,&nbsp;<code>pushBack</code>, <code>popFront</code>, <code>popMiddle</code>, and <code>popBack</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Linked List | Design | Queue | Data Stream</details><br>

<div>👍 797, 👎 111<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题有点难度，主要是细节不好把控。常规的队列只能在首尾进行操作，想在中间操作队列，需要在底层把队列切分成 `left, right` 两个列表，但这里的细节问题就是元素为奇数时两个链表中元素的分配问题。

直接看代码吧，注释很详细。

**详细题解**：
  - [【练习】更多经典设计习题](https://labuladong.online/algo/problem-set/ds-design/)
  - [【练习】队列的经典习题](https://labuladong.online/algo/problem-set/queue/)

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

class FrontMiddleBackQueue {
    // 用两个列表表示队列的左右两部分，一遍从中间操作元素
    deque<int> left;
    deque<int> right;
    // 如果是奇数个元素，维护左边少右边多，所以：
    // 1、如果有偶数个元素时，pushMiddle 优先向右边添加
    // 2、如果有奇数个元素时，popMiddle 优先从右边删除
    // 3、如果只有 1 个元素，popFront 的时候，要去右边删除
    // 要把以上三个特点写到代码里，才能保证细节不出错

    // 维护左边少右边多的状态，每次增删元素之后都要执行一次
    void balance() {
        // 右边最多比左边多一个元素
        if (right.size() > left.size() + 1) {
            // 右边多，匀一个给左边
            left.push_back(right.front());
            right.pop_front();
        }
        if (left.size() > right.size()) {
            // 左边多，匀一个给右边
            right.push_front(left.back());
            left.pop_back();
        }
    }

public:
    void pushFront(int val) {
        left.push_front(val);
        balance();
    }

    void pushMiddle(int val) {
        if (size() % 2 == 0) {
            // 如果有偶数个元素时，pushMiddle 优先向右边添加
            right.push_front(val);
        } else {
            left.push_back(val);
        }
        balance();
    }

    void pushBack(int val) {
        right.push_back(val);
        balance();
    }

    int popFront() {
        if (size() == 0) {
            return -1;
        }
        if (size() == 1) {
            // 如果只有 1 个元素，popFront 的时候，要去右边删除
            int e = right.front();
            right.pop_front();
            return e;
        }
        int e = left.front();
        left.pop_front();
        balance();
        return e;
    }

    int popMiddle() {
        if (size() == 0) {
            return -1;
        }
        int e;
        if (size() % 2 == 0) {
            e = left.back();
            left.pop_back();
        } else {
            // 如果有奇数个元素时，popMiddle 优先从右边删除
            e = right.front();
            right.pop_front();
        }
        balance();
        return e;
    }

    int popBack() {
        if (size() == 0) {
            return -1;
        }
        int e = right.back();
        right.pop_back();
        balance();
        return e;
    }

    int size() {
        return left.size() + right.size();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

from collections import deque

class FrontMiddleBackQueue:
    # 用两个列表表示队列的左右两部分，一遍从中间操作元素
    def __init__(self):
        self.left = deque()
        self.right = deque()
    
    # 维护左边少右边多的状态，每次增删元素之后都要执行一次
    def balance(self):
        # 右边最多比左边多一个元素
        if len(self.right) > len(self.left) + 1:
            # 右边多，匀一个给左边
            self.left.append(self.right.popleft())
        if len(self.left) > len(self.right):
            # 左边多，匀一个给右边
            self.right.appendleft(self.left.pop())
    
    def pushFront(self, val: int) -> None:
        self.left.appendleft(val)
        self.balance()
    
    def pushMiddle(self, val: int) -> None:
        if self.size() % 2 == 0:
            # 如果有偶数个元素时，pushMiddle 优先向右边添加
            self.right.appendleft(val)
        else:
            self.left.append(val)
        self.balance()
    
    def pushBack(self, val: int) -> None:
        self.right.append(val)
        self.balance()
    
    def popFront(self) -> int:
        if self.size() == 0:
            return -1
        if self.size() == 1:
            # 如果只有 1 个元素，popFront 的时候，要去右边删除
            return self.right.popleft()
        e = self.left.popleft()
        self.balance()
        return e
    
    def popMiddle(self) -> int:
        if self.size() == 0:
            return -1
        if self.size() % 2 == 0:
            e = self.left.pop()
        else:
            # 如果有奇数个元素时，popMiddle 优先从右边删除
            e = self.right.popleft()
        self.balance()
        return e
    
    def popBack(self) -> int:
        if self.size() == 0:
            return -1
        e = self.right.pop()
        self.balance()
        return e
    
    def size(self) -> int:
        return len(self.left) + len(self.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class FrontMiddleBackQueue {
    // 用两个列表表示队列的左右两部分，一遍从中间操作元素
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();
    // 如果是奇数个元素，维护左边少右边多，所以：
    // 1、如果有偶数个元素时，pushMiddle 优先向右边添加
    // 2、如果有奇数个元素时，popMiddle 优先从右边删除
    // 3、如果只有 1 个元素，popFront 的时候，要去右边删除
    // 要把以上三个特点写到代码里，才能保证细节不出错

    // 维护左边少右边多的状态，每次增删元素之后都要执行一次
    private void balance() {
        // 右边最多比左边多一个元素
        if (right.size() > left.size() + 1) {
            // 右边多，匀一个给左边
            left.addLast(right.removeFirst());
        }
        if (left.size() > right.size()) {
            // 左边多，匀一个给右边
            right.addFirst(left.removeLast());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (size() % 2 == 0) {
            // 如果有偶数个元素时，pushMiddle 优先向右边添加
            right.addFirst(val);
        } else {
            left.addLast(val);
        }
        balance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (size() == 0) {
            return -1;
        }
        if (size() == 1) {
            // 如果只有 1 个元素，popFront 的时候，要去右边删除
            return right.removeFirst();
        }
        int e = left.removeFirst();
        balance();
        return e;
    }

    public int popMiddle() {
        if (size() == 0) {
            return -1;
        }
        int e;
        if (size() % 2 == 0) {
            e = left.removeLast();
        } else {
            // 如果有奇数个元素时，popMiddle 优先从右边删除
            e = right.removeFirst();
        }
        balance();
        return e;
    }

    public int popBack() {
        if (size() == 0) {
            return -1;
        }
        int e = right.removeLast();
        balance();
        return e;
    }

    public int size() {
        return left.size() + right.size();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import (
	"container/list"
)

type FrontMiddleBackQueue struct {
	left  *list.List
	right *list.List
}

// 用两个列表表示队列的左右两部分，一遍从中间操作元素
// 如果是奇数个元素，维护左边少右边多，所以：
// 1、如果有偶数个元素时，pushMiddle 优先向右边添加
// 2、如果有奇数个元素时，popMiddle 优先从右边删除
// 3、如果只有 1 个元素，popFront 的时候，要去右边删除
// 要把以上三个特点写到代码里，才能保证细节不出错

// 维护左边少右边多的状态，每次增删元素之后都要执行一次
func (q *FrontMiddleBackQueue) balance() {
	// 右边最多比左边多一个元素
	if q.right.Len() > q.left.Len()+1 {
		// 右边多，匀一个给左边
		q.left.PushBack(q.right.Remove(q.right.Front()))
	}
	if q.left.Len() > q.right.Len() {
		// 左边多，匀一个给右边
		q.right.PushFront(q.left.Remove(q.left.Back()))
	}
}

func Constructor() FrontMiddleBackQueue {
	return FrontMiddleBackQueue{
		left:  list.New(),
		right: list.New(),
	}
}

func (q *FrontMiddleBackQueue) PushFront(val int) {
	q.left.PushFront(val)
	q.balance()
}

func (q *FrontMiddleBackQueue) PushMiddle(val int) {
	if (q.left.Len()+q.right.Len())%2 == 0 {
		// 如果有偶数个元素时，pushMiddle 优先向右边添加
		q.right.PushFront(val)
	} else {
		q.left.PushBack(val)
	}
	q.balance()
}

func (q *FrontMiddleBackQueue) PushBack(val int) {
	q.right.PushBack(val)
	q.balance()
}

func (q *FrontMiddleBackQueue) PopFront() int {
	if q.left.Len()+q.right.Len() == 0 {
		return -1
	}
	if q.left.Len()+q.right.Len() == 1 {
		// 如果只有 1 个元素，popFront 的时候，要去右边删除
		return q.right.Remove(q.right.Front()).(int)
	}
	e := q.left.Remove(q.left.Front()).(int)
	q.balance()
	return e
}

func (q *FrontMiddleBackQueue) PopMiddle() int {
	if q.left.Len()+q.right.Len() == 0 {
		return -1
	}
	var e int
	if (q.left.Len()+q.right.Len())%2 == 0 {
		e = q.left.Remove(q.left.Back()).(int)
	} else {
		// 如果有奇数个元素时，popMiddle 优先从右边删除
		e = q.right.Remove(q.right.Front()).(int)
	}
	q.balance()
	return e
}

func (q *FrontMiddleBackQueue) PopBack() int {
	if q.left.Len()+q.right.Len() == 0 {
		return -1
	}
	e := q.right.Remove(q.right.Back()).(int)
	q.balance()
	return e
}

func (q *FrontMiddleBackQueue) Size() int {
	return q.left.Len() + q.right.Len()
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var FrontMiddleBackQueue = function() {
    // 用两个列表表示队列的左右两部分，一遍从中间操作元素
    this.left = [];
    this.right = [];
    // 如果是奇数个元素，维护左边少右边多，所以：
    // 1、如果有偶数个元素时，pushMiddle 优先向右边添加
    // 2、如果有奇数个元素时，popMiddle 优先从右边删除
    // 3、如果只有 1 个元素，popFront 的时候，要去右边删除
    // 要把以上三个特点写到代码里，才能保证细节不出错
};

FrontMiddleBackQueue.prototype.balance = function() {
    // 维护左边少右边多的状态，每次增删元素之后都要执行一次
    // 右边最多比左边多一个元素
    if (this.right.length > this.left.length + 1) {
        // 右边多，匀一个给左边
        this.left.push(this.right.shift());
    }
    if (this.left.length > this.right.length) {
        // 左边多，匀一个给右边
        this.right.unshift(this.left.pop());
    }
};

FrontMiddleBackQueue.prototype.pushFront = function(val) {
    this.left.unshift(val);
    this.balance();
};

FrontMiddleBackQueue.prototype.pushMiddle = function(val) {
    if (this.size() % 2 === 0) {
        // 如果有偶数个元素时，pushMiddle 优先向右边添加
        this.right.unshift(val);
    } else {
        this.left.push(val);
    }
    this.balance();
};

FrontMiddleBackQueue.prototype.pushBack = function(val) {
    this.right.push(val);
    this.balance();
};

FrontMiddleBackQueue.prototype.popFront = function() {
    if (this.size() === 0) {
        return -1;
    }
    if (this.size() === 1) {
        // 如果只有 1 个元素，popFront 的时候，要去右边删除
        return this.right.shift();
    }
    const e = this.left.shift();
    this.balance();
    return e;
};

FrontMiddleBackQueue.prototype.popMiddle = function() {
    if (this.size() === 0) {
        return -1;
    }
    let e;
    if (this.size() % 2 === 0) {
        e = this.left.pop();
    } else {
        // 如果有奇数个元素时，popMiddle 优先从右边删除
        e = this.right.shift();
    }
    this.balance();
    return e;
};

FrontMiddleBackQueue.prototype.popBack = function() {
    if (this.size() === 0) {
        return -1;
    }
    const e = this.right.pop();
    this.balance();
    return e;
};

FrontMiddleBackQueue.prototype.size = function() {
    return this.left.length + this.right.length;
};
```

</div></div>
</div></div>

</div>
</details>
</div>



