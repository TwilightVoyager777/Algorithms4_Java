<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/sumii-linked-list.jpg" style="width: 523px; height: 342px;" /> 
<pre>
<strong>Input:</strong> l1 = [7,2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,8,0,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [8,0,7]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>It is guaranteed that the list represents a number that does not have leading zeros.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong>&nbsp;Could you solve it without reversing the input lists?</p>

<details><summary><strong>Related Topics</strong></summary>Linked List | Math | Stack</details><br>

<div>👍 6056, 👎 297<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题是 [✨2. 两数相加](/problems/add-two-numbers/) 的进阶问题，我们模拟加法运算当然是从最低位开始加，这样才能正确的处理进位。但现在单链表的开头是最高位，那么最直接的想法就是先 [翻转链表](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/)，这样就可以继续玩第 2 题那一套了，没什么难度。

不过本题也说了，如果不让你反转链表怎么办？其实也好办，我们可以利用栈这种先进后出的数据结构，把链表节点从头到尾放进栈中，再从栈拿出来就是从尾到头的顺序，相当于是反转链表的效果，然后又回到了第 2 题的加法逻辑。

还有一个需要注意的是，计算结果的高位也应该放在结果链表的左侧，也就是插入到 `dummy` 节点的后面。具体看代码吧。

**详细题解**：
  - [【练习】链表双指针经典习题](https://labuladong.online/algo/problem-set/linkedlist-two-pointers/)

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

#include <stack>

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // 把链表元素转入栈中
        std::stack<int> stk1;
        while (l1 != nullptr) {
            stk1.push(l1->val);
            l1 = l1->next;
        }
        std::stack<int> stk2;
        while (l2 != nullptr) {
            stk2.push(l2->val);
            l2 = l2->next;
        }
        
        // 接下来基本上是复用我在第 2 题的代码逻辑
        // 注意新节点要直接插入到 dummy 后面

        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode* dummy = new ListNode(-1);

        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (!stk1.empty() || !stk2.empty() || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (!stk1.empty()) {
                val += stk1.top();
                stk1.pop();
            }
            if (!stk2.empty()) {
                val += stk2.top();
                stk2.pop();
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点，直接接在 dummy 后面
            ListNode* newNode = new ListNode(val);
            newNode->next = dummy->next;
            dummy->next = newNode;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy->next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 把链表元素转入栈中
        stk1 = []
        while l1:
            stk1.append(l1.val)
            l1 = l1.next
        stk2 = []
        while l2:
            stk2.append(l2.val)
            l2 = l2.next

        # 接下来基本上是复用我在第 2 题的代码逻辑
        # 注意新节点要直接插入到 dummy 后面

        # 虚拟头结点（构建新链表时的常用技巧）
        dummy = ListNode(-1)

        # 记录进位
        carry = 0
        # 开始执行加法，两条链表走完且没有进位时才能结束循环
        while stk1 or stk2 or carry > 0:
            # 先加上上次的进位
            val = carry
            if stk1:
                val += stk1.pop()
            if stk2:
                val += stk2.pop()
            # 处理进位情况
            carry = val // 10
            val = val % 10
            # 构建新节点，直接接在 dummy 后面
            newNode = ListNode(val)
            newNode.next = dummy.next
            dummy.next = newNode

        # 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 把链表元素转入栈中
        Stack<Integer> stk1 = new Stack<>();
        while (l1 != null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stk2 = new Stack<>();
        while (l2 != null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }

        // 接下来基本上是复用我在第 2 题的代码逻辑
        // 注意新节点要直接插入到 dummy 后面

        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);

        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (!stk1.isEmpty() || !stk2.isEmpty() || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (!stk1.isEmpty()) {
                val += stk1.pop();
            }
            if (!stk2.isEmpty()) {
                val += stk2.pop();
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点，直接接在 dummy 后面
            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    // 把链表元素转入栈中
    var stk1 []int
    for l1 != nil {
        stk1 = append(stk1, l1.Val)
        l1 = l1.Next
    }
    var stk2 []int
    for l2 != nil {
        stk2 = append(stk2, l2.Val)
        l2 = l2.Next
    }

    // 接下来基本上是复用我在第 2 题的代码逻辑
    // 注意新节点要直接插入到 dummy 后面

    // 虚拟头结点（构建新链表时的常用技巧）
    dummy := &ListNode{-1, nil}

    // 记录进位
    carry := 0
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    for len(stk1) > 0 || len(stk2) > 0 || carry > 0 {
        // 先加上上次的进位
        val := carry
        if len(stk1) > 0 {
            val += stk1[len(stk1)-1]
            stk1 = stk1[:len(stk1)-1]
        }
        if len(stk2) > 0 {
            val += stk2[len(stk2)-1]
            stk2 = stk2[:len(stk2)-1]
        }
        // 处理进位情况
        carry = val / 10
        val = val % 10
        // 构建新节点，直接接在 dummy 后面
        newNode := &ListNode{Val: val, Next: dummy.Next}
        dummy.Next = newNode
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var addTwoNumbers = function(l1, l2) {
    // 把链表元素转入栈中
    let stk1 = [];
    while (l1 !== null) {
        stk1.push(l1.val);
        l1 = l1.next;
    }
    let stk2 = [];
    while (l2 !== null) {
        stk2.push(l2.val);
        l2 = l2.next;
    }

    // 接下来基本上是复用我在第 2 题的代码逻辑
    // 注意新节点要直接插入到 dummy 后面

    // 虚拟头结点（构建新链表时的常用技巧）
    let dummy = new ListNode(-1);

    // 记录进位
    let carry = 0;
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    while (stk1.length > 0 || stk2.length > 0 || carry > 0) {
        // 先加上上次的进位
        let val = carry;
        if (stk1.length > 0) {
            val += stk1.pop();
        }
        if (stk2.length > 0) {
            val += stk2.pop();
        }
        // 处理进位情况
        carry = Math.floor(val / 10);
        val = val % 10;
        // 构建新节点，直接接在 dummy 后面
        let newNode = new ListNode(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.next;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_add-two-numbers-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_add-two-numbers-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

