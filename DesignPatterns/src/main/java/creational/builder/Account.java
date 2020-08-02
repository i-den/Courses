package creational.builder;

public class Account {

    private int age;
    private String uid;
    private double amount;

    private Account(Builder builder) {
        this.age = builder.age;
        this.uid = builder.uid;
        this.amount = builder.amount;
    }

    public static class Builder {

        private int age = 0;
        private String uid = "";
        private double amount = 0D;

        Builder(int age) {
            this.age = age;
        }

        public void withAge(int age) {
            this.age = age;
        }

        public void withUID(String uid) {
            this.uid = uid;
        }

        public void withAmount(double amount) {
            this.amount = amount;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
