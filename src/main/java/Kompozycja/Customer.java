package Kompozycja;

public class Customer {


    private final int clientID;
    private static int clientNumber = 1;
    private String name;
    private String surname;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        clientID = clientNumber;
        clientNumber++;
        System.out.print("\n" + name + " " + surname + " " + clientID);
    }
}
