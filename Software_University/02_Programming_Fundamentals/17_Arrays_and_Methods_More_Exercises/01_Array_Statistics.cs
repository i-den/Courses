using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();

        var minValue = int.MaxValue;
        var maxValue = int.MinValue;
        var sum = 0;
        var averageValue = 0D;

        for (int i = 0; i < inputArr.Length; i++)
        {
            var currentNum = inputArr[i];

            if (currentNum >= maxValue)
            {
                maxValue = currentNum;
            }

            if (currentNum <= minValue)
            {
                minValue = currentNum;
            }

            sum += currentNum;
        }

        averageValue = sum / (double)inputArr.Length;

        Console.WriteLine($"Min = {minValue}");
        Console.WriteLine($"Max = {maxValue}");
        Console.WriteLine($"Sum = {sum}");
        Console.WriteLine($"Average = {averageValue}");
    }
}