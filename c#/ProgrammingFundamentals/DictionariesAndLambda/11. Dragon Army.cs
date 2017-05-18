using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var dragonList = new Dictionary<string, SortedDictionary<string, decimal[]>>();
        var totalDragons = int.Parse(Console.ReadLine());

        for (int i = 1; i <= totalDragons; i++)
        {
            var dragonInputInfo = Console.ReadLine().Split();

            var currentDragonType = dragonInputInfo[0];
            var currentDragonName = dragonInputInfo[1];
            var currentDragonDamage = dragonInputInfo[2] == "null" ? 45 : decimal.Parse(dragonInputInfo[2]);
            var currentDragonHealth = dragonInputInfo[3] == "null" ? 250 : decimal.Parse(dragonInputInfo[3]);
            var currentDragonArmor = dragonInputInfo[4] == "null" ? 10 : decimal.Parse(dragonInputInfo[4]);

            if (!dragonList.ContainsKey(currentDragonType))
            {
                dragonList[currentDragonType] = new SortedDictionary<string, decimal[]>();
            }
            
                dragonList[currentDragonType][currentDragonName] = new decimal[] { currentDragonDamage, currentDragonHealth, currentDragonArmor };
        }

        foreach (var dragonTypeInfo in dragonList)
        {
            var currentDragonType = dragonTypeInfo.Key;
            var currentTypeDragons = dragonTypeInfo.Value;

            var currentDragonTypeAverageDamage = currentTypeDragons.Values.Average(x => x[0]);
            var currentDragonTypeAverageHealth = currentTypeDragons.Values.Average(x => x[1]);
            var currentDragonTypeAverageArmor = currentTypeDragons.Values.Average(x => x[2]);

            Console.WriteLine($"{currentDragonType}::({currentDragonTypeAverageDamage:F2}/{currentDragonTypeAverageHealth:F2}/{currentDragonTypeAverageArmor:F2})");

            foreach (var dragonNameStatsPair in currentTypeDragons)
            {
                var currentDragonName = dragonNameStatsPair.Key;
                var currentDragonDamage = dragonNameStatsPair.Value[0];
                var currentDragonHealth = dragonNameStatsPair.Value[1];
                var currentDragonArmor = dragonNameStatsPair.Value[2];

                Console.WriteLine($"-{currentDragonName} -> damage: {currentDragonDamage}, health: {currentDragonHealth}, armor: {currentDragonArmor}");
            }
        }
    }
}