import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    private static String strToFindEven = "even";
    private static String strToFindOdd = "odd";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            LinkedList<Integer> numsToDisplay = new LinkedList<>();
            int[] intBounds = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            String inpStrToFilterEvenOrOdd = reader.readLine();
            Predicate<Integer> evenOrOddFilterFn = getEvenOrOddFilterFn(inpStrToFilterEvenOrOdd);
            
            for (int i = intBounds[0]; i <= intBounds[1]; i++) {
                if (evenOrOddFilterFn.test(i)) {
                    numsToDisplay.add(i);
                }
            }

            for (Integer numToDisplay : numsToDisplay) {
                System.out.printf("%d ", numToDisplay);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Integer> getEvenOrOddFilterFn(String inpStrToFilterEvenOrOdd) {
        Predicate<Integer> evenOrOddFilterFn;
        if (strToFindEven.equals(inpStrToFilterEvenOrOdd)) {
            evenOrOddFilterFn = currNum -> currNum % 2 == 0;
        } else {
            evenOrOddFilterFn = currNum -> currNum % 2 != 0;
        }
        return evenOrOddFilterFn;
    }
}