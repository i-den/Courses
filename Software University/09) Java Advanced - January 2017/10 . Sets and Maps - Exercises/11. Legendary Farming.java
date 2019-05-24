import java.util.*;

public class LegendaryFarming {

    private static LinkedHashMap<String, Integer> legendaries = new LinkedHashMap<String, Integer>() {
        {put("Valanyr", 0);}
        {put("Shadowmourne", 0);}
        {put("Dragonwrath", 0);}
    };

    private static HashMap<String, String> legendaryMats = new HashMap<String, String>() {
        {put("shards", "Shadowmourne");}
        {put("fragments", "Valanyr");}
        {put("motes", "Dragonwrath");}
    };

    private static HashMap<String, String> legendaryMatsRev = new HashMap<String, String>() {
        {put("Shadowmourne", "shards");}
        {put("Valanyr", "fragments");}
        {put("Dragonwrath", "motes");}
    };

    private static int necessaryLegendaryMatQuantity = 250;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> junkMats = new TreeMap<>();
        String obtainedLegendary = "";

        while ("".equals(obtainedLegendary)) {
            String[] currMats = scanner.nextLine()
                    .split("\\s+");

            for (int i = 0; i < currMats.length; i += 2) {
                int currMatQuantity = Integer.parseInt(currMats[i]);
                String currMat = currMats[i + 1].toLowerCase();

                if (legendaryMats.containsKey(currMat)) {
                    String currLegendary = legendaryMats.get(currMat);

                    legendaries.put(
                            currLegendary,
                            legendaries.get(currLegendary) + currMatQuantity
                    );

                    if (legendaries.get(currLegendary) >= necessaryLegendaryMatQuantity) {
                        obtainedLegendary = currLegendary;

                        legendaries.put(
                                currLegendary,
                                legendaries.get(currLegendary) - necessaryLegendaryMatQuantity
                        );

                        break;
                    }
                } else {
                    if (!junkMats.containsKey(currMat)) {
                        junkMats.put(currMat, 0);
                    }
                    junkMats.put(
                            currMat,
                            junkMats.get(currMat) + currMatQuantity
                    );
                }
            }
        }

        System.out.println(obtainedLegendary + " obtained!");

        legendaries.entrySet()
                .stream()
                .sorted((firstLegendary, secLegendary) -> legendaries.get(secLegendary.getKey()).compareTo(legendaries.get(firstLegendary.getKey())))
                .forEach(currLegendaryMap -> {
                    String currLegendary = currLegendaryMap.getKey();
                    int currLegendaryQuantity = currLegendaryMap.getValue();

                    System.out.printf("%s: %d%n",
                            legendaryMatsRev.get(currLegendary),
                            currLegendaryQuantity
                    );
                });

        junkMats.forEach((currJunkMat, currJunkMatQuantity) -> System.out.println(currJunkMat + ": " + currJunkMatQuantity));
    }
}