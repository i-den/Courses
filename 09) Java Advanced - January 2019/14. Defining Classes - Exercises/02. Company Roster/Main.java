import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeCnt = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < employeeCnt; i++) {
            String[] employeeTokens = scanner.nextLine().split("\\s+");
            Employee currEmployee = new Employee(
                    employeeTokens[0],
                    Double.parseDouble(employeeTokens[1]),
                    employeeTokens[2],
                    employeeTokens[3]
            );

            if (employeeTokens.length > 4) {
                for (int j = 4; j < employeeTokens.length; j++) {
                    if (employeeTokens[j].contains("@")) {
                        currEmployee.setEmail(employeeTokens[j]);
                    } else {
                        currEmployee.setAge(Integer.parseInt(employeeTokens[j]));
                    }
                }
            }

            Department currDepartment = getDepartmentFromListByName(departments, employeeTokens[3]);
            if (currDepartment == null) {
                currDepartment = new Department(employeeTokens[3]);
                currDepartment.addEmployee(currEmployee);
                departments.add(currDepartment);
            } else {
                currDepartment.addEmployee(currEmployee);
            }
        }

        Department highestEarningDept = departments.stream().min((d1, d2) -> d2.getAvgSalary().compareTo(d1.getAvgSalary())).orElse(null);

        if (highestEarningDept != null) {
            System.out.println(String.format("Highest Average Salary: %s", highestEarningDept.getName()));
            highestEarningDept.getEmployees().stream()
                    .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                    .forEach(e -> System.out.println(e.getInfo()));
        }
    }

    static Department getDepartmentFromListByName(List<Department> departments, String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }
}
