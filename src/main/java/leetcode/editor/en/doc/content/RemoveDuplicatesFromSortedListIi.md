<p>Given the <code>head</code> of a sorted linked list, <em>delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" style="width: 500px; height: 142px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,3,4,4,5]
<strong>Output:</strong> [1,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" style="width: 500px; height: 205px;" /> 
<pre>
<strong>Input:</strong> head = [1,1,1,2,3]
<strong>Output:</strong> [2,3]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List | Two Pointers</details><br>

<div>👍 9316, 👎 265<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题可以有多种解法，最简单粗暴的解法是用 [哈希集合](https://labuladong.online/algo/data-structure-basic/hash-set/) 来记录重复节点，需要额外的空间复杂度，我们不讨论。下面探讨如何用双指针技巧，避免使用额外的空间复杂度来求解。

第一种思路，也是我比较推荐的方式，就是把这种题转化成 [链表的双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中讲的链表分解的技巧。题目其实就是让你把链表分解成「重复元素」和「不重复元素」两条链表，然后把不重复元素这条链表返回即可。

第二种思路，可以把这道题理解为 [链表的双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中讲的 [✨83. 删除排序链表中的重复元素](/problems/remove-duplicates-from-sorted-list/) 的变体，只不过 83 题让你把多于的重复元素去掉，这道题要求你把所有重复的元素全都去掉。

第三种思路，可以用递归思维来做，稍微难理解一些，我也写出来供大家参考。

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

// 推荐的通用解法，运用链表分解的技巧
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // 将原链表分解为两条链表
        // 一条链表存放不重复的节点，另一条链表存放重复的节点
        // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
        ListNode dummyUniq(101);
        ListNode dummyDup(101);

        ListNode* pUniq = &dummyUniq;
        ListNode* pDup = &dummyDup;
        ListNode* p = head;

        while (p != nullptr) {
            if ((p->next != nullptr && p->val == p->next->val) || p->val == pDup->val) {
                // 发现重复节点，接到重复链表后面
                pDup->next = p;
                pDup = pDup->next;
            } else {
                // 不是重复节点，接到不重复链表后面
                pUniq->next = p;
                pUniq = pUniq->next;
            }

            p = p->next;
            // 将原链表和新链表断开
            pUniq->next = nullptr;
            pDup->next = nullptr;
        }

        return dummyUniq.next;
    }
};

// 快慢双指针解法
class Solution2 {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode dummy(-1);
        ListNode* p = &dummy;
        ListNode* q = head;
        while (q != nullptr) {
            if (q->next != nullptr && q->val == q->next->val) {
                // 发现重复节点，跳过这些重复节点
                while (q->next != nullptr && q->val == q->next->val) {
                    q = q->next;
                }
                q = q->next;
                // 此时 q 跳过了这一段重复元素
                if (q == nullptr) {
                    p->next = nullptr;
                }
                // 不过下一段元素也可能重复，等下一轮 while 循环判断
            } else {
                // 不是重复节点，接到 dummy 后面
                p->next = q;
                p = p->next;
                q = q->next;
            }
        }
        return dummy.next;
    }
};

// 递归解法
class Solution3 {
public:
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    ListNode* deleteDuplicates(ListNode* head) {
        // base case
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        if (head->val != head->next->val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head->next = deleteDuplicates(head->next);
            return head;
        }
        // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
        // 越过重复节点，找到 head 之后那个不重复的节点
        while (head->next != nullptr && head->val == head->next->val) {
            head = head->next;
        }
        // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
        return deleteDuplicates(head->next);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 推荐的通用解法，运用链表分解的技巧
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # 将原链表分解为两条链表
        # 一条链表存放不重复的节点，另一条链表存放重复的节点
        # 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
        dummyUniq = ListNode(101)
        dummyDup = ListNode(101)

        pUniq, pDup = dummyUniq, dummyDup
        p = head

        while p is not None:
            if (p.next is not None and p.val == p.next.val) or p.val == pDup.val:
                # 发现重复节点，接到重复链表后面
                pDup.next = p
                pDup = pDup.next
            else:
                # 不是重复节点，接到不重复链表后面
                pUniq.next = p
                pUniq = pUniq.next

            p = p.next
            # 将原链表和新链表断开
            pUniq.next = None
            pDup.next = None

        return dummyUniq.next

# 快慢双指针解法
class Solution2:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(-1)
        p, q = dummy, head
        while q is not None:
            if q.next is not None and q.val == q.next.val:
                # 发现重复节点，跳过这些重复节点
                while q.next is not None and q.val == q.next.val:
                    q = q.next
                q = q.next
                # 此时 q 跳过了这一段重复元素
                if q is None:
                    p.next = None
                # 不过下一段元素也可能重复，等下一轮 while 循环判断
            else:
                # 不是重复节点，接到 dummy 后面
                p.next = q
                p = p.next
                q = q.next
        return dummy.next

# 递归解法
class Solution3:
    # 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # base case
        if head is None or head.next is None:
            return head
        if head.val != head.next.val:
            # 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = self.deleteDuplicates(head.next)
            return head
        # 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
        # 越过重复节点，找到 head 之后那个不重复的节点
        while head.next is not None and head.val == head.next.val:
            head = head.next
        # 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
        return self.deleteDuplicates(head.next)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 推荐的通用解法，运用链表分解的技巧
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 将原链表分解为两条链表
        // 一条链表存放不重复的节点，另一条链表存放重复的节点
        // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
        ListNode dummyUniq = new ListNode(101);
        ListNode dummyDup = new ListNode(101);

        ListNode pUniq = dummyUniq, pDup = dummyDup;
        ListNode p = head;

        while (p != null) {
            if ((p.next != null && p.val == p.next.val) || p.val == pDup.val) {
                // 发现重复节点，接到重复链表后面
                pDup.next = p;
                pDup = pDup.next;
            } else {
                // 不是重复节点，接到不重复链表后面
                pUniq.next = p;
                pUniq = pUniq.next;
            }

            p = p.next;
            // 将原链表和新链表断开
            pUniq.next = null;
            pDup.next = null;
        }

        return dummyUniq.next;
    }
}

// 快慢双指针解法
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;
        while (q != null) {
            if (q.next != null && q.val == q.next.val){
                // 发现重复节点，跳过这些重复节点
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;
                // 此时 q 跳过了这一段重复元素
                if (q == null) {
                    p.next = null;
                }
                // 不过下一段元素也可能重复，等下一轮 while 循环判断
            } else {
                // 不是重复节点，接到 dummy 后面
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}

// 递归解法
class Solution3 {
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = deleteDuplicates(head.next);
            return head;
        }
        // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
        // 越过重复节点，找到 head 之后那个不重复的节点
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
        return deleteDuplicates(head.next);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 推荐的通用解法，运用链表分解的技巧
func deleteDuplicates(head *ListNode) *ListNode {
    // 将原链表分解为两条链表
    // 一条链表存放不重复的节点，另一条链表存放重复的节点
    // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
    dummyUniq := &ListNode{Val: 101}
    dummyDup := &ListNode{Val: 101}

    pUniq, pDup := dummyUniq, dummyDup
    p := head

    for p != nil {
        if (p.Next != nil && p.Val == p.Next.Val) || p.Val == pDup.Val {
            // 发现重复节点，接到重复链表后面
            pDup.Next = p
            pDup = pDup.Next
        } else {
            // 不是重复节点，接到不重复链表后面
            pUniq.Next = p
            pUniq = pUniq.Next
        }

        p = p.Next
        // 将原链表和新链表断开
        pUniq.Next = nil
        pDup.Next = nil
    }

    return dummyUniq.Next
}

// 快慢双指针解法
func deleteDuplicates2(head *ListNode) *ListNode {
    dummy := &ListNode{Val: -1}
    p, q := dummy, head
    for q != nil {
        if q.Next != nil && q.Val == q.Next.Val {
            // 发现重复节点，跳过这些重复节点
            for q.Next != nil && q.Val == q.Next.Val {
                q = q.Next
            }
            q = q.Next
            // 此时 q 跳过了这一段重复元素
            if q == nil {
                p.Next = nil
            }
            // 不过下一段元素也可能重复，等下一轮 while 循环判断
        } else {
            // 不是重复节点，接到 dummy 后面
            p.Next = q
            p = p.Next
            q = q.Next
        }
    }
    return dummy.Next
}

// 递归解法
func deleteDuplicates3(head *ListNode) *ListNode {
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    // base case
    if head == nil || head.Next == nil {
        return head
    }
    if head.Val != head.Next.Val {
        // 如果头结点和身后节点的值不同，则对之后的链表去重即可
        head.Next = deleteDuplicates3(head.Next)
        return head
    }
    // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
    // 越过重复节点，找到 head 之后那个不重复的节点
    for head.Next != nil && head.Val == head.Next.Val {
        head = head.Next
    }
    // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
    return deleteDuplicates3(head.Next)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 推荐的通用解法，运用链表分解的技巧
var deleteDuplicates = function(head) {
    // 将原链表分解为两条链表
    // 一条链表存放不重复的节点，另一条链表存放重复的节点
    // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
    let dummyUniq = new ListNode(101);
    let dummyDup = new ListNode(101);

    let pUniq = dummyUniq, pDup = dummyDup;
    let p = head;

    while (p !== null) {
        if ((p.next !== null && p.val === p.next.val) || p.val === pDup.val) {
            // 发现重复节点，接到重复链表后面
            pDup.next = p;
            pDup = pDup.next;
        } else {
            // 不是重复节点，接到不重复链表后面
            pUniq.next = p;
            pUniq = pUniq.next;
        }

        p = p.next;
        // 将原链表和新链表断开
        pUniq.next = null;
        pDup.next = null;
    }

    return dummyUniq.next;
};

// 快慢双指针解法
var deleteDuplicates2 = function(head) {
    let dummy = new ListNode(-1);
    let p = dummy, q = head;
    while (q !== null) {
        if (q.next !== null && q.val === q.next.val) {
            // 发现重复节点，跳过这些重复节点
            while (q.next !== null && q.val === q.next.val) {
                q = q.next;
            }
            q = q.next;
            // 此时 q 跳过了这一段重复元素
            if (q === null) {
                p.next = null;
            }
            // 不过下一段元素也可能重复，等下一轮 while 循环判断
        } else {
            // 不是重复节点，接到 dummy 后面
            p.next = q;
            p = p.next;
            q = q.next;
        }
    }
    return dummy.next;
};

// 递归解法
var deleteDuplicates3 = function(head) {
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    if (head === null || head.next === null) {
        return head;
    }
    if (head.val !== head.next.val) {
        // 如果头结点和身后节点的值不同，则对之后的链表去重即可
        head.next = deleteDuplicates3(head.next);
        return head;
    }
    // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
    // 越过重复节点，找到 head 之后那个不重复的节点
    while (head.next !== null && head.val === head.next.val) {
        head = head.next;
    }
    // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
    return deleteDuplicates3(head.next);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_remove-duplicates-from-sorted-list-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-list-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

