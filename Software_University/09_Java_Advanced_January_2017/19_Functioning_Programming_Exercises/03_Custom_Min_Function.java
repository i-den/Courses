import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<int[], Integer> lowestIntInArr = intArr -> {
            int minNumFound = Integer.MAX_VALUE;
            for (Integer currInt : intArr) {
                if (currInt < minNumFound) {
                    minNumFound = currInt;
                }
            }
            return minNumFound;
        };

        try {
            System.out.println(
                    lowestIntInArr.apply(
                            Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray()
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}