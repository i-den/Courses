using System;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var input = Console.ReadLine();

        while (Regex.IsMatch(input, @"\<[a-zA-Z]{2}\>"))
        {
            var match = Regex.Match(input, @"\<(?<first>[a-zA-Z])(?<second>[a-zA-Z])\>");

            var firstPow = (int)char.Parse(match.Groups["first"].Value);
            var secPow = (int)char.Parse(match.Groups["second"].Value);
            var totalPow = Math.Abs(firstPow - secPow);

            var pattern = @".{0," + $"{totalPow}" + @"}\<([a-zA-Z])([a-zA-Z])\>.{0," + $"{totalPow}" + "}";
            var matchz = Regex.Match(input, pattern);
            input = input.Replace(matchz.Value, new string('_', matchz.Length));
        }

        Console.WriteLine(input);
    }
}