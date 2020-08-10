package generics.d;

import java.util.Objects;

public class Holder<T> {

    private T type;

    public Holder() {};

    public Holder(T type) {
        this.type = type;
    }

    public void set(T type) {
        this.type = type;
    }

    public T get() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        return this.type == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
