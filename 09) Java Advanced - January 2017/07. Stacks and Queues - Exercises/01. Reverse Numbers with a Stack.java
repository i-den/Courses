import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseStrWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        for (String currNum : scanner.nextLine().split("\\s+")) {
            nums.push(Integer.parseInt(currNum));
        }

        while(!nums.isEmpty()) {
            System.out.print(nums.pop() + " ");
        }
    }
}
