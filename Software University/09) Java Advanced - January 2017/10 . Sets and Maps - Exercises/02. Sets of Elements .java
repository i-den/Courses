import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstTreeCnt = scanner.nextInt();
        int secTreeCnt = scanner.nextInt();
        scanner.nextLine();

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(firstTreeCnt);
        LinkedHashSet<Integer> secSet = new LinkedHashSet<>(secTreeCnt);

        for (int i = 0; i < firstTreeCnt; i++) {
            firstSet.add(scanner.nextInt());
        }

        for (int i = 0; i < firstTreeCnt; i++) {
            secSet.add(scanner.nextInt());
        }

        firstSet.retainAll(secSet);
        for (Integer currNum : firstSet) {
            System.out.print(currNum + " ");
        }
    }
}