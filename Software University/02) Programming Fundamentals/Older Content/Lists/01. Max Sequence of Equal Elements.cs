using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();

        int biggestLength = 0;
        int indexAnchor = 0;

        for (int outerCycleIndex = 0; outerCycleIndex < inputList.Count; outerCycleIndex++)
        {
            int currentBiggestLength = 0;

            for (int innerCycleIndex = outerCycleIndex; innerCycleIndex < inputList.Count; innerCycleIndex++)
            {
                if (inputList[outerCycleIndex] == inputList[innerCycleIndex])
                {
                    currentBiggestLength++;

                    if (biggestLength < currentBiggestLength)
                    {
                        biggestLength = currentBiggestLength;
                        indexAnchor = outerCycleIndex;
                    }
                }
                else
                {
                    break;
                }
            }
        }

        for (int i = indexAnchor; i < indexAnchor + biggestLength; i++)
        {
            Console.Write(inputList[i] + " ");
        }
    }
}