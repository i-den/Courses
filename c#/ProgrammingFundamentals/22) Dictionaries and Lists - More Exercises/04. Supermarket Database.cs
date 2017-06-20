using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var prodPrice = new Dictionary<string, double>();
        var prodQuantity = new Dictionary<string, long>();

        while (true)
        {
            var input = Console.ReadLine().Split();

            if (input[0] == "stocked")
            {
                break;
            }

            var currProd = input[0];
            var currPrice = double.Parse(input[1]);
            var currQuantity = long.Parse(input[2]);

            if (!prodQuantity.ContainsKey(currProd))
            {
                prodQuantity[currProd] = 0L;
            }

            if (!prodPrice.ContainsKey(currProd))
            {
                prodPrice[currProd] = currPrice;
            }

            prodQuantity[currProd] += currQuantity;
            prodPrice[currProd] = currPrice;
        }

        foreach (var kvp in prodQuantity)
        {
            var currProdName = kvp.Key;
            var currQuantity = kvp.Value;
            var currPrice = prodPrice[currProdName];

            Console.WriteLine($"{currProdName}: ${currPrice:F2} * {currQuantity} = ${(currPrice * currQuantity):F2}");
        }

        var totalSum = prodPrice.Zip(prodQuantity, (x, y) => x.Value * y.Value).ToList().Sum();
        Console.WriteLine("------------------------------");
        Console.WriteLine($"Grand Total: ${totalSum:F2}");
    }
}