using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var input = Console.ReadLine().Split();
        var numDict = new Dictionary<string, List<string>>();

        foreach (var kvp in input)
        {
            var tokens = kvp.Split(':');

            if (!numDict.ContainsKey(tokens[0]))
            {
                numDict[tokens[0]] = new List<string>();
                    }

            numDict[tokens[0]].Add(tokens[1]);
        }
        var listToPrint = new List<string>();

        foreach (var kvp in numDict.OrderBy(x => x.Key))
        {

            foreach (var item in kvp.Value.OrderBy(x => x))
            {
                listToPrint.Add(kvp.Key + ":" + item);
            }
        }

        Console.WriteLine(string.Join(", ", listToPrint));
    }
}