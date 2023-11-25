package Kompozycja;

public class Order {


    private Customer customer;
    private Product product;
    private boolean payed;
    private boolean delivered;
    private double orderValue;

    public Order(Customer customer, Product product, boolean payed, boolean delivered) {
        this.customer = customer;
        this.product = product;
        this.payed = payed;
        this.delivered = delivered;
        this.orderValue = calculateOrderValue();
    }

    public double calculateOrderValue() {
        return product.getPrice();
    }

    public void printPrice() {
        System.out.print("\n" + "cena to " + orderValue);
    }
}
