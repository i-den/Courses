import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Long> trashItemsQuantity = new TreeMap<>();
        LegendaryManager legendaryManager = new LegendaryManager();

        while (!legendaryManager.legendaryObtained()) {
            String[] matQuantityTokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < matQuantityTokens.length; i += 2) {
                Long quantity = Long.parseLong(matQuantityTokens[i]);
                String material = matQuantityTokens[i + 1].toLowerCase();

                if (legendaryManager.isMaterialForLegendary(material)) {
                    legendaryManager.addMaterialsForLegendary(material, quantity);

                    if (legendaryManager.legendaryObtained()) {
                        System.out.printf(
                                "%s obtained!%s",
                                legendaryManager.getObtainedLegendary(),
                                System.lineSeparator()
                        );
                        legendaryManager.printCollectedMats();
                        break;
                    }
                } else {
                    trashItemsQuantity.putIfAbsent(material, 0L);
                    trashItemsQuantity.put(
                            material,
                            trashItemsQuantity.get(material) + quantity
                    );
                }
            }
        }

        for (String trashItemName : trashItemsQuantity.keySet()) {
            System.out.printf("%s: %d%s", trashItemName, trashItemsQuantity.get(trashItemName), System.lineSeparator());
        }
    }
}

class LegendaryManager {

    private static final int AMNT_TO_COMPLETE = 250;

    private HashMap<String, Integer> legendariesQuantity;

    private HashMap<String, String> materialLegendaryName;

    private String obtainedLegendary;

    LegendaryManager() {
        initializeLegendariesMap();
        initializeMaterialsMap();
    }

    boolean legendaryObtained() {
        if (obtainedLegendary != null) {
            return true;
        }

        for (String legendaryName : legendariesQuantity.keySet()) {
            int currLegendaryMatQuantity = legendariesQuantity.get(legendaryName);
            if (currLegendaryMatQuantity >= AMNT_TO_COMPLETE) {
                obtainedLegendary = legendaryName;
                legendariesQuantity.put(
                        legendaryName,
                        currLegendaryMatQuantity - AMNT_TO_COMPLETE
                );
                return true;
            }
        }
        return false;
    }

    void addMaterialsForLegendary(String material, Long quantity) {
        String legendaryName = materialLegendaryName.get(material);
        legendariesQuantity.put(
                legendaryName,
                legendariesQuantity.get(legendaryName) + quantity.intValue()
        );
    }

    private void initializeLegendariesMap() {
        HashMap<String, Integer> legendaryItemsMap = new HashMap<>();
        legendaryItemsMap.put("Shadowmourne", 0);
        legendaryItemsMap.put("Valanyr", 0);
        legendaryItemsMap.put("Dragonwrath", 0);
        legendariesQuantity = legendaryItemsMap;
    }

    private void initializeMaterialsMap() {
        HashMap<String, String> legendaryMaterialsMap = new HashMap<>();
        legendaryMaterialsMap.put("shards", "Shadowmourne");
        legendaryMaterialsMap.put("fragments", "Valanyr");
        legendaryMaterialsMap.put("motes", "Dragonwrath");
        materialLegendaryName = legendaryMaterialsMap;
    }

    boolean isMaterialForLegendary(String material) {
        return materialLegendaryName.keySet().contains(material.toLowerCase());
    }

    String getObtainedLegendary() {
        return obtainedLegendary;
    }

    void printCollectedMats() {
        this.legendariesQuantity.keySet().stream()
                .sorted((m1, m2) -> legendariesQuantity.get(m2).compareTo(legendariesQuantity.get(m1)))
                .forEach(legendaryName -> System.out.printf(
                        "%s: %d%s",
                        getLegendaryMaterialName(legendaryName),
                        legendariesQuantity.get(legendaryName),
                        System.lineSeparator()
                ));
    }

    private String getLegendaryMaterialName(String legendaryName) {
        for (String material : materialLegendaryName.keySet()) {
            if (materialLegendaryName.get(material).equals(legendaryName)) {
                return material;
            }
        }
        return null;
    }
}