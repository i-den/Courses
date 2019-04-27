package Company;

public class CompanyInfo {

    private String name;

    private String department;

    private Double salary;

    public CompanyInfo(String name, String department, Double salary) {
        setName(name);
        setDepartment(department);
        setSalary(salary);
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s %.2f",
                name,
                department,
                salary
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
