import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> chemicals = new TreeSet<>();

        int compoundsCnt = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < compoundsCnt; i++) {
            String[] currChemicals = scanner.nextLine()
                    .split("\\s+");

            chemicals.addAll(Arrays.asList(currChemicals));
        }

        for (String chemical : chemicals) {
            System.out.print(chemical + " ");
        }
    }
}