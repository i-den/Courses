import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FilterStudentsByEmailDomain {

    private static final String strToEndInput = "END";
    private static final String emailDomain = "@gmail.com";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new LinkedList<>();

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            students.add(getStudentFromInput(currInput));
        }

        students.stream()
                .filter(e -> e.getEmail().endsWith(emailDomain))
                .forEach(s -> System.out.println(s.getFullName()));
    }

    private static Student getStudentFromInput(String input) {
        String[] studentTokens = input.split("\\s+");
        return new Student(studentTokens[0], studentTokens[1], studentTokens[2]);
    }
}

class Student {

    private String firstName;
    private String lastName;
    private String email;

    Student(String firstName, String lastName, String email) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String getFullName() {
        return String.format(
                "%s %s",
                this.getFirstName(),
                this.getLastName()
        );
    }
}