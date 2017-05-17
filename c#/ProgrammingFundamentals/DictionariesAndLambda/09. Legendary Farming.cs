using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var legendariesList = new Dictionary<string, int>()
        {
            {"motes", 0 },
            {"shards", 0 },
            {"fragments", 0 }
        };
        var junkList = new Dictionary<string, int>();
        var canContinue = true;

        while (canContinue)
        {
            var input = Console.ReadLine().Split();

            for (int i = 0; i < input.Length; i += 2)
            {
                var currentResourceQuantity = int.Parse(input[i]);
                var currentResourceType = input[i + 1].ToLower();

                if (legendariesList.ContainsKey(currentResourceType))
                {
                    legendariesList[currentResourceType] += currentResourceQuantity;

                    if (legendariesList[currentResourceType] >= 250)
                    {
                        legendariesList[currentResourceType] -= 250;
                        var legendaryItemObtained = string.Empty;

                        switch (currentResourceType)
                        {
                            case "motes": legendaryItemObtained = "Dragonwrath"; break;
                            case "shards": legendaryItemObtained = "Shadowmourne"; break;
                            case "fragments": legendaryItemObtained = "Valanyr"; break;
                        }

                        Console.WriteLine($"{legendaryItemObtained} obtained!");

                        canContinue = false;
                        break;
                    }
                }
                else
                {
                    if (!junkList.ContainsKey(currentResourceType))
                    {
                        junkList[currentResourceType] = 0;
                    }

                    junkList[currentResourceType] += currentResourceQuantity;
                }
            }
        }

        foreach (var legendaryItem in legendariesList.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
        {
            var legendaryItemName = legendaryItem.Key;
            var legendaryMatsQuantity = legendaryItem.Value;

            Console.WriteLine($"{legendaryItemName}: {legendaryMatsQuantity}");
        }

        foreach (var junkItem in junkList.OrderBy(x => x.Key))
        {
            var junkItemName = junkItem.Key;
            var junkMatsQuantity = junkItem.Value;

            Console.WriteLine($"{junkItemName}: {junkMatsQuantity}");
        }
    }
}