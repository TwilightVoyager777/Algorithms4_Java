<p>You have a <code>RecentCounter</code> class which counts the number of recent requests within a certain time frame.</p>

<p>Implement the <code>RecentCounter</code> class:</p>

<ul> 
 <li><code>RecentCounter()</code> Initializes the counter with zero recent requests.</li> 
 <li><code>int ping(int t)</code> Adds a new request at time <code>t</code>, where <code>t</code> represents some time in milliseconds, and returns the number of requests that has happened in the past <code>3000</code> milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range <code>[t - 3000, t]</code>.</li> 
</ul>

<p>It is <strong>guaranteed</strong> that every call to <code>ping</code> uses a strictly larger value of <code>t</code> than the previous call.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
<strong>Output</strong>
[null, 1, 2, 3, 3]

<strong>Explanation</strong>
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [<u>1</u>], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [<u>1</u>, <u>100</u>], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [<u>1</u>, <u>100</u>, <u>3001</u>], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, <u>100</u>, <u>3001</u>, <u>3002</u>], range is [2,3002], return 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= t &lt;= 10<sup>9</sup></code></li> 
 <li>Each test case will call <code>ping</code> with <strong>strictly increasing</strong> values of <code>t</code>.</li> 
 <li>At most <code>10<sup>4</sup></code> calls will be made to <code>ping</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Design | Queue | Data Stream</details><br>

<div>👍 753, 👎 1124<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

