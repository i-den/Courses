using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArray = Console.ReadLine().Split().Select(int.Parse).ToArray();

        int maxSeq = int.MinValue;
        int startIndex = 0;

        GetMaxSeqandIndex(inputArray, ref maxSeq, ref startIndex);

        PrintSeqArray(inputArray, maxSeq, startIndex);
    }

    public static void PrintSeqArray(int[] inputArray, int maxSeq, int startIndex)
    {
        for (int i = startIndex; i < startIndex + maxSeq; i++)
        {
            Console.Write("{0} ", inputArray[i]);
        }
    }

    private static void GetMaxSeqandIndex(int[] inputArray, ref int maxSeq, ref int startIndex)
    {
        for (int i = 0; i < inputArray.Length; i++)
        {
            int currSeq = 1;
            int k = i;

            for (int j = i + 1; j < inputArray.Length; j++)
            {
                if (inputArray[j] - inputArray[k] >= 1)
                {
                    currSeq++;
                    k++;

                    if (currSeq > maxSeq)
                    {
                        maxSeq = currSeq;
                        startIndex = i;
                    }
                }
                else
                {
                    break;
                }
            }
        }
    }
}