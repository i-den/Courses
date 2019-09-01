using System;
using System.Numerics;

public class Program
{
    public static void Main()
    {
        int factorialNumber = int.Parse(Console.ReadLine());
        BigInteger factorial = 1;

        for (int i = 1; i <= factorialNumber; i++)
        {
            factorial *= i;
        }

        Console.WriteLine(factorial);
    }
}