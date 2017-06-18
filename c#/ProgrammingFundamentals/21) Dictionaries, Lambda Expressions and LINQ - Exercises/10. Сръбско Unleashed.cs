using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;


class Problem4
{
    static void Main()
    {
        var dict = new Dictionary<string, Dictionary<string, int>>();

        while (true)
        {
            string input = Console.ReadLine();

            if (input == "End")
            {
                break;
            }

            string correctInputPattern = @"(([a-zA-Z]+\s){1,3})@(([a-zA-Z]+\s){1,3})(\d+)\s(\d+)";

            if (Regex.IsMatch(input, correctInputPattern))
            {
                Match match = Regex.Match(input, correctInputPattern);

                string singer = match.Groups[1].Value.Trim();
                string venue = match.Groups[3].Value.Trim();
                int ticketsPrice = int.Parse(match.Groups[5].Value);
                int ticketsCount = int.Parse(match.Groups[6].Value);

                int totalMoney = ticketsCount * ticketsPrice;

                if (!dict.ContainsKey(venue))
                {
                    dict[venue] = new Dictionary<string, int>();
                }
                if (!dict[venue].ContainsKey(singer))
                {
                    dict[venue][singer] = 0;
                }

                dict[venue][singer] += totalMoney;
            }
        }

        foreach (var pair in dict)
        {
            var venueName = pair.Key;

            Console.WriteLine($"{venueName}");

            foreach (var singerMoneyPair in pair.Value.OrderByDescending(x => x.Value))
            {
                Console.WriteLine("#  {0} -> {1}", singerMoneyPair.Key, singerMoneyPair.Value);
            }
        }
    }
}