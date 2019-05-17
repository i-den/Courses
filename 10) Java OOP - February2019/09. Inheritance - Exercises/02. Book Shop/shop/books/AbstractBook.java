package shop.books;

public abstract class AbstractBook {

    protected String title;

    protected String author;

    protected double price;


    protected AbstractBook(String author, String title, double price) throws IllegalArgumentException {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) throws IllegalArgumentException {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setAuthor(String author) throws IllegalArgumentException {
        String[] authorNameTokens = author.split("\\s+");
        if (authorNameTokens.length > 1 && Character.isDigit(authorNameTokens[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }
}
