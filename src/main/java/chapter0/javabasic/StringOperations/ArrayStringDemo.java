package chapter0.javabasic.StringOperations;

public class ArrayStringDemo {
    public static void main(String[] args) {
        //数组遍历
        int[] numbers = {3, 7, 2, 9, 5};
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("最大值为" + max);
        String text = "Hello, Java!";
        String[] parts = text.split(",");
        System.out.println(parts[0]);
        StringBuilder sb = new StringBuilder("Algorithm");
        System.out.println(sb.reverse());
    }
}
