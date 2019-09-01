using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        var input = Console.ReadLine().ToUpper();
        var regex = new Regex(@"(\D+)(\d+)");
        var sb = new StringBuilder();

        var matches = regex.Matches(input);

        foreach (Match item in matches)
        {
            var currentNumber = int.Parse(item.Groups[2].ToString());
            var currString = item.Groups[1].ToString();

            for (int i = 0; i < currentNumber; i++)
            {
                sb.Append(currString);
            }
        }

        var count = sb.ToString().Distinct().Count();
        Console.WriteLine($"Unique symbols used: {count}");
        Console.WriteLine(sb);
    }
}