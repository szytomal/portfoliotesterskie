package Dziedziczenie;

public class Zoo {

    public static void main(String[] args) {
        Bird ptak = new Bird("Golab");
        ptak.fly();
        ptak.swim();

        Dog pies = new Dog("Bernenczyk");
        pies.fly();
        pies.swim();

        Fish ryba = new Fish("Karp");
        ryba.fly();
        ryba.swim();
    }

}