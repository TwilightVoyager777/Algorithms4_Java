<p>Given the <code>head</code> of a linked list, reverse the nodes of the list <code>k</code> at a time, and return <em>the modified list</em>.</p>

<p><code>k</code> is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of <code>k</code> then left-out nodes, in the end, should remain as it is.</p>

<p>You may not alter the values in the list's nodes, only nodes themselves may be changed.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], k = 2
<strong>Output:</strong> [2,1,4,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], k = 3
<strong>Output:</strong> [3,2,1,4,5]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is <code>n</code>.</li> 
 <li><code>1 &lt;= k &lt;= n &lt;= 5000</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow-up:</strong> Can you solve the problem in <code>O(1)</code> extra memory space?</p>

<details><summary><strong>Related Topics</strong></summary>Linked List | Recursion</details><br>

<div>👍 14819, 👎 763<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

输入 `head`，`reverseKGroup` 函数能够把以 `head` 为头的这条链表进行翻转。

我们要充分利用这个递归函数的定义，把原问题分解成规模更小的子问题进行求解。

**1、先反转以 `head` 开头的 `k` 个元素**。

![](https://labuladong.online/algo/images/kgroup/3.jpg)

**2、将第 `k + 1` 个元素作为 `head` 递归调用 `reverseKGroup` 函数**。

![](https://labuladong.online/algo/images/kgroup/4.jpg)

**3、将上述两个过程的结果连接起来**。

![](https://labuladong.online/algo/images/kgroup/5.jpg)

最后函数递归完成之后就是这个结果，完全符合题意：

![](https://labuladong.online/algo/images/kgroup/7.jpg)

**详细题解**：
  - [单链表的花式反转方法汇总](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/)

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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (head == nullptr) return nullptr;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode *a, *b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == nullptr) return head;
            b = b->next;
        }
        // 反转前 k 个元素
        ListNode* newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a->next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转区间 [a, b) 的元素，注意是左闭右开
    ListNode* reverse(ListNode* a, ListNode* b) {
        ListNode *pre, *cur, *nxt;
        pre = nullptr;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur->next;
            cur->next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if head is None:
            return None
        # 区间 [a, b) 包含 k 个待反转元素
        a = b = head
        for i in range(k):
            # 不足 k 个，不需要反转，base case
            if b is None:
                return head
            b = b.next
        # 反转前 k 个元素
        newHead = self.reverse(a, b)
        # 递归反转后续链表并连接起来
        a.next = self.reverseKGroup(b, k) # <extend up -90>![](https://labuladong.online/algo/images/kgroup/6.jpg) #
        return newHead

    # 反转区间 [a, b) 的元素，注意是左闭右开
    def reverse(self, a: ListNode, b: ListNode) -> ListNode: # <extend up -300>![](https://labuladong.online/algo/images/kgroup/8.gif) #
        pre = None
        cur = a
        nxt = a
        # while 终止的条件改一下就行了
        while cur != b:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        # 返回反转后的头结点
        return pre
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);/**<extend up -90>![](https://labuladong.online/algo/images/kgroup/6.jpg) */
        return newHead;
    }

    // 反转区间 [a, b) 的元素，注意是左闭右开
    ListNode reverse(ListNode a, ListNode b) {/**<extend up -300>![](https://labuladong.online/algo/images/kgroup/8.gif) */
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func reverseKGroup(head *ListNode, k int) *ListNode {
    if head == nil {
        return nil
    }
    // 区间 [a, b) 包含 k 个待反转元素
    a, b := head, head
    for i := 0; i < k; i++ {
        // 不足 k 个，不需要反转，base case
        if b == nil {
            return head
        }
        b = b.Next
    }
    // 反转前 k 个元素
    newHead := reverse(a, b)
    // 递归反转后续链表并连接起来
    a.Next = reverseKGroup(b, k)
    return newHead
}

// 反转区间 [a, b) 的元素，注意是左闭右开
func reverse(a, b *ListNode) *ListNode {
    var pre, cur, nxt *ListNode
    cur = a
    nxt = a
    // while 终止的条件改一下就行了
    for cur != b {
        nxt = cur.Next
        cur.Next = pre
        pre = cur
        cur = nxt
    }
    // 返回反转后的头结点
    return pre
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var reverseKGroup = function(head, k) {
    if (head == null) return null;
    // 区间 [a, b) 包含 k 个待反转元素
    let a, b;
    a = b = head;
    for (let i = 0; i < k; i++) {
        // 不足 k 个，不需要反转，base case
        if (b == null) return head;
        b = b.next;
    }
    // 反转前 k 个元素
    let newHead = reverse(a, b);
    // 递归反转后续链表并连接起来
    a.next = reverseKGroup(b, k);
    return newHead;
};

// 反转区间 [a, b) 的元素，注意是左闭右开
function reverse(a, b) {
    let pre, cur, nxt;
    pre = null;
    cur = a;
    nxt = a;
    // while 终止的条件改一下就行了
    while (cur !== b) {
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    // 返回反转后的头结点
    return pre;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_reverse-nodes-in-k-group"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-nodes-in-k-group"></div></div>
</details><hr /><br />

</div>
</details>
</div>

