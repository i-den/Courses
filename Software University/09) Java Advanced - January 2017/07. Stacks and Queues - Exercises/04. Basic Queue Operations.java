import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        int eleToAddCnt = scanner.nextInt();
        int eleToRemoveCnt = scanner.nextInt();
        int eleToSearch = scanner.nextInt();
        scanner.nextLine();

        String[] inputNumsToAdd = scanner.nextLine()
                .split("\\s+");

        for (int i = 0; i < eleToAddCnt; i++) {
            nums.offer(Integer.parseInt(inputNumsToAdd[i]));
        }

        for (int i = 0; i < eleToRemoveCnt; i++) {
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
            int currNum = nums.poll();
            if (currNum < smallestNum) {
                smallestNum = currNum;
            }
        }

        return Integer.toString(smallestNum);
    }
}