using System;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var tickets = Console.ReadLine()
            .Split(new[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(ticket => ticket.Trim())
            .ToArray();

        foreach (var ticket in tickets)
        {
            var leftSide = string.Join(string.Empty, ticket.Take(10));
            var rightSide = string.Join(string.Empty, ticket.Skip(10).Take(10));

            if (ticket.Length != 20)
            {
                Console.WriteLine($"invalid ticket");
            }
            else if (Regex.IsMatch(ticket, @"(\@{20}|\${20}|\^{20}|\#{20})"))
            {
                Console.WriteLine($"ticket \"{ticket}\" - 10$ Jackpot!");
            }
            else if (Regex.IsMatch(leftSide, @"(?<symbol>\^{6,10}|\#{6,10}|\@{6,10}|\${6,10})"))
            {
                var leftMatch = Regex.Match(leftSide, @"(?<symbol>\^{6,10}|\#{6,10}|\@{6,10}|\${6,10})");
                var stringToMatch = leftMatch.Value;
                var symbol = stringToMatch.First();
                var rightSidePattern = $"\\{symbol}{{6,10}}";

                if (Regex.IsMatch(rightSide, rightSidePattern))
                {
                    var leftLen = stringToMatch.Length;
                    var rightLen = Regex.Match(rightSide, rightSidePattern).Value.Length;
                    var len = rightLen >= leftLen ? leftLen : rightLen;
                    Console.WriteLine($"ticket \"{ticket}\" - {len}{stringToMatch.First()}");
                }
                else
                {
                    Console.WriteLine($"ticket \"{ticket}\" - no match");
                }
            }
            else
            {
                Console.WriteLine($"ticket \"{ticket}\" - no match");
            }
        }
    }
}