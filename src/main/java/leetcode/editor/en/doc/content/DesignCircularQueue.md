<p>Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".</p>

<p>One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.</p>

<p>Implement the <code>MyCircularQueue</code> class:</p>

<ul> 
 <li><code>MyCircularQueue(k)</code> Initializes the object with the size of the queue to be <code>k</code>.</li> 
 <li><code>int Front()</code> Gets the front item from the queue. If the queue is empty, return <code>-1</code>.</li> 
 <li><code>int Rear()</code> Gets the last item from the queue. If the queue is empty, return <code>-1</code>.</li> 
 <li><code>boolean enQueue(int value)</code> Inserts an element into the circular queue. Return <code>true</code> if the operation is successful.</li> 
 <li><code>boolean deQueue()</code> Deletes an element from the circular queue. Return <code>true</code> if the operation is successful.</li> 
 <li><code>boolean isEmpty()</code> Checks whether the circular queue is empty or not.</li> 
 <li><code>boolean isFull()</code> Checks whether the circular queue is full or not.</li> 
</ul>

<p>You must solve the problem without using the built-in queue data structure in your programming language.&nbsp;</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
<strong>Output</strong>
[null, true, true, true, false, 3, true, true, true, 4]

<strong>Explanation</strong>
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= 1000</code></li> 
 <li><code>0 &lt;= value &lt;= 1000</code></li> 
 <li>At most <code>3000</code> calls will be made to&nbsp;<code>enQueue</code>, <code>deQueue</code>,&nbsp;<code>Front</code>,&nbsp;<code>Rear</code>,&nbsp;<code>isEmpty</code>, and&nbsp;<code>isFull</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Linked List | Design | Queue</details><br>

<div>👍 3717, 👎 328<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题考察的是普通队列的实现，底层可以用链表或数组实现，用链表实现比较简单，用数组的话要用到环形数组的技巧。具体可以参见 [用链表实现队列/栈](https://labuladong.online/algo/data-structure-basic/linked-queue-stack/) 和 [用数组实现环形队列](https://labuladong.online/algo/data-structure-basic/array-queue-stack/) 两篇文章。

**详细题解**：
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

#include <vector>
#include <stdexcept>
#include <optional>

// 底层用数组实现队列
template<typename E>
class ArrayQueue {
private:
    int size;
    std::vector<std::optional<E>> data;
    static const int INIT_CAP = 2;
    int first, last;

    void resize(int newCap) {
        std::vector<std::optional<E>> temp(newCap);

        // first ----- last
        // --- last    first ---

        for (int i = 0; i < size; i++) {
            temp[i] = data[(first + i) % data.size()];
        }

        first = 0;
        last = size;
        data = std::move(temp);
    }

public:
    ArrayQueue(int initCap) : size(0), data(initCap), first(0), last(0) {}

    ArrayQueue() : ArrayQueue(INIT_CAP) {
        // 不传参数，默认大小为 INIT_CAP
    }

    // 增
    void enqueue(E e) {
        if (size == data.size()) {
            resize(size * 2);
        }

        data[last] = e;
        last++;
        if (last == data.size()) {
            last = 0;
        }

        size++;
    }

    // 删
    E dequeue() {
        if (isEmpty()) {
            throw std::out_of_range("Queue is empty");
        }

        if (size == data.size() / 4) {
            resize(data.size() / 2);
        }

        E oldVal = *data[first];
        data[first].reset();
        first++;
        if (first == data.size()) {
            first = 0;
        }

        size--;
        return oldVal;
    }

    // 查
    E peekFirst() {
        if (isEmpty()) {
            throw std::out_of_range("Queue is empty");
        }
        return *data[first];
    }

    E peekLast() {
        if (isEmpty()) {
            throw std::out_of_range("Queue is empty");
        }
        if (last == 0) return *data[data.size() - 1];
        return *data[last - 1];
    }

    int getSize() const {
        return size;
    }

    bool isEmpty() const {
        return size == 0;
    }
};

class MyCircularQueue {
private:
    ArrayQueue<int> q;
    int maxCap;

public:
    MyCircularQueue(int k) : q(k), maxCap(k) {}

    bool enQueue(int value) {
        if (q.getSize() == maxCap) {
            return false;
        }
        q.enqueue(value);
        return true;
    }

    bool deQueue() {
        if (q.isEmpty()) {
            return false;
        }
        q.dequeue();
        return true;
    }

    int Front() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekFirst();
    }

    int Rear() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekLast();
    }

    bool isEmpty() {
        return q.isEmpty();
    }

    bool isFull() {
        return q.getSize() == maxCap;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

from collections import deque

# 底层用数组实现队列
class ArrayQueue:
    INIT_CAP = 2

    def __init__(self, init_cap=INIT_CAP):
        self.size = 0
        self.data = [None] * init_cap
        self.first = 0
        self.last = 0

    # 不传参数，默认大小为 INIT_CAP
    # Initializer with default capacity

    # 增
    def enqueue(self, e):
        if self.size == len(self.data):
            self.resize(self.size * 2)

        self.data[self.last] = e
        self.last += 1
        if self.last == len(self.data):
            self.last = 0

        self.size += 1

    # 删
    def dequeue(self):
        if self.is_empty():
            raise Exception('Queue underflow')

        if self.size == len(self.data) // 4:
            self.resize(len(self.data) // 2)

        old_val = self.data[self.first]
        self.data[self.first] = None
        self.first += 1
        if self.first == len(self.data):
            self.first = 0

        self.size -= 1
        return old_val

    def resize(self, new_cap):
        temp = [None] * new_cap

        # first ----- last
        # --- last    first ---

        for i in range(self.size):
            temp[i] = self.data[(self.first + i) % len(self.data)]

        self.first = 0
        self.last = self.size
        self.data = temp

    # 查
    def peek_first(self):
        if self.is_empty():
            raise Exception('Queue underflow')
        return self.data[self.first]

    def peek_last(self):
        if self.is_empty():
            raise Exception('Queue underflow')
        if self.last == 0:
            return self.data[len(self.data) - 1]
        return self.data[self.last - 1]

    def size(self):
        return self.size

    def is_empty(self):
        return self.size == 0


class MyCircularQueue:

    def __init__(self, k):
        self.q = ArrayQueue(k)
        self.max_cap = k

    def enQueue(self, value):
        if self.q.size == self.max_cap:
            return False
        self.q.enqueue(value)
        return True

    def deQueue(self):
        if self.q.is_empty():
            return False
        self.q.dequeue()
        return True

    def Front(self):
        if self.q.is_empty():
            return -1
        return self.q.peek_first()

    def Rear(self):
        if self.q.is_empty():
            return -1
        return self.q.peek_last()

    def isEmpty(self):
        return self.q.is_empty()

    def isFull(self):
        return self.q.size == self.max_cap
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
import java.util.NoSuchElementException;

// 底层用数组实现队列
public class ArrayQueue<E> {
    private int size;
    private E[] data;
    private final static int INIT_CAP = 2;

    private int first, last;

    public ArrayQueue(int initCap) {
        size = 0;
        data = (E[]) new Object[initCap];
        first = last = 0;
    }

    public ArrayQueue() {
        // 不传参数，默认大小为 INIT_CAP
        this(INIT_CAP);
    }

    // 增
    public void enqueue(E e) {
        if (size == data.length) {
            resize(size * 2);
        }

        data[last] = e;
        last++;
        if (last == data.length) {
            last = 0;
        }

        size++;
    }

    // 删
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (size == data.length / 4) {
            resize(data.length / 2);
        }

        E oldVal = data[first];
        data[first] = null;
        first++;
        if (first == data.length) {
            first = 0;
        }

        size--;
        return oldVal;
    }

    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];

        // first ----- last
        // --- last    first ---

        for (int i = 0; i < size; i++) {
            temp[i] = data[(first + i) % data.length];
        }

        first = 0;
        last = size;
        data = temp;
    }

    // 查
    public E peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[first];
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (last == 0) return data[data.length - 1];
        return data[last - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}

class MyCircularQueue {

    ArrayQueue<Integer> q;
    int maxCap;

    public MyCircularQueue(int k) {
        q = new ArrayQueue<>(k);
        maxCap = k;
    }

    public boolean enQueue(int value) {
        if (q.size() == maxCap) {
            return false;
        }
        q.enqueue(value);
        return true;
    }

    public boolean deQueue() {
        if (q.isEmpty()) {
            return false;
        }
        q.dequeue();
        return true;
    }

    public int Front() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekFirst();
    }

    public int Rear() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekLast();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public boolean isFull() {
        return q.size() == maxCap;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import "errors"

// 底层用数组实现队列
type ArrayQueue[E any] struct {
    size  int
    data  []E
    first int
    last  int
}

const INIT_CAP = 2

func NewArrayQueue[E any](initCap int) *ArrayQueue[E] {
    return &ArrayQueue[E]{
        size:  0,
        data:  make([]E, initCap),
        first: 0,
        last:  0,
    }
}

func NewArrayQueueDefault[E any]() *ArrayQueue[E] {
    // 不传参数，默认大小为 INIT_CAP
    return NewArrayQueue[E](INIT_CAP)
}

// 增
func (q *ArrayQueue[E]) Enqueue(e E) {
    if q.size == len(q.data) {
        q.resize(q.size * 2)
    }

    q.data[q.last] = e
    q.last++
    if q.last == len(q.data) {
        q.last = 0
    }

    q.size++
}

// 删
func (q *ArrayQueue[E]) Dequeue() (E, error) {
    if q.isEmpty() {
        var zero E
        return zero, errors.New("no such element")
    }

    if q.size == len(q.data)/4 {
        q.resize(len(q.data) / 2)
    }

    oldVal := q.data[q.first]
    var zero E
    q.data[q.first] = zero
    q.first++
    if q.first == len(q.data) {
        q.first = 0
    }

    q.size--
    return oldVal, nil
}

func (q *ArrayQueue[E]) resize(newCap int) {
    temp := make([]E, newCap)

    // first ----- last
    // --- last    first ---
    for i := 0; i < q.size; i++ {
        temp[i] = q.data[(q.first+i)%len(q.data)]
    }

    q.first = 0
    q.last = q.size
    q.data = temp
}

// 查
func (q *ArrayQueue[E]) PeekFirst() (E, error) {
    if q.isEmpty() {
        var zero E
        return zero, errors.New("no such element")
    }
    return q.data[q.first], nil
}

func (q *ArrayQueue[E]) PeekLast() (E, error) {
    if q.isEmpty() {
        var zero E
        return zero, errors.New("no such element")
    }
    if q.last == 0 {
        return q.data[len(q.data)-1], nil
    }
    return q.data[q.last-1], nil
}

func (q *ArrayQueue[E]) Size() int {
    return q.size
}

func (q *ArrayQueue[E]) isEmpty() bool {
    return q.size == 0
}

type MyCircularQueue struct {
    q      *ArrayQueue[int]
    maxCap int
}

func Constructor(k int) MyCircularQueue {
    return MyCircularQueue{
        q:      NewArrayQueue[int](k),
        maxCap: k,
    }
}

func (cq *MyCircularQueue) EnQueue(value int) bool {
    if cq.q.Size() == cq.maxCap {
        return false
    }
    cq.q.Enqueue(value)
    return true
}

func (cq *MyCircularQueue) DeQueue() bool {
    if cq.q.isEmpty() {
        return false
    }
    _, _ = cq.q.Dequeue()
    return true
}

func (cq *MyCircularQueue) Front() int {
    if cq.q.isEmpty() {
        return -1
    }
    val, _ := cq.q.PeekFirst()
    return val
}

func (cq *MyCircularQueue) Rear() int {
    if cq.q.isEmpty() {
        return -1
    }
    val, _ := cq.q.PeekLast()
    return val
}

func (cq *MyCircularQueue) IsEmpty() bool {
    return cq.q.isEmpty()
}

func (cq *MyCircularQueue) IsFull() bool {
    return cq.q.Size() == cq.maxCap
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 底层用数组实现队列
class ArrayQueue {
    // 不传参数，默认大小为 INIT_CAP
    constructor(initCap = 2) {
        this.size = 0;
        this.data = new Array(initCap);
        this.first = 0;
        this.last = 0;
    }

    // 增
    enqueue(e) {
        if (this.size === this.data.length) {
            this.resize(this.size * 2);
        }

        this.data[this.last] = e;
        this.last++;
        if (this.last === this.data.length) {
            this.last = 0;
        }

        this.size++;
    }

    // 删
    dequeue() {
        if (this.isEmpty()) {
            throw new Error('NoSuchElementException');
        }

        if (this.size === this.data.length / 4) {
            this.resize(Math.floor(this.data.length / 2));
        }

        const oldVal = this.data[this.first];
        this.data[this.first] = null;
        this.first++;
        if (this.first === this.data.length) {
            this.first = 0;
        }

        this.size--;
        return oldVal;
    }

    resize(newCap) {
        const temp = new Array(newCap);

        // first ----- last
        // --- last    first ---

        for (let i = 0; i < this.size; i++) {
            temp[i] = this.data[(this.first + i) % this.data.length];
        }

        this.first = 0;
        this.last = this.size;
        this.data = temp;
    }

    // 查
    peekFirst() {
        if (this.isEmpty()) {
            throw new Error('NoSuchElementException');
        }
        return this.data[this.first];
    }

    peekLast() {
        if (this.isEmpty()) {
            throw new Error('NoSuchElementException');
        }
        if (this.last === 0) return this.data[this.data.length - 1];
        return this.data[this.last - 1];
    }

    size() {
        return this.size;
    }

    isEmpty() {
        return this.size === 0;
    }
}

var MyCircularQueue = function(k) {
    this.q = new ArrayQueue(k);
    this.maxCap = k;
};

MyCircularQueue.prototype.enQueue = function(value) {
    if (this.q.size === this.maxCap) {
        return false;
    }
    this.q.enqueue(value);
    return true;
};

MyCircularQueue.prototype.deQueue = function() {
    if (this.q.isEmpty()) {
        return false;
    }
    this.q.dequeue();
    return true;
};

MyCircularQueue.prototype.Front = function() {
    if (this.q.isEmpty()) {
        return -1;
    }
    return this.q.peekFirst();
};

MyCircularQueue.prototype.Rear = function() {
    if (this.q.isEmpty()) {
        return -1;
    }
    return this.q.peekLast();
};

MyCircularQueue.prototype.isEmpty = function() {
    return this.q.isEmpty();
};

MyCircularQueue.prototype.isFull = function() {
    return this.q.size === this.maxCap;
};
```

</div></div>
</div></div>

</div>
</details>
</div>





