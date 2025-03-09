package chapter0.javabasic.BasicSyntax;

public class CheckPositive {
    public static void main(String[] args) {
        int num = 10;
        if (num > 0) {
            System.out.println("是正数");
        } else if (num < 0) {
            System.out.println("不是正数");
        }
    }
}
