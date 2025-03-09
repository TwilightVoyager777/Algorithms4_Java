package chapter0.javabasic.OOP;

interface Swimmable {
    void swim();
}

//父类
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

//子类1
class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("Dog is eating bones!");
    }
}

class Duck extends Animal implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Duck is swimming!");
    }
}

class Bird extends Animal implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Bird is swimming in the sky!");
    }
    @Override
    void eat() {
        System.out.println("Bird is eating seeds!");
    }
}

class Car {
    String brand;
    void startEngine() {
        System.out.println("Engine starting...");
    }
}

class ElectricCar extends Car {
    @Override
    void startEngine(){
        System.out.println("Electric car engine started silently");
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.eat();
        Duck duck = new Duck();
        duck.swim();
        Bird bird = new Bird();
        bird.eat();
        bird.swim();
        Car car = new Car();
        car.startEngine();
        ElectricCar car2 = new ElectricCar();
        car2.startEngine();
    }
}
