using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();
        var shiftsCount = int.Parse(Console.ReadLine());

        var resultsArr = new int[inputArr.Length];

        for (int currentShift = 0; currentShift < shiftsCount; currentShift++)
        {
            var lastArrDigit = inputArr.Last();

            for (int i = inputArr.Length - 1; i > 0; i--)
            {
                inputArr[i] = inputArr[i - 1];
            }

            inputArr[0] = lastArrDigit;

            for (int i = 0; i < inputArr.Length; i++)
            {
                resultsArr[i] += inputArr[i];
            }
        }

        Console.WriteLine(string.Join(" ", resultsArr));
    }
}