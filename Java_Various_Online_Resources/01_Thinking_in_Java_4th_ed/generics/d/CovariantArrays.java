package generics.d;

import java.util.ArrayList;
import java.util.List;

/**
 * Bounds
 * Erasure removes type information, you can only use Object methods for Unbounded Generics
 *
 * Unbounded WildCard Generic       -   Class<?>
 * Bounded WildCard Generic         -   Class<? extends Class>
 *
 * Raw type                         -   Class
 * Generic type                     -   Class<E>
 * Parameterized type               -   Class<String>
 *
 * Raw types are for compatibility, they should not be used
 *
 */
public class CovariantArrays {

    public void covariantArrays() {
        Grandparent[] grandparents = new Parent[7]; // Runtime Array is Parent[]
        grandparents[0] = new Parent();
        grandparents[1] = new Child();

        try {
            grandparents[0] = new Grandparent(); // ArrayStoreException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nonCovariantGenerics() {
        // List<Grandparent> grandparentList = new ArrayList<Parent>(); // Won't compile: you're required to use ArrayList of GrandParent, not Parent
    }

    /**
     * Type is now List<? extends Grandparent>
     * A List of any type that's inherited from Grandparent
     * Doesn't actually mean that the List will hold any type of Grandparent, however
     * The wildcard refers to a definite type, so it means "some specific type which the List reference doesn't specify."
     * So the List that’s assigned has to be holding some specified type such as Grandparent, but in order to upcast to grandparents, that type is a "don’t actually care."
     * If the only constraint is that the List hold a specific Grandparent or subtype of Grandparent, but you don’t actually care what it is, then what can you do with such a List?
     * If you don’t know what type the List is holding, how can you safely add an object?
     */
    public void genericsAndCovariance() {
        List<? extends Grandparent> grandparents = new ArrayList<Parent>(); // Compiles
        // grandparents.add(new Parent()); // Won't compile: you're required to use capture of ? extends Grandparent, not Parent
        // grandparents.add(new Child());

        grandparents.add(null); // Legal
        Grandparent grandparent = grandparents.get(0);
    }


    /**
     * List<? extends Class>
     * extendsGrandparentHolder is a Holder of some type that has ? extending it
     * ? extends goes up
     */
    public static void extendsHolder() {
        Holder<Parent> parentHolder = new Holder<>(new Parent());
        Parent parent = parentHolder.get();
        parentHolder.set(parent);

        // Holder<Grandparent> grandparentHolder = parentHolder; // Cannot upcast from Parent to Grandparent
        Holder<? extends Grandparent> extendsGrandparentHolder = parentHolder;

        Grandparent grandparent = extendsGrandparentHolder.get(); // Runtime's Late Binding is of type Parent
        parent = (Parent) extendsGrandparentHolder.get();

        try { // Will compile. Runtime Exception
            Child child = (Child) extendsGrandparentHolder.get(); // Grandparent < Parent < Child. Runtime val is Parent. Can't downcast
        } catch (ClassCastException e) {
            System.out.println(e.toString()); // java.lang.ClassCastException: generics.d.Parent cannot be cast to generics.d.Child
        }

        // Holder<? extends Child> extendsChildHolder = parentHolder; Can't downcast
        Holder<? extends Parent> extendsParentHolder = parentHolder;
        Holder<? extends Grandparent> extendsGrandparentHolder2 = parentHolder;

        System.out.println(parentHolder == extendsGrandparentHolder); // true
        parentHolder.set(new Parent());
        // extendsGrandparentHolder.set(new Parent()); Requires <? extends Grandparent>
        parentHolder.set(new Child());
        // extendsGrandparentHolder.set(new Child());
    }

    /**
     * List<? super Parent>
     * superParentList is a List of some type that is "derived" of Parent
     * It's safe to add Parent, or anything below Parent
     *
     * Lower bound is Parent
     * You can't add a Grandparent as Grandparent might extend another class other than Parent
     *
     *                  Grandparent
     *              Parent       Uncle
     *           Child            Cousin
     *
     *           Super: Grandparent -> Parent -> Child
     *           ? super Grandparent is Grandparent, Parent and Child
     *           ? super Grandparent is Grandparent, Uncle and Cousin
     *
     *           ? super Parent is Parent and Child
     *           ? super Uncle is Uncle and Cousin
     *
     *  Being able to add a Grandparent to a List<? super Parent> means that you'll also be able to add Uncle or Cousin, which breaks type safety
     *  You cannot upcast
     */
    public static void superHolder() {
        List<? super Parent> superParentList = new ArrayList<>();

        superParentList.add(new Parent());
        superParentList.add(new Child());
        // superParentList.add(new Grandparent()); Won't compile
        for (Object o : superParentList) {
            Parent p = (Parent) o;
            p.parentStuff();
        }

        List<? extends Grandparent> grandparents = new ArrayList<>();
        // grandparents.add(new Grandparent());   No go
        // grandparents.add(new Parent());
        // grandparents.add(new Child());
        grandparents.add(null);
        Holder<? extends Grandparent> grandparentHolder = new Holder<>();
        // grandparentHolder.set(new Grandparent());
        // grandparentHolder.set(new Parent());
        // grandparentHolder.set(new Child());
        grandparentHolder.set(null);
    }

}

class ExtendsTest<T extends Parent> {

    T type;

    public static void main(String[] args) {
        // Test<Grandparent> grandparentTest = new Test<>(); Won't compile
        ExtendsTest<Parent> parentTest = new ExtendsTest<>();
        ExtendsTest<Child> childTest = new ExtendsTest<>();
    }
}

//class SuperTest<T super Parent> {} // Won't compile
