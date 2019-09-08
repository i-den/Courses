using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(long.Parse).ToList();

        var jewelsPrice = inputList.First();
        var goldPrice = inputList.Skip(1).First();
        var heistList = new List<string>();

        while (true)
        {
            var currentLootAndExpenses = Console.ReadLine().Split();

            if (currentLootAndExpenses[0] == "Jail")
            {
                break;
            }

            var currentLoot = currentLootAndExpenses[0];
            var currentExpense = currentLootAndExpenses[1];

            heistList.Add(currentLoot);
            heistList.Add(currentExpense);
        }

        var jewelsCount = GetLootCount(heistList, '%');
        var goldCount = GetLootCount(heistList, '$');

        var totalProfit = jewelsCount * jewelsPrice + goldPrice * goldCount;

        var totalExpense = heistList
            .Where((x, index) => index % 2 == 1)
            .Select(long.Parse)
            .ToList()
            .Sum();

        var totalEarnings = totalProfit - totalExpense;

        if (totalEarnings >= 0)
        {
            Console.WriteLine($"Heists will continue. Total earnings: {totalEarnings}.");
        }
        else
        {
            Console.WriteLine($"Have to find another job. Lost: {Math.Abs(totalEarnings)}.");
        }
    }

    public static int GetLootCount(List<string> heistList, char currLoot)
    {
        return heistList
            .Where((x, index) => index % 2 == 0)
            .ToList()
            .ToArray()
            .SelectMany(x => x.ToCharArray())
            .ToArray()
            .Where( x => x == currLoot)
            .ToList()
            .Count();
    }
}