package chapter0.javabasic.StringOperations;

public class PalindromeCheck {
    public static boolean isPalinerome(String str){
        String lowerStr = str.toLowerCase();
        StringBuilder sb = new StringBuilder(lowerStr);
        return sb.reverse().toString().equals(lowerStr);
    }
    public static void main(String[] args) {
        String input = "Racecar";
        System.out.println(isPalinerome(input));
    }
}
