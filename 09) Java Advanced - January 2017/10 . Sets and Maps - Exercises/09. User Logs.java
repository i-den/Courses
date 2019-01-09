import java.util.*;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> userIPCount = new TreeMap<>();


        while (true) {
            String[] inputTokens = scanner.nextLine()
                    .split("\\s+");

            if (inputTokens[0].equals("end")) {
                break;
            }

            String currIP = inputTokens[0].split("=")[1];
            String currUsername = inputTokens[2].split("=")[1];

            if (!userIPCount.containsKey(currUsername)) {
                userIPCount.put(currUsername, new LinkedHashMap<>());
            }

            LinkedHashMap<String, Integer> currIPCnt = userIPCount.get(currUsername);

            if (!currIPCnt.containsKey(currIP)) {
                currIPCnt.put(currIP, 0);
            }

            userIPCount.get(currUsername).put(
                    currIP,
                    currIPCnt.get(currIP) + 1
            );
        }

        for (String currUsername : userIPCount.keySet()) {
            System.out.println(currUsername + ": ");

            LinkedHashMap<String, Integer> currIPCnt = userIPCount.get(currUsername);

            // Da vi e*a maikata
            ArrayDeque<String> output = new ArrayDeque<>();
            for (String currIP : currIPCnt.keySet()) {
                output.add(currIP + " => " + currIPCnt.get(currIP));
            }
            System.out.println(String.join(", ", output) + ".");
        }
    }
}