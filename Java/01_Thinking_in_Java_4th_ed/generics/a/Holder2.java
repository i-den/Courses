package generics.a;

import generics.general.TestClass;

public class Holder2 {

    private Object obj;

    public Holder2(Object obj) {
        this.obj = obj;
    }

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return this.obj;
    }

    /**
     * Can hold anything
     * Requires a cast
     */
    public static void main(String[] args) {
        Holder2 holder2 = new Holder2(new TestClass());
        TestClass testClass = (TestClass) holder2.get();

        holder2.set("This is a String");
        String str = (String) holder2.get();

        holder2.set(1);
        Integer num = (Integer) holder2.get();
    }
}
