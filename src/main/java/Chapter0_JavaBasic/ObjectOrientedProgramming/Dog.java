package Chapter0_JavaBasic.ObjectOrientedProgramming;

//基类
abstract class Animal {
    private String sound;

    public Animal(String sound) {
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(sound);
    }
}

//子类
public class Dog extends Animal {
    public Dog() {
        super("Woof");
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof");
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}

