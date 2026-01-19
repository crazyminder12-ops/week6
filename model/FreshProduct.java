package model;

public class FreshProduct extends Product implements Discountable {

    private int daysToExpire;

    public FreshProduct(String name, double price, int daysToExpire) {
        super(name, price);
        setDaysToExpire(daysToExpire);
    }

    @Override
    public String getType() {
        return "Fresh Product";
    }

    public void setDaysToExpire(int daysToExpire) {
        if (daysToExpire < 0) {
            throw new IllegalArgumentException("Days to expire cannot be negative");
        }
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double getDiscountedPrice() {
        return daysToExpire <= 2 ? price * 0.8 : price;
    }
}
