using System;

public class Program
{
    public static void Main()
    {
        var inputNumber = Console.ReadLine();

        var dummyInt = 0L;
        var parsedInteger = long.TryParse(inputNumber, out dummyInt);

        Console.WriteLine(parsedInteger ? "integer" : "floating-point");
    }
}