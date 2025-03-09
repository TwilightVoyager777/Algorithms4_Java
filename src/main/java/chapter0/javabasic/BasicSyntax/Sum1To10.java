package chapter0.javabasic.BasicSyntax;

public class Sum1To10 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++){
            sum = sum + i ;
        }
        System.out.println("总和为" + sum);
    }
}
