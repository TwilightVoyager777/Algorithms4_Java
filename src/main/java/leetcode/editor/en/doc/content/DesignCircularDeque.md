<p>Design your implementation of the circular double-ended queue (deque).</p>

<p>Implement the <code>MyCircularDeque</code> class:</p>

<ul> 
 <li><code>MyCircularDeque(int k)</code> Initializes the deque with a maximum size of <code>k</code>.</li> 
 <li><code>boolean insertFront()</code> Adds an item at the front of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li> 
 <li><code>boolean insertLast()</code> Adds an item at the rear of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li> 
 <li><code>boolean deleteFront()</code> Deletes an item from the front of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li> 
 <li><code>boolean deleteLast()</code> Deletes an item from the rear of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li> 
 <li><code>int getFront()</code> Returns the front item from the Deque. Returns <code>-1</code> if the deque is empty.</li> 
 <li><code>int getRear()</code> Returns the last item from Deque. Returns <code>-1</code> if the deque is empty.</li> 
 <li><code>boolean isEmpty()</code> Returns <code>true</code> if the deque is empty, or <code>false</code> otherwise.</li> 
 <li><code>boolean isFull()</code> Returns <code>true</code> if the deque is full, or <code>false</code> otherwise.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
<strong>Output</strong>
[null, true, true, true, false, 2, true, true, true, 4]

<strong>Explanation</strong>
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= 1000</code></li> 
 <li><code>0 &lt;= value &lt;= 1000</code></li> 
 <li>At most <code>2000</code> calls will be made to <code>insertFront</code>, <code>insertLast</code>, <code>deleteFront</code>, <code>deleteLast</code>, <code>getFront</code>, <code>getRear</code>, <code>isEmpty</code>, <code>isFull</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Linked List | Design | Queue</details><br>

<div>👍 1642, 👎 105<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

