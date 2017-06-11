using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var prices = Console.ReadLine().Split().Select(int.Parse).ToArray();

        var jewelsPrice = prices[0];
        var goldPrice = prices[1];
        var earnings = 0L;
        var expenditure = 0L;

        while (true)
        {
            var currentLootAndExpenses = Console.ReadLine().Split();

            if (currentLootAndExpenses[0] == "Jail")
            {
                break;
            }

            var currentLoot = currentLootAndExpenses[0];
            var currentExpense = int.Parse(currentLootAndExpenses[1]);

            var currentLootProfit = GetCurrentLootProfit(currentLoot, jewelsPrice, goldPrice);

            earnings += currentLootProfit;
            expenditure += currentExpense;
        }

        var totalEarnings = earnings - expenditure;

        if (totalEarnings >= 0)
        {
            Console.WriteLine($"Heists will continue. Total earnings: {totalEarnings}.");
        }
        else
        {
            Console.WriteLine($"Have to find another job. Lost: {Math.Abs(totalEarnings)}.");
        }
    }

    private static long GetCurrentLootProfit(string currentLoot, int jewelsPrice, int goldPrice)
    {
        var profitToReturn = 0L;

        foreach (var currChar in currentLoot)
        {
            profitToReturn += currChar == '%' ? jewelsPrice : 0;
            profitToReturn += currChar == '$' ? goldPrice : 0;
        }

        return profitToReturn;
    }
}