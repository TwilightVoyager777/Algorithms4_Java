package Exercise0;

import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExercise {
    public static void main(String[] args) {
        // 初始化一个大小为5的ArrayList，所有元素初始值为100
        int n = 5;
        ArrayList<Integer> nums = new ArrayList<>(Collections.nCopies(n,100));
        // 检查ArrayList是否为空并输出结果
        System.out.println(nums.isEmpty());
        // 输出ArrayList的当前大小
        System.out.println(nums.size());
        // 在ArrayList的末尾添加一个元素50
        System.out.println(nums.add(50));
        // 输出ArrayList的新大小
        System.out.println(nums.size());
        // 获取并输出ArrayList的最后一个元素
        System.out.println(nums.get(nums.size() - 1));
        // 删除ArrayList的最后一个元素
        System.out.println(nums.remove(nums.size() - 1));
        // 再次输出ArrayList的大小
        System.out.println(nums.size());
        // 将索引1处的元素值改为200
        nums.set(1, 200);
        // 在索引2处插入一个元素75
        nums.add(2,75);
        // 删除索引3处的元素
        nums.remove(3);
        // 交换索引0和索引1处的元素
        Collections.swap(nums, 0 , 1);
        // 遍历并输出ArrayList中的所有元素
        for(int num : nums) {
            System.out.println(num);
        }
    }
}