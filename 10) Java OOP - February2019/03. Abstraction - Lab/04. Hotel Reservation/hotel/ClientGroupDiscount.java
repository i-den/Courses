package hotel;

public enum ClientGroupDiscount {

    Normal(0),
    SecondVisit(10),
    VIP(20);

    private int discountPercentage;

    ClientGroupDiscount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
