import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ExcellentStudents {

    private static final String strToEndInput = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new LinkedList<>();

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            students.add(getStudentFromInput(currInput));
        }

        students.stream()
                .filter(Student::hasAtLeastOneExcellentMark)
                .forEach(s -> System.out.println(s.getFullName()));
    }

    private static Student getStudentFromInput(String input) {
        String[] studentTokens = input.split("\\s+");
        Student currStudent = new Student(studentTokens[0], studentTokens[1]);
        for (int i = 2; i < studentTokens.length; i++) {
            currStudent.addMark(Integer.parseInt(studentTokens[i]));
        }
        return currStudent;
    }
}

class Student {

    public static final int excellentMark = 6;

    private String firstName;
    private String lastName;
    private List<Integer> marks;

    Student(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.marks = new ArrayList<>();
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

    public void addMark(int mark) {
        this.marks.add(mark);
    }

    public boolean hasAtLeastOneExcellentMark() {
        return this.marks.stream().anyMatch(m -> m == excellentMark);
    }

    String getFullName() {
        return String.format(
                "%s %s",
                this.getFirstName(),
                this.getLastName()
        );
    }
}