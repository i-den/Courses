package people;

public class Person {

    private static final int MIN_NAME_LEN = 3;

    private String name;

    private int age;

    public Person(String name, int age) throws IllegalArgumentException {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s, Age: %d",
                this.getName(),
                this.getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.length() < MIN_NAME_LEN) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }
}
