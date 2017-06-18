using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var resourceDict = new Dictionary<string, int>();

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "stop")
            {
                break;
            }

            var currResource = input;
            var currQuantity = int.Parse(Console.ReadLine());

            if (!resourceDict.ContainsKey(currResource))
            {
                resourceDict[currResource] = 0;
            }

            resourceDict[currResource] += currQuantity;
        }

        foreach (var kvp in resourceDict)
        {
            var currResource = kvp.Key;
            var currResourceQuantity = kvp.Value;

            Console.WriteLine($"{currResource} -> {currResourceQuantity}");
        }
    }
}