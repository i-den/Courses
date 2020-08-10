package generics.a;

import generics.general.TestClass;

public class Holder3<T> {

    private T type;

    public Holder3(T type) {
        this.type = type;
    }

    public void set(T type) {
        this.type = type;
    }

    public T get() {
        return this.type;
    }

    public static void main(String[] args) {
        Holder3<TestClass> holder3 = new Holder3<>(new TestClass());
        TestClass testClass = holder3.get();

        // holder3.set("Required: TestClass; Found: String");
    }
}
