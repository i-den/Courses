using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        var demonsList = Console.ReadLine()
            .Split(',')
            .Select(d => d.Trim())
            .ToList();

        var demonStatsList = new Dictionary<string, decimal[]>();

        foreach (var currentDemon in demonsList)
        {
            var currentDemonHealth = GetDemonHealth(currentDemon);
            var currentDemonDamage = GetDemonDamage(currentDemon);

            demonStatsList.Add(currentDemon, new decimal[2]);
            demonStatsList[currentDemon][0] = currentDemonHealth;
            demonStatsList[currentDemon][1] = currentDemonDamage;
        }

        foreach (var demonStatsPair in demonStatsList.OrderBy(a => a.Key))
        {
            var currentDemonName = demonStatsPair.Key;
            var currentDemonStats = demonStatsPair.Value;
            var currentDemonHealth = currentDemonStats[0];
            var currentDemonDamage = currentDemonStats[1];

            Console.WriteLine($"{currentDemonName} - {currentDemonHealth} health, {currentDemonDamage:F2} damage");
        }
    }

    public static decimal GetDemonHealth(string currentDemon)
    {
        var demonHealth = 0M;
        var findCharactersRegex = new Regex(@"[^\d\.\+\-\*\/\s\,]");
        var demonName = string.Join(string.Empty, findCharactersRegex.Matches(currentDemon)
            .Cast<Match>()
            .Select(w => w.Value));

        foreach (var nameCharacter in demonName)
        {
            demonHealth += (int)nameCharacter;
        }

        return demonHealth;
    }

    public static decimal GetDemonDamage(string currentDemon)
    {
        var findNumbersRegex = new Regex(@"[\+\-]*[0-9.]+[0-9]*");
        var demonDamage = findNumbersRegex.Matches(currentDemon)
            .Cast<Match>()
            .Select(m => decimal.Parse(m.Value))
            .ToArray()
            .Sum();

        foreach (var currentCharInName in currentDemon.Where(c => c == '*' || c == '/'))
        {
            if (currentCharInName == '*')
            {
                demonDamage *= 2;
            }
            else if (currentCharInName == '/')
            {
                demonDamage /= 2;
            }
        }

        return demonDamage;
    }
}