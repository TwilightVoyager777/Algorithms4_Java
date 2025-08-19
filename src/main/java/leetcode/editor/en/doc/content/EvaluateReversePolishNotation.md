<p>You are given an array of strings <code>tokens</code> that represents an arithmetic expression in a <a href="http://en.wikipedia.org/wiki/Reverse_Polish_notation" target="_blank">Reverse Polish Notation</a>.</p>

<p>Evaluate the expression. Return <em>an integer that represents the value of the expression</em>.</p>

<p><strong>Note</strong> that:</p>

<ul> 
 <li>The valid operators are <code>'+'</code>, <code>'-'</code>, <code>'*'</code>, and <code>'/'</code>.</li> 
 <li>Each operand may be an integer or another expression.</li> 
 <li>The division between two integers always <strong>truncates toward zero</strong>.</li> 
 <li>There will not be any division by zero.</li> 
 <li>The input represents a valid arithmetic expression in a reverse polish notation.</li> 
 <li>The answer and all the intermediate calculations can be represented in a <strong>32-bit</strong> integer.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> tokens = ["2","1","+","3","*"]
<strong>Output:</strong> 9
<strong>Explanation:</strong> ((2 + 1) * 3) = 9
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> tokens = ["4","13","5","/","+"]
<strong>Output:</strong> 6
<strong>Explanation:</strong> (4 + (13 / 5)) = 6
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
<strong>Output:</strong> 22
<strong>Explanation:</strong> ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= tokens.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>tokens[i]</code> is either an operator: <code>"+"</code>, <code>"-"</code>, <code>"*"</code>, or <code>"/"</code>, or an integer in the range <code>[-200, 200]</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Math | Stack</details><br>

<div>👍 8267, 👎 1155<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

逆波兰表达式发明出来就是为了方便计算机运用「栈」进行表达式运算的，其运算规则如下：

按顺序遍历逆波兰表达式中的字符，如果是数字，则放入栈；如果是运算符，则将栈顶的两个元素拿出来进行运算，再将结果放入栈。对于减法和除法，运算顺序别搞反了，栈顶第二个数是被除（减）数。

所以这题很简单，直接按照运算规则借助栈计算表达式结果即可。

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

#include <vector>
#include <string>
#include <stack>

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        std::stack<int> stk;
        for (const std::string& token : tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                // 是个运算符，从栈顶拿出两个数字进行运算，运算结果入栈
                int a = stk.top(); stk.pop();
                int b = stk.top(); stk.pop();
                if (token == "+") stk.push(b + a);
                else if (token == "*") stk.push(b * a);
                else if (token == "-") {
                    // 对于减法和除法，顺序别搞反了，第二个数是被除（减）数
                    stk.push(b - a);
                }
                else if (token == "/") stk.push(b / a);
            } else {
                // 是个数字，直接入栈即可
                stk.push(std::stoi(token));
            }
        }
        // 最后栈中剩下一个数字，即是计算结果
        return stk.top();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stk = []
        for token in tokens:
            if token in "+-*/":
                # 是个运算符，从栈顶拿出两个数字进行运算，运算结果入栈
                a = stk.pop()
                b = stk.pop()
                if token == "+":
                    stk.append(a + b)
                elif token == "*":
                    stk.append(a * b)
                # 对于减法和除法，顺序别搞反了，第二个数是被除（减）数
                elif token == "-":
                    stk.append(b - a)
                elif token == "/":
                    stk.append(int(b / a))  # Ensure the result is an integer
            else:
                # 是个数字，直接入栈即可
                stk.append(int(token))
        # 最后栈中剩下一个数字，即是计算结果
        return stk.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                // 是个运算符，从栈顶拿出两个数字进行运算，运算结果入栈
                int a = stk.pop(), b = stk.pop();
                switch (token) {
                    case "+":
                        stk.push(a + b);
                        break;
                    case "*":
                        stk.push(a * b);
                        break;
                    // 对于减法和除法，顺序别搞反了，第二个数是被除（减）数
                    case "-":
                        stk.push(b - a);
                        break;
                    case "/":
                        stk.push(b / a);
                        break;
                }
            } else {
                // 是个数字，直接入栈即可
                stk.push(Integer.parseInt(token));
            }
        }
        // 最后栈中剩下一个数字，即是计算结果
        return stk.pop();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func evalRPN(tokens []string) int {
    stk := []int{}
    for _, token := range tokens {
        if strings.Contains("+-*/", token) {
            // 是个运算符，从栈顶拿出两个数字进行运算，运算结果入栈
            a, b := stk[len(stk)-1], stk[len(stk)-2]
            stk = stk[:len(stk)-2]
            switch token {
                case "+":
                    stk = append(stk, b + a)
                case "*":
                    stk = append(stk, b * a)
                // 对于减法和除法，顺序别搞反了，第二个数是被除（减）数
                case "-":
                    stk = append(stk, b - a)
                case "/":
                    stk = append(stk, b / a)
            }
        } else {
            // 是个数字，直接入栈即可
            num, _ := strconv.Atoi(token)
            stk = append(stk, num)
        }
    }
    // 最后栈中剩下一个数字，即是计算结果
    return stk[0]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var evalRPN = function(tokens) {
    let stk = [];
    for (let token of tokens) {
        if ("+-*/".includes(token)) {
            // 是个运算符，从栈顶拿出两个数字进行运算，运算结果入栈
            let a = stk.pop(), b = stk.pop();
            switch (token) {
                case "+":
                    stk.push(b + a);
                    break;
                case "*":
                    stk.push(b * a);
                    break;
                // 对于减法和除法，顺序别搞反了，第二个数是被除（减）数
                case "-":
                    stk.push(b - a);
                    break;
                case "/":
                    stk.push(Math.trunc(b / a));
                    break;
            }
        } else {
            // 是个数字，直接入栈即可
            stk.push(parseInt(token));
        }
    }
    // 最后栈中剩下一个数字，即是计算结果
    return stk.pop();
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_evaluate-reverse-polish-notation"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_evaluate-reverse-polish-notation"></div></div>
</details><hr /><br />

</div>
</details>
</div>

