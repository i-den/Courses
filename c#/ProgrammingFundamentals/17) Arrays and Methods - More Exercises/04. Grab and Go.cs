using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();
        var numToFind = int.Parse(Console.ReadLine());
        var sum = 0L;

        for (int i = inputArr.Length - 1; i >= 0; i--)
        {
            if (inputArr[i] == numToFind)
            {
                for (int j = i - 1; j >= 0 ; j--)
                {
                    sum += inputArr[j];
                }
                Console.WriteLine(sum);
                return;
            }
        }

        Console.WriteLine("No occurrences were found!”");
    }
}