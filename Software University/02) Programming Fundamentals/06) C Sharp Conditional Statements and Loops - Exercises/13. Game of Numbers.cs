using System;

public class Program
{
    public static void Main()
    {
        var startingIndex = int.Parse(Console.ReadLine());
        var endingIndex = int.Parse(Console.ReadLine());
        var numberToFind = int.Parse(Console.ReadLine());

        var firstValidNumber = 0;
        var secondValidNumber = 0;
        var valarMorghulis = false;
        var numberOfCombinations = 0;

        for (int firstIndex = startingIndex; firstIndex <= endingIndex; firstIndex++)
        {
            for (int secondIndex = startingIndex; secondIndex <= endingIndex; secondIndex++)
            {
                if (firstIndex + secondIndex == numberToFind)
                {
                    firstValidNumber = firstIndex;
                    secondValidNumber = secondIndex;
                    valarMorghulis = true;
                }

                numberOfCombinations++;
            }
        }

        if (valarMorghulis)
        {
            Console.WriteLine($"Number found! {firstValidNumber} + {secondValidNumber} = {numberToFind}");
        }
        else
        {
            Console.WriteLine($"{numberOfCombinations} combinations - neither equals {numberToFind}");
        }
    }
}