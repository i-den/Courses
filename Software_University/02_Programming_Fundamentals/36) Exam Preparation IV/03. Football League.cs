using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        var textToMatch = Console.ReadLine();
        var countryPtsDict = new Dictionary<string, int>();
        var countryGoalsDict = new Dictionary<string, int>();

        while (true)
        {
            var currentInput = Console.ReadLine().Split(); ;

            if (currentInput[0] == "final")
            {
                break;
            }

            var currFirstCountry = GetCountryName(currentInput[0], textToMatch);
            var currSecondCountry = GetCountryName(currentInput[1], textToMatch);

            var firstCountryGoals = int.Parse(currentInput[2].Split(':')[0]);
            var secondCountryGoals = int.Parse(currentInput[2].Split(':')[1]);

            if (firstCountryGoals == secondCountryGoals)
            {
                AddScore(countryPtsDict, currFirstCountry, 1);
                AddScore(countryPtsDict, currSecondCountry, 1);
            }
            else if (firstCountryGoals > secondCountryGoals)
            {
                AddScore(countryPtsDict, currFirstCountry, 3);
                AddScore(countryPtsDict, currSecondCountry, 0);
            }
            else
            {
                AddScore(countryPtsDict, currFirstCountry, 0);
                AddScore(countryPtsDict, currSecondCountry, 3);
            }

            AddScore(countryGoalsDict, currFirstCountry, firstCountryGoals);
            AddScore(countryGoalsDict, currSecondCountry, secondCountryGoals);
        }

        Console.WriteLine("League standings:");
        var currStand = 1;

        foreach (var kvp in countryPtsDict.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
        {
            var currCountry = kvp.Key;
            var currCountryPts = kvp.Value;

            Console.WriteLine($"{currStand}. {currCountry} {currCountryPts}");

            currStand++;
        }

        Console.WriteLine("Top 3 scored goals:");
        foreach (var kvp in countryGoalsDict.OrderByDescending( x => x.Value).ThenBy(x => x.Key).Take(3))
        {
            var currCountry = kvp.Key;
            var currCountryGoals = kvp.Value;

            Console.WriteLine($"- {currCountry} -> {currCountryGoals}");
        }
    }

    public static void AddScore(Dictionary<string, int> currDict, string currCountry, int score)
    {
        if (!currDict.ContainsKey(currCountry))
        {
            currDict[currCountry] = 0;
        }

        currDict[currCountry] += score;
    }

    public static string GetCountryName(string str, string textToMatch)
    {
        var firstIndex = str.IndexOf(textToMatch)+textToMatch.Length;
        var lastIndex = str.LastIndexOf(textToMatch);
        var substringLength = lastIndex - firstIndex;

        str = str.Substring(firstIndex, substringLength).ToUpper();
        return string.Join("", str.Reverse());
    }
}