import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> userNames = new LinkedHashSet<>();

        int userNameCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < userNameCnt; i++) {
            userNames.add(scanner.nextLine());
        }

        for (String userName : userNames) {
            System.out.println(userName);
        }
    }
}