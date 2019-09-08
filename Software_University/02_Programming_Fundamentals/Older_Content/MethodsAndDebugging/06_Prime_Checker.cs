using System;

public class Program
{
    public static void Main()
    {
        long testingNumber = long.Parse(Console.ReadLine());

        Console.WriteLine(CheckIfNumberIsPrime(testingNumber));
    }

    public static bool CheckIfNumberIsPrime(long testingNumber)
    {
        if (testingNumber == 0) return false;
        if (testingNumber == 1) return false;
        if (testingNumber == 2) return true;

        for (long i = 2; i < testingNumber; i++)
            if (testingNumber % i == 0)
                return false;

        return true;
    }
}