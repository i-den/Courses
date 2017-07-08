using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    public static void Main()
    {
        var coffeeOrders = int.Parse(Console.ReadLine());
        var totalPrize = 0M;


        for (int i = 0; i < coffeeOrders; i++)
        {
            var pricePerCapsule = decimal.Parse(Console.ReadLine());
            var startDate = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
            var capsulesCount = decimal.Parse(Console.ReadLine());

            var daysInMonth = DateTime.DaysInMonth(startDate.Year, startDate.Month);
            var totalPrice = daysInMonth * capsulesCount * pricePerCapsule;
            totalPrize += totalPrice;
            Console.WriteLine($"The price for the coffee is: ${totalPrice:F2}");
        }

        Console.WriteLine($"Total: ${totalPrize:F2}");
    }
}