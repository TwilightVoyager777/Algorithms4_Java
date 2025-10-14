<p>One way to serialize a binary tree is to use <strong>preorder traversal</strong>. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as <code>'#'</code>.</p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/pre-tree.jpg" style="width: 362px; height: 293px;" /> 
<p>For example, the above binary tree can be serialized to the string <code>"9,3,4,#,#,1,#,#,2,#,6,#,#"</code>, where <code>'#'</code> represents a null node.</p>

<p>Given a string of comma-separated values <code>preorder</code>, return <code>true</code> if it is a correct preorder traversal serialization of a binary tree.</p>

<p>It is <strong>guaranteed</strong> that each comma-separated value in the string must be either an integer or a character <code>'#'</code> representing null pointer.</p>

<p>You may assume that the input format is always valid.</p>

<ul> 
 <li>For example, it could never contain two consecutive commas, such as <code>"1,,3"</code>.</li> 
</ul>

<p><strong>Note:&nbsp;</strong>You are not allowed to reconstruct the tree.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
<strong>Output:</strong> true
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> preorder = "1,#"
<strong>Output:</strong> false
</pre>
<p><strong class="example">Example 3:</strong></p> 
<pre><strong>Input:</strong> preorder = "9,#,#,1"
<strong>Output:</strong> false
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= preorder.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>preorder</code> consist of integers in the range <code>[0, 100]</code> and <code>'#'</code> separated by commas <code>','</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Stack | Tree | Binary Tree</details><br>

<div>👍 2423, 👎 129<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

首先，如果看过前文 [手把手带你刷二叉树（序列化篇）](https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/) 理解了前序遍历序列化和反序列化的原理，肯定可以通过改造反序列化函数 `deserialize` 来判断序列化的合法性。

另外还有一种更巧妙的解法，就是利用二叉树节点和边的关系。

每个非空的二叉树节点都会产生两条边，并消耗一条边；而每个空节点只会消耗一条边：

![](https://labuladong.online/algo/images/brief-extra/331.jpeg)

**详细题解**：
  - [【练习】用「分解问题」思维解题 I](https://labuladong.online/algo/problem-set/binary-tree-divide-i/)

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
    bool isValidSerialization(string preorder) {
        // 一条指向根节点的虚拟边
        int edge = 1;
        stringstream ss(preorder);
        string node;
        while (getline(ss, node, ',')) {
            // 任何时候，边数都不能小于 0
            if (node == "#") {
                // 空指针消耗一条空闲边
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
            } else {
                // 非空节点消耗一条空闲边，增加两条空闲边
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
                edge += 2;
            }
        }
        // 最后不应该存在空闲边
        return edge == 0;
    }
};

class Solution2 {
public:
    bool isValidSerialization(string preorder) {
        // 将字符串转化成列表
        list<string> nodes;
        stringstream ss(preorder);
        string s;
        while (getline(ss, s, ',')) {
            nodes.push_back(s);
        }
        return deserialize(nodes) && nodes.empty();
    }

    // 改造后的前序遍历反序列化函数
    // 详细解析：https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/
    bool deserialize(list<string>& nodes) {
        if (nodes.empty()) {
            return false;
        }

        // ***** 前序遍历位置 *****
        // 列表最左侧就是根节点
        string first = nodes.front();
        nodes.pop_front();
        if (first == "#") return true;
        // *********************

        return deserialize(nodes) && deserialize(nodes);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        # 一条指向根节点的虚拟边
        edge = 1
        for node in preorder.split(","):
            # 任何时候，边数都不能小于 0
            if node == "#":
                # 空指针消耗一条空闲边
                edge -= 1
                if edge < 0:
                    return False
            else:
                # 非空节点消耗一条空闲边，增加两条空闲边
                edge -= 1
                if edge < 0:
                    return False
                edge += 2
        # 最后不应该存在空闲边
        return edge == 0


class Solution2:
    def isValidSerialization(self, preorder: str) -> bool:
        # 将字符串转化成列表
        nodes = list(preorder.split(","))
        return self.deserialize(nodes) and len(nodes) == 0

    # 改造后的前序遍历反序列化函数
    # 详细解析：https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/
    def deserialize(self, nodes) -> bool:
        if not nodes:
            return False

        # ***** 前序遍历位置 *****
        # 列表最左侧就是根节点
        first = nodes.pop(0)
        if first == "#":
            return True
        # *********************

        return self.deserialize(nodes) and self.deserialize(nodes)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isValidSerialization(String preorder) {
        // 一条指向根节点的虚拟边
        int edge = 1;
        for (String node : preorder.split(",")) {
            // 任何时候，边数都不能小于 0
            if (node.equals("#")) {
                // 空指针消耗一条空闲边
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
            } else {
                // 非空节点消耗一条空闲边，增加两条空闲边
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
                edge += 2;
            }
        }
        // 最后不应该存在空闲边
        return edge == 0;
    }
}

class Solution2 {
    public boolean isValidSerialization(String preorder) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : preorder.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes) && nodes.isEmpty();
    }

    // 改造后的前序遍历反序列化函数
    // 详细解析：https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/
    boolean deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return false;
        }

        // ***** 前序遍历位置 *****
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals("#")) return true;
        // *********************

        return deserialize(nodes) && deserialize(nodes);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import "strings"

func isValidSerialization(preorder string) bool {
    // 一条指向根节点的虚拟边
    edge := 1
    for _, node := range strings.Split(preorder, ",") {
        // 任何时候，边数都不能小于 0
        if node == "#" {
            // 空指针消耗一条空闲边
            edge -= 1
            if edge < 0 {
                return false
            }
        } else {
            // 非空节点消耗一条空闲边，增加两条空闲边
            edge -= 1
            if edge < 0 {
                return false
            }
            edge += 2
        }
    }
    // 最后不应该存在空闲边
    return edge == 0
}

type Solution2 struct{}

func (s *Solution2) isValidSerialization(preorder string) bool {
    // 将字符串转化成列表
    nodes := strings.Split(preorder, ",")
    return s.deserialize(&nodes) && len(nodes) == 0
}

// 改造后的前序遍历反序列化函数
// 详细解析：https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/
func (s *Solution2) deserialize(nodes *[]string) bool {
    if len(*nodes) == 0 {
        return false
    }

    // ***** 前序遍历位置 *****
    // 列表最左侧就是根节点
    first := (*nodes)[0]
    *nodes = (*nodes)[1:]
    if first == "#" {
        return true
    }
    // *********************

    return s.deserialize(nodes) && s.deserialize(nodes)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isValidSerialization = function(preorder) {
    // 一条指向根节点的虚拟边
    let edge = 1;
    const nodes = preorder.split(",");
    for (let node of nodes) {
        // 任何时候，边数都不能小于 0
        if (node === "#") {
            // 空指针消耗一条空闲边
            edge -= 1;
            if (edge < 0) {
                return false;
            }
        } else {
            // 非空节点消耗一条空闲边，增加两条空闲边
            edge -= 1;
            if (edge < 0) {
                return false;
            }
            edge += 2;
        }
    }
    // 最后不应该存在空闲边
    return edge === 0;
};

var isValidSerialization2 = function(preorder) {
    // 将字符串转化成列表
    const nodes = preorder.split(",").values();
    return deserialize(nodes) && nodes.next().done;
};

// 改造后的前序遍历反序列化函数
// 详细解析：https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/
function deserialize(nodes) {
    if (nodes.next().done) {
        return false;
    }

    // ***** 前序遍历位置 *****
    // 列表最左侧就是根节点
    let first = nodes.next().value;
    if (first === "#") return true;
    // *********************

    return deserialize(nodes) && deserialize(nodes);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_verify-preorder-serialization-of-a-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_verify-preorder-serialization-of-a-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

