using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myDict = new Dictionary<string, long>();
        var canContinue = true;

        while (canContinue)
        {
            var input = Console.ReadLine();

            if (input == "stop")
            {
                canContinue = false;
                break;
            }

            var currentResource = input;
            var currentQuantity = int.Parse(Console.ReadLine());

            if (!myDict.ContainsKey(currentResource))
            {
                myDict[currentResource] = 0;
            }

                myDict[currentResource] += currentQuantity;
        }
        
        foreach (var pair in myDict)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value}");
        }
    }
}