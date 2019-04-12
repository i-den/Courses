import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Comparator<Integer> comparator = (fistNum, secNum) -> {
            if (fistNum % 2 == 0 && secNum % 2 != 0) {
                return -1;
            }

            if (fistNum % 2 != 0 && secNum % 2 == 0) {
                return 1;
            }

            return fistNum.compareTo(secNum);
        };

        try {
            List<Integer> inputNums = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .sorted(comparator)
                    .collect(Collectors.toList());

            for (Integer currNum : inputNums) {
                System.out.print(currNum + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}