import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElemenet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> nums = new ArrayDeque<>();

        int cmdCnt = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cmdCnt; i++) {
            String[] currInput = scanner.nextLine()
                    .split("\\s+");

            switch (Integer.parseInt(currInput[0])) {
                case 1:
                    nums.push(Integer.parseInt(currInput[1]));
                    break;
                case 2:
                    nums.poll();
                    break;
                case 3:
                    System.out.println(findMaxNumInArrayDeque(nums.clone()));
            }
        }
    }

    private static Integer findMaxNumInArrayDeque (ArrayDeque<Integer> nums) {
        int maxNum = Integer.MIN_VALUE;
        while (!nums.isEmpty()) {
            int currNum = nums.pop();
            if (currNum > maxNum) {
                maxNum = currNum;
            }
        }

        return maxNum;
    }
}
