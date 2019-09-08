using System;

public class Program
{
    public static void Main()
    {
        var firstNumber = Console.ReadLine();
        var secNumber = Console.ReadLine();
        var totalSum = 0L;

        sbyte dummySbyte = 0;

        if (sbyte.TryParse(firstNumber, out dummySbyte))
        {
            totalSum = short.Parse(firstNumber) * 4 + long.Parse(secNumber) * 10;
        }
        else
        {
            totalSum = long.Parse(firstNumber) * 10 + sbyte.Parse(secNumber) * 4;
        }

        Console.WriteLine(totalSum);
    }
}