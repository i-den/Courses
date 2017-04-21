using System;

public class AltSolution
{
    public static void Main()
    {
        decimal number = decimal.Parse(Console.ReadLine());

        PrintDecimalNumberInReverse(number);
    }

    public static void PrintDecimalNumberInReverse(decimal number)
    {
        string reversedNumber = number.ToString();

        for (int i = reversedNumber.Length - 1; i >= 0; i--)
        {
            Console.Write(reversedNumber[i]);
        }

        Console.WriteLine();
    }
}


