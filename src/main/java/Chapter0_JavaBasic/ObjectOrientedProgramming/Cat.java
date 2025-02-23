package Chapter0_JavaBasic.ObjectOrientedProgramming;

public class Cat extends Animal{
    public Cat() { super("Meow"); }

    @Override
    public void makeSound() {
        System.out.println("Cat says: Meow");
    }

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.makeSound();
    }
}
