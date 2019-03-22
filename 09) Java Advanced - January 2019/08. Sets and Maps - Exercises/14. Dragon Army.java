import java.util.*;
import java.util.stream.Stream;

public class PopulationCounter {

    private static int defHealth = 250;
    private static int defDamage = 45;
    private static int defArmor = 10;
    private static String statToRetDef = "null";

    private static int dragonDmgIndex = 0;
    private static int dragonHealthIndex = 1;
    private static int dragonArmorIndex = 2;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, Integer[]>> dragons = new LinkedHashMap<>();

        int dragonCnt = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < dragonCnt; i++) {
            String[] dragonInfoInput = scanner.nextLine()
                    .split("\\s+");

            String type = dragonInfoInput[0];
            String name = dragonInfoInput[1];
            int damage = getDragonStat(dragonInfoInput[2], defDamage);
            int health = getDragonStat(dragonInfoInput[3], defHealth);
            int armor = getDragonStat(dragonInfoInput[4], defArmor);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }

            TreeMap<String, Integer[]> currDragonTypeInfo = dragons.get(type);
            if (!currDragonTypeInfo.containsKey(name)) {
                currDragonTypeInfo.put(name, new Integer[3]);
            }

            Integer[] currDragonStats = currDragonTypeInfo.get(name);
            currDragonStats[dragonDmgIndex] = damage;
            currDragonStats[dragonHealthIndex] = health;
            currDragonStats[dragonArmorIndex] = armor;
        }

        for (Map.Entry<String, TreeMap<String, Integer[]>> currDragonTypeInfo : dragons.entrySet()) {
            String currType = currDragonTypeInfo.getKey();

            double avgDmg = getDragonAverageStat(
                    currDragonTypeInfo.getValue().values().stream(),
                    dragonDmgIndex
            );

            double avgHealth = getDragonAverageStat(
                    currDragonTypeInfo.getValue().values().stream(),
                    dragonHealthIndex
            );

            double avgArmor = getDragonAverageStat(
                    currDragonTypeInfo.getValue().values().stream(),
                    dragonArmorIndex
            );

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", currType, avgDmg, avgHealth, avgArmor);

            for (Map.Entry<String, Integer[]> currDragonInfo : currDragonTypeInfo.getValue().entrySet()) {
                Integer[] currDragonStats = currDragonInfo.getValue();
                System.out.printf(
                        "-%s -> damage: %d, health: %d, armor: %d%n",
                        currDragonInfo.getKey(),
                        currDragonStats[dragonDmgIndex],
                        currDragonStats[dragonHealthIndex],
                        currDragonStats[dragonArmorIndex]
                );
            }
        }
    }

    private static Double getDragonAverageStat(Stream<Integer[]> dragonTypeStats, int dragonStatIndex) {
        return dragonTypeStats
                .mapToInt(currStatArray -> currStatArray[dragonStatIndex])
                .summaryStatistics()
                .getAverage();
    }

    private static int getDragonStat(String currStat, int defStat) {
        if (statToRetDef.equals(currStat)) {
            return defStat;
        }

        return Integer.parseInt(currStat);
    }
}