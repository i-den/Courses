using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArray = Console.ReadLine().Split().Select(int.Parse).ToArray();
        bool isFound = false;
        
        for (int i = 0; i < inputArray.Length; i++)
        {
            int leftSum = GetSum(0, i, inputArray);
            int rightSum = GetSum(i + 1, inputArray.Length, inputArray);

            if (leftSum == rightSum)
            {
                Console.WriteLine(i);
                isFound = true;
                break;
            }
        }

        if (!isFound)
        {
            Console.WriteLine("no");
        }
    }

    private static int GetSum(int start, int end, int[] inputArray)
    {
        int sum = 0;

        for (int i = start; i < end; i++)
        {
            sum += inputArray[i];
        }

        return sum;
    }
}