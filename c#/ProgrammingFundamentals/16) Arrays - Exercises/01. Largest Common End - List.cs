using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var firstList = Console.ReadLine().Split().ToList();
        var secList = Console.ReadLine().Split().ToList();

        var minCount = firstList.Count > secList.Count ? secList.Count : firstList.Count;

        var leftSum = GetSidesSum(firstList, secList, minCount);
        
        firstList.Reverse();
        secList.Reverse();

        var rightSum = GetSidesSum(firstList, secList, minCount);

        Console.WriteLine(leftSum > rightSum ? leftSum : rightSum);
    }

    public static int GetSidesSum(List<string> firstList, List<string> secList, int minCount)
    {
        var currentSideSum = 0;

        for (int i = 0; i < minCount; i++)
        {
            if (firstList[i] == secList[i])
            {
                currentSideSum++;
            }
            else
            {
                break;
            }
        }

        return currentSideSum;
    }
}