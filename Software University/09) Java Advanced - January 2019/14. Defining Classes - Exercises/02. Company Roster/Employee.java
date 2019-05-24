class Employee {
    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    Employee(String name, double salary, String position, String department) {
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setEmail(DEFAULT_EMAIL);
        setAge(DEFAULT_AGE);
    }

    String getInfo() {
        return String.format(
                "%s %.2f %s %d",
                getName(),
                getSalary(),
                getEmail(),
                getAge()
        );
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    String getPosition() {
        return position;
    }

    void setPosition(String position) {
        this.position = position;
    }

    String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }
}
