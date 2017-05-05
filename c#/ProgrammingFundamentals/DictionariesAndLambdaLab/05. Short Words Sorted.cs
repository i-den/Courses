using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var separators = new char[] { '.', ',', ':', ';', '(', ')', '[', ']', '&', '\"', '\'', '\\', '/', '!', '?', ' '};

        var input = Console.ReadLine().ToLower().Split(separators, StringSplitOptions.RemoveEmptyEntries).ToList();

        var resultList = input.Where(x => x.Length < 5).OrderBy(x => x).Distinct();

        Console.WriteLine(string.Join(", ", resultList));
    }
}