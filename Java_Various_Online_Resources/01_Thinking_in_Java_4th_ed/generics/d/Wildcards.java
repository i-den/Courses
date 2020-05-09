package generics.d;

public class Wildcards {

    static void holderSetRawArg(Holder holder, Object obj) {
        holder.set(obj); // Warning: Unchecked
    }

    static void holderSetUnboundedArg(Holder<?> holder, Object obj) {
        // holder.set(obj); // Won't compile: Requires Captur of ?
        // can't set anything except null
        holder.set(null);
        Object o = holder.get();
    }

    static <T> T holderExactT(Holder<T> holder, T type) {
        holder.set(type);
        return holder.get(); // T type = holder.get();
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T type) {
        // holder.set(type); // Won't compile
        return holder.get(); // T type = holder.get();
    }

    static <T> T wildSupertype(Holder<? super T> holder, T type) {
        holder.set(type);
        // T t = holder.get(); // Required: T, Provided: Capture of ? super T
        Object o = holder.get(); // Type info is lost
        return (T) holder.get(); // Warning: Unchecked Cast
    }

    public static void main(String[] args) {
        Long l = 7L;

        Holder rawHolder = new Holder();
        Holder<Long> qualifiedLongHolder = new Holder<>(l);
        Holder<?> unboundedHolder = new Holder<Long>();
        Holder<? extends Long> boundedHolder = new Holder<Long>();

        // holderSetRawArg(Holder holder, Object obj)
        // (Holder, Long)
        holderSetRawArg(rawHolder, l);

        // (Holder<Long>, Long)
        holderSetRawArg(qualifiedLongHolder, l);

        // (Holder<?>, Long)
        holderSetRawArg(unboundedHolder, l);

        // (Holder<? extends Long>, 1L)
        holderSetRawArg(boundedHolder, l);
        // No issues, value is set to 1L


        // holderSetUnboundedArg(Holder<?> holder, Object obj)
        // (Holder, Long)
        holderSetUnboundedArg(rawHolder, l);

        // (Holder<Long>, Long)
        holderSetUnboundedArg(qualifiedLongHolder, l);

        // (Holder<?>, Long)
        holderSetUnboundedArg(unboundedHolder, l);

        // (Holder<? extends Long>, 1L)
        holderSetUnboundedArg(boundedHolder, l);
        // No issues, value is set to null as per the method body


        // <T> T holderExactT(Holder<T> holder, T type) { holder.set(type); return holder.get(); }
        // (Holder, Long)
        Long n1 = holderExactT(rawHolder, l); // Warning: Unchecked assignment Holder to Holder<Long>

        // (Holder<Long>, Long)
        Long n2 = holderExactT(qualifiedLongHolder, l);

        // (Holder<?>, Long)
        // Long n3 = holderExactT(unboundedHolder, l);

        // (Holder<? extends Long>, 1L)
        // Long n4 = holderExactT(boundedHolder, l);


        // <T> T wildSubtype(Holder<? extends T> holder, T type) { return holder.get(); }
        // (Holder, Long)
        Long m1 = wildSubtype(rawHolder, l); // Warning: Unchecked assignment Holder to Holder<Long>

        // (Holder<Long>, Long)
        Long m2 = wildSubtype(qualifiedLongHolder, l);

        // (Holder<?>, Long)
        // Long m3 = wildSubtype(unboundedHolder, l); // Required: Long, Found: Object

        // (Holder<? extends Long>, 1L)
        Long m4 = wildSubtype(boundedHolder, l);


        // <T> T wildSupertype(Holder<? super T> holder, T type) { holder.set(type); return (T) holder.get(); }
        // (Holder, Long)
        Long z1 = wildSupertype(rawHolder, l);

        // (Holder<Long>, Long)
        Long z2 = wildSupertype(qualifiedLongHolder, l);

        // (Holder<?>, Long)
        // Long z3 = wildSupertype(unboundedHolder, l); // Long does not conform to capture of ?

        // Long z4 = wildSupertype(boundedHolder, l); // Long does not conform to capture of ? extends Long
    }
}
