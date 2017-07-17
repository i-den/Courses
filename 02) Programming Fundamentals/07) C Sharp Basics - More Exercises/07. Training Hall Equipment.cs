using System;

public class Program
{
    public static void Main()
    {
        var budget = double.Parse(Console.ReadLine());
        var subtotal = 0D;
        var numberOfEquippment = int.Parse(Console.ReadLine());

        for (int i = 0; i < numberOfEquippment; i++)
        {
            var currentItemName = Console.ReadLine();
            var currentItemPrice = double.Parse(Console.ReadLine());
            var currentItemCount = int.Parse(Console.ReadLine());

            var currentExpense = currentItemPrice * currentItemCount;

            if (currentItemCount > 1)
            {
                currentItemName += "s";
            }

            Console.WriteLine($"Adding {currentItemCount} {currentItemName} to cart.");
            subtotal += currentExpense;
        }

        var currentBalance = budget - subtotal;

        Console.WriteLine($"Subtotal: ${subtotal:F2}");

        if (currentBalance >= 0)
        {
            Console.WriteLine($"Money left: ${currentBalance:F2}");
        }
        else
        {
            Console.WriteLine($"Not enough. We need ${Math.Abs(currentBalance):F2} more.");
        }
    }
}