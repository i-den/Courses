using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();

        for (int i = 0; i < inputArr.Length; i++)
        {
            var leftSum = 0;
            var rightSum = 0;

            for (int j = 0; j < i; j++)
            {
                leftSum += inputArr[j];
            }

            for (int j = i + 1; j < inputArr.Length; j++)
            {
                rightSum += inputArr[j];
            }

            if (leftSum == rightSum)
            {
                Console.WriteLine(i);
                return;
            }
        }

        Console.WriteLine("no");
    }
}