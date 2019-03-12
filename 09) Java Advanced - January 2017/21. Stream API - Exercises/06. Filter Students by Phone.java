import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FilterStudentsByPhone {

    private static final String strToEndInput = "END";
    private static final String phoneStartsWith1 = "02";
    private static final String phoneStartsWith2 = "+3592";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new LinkedList<>();

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            students.add(getStudentFromInput(currInput));
        }

        students.stream()
                .filter(s -> s.getPhone().startsWith(phoneStartsWith1) || s.getPhone().startsWith(phoneStartsWith2))
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
    private String phone;

    Student(String firstName, String lastName, String phone) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String getFullName() {
        return String.format(
                "%s %s",
                this.getFirstName(),
                this.getLastName()
        );
    }
}