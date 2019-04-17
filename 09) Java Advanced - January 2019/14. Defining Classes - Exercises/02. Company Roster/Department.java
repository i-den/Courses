import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    Department(String name) {
        setName(name);
        employees = new ArrayList<>();
    }

    Double getAvgSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(Double.NaN);
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    List<Employee> getEmployees() {
        return employees;
    }
}
