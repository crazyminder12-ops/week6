package model;

public class PackagedProduct extends Product implements Discountable {

    private double weight;

    public PackagedProduct(String name, double price, double weight) {
        super(name, price);
        setWeight(weight);
    }

    @Override
    public String getType() {
        return "Packaged Product";
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    @Override
    public double getDiscountedPrice() {
        return price * 0.9;
    }
}
