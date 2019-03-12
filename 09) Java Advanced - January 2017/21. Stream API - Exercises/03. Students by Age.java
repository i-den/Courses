import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentsByAge {

    private static final String strToEndInput = "END";
    private static final int minAgeIncl = 18;
    private static final int maxAgeIncl = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new LinkedList<>();

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            students.add(getStudentFromInput(currInput));
        }

        students.stream()
                .filter(s -> s.getAge() >= minAgeIncl && s.getAge() <= maxAgeIncl)
                .forEach(s -> System.out.println(s.getFullName()));
    }

    private static Student getStudentFromInput(String input) {
        String[] studentTokens = input.split("\\s+");
        return new Student(
                studentTokens[0],
                studentTokens[1],
                Integer.parseInt(studentTokens[2])
        );
    }
}

class Student {

    private String firstName;
    private String lastName;
    private int age;

    Student(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String getFullName() {
        return String.format(
                "%s %s %d",
                this.getFirstName(),
                this.getLastName(),
                this.getAge()
        );
    }
}