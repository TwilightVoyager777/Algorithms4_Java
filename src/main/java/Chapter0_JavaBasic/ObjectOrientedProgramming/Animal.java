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
