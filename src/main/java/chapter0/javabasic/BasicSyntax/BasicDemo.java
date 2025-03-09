package chapter0.javabasic.BasicSyntax;

public class BasicDemo {
    public static void main(String[] args) {
        //变量与运算符
        int num1 = 10;
        double num2 = 5.5;
        boolean isEven = (num1 % 2 == 0);
        if (isEven) {
            System.out.println(num1 + "是偶数");
        } else {
            System.out.println(num1 + "是奇数");
        }
        //循环
        for (int i = 0; i < 3; i++) {
            System.out.println("循环次数" + i);
        }
    }
}
