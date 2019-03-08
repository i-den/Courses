import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class CustomComparator {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BiPredicate<Integer, List<Integer>> isDivisibleByAllNumsInList = (currNumToCheck, divisibleNums) -> {
            for (Integer currDivNum : divisibleNums) {
                if (currNumToCheck % currDivNum != 0) {
                    return false;
                }
            }
            return true;
        };

        try {
            int inpMaxInclusiveNumInRange = Integer.parseInt(reader.readLine());
            List<Integer> divisibleNums = Arrays.stream(reader.readLine().split("\\s+"))
                    .distinct()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int i = 1; i <= inpMaxInclusiveNumInRange; i++) {
                if (isDivisibleByAllNumsInList.test(i, divisibleNums)) {
                    System.out.print(i + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}