package Chapter0_JavaBasic.ObjectOrientedProgramming;

public class Person {
    String name; //属性
    int age;
    String gender;

    public Person(String name, int age, String gender) { //构造方法
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void introduce() { //方法
        System.out.println("I'm " + name + ", " + age + " years old " + gender + ".");
    }
    public static void main (String[] arg) {
        Person alice = new Person("Alice", 25, "girl"); //创建对象
        alice.introduce(); //调用方法
    }
}
