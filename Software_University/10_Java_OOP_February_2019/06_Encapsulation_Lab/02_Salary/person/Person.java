package person;

public class Person {

    private String firstName;

    private String lastName;

    private Integer age;

    private Double salary;


    public Person(String firstName, String lastName, Integer age, Double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s gets %.2f leva",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary()
        );
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void increaseSalary(Double bonus) {
        if (age < 30)
            salary *= (100 + bonus / 100) / 2;
        else
            salary *= (100 + bonus) / 100;
    }
}
