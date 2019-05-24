package animals;

public class Chicken {

    private String name;

    private int age;


    public Chicken(String name, int age) throws Exception {
        this.setName(name);
        this.setAge(age);
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double productPerDay = 0;
        if (age > 0 && 5 >= age)
            productPerDay = 2;
        else if (age >= 6 && 11 >= age)
            productPerDay = 1;
        else
            productPerDay = 0.75;
        return productPerDay;
    }

    @Override
    public String toString() {
        return String.format(
                "Chicken %s (age %d) can produce %s eggs per day",
                name,
                age,
                String.valueOf(calculateProductPerDay())
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age < 0 || age > 15) {
            throw new Exception("Age should be between 0 and 15.");
        }
        this.age = age;
    }


}
