package chapter0.javabasic.Generics;


import java.util.Arrays;

public class GenericsDemo {
    class Box<T> {
        private T content;
        public void setContent(T content) {
            this.content = content;
        }
        public T getContent() {
            return content;
        }
    }
    public class Utils {
        public static <T> void swap(T[] array, int i, int j) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    public void main(String[] args){
        Box<Integer> intBox = new Box<>();
        intBox.setContent(100);
        System.out.println(intBox.getContent());
        String[] words = {"Java", "Python", "C++"};
        Utils.swap(words, 0 ,2);
        System.out.println(Arrays.toString(words));
        Box rawBox = new Box();
        rawBox.setContent("Oops");
    }
}
