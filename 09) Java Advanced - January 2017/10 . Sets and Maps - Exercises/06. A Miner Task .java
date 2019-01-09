import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class AMinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        while (true) {
            String currResource = scanner.nextLine();

            if (currResource.equals("stop")) {
                break;
            }

            int currResourceAmt = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(currResource)) {
                resources.put(currResource, 0);
            }

            resources.put(currResource, resources.get(currResource) + currResourceAmt);
        }

        for (String currResource : resources.keySet()) {
            System.out.println(currResource + " -> " + resources.get(currResource));
        }
    }
}