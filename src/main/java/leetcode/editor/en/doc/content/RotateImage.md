<p>You are given an <code>n x n</code> 2D <code>matrix</code> representing an image, rotate the image by <strong>90</strong> degrees (clockwise).</p>

<p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="width: 500px; height: 188px;" /> 
<pre>
<strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [[7,4,1],[8,5,2],[9,6,3]]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="width: 500px; height: 201px;" /> 
<pre>
<strong>Input:</strong> matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
<strong>Output:</strong> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == matrix.length == matrix[i].length</code></li> 
 <li><code>1 &lt;= n &lt;= 20</code></li> 
 <li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Math | Matrix</details><br>

<div>👍 18927, 👎 911<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题看起来复杂，但只要掌握了规律就很简单。

先把二维矩阵沿对角线反转，然后反转矩阵的每一行，结果就是顺时针反转整个矩阵。

**详细题解**：
  - [二维数组的花式遍历技巧](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/)

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
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (auto& row : matrix) {
            ::reverse(row.begin(), row.end());
        }
    }

    // 反转一维数组
    void reverse(vector<int>& arr) {
        int i = 0, j = arr.size() - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def rotate(self, matrix):
        n = len(matrix)
        # 先沿对角线反转二维矩阵
        for i in range(n):
            for j in range(i, n):
                # swap(matrix[i][j], matrix[j][i])
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # 然后反转二维矩阵的每一行
        for row in matrix:
            self.reverse(row)

    # 反转一维数组
    def reverse(self, arr):
        i, j = 0, len(arr) - 1
        while j > i:
            # swap(arr[i], arr[j])
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func rotate(matrix [][]int) {
    n := len(matrix)
    // 先沿对角线反转二维矩阵
    for i := 0; i < n; i++ {
        for j := i; j < n; j++ {
            // swap(matrix[i][j], matrix[j][i]);
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        }
    }
    // 然后反转二维矩阵的每一行
    for i := range matrix {
        reverse(matrix[i])
    }
}

// 反转一维数组
func reverse(arr []int) {
    i, j := 0, len(arr)-1
    for j > i {
        // swap(arr[i], arr[j]);
        arr[i], arr[j] = arr[j], arr[i]
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var rotate = function(matrix) {
    let n = matrix.length;
    // 先沿对角线反转二维矩阵
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            // swap(matrix[i][j], matrix[j][i]);
            let temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    // 然后反转二维矩阵的每一行
    for (let row of matrix) {
        reverse(row);
    }

    // 反转一维数组
    function reverse(arr) {
        let i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            let temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_rotate-image"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_rotate-image"></div></div>
</details><hr /><br />

</div>
</details>
</div>

