using System;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    public static void Main()
    {
        var demons = Console.ReadLine()
            .Split(new[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(currDemon => new Demon
            {
                Name = currDemon
            })
            .OrderBy(currDemon => currDemon.Name)
            .ToList();

        demons.ForEach(currDemon => currDemon.PrintStats());
    }
}

internal class Demon
{
    public string Name { get; set; }

    public decimal Health => GetDemonHealth(Name);

    public decimal Damage => GetDemonDamage(Name);

    public void PrintStats()
    {
        Console.WriteLine($"{Name} - {Health} health, {Damage:F2} damage ");
    }

    private decimal GetDemonHealth(string demonName)
    {
        return Regex.Matches(demonName, @"[^0-9+\-\*\/.]")
            .Cast<Match>()
            .Select(nameCharMatch => nameCharMatch.Value)
            .Select(nameChar => (int)char.Parse(nameChar))
            .ToArray()
            .Sum();
    }

    private decimal GetDemonDamage(string demonName)
    {
        var demonDamage = 0M;

        demonDamage = Regex.Matches(demonName, @"[\+\-]*[0-9.]+[0-9]*")
         .Cast<Match>()
         .Select(nameDigitMatch => nameDigitMatch.Value)
         .Select(nameDigit => decimal.Parse(nameDigit))
         .ToArray()
         .Sum();

        foreach (var currChar in demonName
            .Where(demonNameChar => demonNameChar == '*'))
        {
            demonDamage *= 2;
        }
        foreach (var currChar in demonName
            .Where(demonNameChar => demonNameChar == '/'))
        {
            demonDamage /= 2;
        }

        return demonDamage;
    }
}