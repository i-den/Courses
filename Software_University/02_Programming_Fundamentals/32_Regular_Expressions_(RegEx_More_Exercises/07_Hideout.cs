using System;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var map = Console.ReadLine();
        var indexOfTheFirstChar = 0;
        var lengthOfTheFoundString = 0;
        var escapedRegexCharacters = new []
        {
            '.', '\\', '+', '*', '?', '^', '$', '[', ']', '{', '}', '(', ')', '|', '/'
        };

        while (true)
        {
            var currInput = Console.ReadLine().Split();
            var symbol = currInput[0];
            var symbolIndex = char.Parse(symbol);
            var count = int.Parse(currInput[1]);

            if (escapedRegexCharacters.Contains(char.Parse(symbol)))
            {
                symbol = @"\" + symbol;
            }

            var regexPattern = $"[{symbol}]" + $"{{{count},}}";

            if (Regex.IsMatch(map, regexPattern))
            {
                indexOfTheFirstChar = map.IndexOf(new string(symbolIndex, count));
                lengthOfTheFoundString = Regex.Match(map, regexPattern).Value.Length;
                break;
            }
        }

        Console.WriteLine($"Hideout found at index {indexOfTheFirstChar} and it is with size {lengthOfTheFoundString}!");
    }
}