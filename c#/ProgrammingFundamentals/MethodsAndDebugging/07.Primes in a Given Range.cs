using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        int startNumber = int.Parse(Console.ReadLine());
        int endNumber = int.Parse(Console.ReadLine());

        List<int> primes = GetPrimes(startNumber, endNumber);

        Console.WriteLine(string.Join(", ", primes));
    }

    private static List<int> GetPrimes(int start, int end)
    {
        List<int> primesList = new List<int>();

        for (int num = start; num <= end; num++)
        {
            bool prime = true;

            if (num == 0 || num == 1)
            {
                prime = false;
            }

            for (int i = 2; i < num; i++)
            {
                if (num % i == 0)
                {
                    prime = false;
                }
            }

            if (prime)
            {
                primesList.Add(num);
            }
        }

        return primesList;
    }
}
