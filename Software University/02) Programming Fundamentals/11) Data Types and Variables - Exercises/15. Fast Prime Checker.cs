using System;

public class Program
{
    public static void Main()
    {
        var inputNum = int.Parse(Console.ReadLine());

        for (int i = 2; i <= inputNum; i++)
        {
            var isPrime = true;

            for (int j = 2; j <= Math.Sqrt(i); j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            Console.WriteLine($"{i} -> {isPrime}");
        }
    }
}