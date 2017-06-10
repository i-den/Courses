using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();

        var maxDigit = 0;
        var maxOccurences = 0;

        for (int i = 0; i < inputArr.Length; i++)
        {
            var currAnchorDigit = inputArr[i];
            var currOccurences = 0;

            for (int j = i; j < inputArr.Length; j++)
            {
                var currDigit = inputArr[j];

                if (currAnchorDigit == currDigit)
                {
                    currOccurences++;
                }
            }

            if (currOccurences > maxOccurences)
            {
                maxDigit = currAnchorDigit;
                maxOccurences = currOccurences;
            }
        }

        Console.WriteLine(maxDigit);
    }
}