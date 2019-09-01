using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();

        Console.WriteLine($"Min = {inputList.Min()}");
        Console.WriteLine($"Max = {inputList.Max()}");
        Console.WriteLine($"Sum = {inputList.Sum()}");
        Console.WriteLine($"Average = {inputList.Average()}");
    }
}