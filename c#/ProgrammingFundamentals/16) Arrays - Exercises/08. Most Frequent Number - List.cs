using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();

        var mostFrequentDigit = inputList.GroupBy(a => a)
            .OrderByDescending(a => a.Count())
            .Select(a => a.Key)
            .First();

        Console.WriteLine(mostFrequentDigit);
    }
}