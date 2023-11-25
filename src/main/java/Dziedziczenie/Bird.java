package Dziedziczenie;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
        numberoflegs = 2;
        numberofwings = 2;
    }

    public void fly() {
        System.out.print("\n" + name + " lata");
    }

    public void swim() {
        System.out.print("\n" + name + " nie plywa");
    }

}