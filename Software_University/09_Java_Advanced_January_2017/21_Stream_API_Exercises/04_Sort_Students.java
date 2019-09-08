import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SortStudents {

    private static final String strToEndInput = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new LinkedList<>();

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            students.add(getStudentFromInput(currInput));
        }

        students.stream()
                .sorted(Student::lastNameAscFirstNameDescCmp)
                .forEach(s -> System.out.println(s.getFullName()));
    }

    private static Student getStudentFromInput(String input) {
        String[] studentTokens = input.split("\\s+");
        return new Student(studentTokens[0], studentTokens[1]);
    }
}

class Student {

    private String firstName;
    private String lastName;

    Student(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    static int lastNameAscFirstNameDescCmp(Student s1, Student s2) {
        int lastNameAscCmp = s1.getLastName().compareTo(s2.getLastName());
        if (lastNameAscCmp == 0) {
            return s2.getFirstName().compareTo(s1.getFirstName());
        }
        return lastNameAscCmp;
    }

    String getFullName() {
        return String.format(
                "%s %s",
                this.getFirstName(),
                this.getLastName()
        );
    }
}