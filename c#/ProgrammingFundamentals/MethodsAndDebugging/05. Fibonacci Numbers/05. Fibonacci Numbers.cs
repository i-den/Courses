using System;

public class Program
{
    public static void Main()
    {
        int maxFibonacciNumber = int.Parse(Console.ReadLine());

        GetFibonacciNumber(maxFibonacciNumber);
    }

    public static void GetFibonacciNumber(int maxFibonacciNumber)
    {
        long[] fibonacciArray = new long[maxFibonacciNumber + 1];

        if (fibonacciArray.Length > 2)
        {
            fibonacciArray[0] = 1;
            fibonacciArray[1] = 1;

            for (int i = 2; i < fibonacciArray.Length; i++)
            {
                long sum = fibonacciArray[i - 1] + fibonacciArray[i - 2];
                fibonacciArray[i] = sum;
            }

            Console.WriteLine(fibonacciArray[fibonacciArray.Length - 1]);
        }
        else
            Console.WriteLine(1);
    }
}