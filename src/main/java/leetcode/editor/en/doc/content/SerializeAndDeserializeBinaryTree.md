<p>Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.</p>

<p>Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.</p>

<p><strong>Clarification:</strong> The input/output format is the same as <a href="https://support.leetcode.com/hc/en-us/articles/32442719377939-How-to-create-test-cases-on-LeetCode#h_01J5EGREAW3NAEJ14XC07GRW1A" target="_blank">how LeetCode serializes a binary tree</a>. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,null,null,4,5]
<strong>Output:</strong> [1,2,3,null,null,4,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Tree | Depth-First Search | Breadth-First Search | Design | Binary Tree</details><br>

<div>👍 10864, 👎 422<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

序列化问题其实就是遍历问题，你能遍历，顺手把遍历的结果转化成字符串的形式，不就是序列化了么？

这里我就简单说说用前序遍历的思路，前序遍历的特点是根节点在开头，然后接着左子树的前序遍历结果，然后接着右子树的前序遍历结果：

![](https://labuladong.online/algo/images/binary-tree-serialization/1.jpeg)

所以如果按照前序遍历顺序进行序列化，反序列化的时候，就知道第一个元素是根节点的值，然后递归调用反序列化左右子树，接到根节点上即可，上述思路翻译成代码即可解决本题。

当然，这题也可以尝试使用二叉树的中序、后序、层序的遍历方式来做，具体可看详细题解。

**详细题解**：
  - [二叉树心法（序列化篇）](https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/)

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

class Codec {
    string SEP;
    string NULL_NODE;

public:
    Codec() : SEP(","), NULL_NODE("#") {}

    // 主函数，将二叉树序列化为字符串
    string serialize(TreeNode* root) {
        stringstream ss;
        serialize(root, ss);
        return ss.str();
    }

    // 辅助函数，将二叉树存入 StringBuilder
    void serialize(TreeNode* root, stringstream& ss) {
        if (root == nullptr) {
            ss << NULL_NODE << SEP;
            return;
        }

        // *****前序遍历位置*****
        ss << root->val << SEP;
        // *********************

        serialize(root->left, ss);
        serialize(root->right, ss);
    }

    // 主函数，将字符串反序列化为二叉树结构
    TreeNode* deserialize(string data) {
        // 将字符串转化成列表
        list<string> nodes;
        stringstream ss(data);
        string item;
        while (getline(ss, item, ',')) {
            nodes.push_back(item);
        }
        return deserialize(nodes);
    }

    // 辅助函数，通过 nodes 列表构造二叉树
    TreeNode* deserialize(list<string>& nodes) {
        if (nodes.empty()) return nullptr;

        // *****前序遍历位置*****
        // 列表最左侧就是根节点
        string first = nodes.front();
        nodes.pop_front();
        if (first == NULL_NODE) return nullptr;
        TreeNode* root = new TreeNode(stoi(first));
        // *********************

        root->left = deserialize(nodes);
        root->right = deserialize(nodes);

        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Codec:
    SEP = ","
    NULL = "#"

    # 主函数，将二叉树序列化为字符串
    def serialize(self, root: TreeNode) -> str:
        sb = []
        self._serialize(root, sb)
        return ''.join(sb)

    # 辅助函数，将二叉树存入 StringBuilder
    def _serialize(self, root: TreeNode, sb: list):
        if root is None:
            sb.append(self.NULL + self.SEP)
            return

        # *****前序遍历位置*****
        sb.append(str(root.val) + self.SEP)
        # *********************

        self._serialize(root.left, sb)
        self._serialize(root.right, sb)

    # 主函数，将字符串反序列化为二叉树结构
    def deserialize(self, data: str) -> TreeNode:
        # 将字符串转化成列表
        nodes = data.split(self.SEP)
        nodes = deque(nodes)  # 使用 deque 以便高效地从左侧弹出元素
        return self._deserialize(nodes)

    # 辅助函数，通过 nodes 列表构造二叉树
    def _deserialize(self, nodes: deque) -> TreeNode:
        if not nodes:
            return None

        # *****前序遍历位置*****
        # 列表最左侧就是根节点
        first = nodes.popleft()
        if first == self.NULL:
            return None
        root = TreeNode(int(first))
        # *********************

        root.left = self._deserialize(nodes)
        root.right = self._deserialize(nodes)

        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Codec {
    String SEP = ",";
    String NULL = "#";

    // 主函数，将二叉树序列化为字符串
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // 辅助函数，将二叉树存入 StringBuilder
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // *****前序遍历位置*****
        sb.append(root.val).append(SEP);
        // *********************

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // 主函数，将字符串反序列化为二叉树结构
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    // 辅助函数，通过 nodes 列表构造二叉树
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        // *****前序遍历位置*****
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        // *********************

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type Codec struct {
    SEP  string
    NULL string
}

func Constructor() Codec {
    return Codec{
        SEP:  ",",
        NULL: "#",
    }
}

// 主函数，将二叉树序列化为字符串
func (c *Codec) serialize(root *TreeNode) string {
    var sb strings.Builder
    c.serializeHelper(root, &sb)
    return sb.String()
}

// 辅助函数，将二叉树存入 StringBuilder
func (c *Codec) serializeHelper(root *TreeNode, sb *strings.Builder) {
    if root == nil {
        sb.WriteString(c.NULL)
        sb.WriteString(c.SEP)
        return
    }

    // *****前序遍历位置*****
    sb.WriteString(strconv.Itoa(root.Val))
    sb.WriteString(c.SEP)
    // *********************

    c.serializeHelper(root.Left, sb)
    c.serializeHelper(root.Right, sb)
}

// 主函数，将字符串反序列化为二叉树结构
func (c *Codec) deserialize(data string) *TreeNode {
    // 将字符串转化成列表
    nodes := strings.Split(data, c.SEP)
    nodeList := list.New()
    for _, s := range nodes {
        nodeList.PushBack(s)
    }
    return c.deserializeHelper(nodeList)
}

// 辅助函数，通过 nodes 列表构造二叉树
func (c *Codec) deserializeHelper(nodes *list.List) *TreeNode {
    if nodes.Len() == 0 {
        return nil
    }

    // *****前序遍历位置*****
    // 列表最左侧就是根节点
    first := nodes.Remove(nodes.Front()).(string)
    if first == c.NULL {
        return nil
    }
    val, _ := strconv.Atoi(first)
    root := &TreeNode{Val: val}
    // *********************

    root.Left = c.deserializeHelper(nodes)
    root.Right = c.deserializeHelper(nodes)

    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var Codec = function() {
    const SEP = ",";
    const NULL = "#";

    // 主函数，将二叉树序列化为字符串
    this.serialize = function(root) {
        let sb = [];
        serializeHelper(root, sb);
        return sb.join(SEP);
    };

    // 辅助函数，将二叉树存入 StringBuilder
    const serializeHelper = function(root, sb) {
        if (root === null) {
            sb.push(NULL);
            return;
        }

        // *****前序遍历位置*****
        sb.push(root.val);
        // *********************

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    };

    // 主函数，将字符串反序列化为二叉树结构
    this.deserialize = function(data) {
        // 将字符串转化成列表
        let nodes = data.split(SEP);
        return deserializeHelper(nodes);
    };

    // 辅助函数，通过 nodes 列表构造二叉树
    const deserializeHelper = function(nodes) {
        if (nodes.length === 0) return null;

        // *****前序遍历位置*****
        // 列表最左侧就是根节点
        let first = nodes.shift();
        if (first === NULL) return null;
        let root = new TreeNode(parseInt(first));
        // *********************

        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);

        return root;
    };
};

// Helper function to create a new TreeNode
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

// Export the Codec class to be used in LeetCode
var deserialize = function(data) {
    const codec = new Codec();
    return codec.deserialize(data);
};

var serialize = function(root) {
    const codec = new Codec();
    return codec.serialize(root);
};

module.exports = { serialize, deserialize };
```

</div></div>
</div></div>

</div>
</details>
</div>

