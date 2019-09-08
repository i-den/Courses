import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, TreeSet<String>> userIPs = new TreeMap<>();
        HashMap<String, Long> userDuration = new HashMap<>();

        int inputCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputCnt; i++) {
            String[] ipUserDurationTokens = scanner.nextLine().split("\\s+");
            Long durationToAdd = Long.parseLong(ipUserDurationTokens[2]);

            userDuration.putIfAbsent(ipUserDurationTokens[1], 0L);
            userDuration.put(
                    ipUserDurationTokens[1],
                    userDuration.get(ipUserDurationTokens[1]) + durationToAdd
            );

            userIPs.putIfAbsent(ipUserDurationTokens[1], new TreeSet<>());
            userIPs.get(ipUserDurationTokens[1]).add(ipUserDurationTokens[0]);
        }

        for (String user : userIPs.keySet()) {
            System.out.printf(
                    "%s: %d [%s]%s",
                    user,
                    userDuration.get(user),
                    String.join(", ", userIPs.get(user)),
                    System.lineSeparator()
            );
        }
    }
}