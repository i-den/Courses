import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSameValuesInArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Double, Integer> valCnt = new TreeMap<>();

        double[] inputNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double currInputNum : inputNums) {
            if (!valCnt.containsKey(currInputNum)) {
                valCnt.put(currInputNum, 0);
            }

            valCnt.put(currInputNum, valCnt.get(currInputNum) + 1);
        }

        DecimalFormat dcFormatter = new DecimalFormat("0.#");
        for (Double currVal : valCnt.keySet()) {
            System.out.printf("%s - %d times%n", dcFormatter.format(currVal), valCnt.get(currVal));
        }
    }
}