import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {

    private final static String strToFilterYoungerStudents = "younger";
    private final static String strToFilterOlderStudents = "older";

    private final static String strToAddNameToOutput = "name";
    private final static String strToAddAgeTOOutput = "age";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int studentCnt = Integer.parseInt(reader.readLine());

            LinkedList<Student> students = new LinkedList<>();
            for (int i = 0; i < studentCnt; i++) {
                String[] studentTknsInp = reader.readLine().split("[\\s,]+");
                students.add(new Student(studentTknsInp[0], Integer.parseInt(studentTknsInp[1])));
            }

            String inpStrToFilterByAge = reader.readLine();
            int ageToFilterBy = Integer.parseInt(reader.readLine());
            Predicate<Integer> ageFilterFn = getAgeFn(inpStrToFilterByAge, ageToFilterBy);
            students = students.stream()
                    .filter(student -> ageFilterFn.test(student.getAge()))
                    .collect(Collectors.toCollection(LinkedList::new));

            String[] outputPropertiesRequest = reader.readLine().split("\\s+");
            Consumer<Student> printStudentStatsFn = getStudentPrintFn(outputPropertiesRequest);

            students.forEach(printStudentStatsFn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Integer> getAgeFn(String inpStrToFilterByAge, int ageToFilterBy) {
        Predicate<Integer> ageFilterFn;
        if (strToFilterYoungerStudents.equals(inpStrToFilterByAge)) {
            ageFilterFn = currStudentAge -> currStudentAge < ageToFilterBy;
        } else {
            ageFilterFn = currStudentAge -> currStudentAge >= ageToFilterBy;
        }
        return ageFilterFn;
    }

    private static Consumer<Student> getStudentPrintFn(String[] outputPropertiesRequest) {
        Consumer<Student> printStudentStatsFn;
        if (outputPropertiesRequest.length > 1) {
            printStudentStatsFn = student -> System.out.printf(
                    "%s - %d%s",
                    student.getName(),
                    student.getAge(),
                    System.lineSeparator()
            );
        } else if (strToAddNameToOutput.equals(outputPropertiesRequest[0])) {
            printStudentStatsFn = student -> System.out.printf(
                    "%s%s", student.getName(), System.lineSeparator()
            );
        } else {
            printStudentStatsFn = student -> System.out.printf(
                    "%d%s", student.getAge(), System.lineSeparator()
            );
        }
        return printStudentStatsFn;
    }
}

class Student {
    private String name;

    private int age;

    Student(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
