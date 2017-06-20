using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var chars = Console.ReadLine()
            .Split()
            .Where(x => x.Length == 2)
            .Select(x => string.Join("",x.Skip(1).Concat(x.Take(1))))
            .ToList();

        chars.Reverse();

        foreach (var item in chars)
        {
            Console.Write($"{(char)Convert.ToInt32(item, 16)}");
        }
    }
}