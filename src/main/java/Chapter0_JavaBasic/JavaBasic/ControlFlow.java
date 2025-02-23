package Chapter0_JavaBasic;

public class ControlFlow {
    public static void main(String[] arg){
        int score = 95;
        if (score>90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
        for (int i = 0; i < 5; i++){
            System.out.println("i = "+ i);
        }
    }
}
