package generics.b;

public class ClassTypeCapture<T> {

    Class<T> clazz;

    public ClassTypeCapture(Class<T> clazz) {
        this.clazz = clazz;
    }

    public boolean isStoredClazzInstanceOf(Object obj) {
        return clazz.isInstance(obj);
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        ClassTypeCapture<Parent> parentClassTypeCapture = new ClassTypeCapture<>(Parent.class);
        System.out.println("Is Parent.class instance of Parent: " + parentClassTypeCapture.isStoredClazzInstanceOf(parent)); // true
        System.out.println("Is Parent.class instance of Child: " + parentClassTypeCapture.isStoredClazzInstanceOf(child));   // true

        ClassTypeCapture<Child> childClassTypeCapture = new ClassTypeCapture<>(Child.class);
        System.out.println("Is Child.class instance of Parent: " + childClassTypeCapture.isStoredClazzInstanceOf(parent));   // false
        System.out.println("Is Child.class instance of Child: " + childClassTypeCapture.isStoredClazzInstanceOf(child));     // true
    }
}
