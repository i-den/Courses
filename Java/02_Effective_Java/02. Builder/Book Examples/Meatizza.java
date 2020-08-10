public class Meatizza extends Pizza {
    private final int size;

    public class Builder extends Pizza.Builder<Builder> {
        private int size;

        public Builder(int size) {
            this.size = size;
        }

        @Override
        Meatizza build() {
            return new Meatizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Meatizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
