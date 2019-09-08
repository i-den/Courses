using System;
using System.Text.RegularExpressions;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var email = Console.ReadLine();
        var matches = Regex.Matches(email, @"(?<left>.*?)@(?<right>.*)");

        var left = GetSideSum("left", matches);
        var right = GetSideSum("right", matches);

        Console.WriteLine(right <= left ? "Call her!" : "She is not the one.");
    }

    public static int GetSideSum(string side, MatchCollection matches)
    {
        return string.Join(string.Empty, matches
             .Cast<Match>()
             .Select(match => match.Groups[side].Value)
             .ToArray())
             .ToCharArray()
             .Sum(c => c);
    }
}
