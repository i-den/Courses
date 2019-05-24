import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentsByGroup {

    private static final String strToEndInput = "END";
    private static final int groupToAddStudentsFrom = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            students.add(addStudentFromInput(currInput));
        }

        students.stream()
                .filter(s -> s.getGroupNum() == groupToAddStudentsFrom)
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(s -> System.out.println(s.getFullName()));
    }

    private static Student addStudentFromInput(String input) {
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
    private int groupNum;

    Student(String firstName, String lastName, int groupNum) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGroupNum(groupNum);
    }

    String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    int getGroupNum() {
        return groupNum;
    }

    private void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    String getFullName() {
        return String.format(
                "%s %s",
                this.getFirstName(),
                this.getLastName()
        );
    }
}