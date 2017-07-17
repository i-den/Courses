using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        int numberToCheck = int.Parse(Console.ReadLine());

        for (int i = 1; i <= numberToCheck; i++)
        {
            if (IsPalindrome(i.ToString()) && DigitsDivisibleBySeven(i) && HasEvenDigit(i))
            {
                Console.WriteLine(i);
            }
        }
    }

    public static bool IsPalindrome(string number)
    {
        int min = 0;
        int max = number.Length - 1;

        while (true)
        {
            if (min > max)
            {
                return true;
            }
            char a = number[min];
            char b = number[max];

            if (char.ToLower(a) != char.ToLower(b))
            {
                return false;
            }

            min++;
            max--;
        }
    }

    public static bool DigitsDivisibleBySeven(int testingNumber)
    {
        int sum = 0;

        while (testingNumber != 0)
        {
            sum += testingNumber % 10;
            testingNumber /= 10;
        }

        if (sum % 7 == 0)
        {
            return true;
        }

        return false;
    }

    public static bool HasEvenDigit(int testingNumber)
    {
        while (testingNumber != 0)
        {
            int digit = testingNumber % 10;

            if (digit % 2 == 0)
            {
                return true;
            }

            testingNumber /= 10;
        }

        return false;
    }
}