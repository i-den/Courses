import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            List<Integer> inpNums = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Collections.reverse(inpNums);

            int inpDivisibleNum = Integer.parseInt(reader.readLine());

            inpNums.stream()
                    .filter(inpNum -> inpNum % inpDivisibleNum != 0)
                    .forEach(e -> System.out.print(e + " "));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}