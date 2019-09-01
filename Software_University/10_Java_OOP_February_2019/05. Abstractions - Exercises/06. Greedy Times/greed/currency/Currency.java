package greed.currency;

public abstract class Currency implements Comparable<Currency> {

    private String name;

    private long amount;

    public Currency(String name, long amount) {
        this.setName(name);
        this.setAmount(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAmount(long amount) {
        this.amount += amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Currency o) {
        int nameCmpDesc = o.getName().compareTo(this.getName());
        if (nameCmpDesc == 0) {
            return Long.compare(o.getAmount(), this.getAmount());
        }
        return nameCmpDesc;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d%n", getName(), getAmount());

    }
}
