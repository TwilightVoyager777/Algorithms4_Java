<p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol> 
 <li>Open brackets must be closed by the same type of brackets.</li> 
 <li>Open brackets must be closed in the correct order.</li> 
 <li>Every close bracket has a corresponding open bracket of the same type.</li> 
</ol>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "()"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "()[]{}"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "(]"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "([])"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "([)]"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Stack</details><br>

<div>👍 26371, 👎 1924<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

栈是一种先进后出的数据结构，处理括号问题的时候尤其有用。

括号的有效性判断在笔试中和现实中都很常见，比如说我们写的代码，编辑器会检查括号是否正确闭合。而且我们的代码可能会包含三种括号 `[](){}`，判断起来有一点难度。

解决这个问题之前，我们先降低难度，思考一下，**如果只有一种括号 `()`**，应该如何判断字符串组成的括号是否有效呢？

假设字符串中只有圆括号，如果想让括号字符串有效，那么必须做到：

**每个右括号 `)` 的左边必须有一个左括号 `(` 和它匹配**。

比如说字符串 `()))((` 中，中间的两个右括号**左边**就没有左括号匹配，所以这个括号组合是无效的。

那么根据这个思路，我们可以写出算法：

```java
boolean isValid(String str) {
    // 待匹配的左括号数量
    int left = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '(') {
            left++;
        } else {
            // 遇到右括号
            left--;
        }

        // 右括号太多
        if (left == -1)
            return false;
    }
    // 是否所有的左括号都被匹配了
    return left == 0;
}
```

如果只有圆括号，这样就能正确判断有效性。对于三种括号的情况，我一开始想模仿这个思路，定义三个变量 `left1`，`left2`，`left3` 分别处理每种括号，虽然要多写不少 if else 分支，但是似乎可以解决问题。

但实际上直接照搬这种思路是不行的，比如说只有一个括号的情况下 `(())` 是有效的，但是多种括号的情况下， `[(])` 显然是无效的。

仅仅记录每种左括号出现的次数已经不能做出正确判断了，我们要加大存储的信息量，可以利用栈来模仿类似的思路。

我们这道题就用一个名为 `left` 的栈代替之前思路中的 `left` 变量，**遇到左括号就入栈，遇到右括号就去栈中寻找最近的左括号，看是否匹配**。

**详细题解**：
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

class Solution {
public:
    bool isValid(string str) {
        stack<char> left;
        for (char c : str) {
            if (c == '(' || c == '{' || c == '[') {
                // 字符 c 是左括号，入栈
                left.push(c);
            } else {
                // 字符 c 是右括号
                if (!left.empty() && leftOf(c) == left.top()) {
                    left.pop();
                } else {
                    // 和最近的左括号不匹配
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }

private:
    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isValid(self, str: str) -> bool:
        left = []
        for c in str:
            if c in '({[':
                # 字符 c 是左括号，入栈
                left.append(c)
            else:
                # 字符 c 是右括号
                if left and self.leftOf(c) == left[-1]:
                    left.pop()
                else:
                    # 和最近的左括号不匹配
                    return False
        # 是否所有的左括号都被匹配了
        return not left

    def leftOf(self, c: str) -> str:
        if c == '}':
            return '{'
        if c == ')':
            return '('
        return '['
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isValid(String str) {
        Stack<Character> left = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // 字符 c 是左括号，入栈
                left.push(c);
            } else {
                // 字符 c 是右括号
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    // 和最近的左括号不匹配
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return left.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isValid(str string) bool {
    left := []rune{}
    for _, c := range str {
        if c == '(' || c == '{' || c == '[' {
            // 字符 c 是左括号，入栈
            left = append(left, c)
        } else {
            // 字符 c 是右括号
            if len(left) > 0 && leftOf(c) == left[len(left)-1] {
                left = left[:len(left)-1]
            } else {
                // 和最近的左括号不匹配
                return false
            }
        }
    }
    // 是否所有的左括号都被匹配了
    return len(left) == 0
}

func leftOf(c rune) rune {
    if c == '}' {
        return '{'
    }
    if c == ')' {
        return '('
    }
    return '['
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isValid = function(str) {
    let left = [];
    for (let c of str) {
        if (c === '(' || c === '{' || c === '[') {
            // 字符 c 是左括号，入栈
            left.push(c);
        } else {
            // 字符 c 是右括号
            if (left.length !== 0 && leftOf(c) === left[left.length - 1]) {
                left.pop();
            } else {
                // 和最近的左括号不匹配
                return false;
            }
        }
    }
    // 是否所有的左括号都被匹配了
    return left.length === 0;
};

var leftOf = function(c) {
    if (c === '}') return '{';
    if (c === ')') return '(';
    return '[';
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_valid-parentheses"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_valid-parentheses"></div></div>
</details><hr /><br />

</div>
</details>
</div>

