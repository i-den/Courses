using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var trashDict = new Dictionary<string, int>();
        var legendaryDict = new Dictionary<string, int>
        {
            { "shards", 0},
            { "fragments", 0},
            { "motes", 0}
        };
        var canContinue = true;

        while (canContinue)
        {
            var input = Console.ReadLine().Split();

            for (int i = 0; i < input.Length; i += 2)
            {
                var currQuantity = int.Parse(input[i]);
                var currMaterial = input[i + 1].ToLower();

                if (legendaryDict.ContainsKey(currMaterial))
                {
                    legendaryDict[currMaterial] += currQuantity;

                    if (legendaryDict[currMaterial] >= 250)
                    {
                        legendaryDict[currMaterial] -= 250;
                        var legendary = GetLegendary(currMaterial);

                        Console.WriteLine($"{legendary} obtained!");
                        canContinue = false;
                        break;
                    }
                }
                else
                {
                    if (!trashDict.ContainsKey(currMaterial))
                    {
                        trashDict[currMaterial] = 0;
                    }

                    trashDict[currMaterial] += currQuantity;
                }
            }
        }

        foreach (var kvp in legendaryDict.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
        {
            var currMat = kvp.Key;
            var currQuantity = kvp.Value;

            Console.WriteLine($"{currMat}: {currQuantity}");
        }

        foreach (var kvp in trashDict.OrderBy(x => x.Key))
        {
            var currMat = kvp.Key;
            var currQuantity = kvp.Value;

            Console.WriteLine($"{currMat}: {currQuantity}");
        }
    }

    private static string GetLegendary(string currMaterial)
    {
        var strToReturn = string.Empty;

        switch (currMaterial)
        {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
        }

        return strToReturn;
    }
}