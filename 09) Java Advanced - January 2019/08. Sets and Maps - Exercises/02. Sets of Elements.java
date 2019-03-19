import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> firstNums = new LinkedHashSet<>();
        LinkedHashSet<String> secNums = new LinkedHashSet<>();

        String[] inputFirstSecNumsCnt = scanner.nextLine().split("\\s+");
        int firstNumsCnt = Integer.parseInt(inputFirstSecNumsCnt[0]);
        int secNumsCnt = Integer.parseInt(inputFirstSecNumsCnt[1]);

        for (int i = 0; i < firstNumsCnt; i++) {
            firstNums.add(scanner.nextLine());
        }

        for (int i = 0; i < secNumsCnt; i++) {
            secNums.add(scanner.nextLine());
        }

        firstNums.retainAll(secNums);
        System.out.println(String.join(" ", firstNums));
    }
}