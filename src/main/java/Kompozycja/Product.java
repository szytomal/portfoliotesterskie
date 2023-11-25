package Kompozycja;


public class Product {


    private double price;
    private final String productName;
    private final String productManufacturer;


    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cena musi być wyższa niż 0");
        } else this.price = price;
    }

    public Product(double price, String productName, String productManufacturer) {
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        setPrice(price);
        System.out.print("\n" + productName + " " + productManufacturer);
    }

    double getPrice() {
        return price;
    }
}
