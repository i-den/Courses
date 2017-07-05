using System;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        var input = Console.ReadLine().Split('|').ToArray();
        var output = new StringBuilder();

        foreach (var currCode in input)
        {
            var onesCount = GetCount('1', 5, currCode);
            var zeroesCount = GetCount('0', 3, currCode);

            var consecZeroes = GetConsecutiveCount(currCode, '0');
            var consecOnes = GetConsecutiveCount(currCode, '1');

            var sum = onesCount + zeroesCount + consecZeroes + consecOnes;

            output.Append((char)sum);
        }

        Console.WriteLine(output);
    }

    public static long GetCount(char ch, int num, string currCode)
    {
        return currCode
                .Where(c => c == ch)
                .ToArray()
                .Length * num;
    }

    public static long GetConsecutiveCount(string currCode, char ch)
    {
        var pattern = $"{ch}" + @"{2,}";

        return string.Join(string.Empty, Regex.Matches(currCode, pattern)
            .Cast<Match>()
            .Select(m => m.Value)
            .ToArray())
            .ToCharArray()
            .Length;
    }
}