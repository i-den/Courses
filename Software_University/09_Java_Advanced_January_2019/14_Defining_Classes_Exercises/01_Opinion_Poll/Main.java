import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int MIN_AGE = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int personCnt = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < personCnt; i++) {
            String[] peopleTokens = scanner.nextLine().split("\\s+");
            people.add(new Person(Integer.parseInt(peopleTokens[1]), peopleTokens[0]));
        }

        people.stream()
                .filter(p -> p.getAge() > MIN_AGE)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getInfo()));
    }
}