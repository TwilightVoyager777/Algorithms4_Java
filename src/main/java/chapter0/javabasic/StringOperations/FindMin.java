package chapter0.javabasic.StringOperations;

public class FindMin {
    public static int ReturnInt(int[] arr){
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void main(String[] arg){
        int[] arr = {5 , 3, 4, 6, -9};
        System.out.println("最小值为" + ReturnInt(arr));
    }
}
