using System;
using System.Linq;

public class FoldAndSum
{
    public static void Main()
    {
        var inputArray = Console.ReadLine().Split().Select(int.Parse).ToArray();
        int sidesLength = inputArray.Length / 4;
        int middleLength = inputArray.Length / 2;

        var leftSideArray = GetArray(0, sidesLength, inputArray, 4);
        var rightSideArray = GetArray(sidesLength + middleLength, inputArray.Length, inputArray, 4);
        var middleArray = GetArray(sidesLength, inputArray.Length - sidesLength, inputArray, 2);

        Array.Reverse(leftSideArray);
        Array.Reverse(rightSideArray);

        var foldedArray = JoinArrays(leftSideArray, rightSideArray);

        var summedArray = GetSumOfArrays(middleArray, foldedArray);

        Console.WriteLine(string.Join(" ", summedArray));
    }

    public static int[] GetArray(int start, int end, int[] intArray, int div)
    {
        int[] currArray = new int[intArray.Length / div];

        for (int i = start, a = 0; i < end; i++, a++)
        {
            currArray[a] = intArray[i];
        }

        return currArray;
    }

    public static int[] JoinArrays(int[] leftKArray, int[] rightKArray)
    {
        int[] currArray = new int[leftKArray.Length + rightKArray.Length];

        for (int i = 0; i < leftKArray.Length; i++)
        {
            currArray[i] = leftKArray[i];
        }

        for (int i = currArray.Length - leftKArray.Length, a = 0; i < currArray.Length; i++, a++)
        {
            currArray[i] = rightKArray[a];
        }

        return currArray;
    }

    public static int[] GetSumOfArrays(int[] midKArray, int[] intArrayTwo)
    {
        int[] currArray = new int[midKArray.Length];

        for (int i = 0; i < currArray.Length; i++)
        {
            currArray[i] = midKArray[i] + intArrayTwo[i];
        }

        return currArray;
    }
}