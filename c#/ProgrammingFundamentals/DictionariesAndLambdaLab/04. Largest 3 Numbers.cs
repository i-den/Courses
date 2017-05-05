using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        Console.WriteLine(string.Join(" ", Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToList<int>()
            .OrderByDescending(x => x)
            .Take(3)));
    }
}