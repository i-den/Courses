import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {

    private static final String STR_TO_END_INPUT = "stop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resourcesQuantity = new LinkedHashMap<>();

        String inputResource;
        while (!STR_TO_END_INPUT.equals((inputResource = scanner.nextLine()))) {
            int quantity = Integer.parseInt(scanner.nextLine());
            resourcesQuantity.putIfAbsent(inputResource, 0);
            resourcesQuantity.put(
                    inputResource,
                    resourcesQuantity.get(inputResource) + quantity
            );
        }

        for (String resource : resourcesQuantity.keySet()) {
            System.out.printf("%s -> %d%s", resource, resourcesQuantity.get(resource), System.lineSeparator());
        }
    }
}