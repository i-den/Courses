import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UpperStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inpNames = scanner.nextLine().split("\\s+");
        Character[] charsNamesShouldStartWith = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(inpStr -> inpStr.charAt(0))
                .toArray(Character[]::new);

        Optional<String> nameFound = Arrays.stream(inpNames)
                .filter(currName -> nameStartsWithAnyChar(currName, charsNamesShouldStartWith))
                .sorted()
                .findFirst();

        System.out.println(nameFound.orElse("No match"));
    }

    private static boolean nameStartsWithAnyChar(String name, Character[] charsNamesShouldStartWith) {
        for (Character currCharNameShouldStartWith : charsNamesShouldStartWith) {
            if (Character.toLowerCase(name.charAt(0)) == Character.toLowerCase(currCharNameShouldStartWith)) {
                return true;
            }
        }
        return false;
    }
}