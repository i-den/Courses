using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var firstNumber = int.Parse(Console.ReadLine());
        var secondNumber = int.Parse(Console.ReadLine());
        var maximumNumber = int.Parse(Console.ReadLine());

        var multiplicationCount = 0;
        var multiplicationResult = 0;

        for (int firstIndex = firstNumber; firstIndex > 0; firstIndex--)
        {
            for (int secondIndex = 1; secondIndex <= secondNumber; secondIndex++)
            {
                var currMultiplication = 3 * firstIndex * secondIndex;
                
                    multiplicationResult += currMultiplication;
                    multiplicationCount++;

                if (multiplicationResult >= maximumNumber)
                {
                    Console.WriteLine($"{multiplicationCount} combinations");
                    Console.WriteLine($"Sum: {multiplicationResult} >= {maximumNumber}");
                    return;
                }
            }
        }

        Console.WriteLine($"{multiplicationCount} combinations");
        Console.WriteLine($"Sum: {multiplicationResult}");
    }
}