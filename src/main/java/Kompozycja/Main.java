package Kompozycja;

public class Main {


    public static void main(String[] args) {
        Order zamowienie1 = new Order(new Customer("Tomasz", "Nowak"),
                new Product(100, "rzecz", "firma"),
                true,
                true);
        zamowienie1.printPrice();

        Order zamowienie2 = new Order(new Customer("Jan", "Kowalski"),
                new Product(200, "inna rzecz", "inna firma"),
                true,
                true);
        zamowienie2.printPrice();
    }
}
