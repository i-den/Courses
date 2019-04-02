import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class FilterByAge {

    private static final String FILTER_YOUNGER = "younger";
    private static final String FILTER_OLDER = "older";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int personCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < personCnt; i++) {
            String[] personTokens = scanner.nextLine().split("[\\s,]+");
            people.add(new Person(personTokens[0], Integer.parseInt(personTokens[1])));
        }

        BiFunction<Integer, Integer, Boolean> ageFilterFn;
        String ageFilter = scanner.nextLine();
        switch (ageFilter) {
            case FILTER_YOUNGER:
                ageFilterFn = (currAge, requiredAge) -> currAge < requiredAge;
                break;
            case FILTER_OLDER:
            default:
                ageFilterFn = (currAge, requiredAge) -> currAge >= requiredAge;
                break;
        }

        int requiredAge = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split("\\s+");

        people = people.stream().filter(s -> ageFilterFn.apply(s.getAge(), requiredAge)).collect(Collectors.toList());
        if (commands.length > 1) {
            for (Person person : people) {
                System.out.println(person.getInfo());
            }
        } else if (commands[0].equals("name")) {
            for (Person person : people) {
                System.out.println(person.getName());
            }
        } else {
            for (Person person : people) {
                System.out.println(person.getAge());
            }
        }
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    String getName() {
        return name;
    }

    String getInfo() {
        return String.format("%s - %d", name, age);
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }
}