using System;

public class Program
{
    public static void Main()
    {
        var literLinesCount = int.Parse(Console.ReadLine());

        var waterTankCapacity = 255;
        var totalWater = 0m;

        for (int i = 0; i < literLinesCount; i++)
        {
            var currentWaterLiters = int.Parse(Console.ReadLine());

            totalWater += currentWaterLiters;

            if (totalWater > waterTankCapacity)
            {
                Console.WriteLine("Insufficient capacity!");
                totalWater -= currentWaterLiters;
            }
        }

        Console.WriteLine(totalWater);
    }
}