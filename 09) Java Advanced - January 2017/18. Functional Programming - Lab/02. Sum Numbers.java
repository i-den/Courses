import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Function<String, Integer> parseInt = Integer::parseInt;
            int[] inpNums = Arrays.stream(reader.readLine().split("[\\s,]+"))
                    .mapToInt(parseInt::apply)
                    .toArray();

            int numCnt = 0;
            int numSum = 0;

            for (int inpNum : inpNums) {
                numCnt++;
                numSum+= inpNum;
            }

            System.out.printf(
                    "Count = %d%sSum = %d",
                    numCnt,
                    System.lineSeparator(),
                    numSum
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
