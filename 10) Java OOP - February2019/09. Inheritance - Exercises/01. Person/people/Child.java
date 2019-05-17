package people;


public class Child extends Person {

    private static final int MIN_AGE = 15;


    public Child(String name, int age) throws IllegalArgumentException {
        super(name, age);
    }

    @Override
    public void setAge(int age) throws IllegalArgumentException {
        if (age > MIN_AGE) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
