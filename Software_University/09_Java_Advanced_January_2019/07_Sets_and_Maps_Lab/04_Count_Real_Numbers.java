import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> numCnt = new LinkedHashMap<>();

        String[] inputNums = scanner.nextLine().split("\\s+");
        for (String inputNum : inputNums) {
            double currNum = Double.parseDouble(inputNum);
            numCnt.putIfAbsent(currNum, 0);
            numCnt.put(
                    currNum,
                    numCnt.get(currNum) + 1
            );
        }

        for (Double num : numCnt.keySet()) {
            System.out.printf(
                    "%.1f -> %d%s",
                    num,
                    numCnt.get(num),
                    System.lineSeparator()
            );
        }
    }
}