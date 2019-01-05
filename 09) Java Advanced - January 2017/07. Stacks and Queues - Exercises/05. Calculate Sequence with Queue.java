import java.util.ArrayDeque;
import java.util.Scanner;

public class CalculateSequenceWithQueue {
    private final static int maxEleCnt = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        nums.push(scanner.nextInt());
        int currStartNumInd = 0;

        while (nums.size() < maxEleCnt) {
            int nextStartNum = nums.toArray(new Integer[0])[currStartNumInd];

            nums.add(nextStartNum + 1);
            nums.add(2 * nextStartNum + 1);
            nums.add(nextStartNum + 2);

            currStartNumInd++;
        }

        for (int i = 0; i < maxEleCnt; i++) {
            System.out.print(nums.poll() + " ");
        }
    }
}