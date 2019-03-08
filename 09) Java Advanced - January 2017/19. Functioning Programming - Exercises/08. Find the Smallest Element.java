import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BiFunction<Integer, Integer, Boolean> isLowerNum = (currLowestNum, numToCheck) -> numToCheck <= currLowestNum;
        Function<List<Integer>, Integer> findLowestNumInList = numsToFindsLowestIn -> {
            Integer lowestNum = Integer.MAX_VALUE;
            int currIndex = 0;
            int indexToReturn = 0;
            for (Integer currNumInListToCheck : numsToFindsLowestIn) {
                if (isLowerNum.apply(lowestNum, currNumInListToCheck)) {
                    lowestNum = currNumInListToCheck;
                    indexToReturn = currIndex;
                }
                currIndex++;
            }
            return indexToReturn;
        };

        try {
            List<Integer> inputNums = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Integer lowestNumInlist = findLowestNumInList.apply(inputNums);
            System.out.println(lowestNumInlist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}