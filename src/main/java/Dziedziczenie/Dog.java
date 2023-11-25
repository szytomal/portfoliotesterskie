package Dziedziczenie;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        numberoflegs = 2;
        numberofwings = 0;
    }

    public void fly() {
        System.out.print("\n" + name + " nie lata");
    }

    public void swim() {
        System.out.print("\n" + name + " plywa");
    }

}