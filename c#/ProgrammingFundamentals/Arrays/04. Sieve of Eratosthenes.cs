using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var numbersRange = int.Parse(Console.ReadLine());

        FindPrimes(numbersRange);
    }

    private static void FindPrimes(int n)
    {
        bool[] primes = new bool[n + 1];
        primes[0] = primes[1] = false;

        for (int i = 2; i <= n; i++)
        {
            primes[i] = true;
        }

        for (int i = 2; i <= n; i++)
        {
            if (!primes[i])
            {
                continue;
            }

            Console.Write($"{i} ");

            for (int j = i * i; j <= n; j += i)
            {
                primes[j] = false;
            }
        }
    }
}