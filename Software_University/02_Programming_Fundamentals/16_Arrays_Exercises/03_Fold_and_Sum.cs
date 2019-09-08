using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArray = Console.ReadLine().Split().Select(int.Parse).ToArray();
        var divNum = inputArray.Length / 4;

        var leftArr = new int[divNum];
        var rightArr = new int[divNum];
        var midArr = new int[divNum * 2];
        var leftAndRightArr = new int[leftArr.Length + rightArr.Length];
        var resultsArr = new int[divNum * 2];

        for (int i = divNum - 1, j = 0; i >= 0; i--, j++)
        {
            leftArr[j] = inputArray[i];
        }

        for (int i = inputArray.Length - 1, j =0; i >= inputArray.Length - divNum; i--, j++)
        {
            rightArr[j] = inputArray[i];
        }

        for (int i = divNum, j = 0; i < inputArray.Length - divNum; i++, j++)
        {
            midArr[j] = inputArray[i];
        }

        for (int i = 0, j = 0, k = 0; i < leftAndRightArr.Length; i++)
        {
            if (i < leftArr.Length)
            {
                leftAndRightArr[i] = leftArr[j];
                j++;
            }
            else
            {
                leftAndRightArr[i] = rightArr[k];
                k++;
            }
        }

        for (int i = 0; i < resultsArr.Length; i++)
        {
            resultsArr[i] = midArr[i] + leftAndRightArr[i]; 
        }

        Console.WriteLine(string.Join(" ", resultsArr));
    }
}