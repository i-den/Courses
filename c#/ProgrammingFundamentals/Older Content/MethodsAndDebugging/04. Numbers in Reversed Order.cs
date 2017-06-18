using System;

public class Program
{
    public static void Main()
    {
        decimal number = decimal.Parse(Console.ReadLine());

        PrintDecimalNumberInReverse(number);
    }

    public static void PrintDecimalNumberInReverse(decimal number)
    {
        char[] reversedNumber = number.ToString().ToCharArray();
        Array.Reverse(reversedNumber);

        foreach (char character in reversedNumber)
        {
            Console.Write(character);
        }

        Console.WriteLine();
    }
}