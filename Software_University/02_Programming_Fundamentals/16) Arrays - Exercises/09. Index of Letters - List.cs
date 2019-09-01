using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().ToList();

        foreach (var currChar in inputList.Select(c => (int)c))
        {
            Console.WriteLine($"{(char)(currChar)} -> {currChar - 'a'}");
        }
    }
}