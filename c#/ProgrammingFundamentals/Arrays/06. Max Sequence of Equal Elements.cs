using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        int[] inputArray = Console.ReadLine().Split().Select(int.Parse).ToArray();

        int startingIndex = 0;
        int maxSequence = int.MinValue;

        for (int currStartIndex = 0; currStartIndex < inputArray.Length; currStartIndex++)
        {
            int currentSequence = 1;

            for (int innerSeqIndex = currStartIndex + 1; innerSeqIndex < inputArray.Length; innerSeqIndex++)
            {
                if (inputArray[currStartIndex] == inputArray[innerSeqIndex])
                {
                    currentSequence++;

                    if (currentSequence > maxSequence)
                    {
                        maxSequence = currentSequence;
                        startingIndex = currStartIndex;
                    }
                }
                else
                {
                    break;
                }
            }
        }

        for (int i = startingIndex; i < startingIndex + maxSequence; i++)
        {
            Console.Write("{0} ", inputArray[i]);
        }
    }
}