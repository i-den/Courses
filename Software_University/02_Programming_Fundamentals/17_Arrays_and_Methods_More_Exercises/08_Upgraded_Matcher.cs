using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var materialsArray = Console.ReadLine().Split();
        var materialsQuantityArr = Console.ReadLine().Split().Select(long.Parse).ToArray();
        var materialsPriceArr = Console.ReadLine().Split().Select(double.Parse).ToArray();

        while (true)
        {
            var materialAndQuantityToQuery = Console.ReadLine().Split();

            if (materialAndQuantityToQuery[0] == "done")
            {
                break;
            }

            var materialToQuery = materialAndQuantityToQuery[0];
            var materialQuantityToQuery = long.Parse(materialAndQuantityToQuery[1]);

            var materialIndex = Array.IndexOf(materialsArray, materialToQuery);
            var currentMaterialQuantityLeft = 0L;

            try
            {
                currentMaterialQuantityLeft = materialsQuantityArr[materialIndex] - materialQuantityToQuery;
            }
            catch (Exception)
            {
                Console.WriteLine($"We do not have enough {materialToQuery}");
                continue;
            }

            if (currentMaterialQuantityLeft >= 0)
            {
                var materialCurrentPrice = materialQuantityToQuery * materialsPriceArr[materialIndex];

                Console.WriteLine($"{materialToQuery} x {materialQuantityToQuery} costs {materialCurrentPrice:F2}");

                materialsQuantityArr[materialIndex] -= materialQuantityToQuery;
            }
            else
            {
                Console.WriteLine($"We do not have enough {materialToQuery}");
            }
        }

    }
}