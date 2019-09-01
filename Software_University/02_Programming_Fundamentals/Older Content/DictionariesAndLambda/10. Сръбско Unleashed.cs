using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class Program
{
    static void Main()
    {
        var singerVenueList = new Dictionary<string, Dictionary<string, int>>();
        var canContinue = true;

        while (canContinue)
        {
            string input = Console.ReadLine();

            if (input == "End")
            {
                canContinue = false;
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

                if (!singerVenueList.ContainsKey(venue))
                {
                    singerVenueList[venue] = new Dictionary<string, int>();
                }

                if (!singerVenueList[venue].ContainsKey(singer))
                {
                    singerVenueList[venue][singer] = 0;
                }

                singerVenueList[venue][singer] += totalMoney;
            }
        }

        foreach (var venueSingerPair in singerVenueList)
        {
            var currentVenue = venueSingerPair.Key;
            var currentVenueData = venueSingerPair.Value;

            Console.WriteLine(currentVenue);

            foreach (var singerMoneyPair in currentVenueData.OrderByDescending(x => x.Value))
            {
                Console.WriteLine("#  {0} -> {1}", singerMoneyPair.Key, singerMoneyPair.Value);
            }
        }
    }
}
