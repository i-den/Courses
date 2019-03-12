import java.util.*;
import java.util.stream.Collectors;

public class GroupByGroup {

    private static final String strToEndInput = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Student>> groupStudents = new HashMap<>();

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            String[] studentTokens = currInput.split("\\s+");
            int group = Integer.parseInt(studentTokens[2]);
            groupStudents.putIfAbsent(
                    group,
                    new LinkedList<>()
            );

            groupStudents.get(group)
                    .add(getStudentFromInput(studentTokens));
        }

        groupStudents.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(gs -> System.out.printf(
                        "%d - %s%s",
                        gs.getKey(),
                        gs.getValue().stream().map(Student::getFullName).collect(Collectors.joining(", ")),
                        System.lineSeparator()
                ));
    }

    private static Student getStudentFromInput(String[] studentTokens) {
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
    private int group;

    Student(String firstName, String lastName, int group) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGroup(group);
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    String getFullName() {
        return String.format(
                "%s %s",
                this.getFirstName(),
                this.getLastName()
        );
    }
}