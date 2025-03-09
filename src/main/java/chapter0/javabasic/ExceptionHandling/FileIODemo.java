package chapter0.javabasic.ExceptionHandling;

import java.io.*;

public class FileIODemo {
    public static void main(String[] args) {
        try {
            //写文件
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hello, Java!");
            writer.close();

            //读文件
            FileReader reader = new FileReader("output.txt");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
