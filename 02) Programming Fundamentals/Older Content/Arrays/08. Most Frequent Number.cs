using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArray = Console.ReadLine().Split().Select(int.Parse).ToArray();
        int maxNumber = 0;
        int max = 1;

        for (int i = 0 ; i < inputArray.Length; i++)
        {
            int currNumber = 0;

            for (int k = i; k < inputArray.Length; k++)
            {
                if (inputArray[i] == inputArray[k])
                {
                    currNumber++;

                    if (currNumber > maxNumber)
                    {
                        maxNumber = currNumber;
                        max = inputArray[i];
                    }
                }
            }
        }

        Console.WriteLine(max);
    }
}