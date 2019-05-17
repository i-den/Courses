package shop.books;

public class GoldenEditionBook extends AbstractBook {

    private static final double addedValue = 30;


    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public double getPrice() {
        return (this.getPrice() * ((100 + addedValue) / 100));
    }
}
