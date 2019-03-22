import java.util.*;

public class UserLogs {

    private static final String STR_TO_END_INPUT = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>>
                userIPsCount = new TreeMap<>();

        String input;
        while (!STR_TO_END_INPUT.equals((input = scanner.nextLine()))) {
            String[] userIPTokens = input.split("[\\s=]+");

            userIPsCount.putIfAbsent(userIPTokens[5], new LinkedHashMap<>());
            LinkedHashMap<String, Integer> IPCount = userIPsCount.get(userIPTokens[5]);

            IPCount.putIfAbsent(userIPTokens[1], 0);
            IPCount.put(
                    userIPTokens[1],
                    IPCount.get(userIPTokens[1]) + 1
            );
        }

        for (String user : userIPsCount.keySet()) {
            LinkedHashMap<String, Integer> IPCount = userIPsCount.get(user);
            List<String> results = new ArrayList<>();
            for (String IP : IPCount.keySet()) {
                results.add(String.format("%s => %s", IP, IPCount.get(IP)));
            }

            System.out.printf("%s:%s", user, System.lineSeparator());
            System.out.println(String.join(", ", results) + ".");
        }
    }

}