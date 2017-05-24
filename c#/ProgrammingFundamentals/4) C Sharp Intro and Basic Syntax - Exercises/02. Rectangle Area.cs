using System;

public class Program
{
    public static void Main()
    {
        var firstNumber = double.Parse(Console.ReadLine());
        var secondNumber = double.Parse(Console.ReadLine());

        Console.WriteLine("{0:F2}", firstNumber * secondNumber);
    }
}