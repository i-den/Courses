import java.util.Arrays;
import java.util.Scanner;

public class MapDistricts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inpNumBoundaries = scanner.nextLine().split("\\s+");
        int firstVal = Integer.parseInt(inpNumBoundaries[0]);
        int secVal = Integer.parseInt(inpNumBoundaries[1]);
        int minVal = Math.min(firstVal, secVal);
        int maxVal = Math.max(firstVal, secVal);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(i -> i >= minVal && i <= maxVal)
                .forEach(i -> System.out.print(i + " "));
    }
}