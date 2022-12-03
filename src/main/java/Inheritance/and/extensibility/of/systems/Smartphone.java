package Inheritance.and.extensibility.of.systems;

public class Smartphone extends Product {
    protected String manufacturer;


    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);
        this.manufacturer = manufacturer;
    }
}
