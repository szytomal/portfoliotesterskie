package Dziedziczenie;

public class Animal {

    String name;
    int numberoflegs;
    int numberofwings;

    public Animal(String name) {
        this.name = name;
    }

    public void fly() {
        System.out.print("Jestem zwierzeciem, ktore potrafi/ nie potrafi latac");
    }

    public void swim() {
        System.out.print("Jestem zwierzeciem, ktore potrafi/nie potrafi plywac");
    }

}