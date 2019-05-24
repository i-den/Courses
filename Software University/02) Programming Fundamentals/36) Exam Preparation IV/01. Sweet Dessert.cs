using System;

public class Program
{
    public static void Main()
    {
        var currentBudget = decimal.Parse(Console.ReadLine());
        var numberOfGuests = long.Parse(Console.ReadLine());
        var pricePerBanana = decimal.Parse(Console.ReadLine());
        var pricePerEgg = decimal.Parse(Console.ReadLine());
        var pricePerBerries = decimal.Parse(Console.ReadLine());

        var portionsToCook = (decimal)Math.Ceiling((numberOfGuests / 6.0)) * 6;

        var totalSets = portionsToCook / 6;
        var totalBananaPrice = 2 * pricePerBanana;
        var totalEggPrice = 4 * pricePerEgg;
        var totalBerriesPrice = 0.2m * pricePerBerries;

        var moneyToSpend = totalSets * (totalBananaPrice + totalEggPrice + totalBerriesPrice);

        var currentBalance = currentBudget - (decimal)moneyToSpend;

        if (currentBalance >= 0)
        {
            Console.WriteLine($"Ivancho has enough money - it would cost {moneyToSpend:F2}lv.");
        }
        else
        {
            Console.WriteLine($"Ivancho will have to withdraw money - he will need {Math.Abs(currentBalance):F2}lv more.");
        }
    }
}