import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inpArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] commands = scanner.nextLine().split("\\s+");

        int[] outputNums = getNumbers(inpArr, commands);
        System.out.println(Arrays.stream(outputNums).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int[] getNumbers(int[] inpArr, String[] commands) {
        String evenOrOdd = commands[2];
        int reqNums = Integer.parseInt(commands[1]);
        int[] oddOrEvenArr;

        if (evenOrOdd.equals("odd")) {
            oddOrEvenArr = Arrays.stream(inpArr)
                    .filter(intEle -> intEle % 2 != 0)
                    .toArray();
        } else {
            oddOrEvenArr = Arrays.stream(inpArr)
                    .filter(intEle -> intEle % 2 == 0)
                    .toArray();
        }

        if (reqNums > oddOrEvenArr.length) {
            return oddOrEvenArr;
        }

        return Arrays.stream(oddOrEvenArr).limit(reqNums).toArray();
    }
}