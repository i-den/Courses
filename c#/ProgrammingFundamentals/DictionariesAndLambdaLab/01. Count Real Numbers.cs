using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myDict = new SortedDictionary<double, int>();

        var inputArray = Console.ReadLine().Split().Select(double.Parse).ToArray();

        foreach (var number in inputArray)
        {
            if (!myDict.ContainsKey(number))
            {
                myDict[number] = 0;
            }

            myDict[number]++;
        }

        foreach (var pair in myDict)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value}");
        }
    }
}