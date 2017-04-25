using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArray = Console.ReadLine().Split().Select(int.Parse).ToArray();
        int numberDifference = int.Parse(Console.ReadLine());

        int maxDifference = 0;

        for (int i = 0; i < inputArray.Length; i++)
        {
            for (int j = i + 1; j < inputArray.Length; j++)
            {
                if (Math.Abs(inputArray[i] - inputArray[j]) == numberDifference)
                {
                    maxDifference++;
                }
            }
        }

        Console.WriteLine(maxDifference);
    }
}