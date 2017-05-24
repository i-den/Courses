using System;

public class Program
{
    public static void Main()
    {
        var inputNumber = Console.ReadLine();
        var parsedNumber = 0D;

        var parsed = double.TryParse(inputNumber, out parsedNumber);

        var printingResult = parsed ? "It is a number." : "Invalid input!";

        Console.WriteLine(printingResult);
    }
}