import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> uniqueChemEles = new TreeSet<>();

        int compoundCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < compoundCnt; i++) {
            Collections.addAll(uniqueChemEles, scanner.nextLine().split("\\s+"));
        }

        System.out.println(String.join(" ", uniqueChemEles));
    }
}