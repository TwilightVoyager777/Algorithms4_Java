<p>In MATLAB, there is a handy function called <code>reshape</code> which can reshape an <code>m x n</code> matrix into a new one with a different size <code>r x c</code> keeping its original data.</p>

<p>You are given an <code>m x n</code> matrix <code>mat</code> and two integers <code>r</code> and <code>c</code> representing the number of rows and the number of columns of the wanted reshaped matrix.</p>

<p>The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.</p>

<p>If the <code>reshape</code> operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/24/reshape1-grid.jpg" style="width: 613px; height: 173px;" /> 
<pre>
<strong>Input:</strong> mat = [[1,2],[3,4]], r = 1, c = 4
<strong>Output:</strong> [[1,2,3,4]]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/24/reshape2-grid.jpg" style="width: 453px; height: 173px;" /> 
<pre>
<strong>Input:</strong> mat = [[1,2],[3,4]], r = 2, c = 4
<strong>Output:</strong> [[1,2],[3,4]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == mat.length</code></li> 
 <li><code>n == mat[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 100</code></li> 
 <li><code>-1000 &lt;= mat[i][j] &lt;= 1000</code></li> 
 <li><code>1 &lt;= r, c &lt;= 300</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Matrix | Simulation</details><br>

<div>👍 3631, 👎 429<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题不难，但指出了一个必知必会的算法技巧：**多维坐标之间的映射转换**。

我直接说结论：**任何多维数组都可以被映射到一维，所以甭管几维数组，你统一把多维的坐标转化成一维，然后再从一维坐标转化到多维**。

所以这道题，我们先把二维坐标转化成一维，然后再转化成不同 shape 的二维坐标即可。我这里实现了通用的 `get/set` 函数。

**详细题解**：
  - [【练习】二分搜索算法经典习题](https://labuladong.online/algo/problem-set/binary-search/)

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
using namespace std;

class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        int m = mat.size(), n = mat[0].size();
        // 如果想成功 reshape，元素个数应该相同
        if (r * c != m * n) {
            return mat;
        }

        vector<vector<int>> res(r, vector<int>(c));
        for (int i = 0; i < m * n; i++) {
            set(res, i, get(mat, i));
        }
        return res;
    }

    // 通过一维坐标访问二维数组中的元素
    int get(vector<vector<int>>& matrix, int index) {
        int m = matrix.size(), n = matrix[0].size();
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        return matrix[i][j];
    }

    // 通过一维坐标设置二维数组中的元素
    void set(vector<vector<int>>& matrix, int index, int value) {
        int m = matrix.size(), n = matrix[0].size();
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        matrix[i][j] = value;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        # 如果想成功 reshape，元素个数应该相同
        if r * c != m * n:
            return mat

        res = [[0] * c for _ in range(r)]
        for i in range(m * n):
            self.set(res, i, self.get(mat, i))
        return res

    # 通过一维坐标访问二维数组中的元素
    def get(self, matrix: List[List[int]], index: int) -> int:
        m, n = len(matrix), len(matrix[0])
        # 计算二维中的横纵坐标
        i, j = divmod(index, n)
        return matrix[i][j]

    # 通过一维坐标设置二维数组中的元素
    def set(self, matrix: List[List[int]], index: int, value: int) -> None:
        m, n = len(matrix), len(matrix[0])
        # 计算二维中的横纵坐标
        i, j = divmod(index, n)
        matrix[i][j] = value
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        // 如果想成功 reshape，元素个数应该相同
        if (r * c != m * n) {
            return mat;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            set(res, i, get(mat, i));
        }
        return res;
    }

    // 通过一维坐标访问二维数组中的元素
    int get(int[][] matrix, int index) {
        int m = matrix.length, n = matrix[0].length;
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        return matrix[i][j];
    }

    // 通过一维坐标设置二维数组中的元素
    void set(int[][] matrix, int index, int value) {
        int m = matrix.length, n = matrix[0].length;
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        matrix[i][j] = value;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func matrixReshape(mat [][]int, r int, c int) [][]int {
    n := len(mat[0])
    // 如果想成功 reshape，元素个数应该相同
    if r*c != len(mat)*n {
        return mat
    }

    res := make([][]int, r)
    for i := range res {
        res[i] = make([]int, c)
    }
    
    for i := 0; i < len(mat)*n; i++ {
        set(&res, i, get(&mat, i, n))
    }
    return res
}

// 通过一维坐标访问二维数组中的元素
func get(matrix *[][]int, index int, n int) int {
    // 计算二维中的横纵坐标
    i := index / n
    j := index % n
    return (*matrix)[i][j]
}

// 通过一维坐标设置二维数组中的元素
func set(matrix *[][]int, index int, value int) {
    n := len((*matrix)[0])
    // 计算二维中的横纵坐标
    i := index / n
    j := index % n
    (*matrix)[i][j] = value
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var matrixReshape = function(mat, r, c) {
    const m = mat.length, n = mat[0].length;
    // 如果想成功 reshape，元素个数应该相同
    if (r * c !== m * n) {
        return mat;
    }

    const res = new Array(r).fill(0).map(() => new Array(c));
    for (let i = 0; i < m * n; i++) {
        set(res, i, get(mat, i));
    }
    return res;
};

// 通过一维坐标访问二维数组中的元素
function get(matrix, index) {
    const m = matrix.length, n = matrix[0].length;
    // 计算二维中的横纵坐标
    const i = Math.floor(index / n), j = index % n;
    return matrix[i][j];
}

// 通过一维坐标设置二维数组中的元素
function set(matrix, index, value) {
    const m = matrix.length, n = matrix[0].length;
    // 计算二维中的横纵坐标
    const i = Math.floor(index / n), j = index % n;
    matrix[i][j] = value;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_reshape-the-matrix"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reshape-the-matrix"></div></div>
</details><hr /><br />

</div>
</details>
</div>

