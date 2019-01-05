import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        int eleToPushCnt = scanner.nextInt();
        int eleToPopCnt = scanner.nextInt();
        int eleToSearch = scanner.nextInt();
        scanner.nextLine();

        String[] inputNumsToPush = scanner.nextLine()
                .split("\\s+");

        for (int i = 0; i < eleToPushCnt; i++) {
            nums.offerFirst(Integer.parseInt(inputNumsToPush[i]));
        }

        for (int i = 0; i < eleToPopCnt; i++) {
            nums.poll();
        }

        System.out.println(searchForEle(nums, eleToSearch));
    }

    private static String searchForEle(ArrayDeque<Integer> nums, int eleToSearch) {
        if (nums.isEmpty()) {
            return Integer.toString(0);
        }

        if (nums.contains(eleToSearch)) {
            return Boolean.toString(true);
        }

        int smallestNum = Integer.MAX_VALUE;
        while (!nums.isEmpty()) {
            int currNum = nums.pop();

            if (currNum < smallestNum) {
                smallestNum = currNum;
            }
        }

        return Integer.toString(smallestNum);
    }
}
