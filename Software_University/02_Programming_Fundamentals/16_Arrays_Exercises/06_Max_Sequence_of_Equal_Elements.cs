using System;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split();

        var indexToStart = 0;
        var maximumSequence = 0;

        for (int i = 0; i < inputArr.Length; i++)
        {
            var currentAnchorElement = inputArr[i];
            var currentMaximumSequence = 0;

            for (int j = i; j < inputArr.Length; j++)
            {
                var currentElement = inputArr[j];

                if (currentAnchorElement == currentElement)
                {
                    currentMaximumSequence++;

                    if (currentMaximumSequence > maximumSequence)
                    {
                        maximumSequence = currentMaximumSequence;
                        indexToStart = i;
                    }
                }
                else
                {
                    i = j - 1;
                    break;
                }
            }
        }

        for (int i = indexToStart; i < indexToStart + maximumSequence; i++)
        {
            Console.Write($"{inputArr[i]} ");
        }
    }
}