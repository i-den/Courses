using System;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var startAndEndMatches = 
            Regex.Match(Console.ReadLine(), 
            @"^(?<start>[a-zA-Z]+(?=\<|\\|\|))[<\\|].*[<\\|](?<=\<|\\|\|)(?<end>[a-zA-Z]+)");

        var inputText = Console.ReadLine();

        var start = startAndEndMatches.Groups["start"].Value;
        var end = startAndEndMatches.Groups["end"].Value;
        var regexPattern = $"{start}" + @"(.*?)" + $"{end}";

        var matches = Regex.Matches(inputText, regexPattern)
            .Cast<Match>()
            .Select(m => m.Groups[1].Value)
            .Where(m => m != string.Empty)
            .ToArray();
        
        Console.WriteLine(matches.Any() ? string.Join(string.Empty, matches) : "Empty result");
    }
}