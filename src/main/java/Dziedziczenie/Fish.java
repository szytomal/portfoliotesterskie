package Dziedziczenie;

class Fish extends Animal {

    public Fish(String name) {
        super(name);
        numberoflegs = 0;
        numberofwings = 0;
    }

    public void fly() {
        System.out.print("\n" + name + " nie lata");
    }

    public void swim() {
        System.out.print("\n" + name + " plywa");
    }

}