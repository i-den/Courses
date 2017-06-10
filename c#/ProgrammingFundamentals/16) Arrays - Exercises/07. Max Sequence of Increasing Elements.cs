using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();

        var maximumSequence = 0;
        var indexToStart = 0;

        for (int i = 0; i < inputArr.Length; i++)
        {
            var currentAnchorDigit = inputArr[i];
            var currentMaximumSequence = 0;

            for (int j = i; j < inputArr.Length - 1; j++)
            {
                var currentDigit = inputArr[j + 1];

                if (currentDigit - currentAnchorDigit > 0)
                {
                    currentMaximumSequence++;
                    currentAnchorDigit = currentDigit;

                    if (currentMaximumSequence > maximumSequence)
                    {
                        maximumSequence = currentMaximumSequence;
                        indexToStart = i;
                    }
                }
                else
                {
                    i = j;
                    break;
                }
            }
        }

        for (int i = indexToStart; i <= indexToStart + maximumSequence; i++)
        {
            Console.Write($"{inputArr[i]} ");
        }
    }
}