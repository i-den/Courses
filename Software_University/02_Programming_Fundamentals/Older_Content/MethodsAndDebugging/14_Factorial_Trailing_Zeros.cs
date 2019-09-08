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

        int sum = 0;
        char[] charArray = factorial.ToString().ToCharArray();

        for (int i = charArray.Length - 1; i >= 0 ; i--)
        {
            if (charArray[i] == '0')
            {
                sum++;
            }
            else
            {
                break;
            }
        }

        Console.WriteLine(sum);
    }
}