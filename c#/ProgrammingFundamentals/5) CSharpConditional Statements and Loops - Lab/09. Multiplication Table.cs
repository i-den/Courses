using System;

public class Program
{
    public static void Main()
    {
        var inputNumber = int.Parse(Console.ReadLine());

        for (int i = 1; i <= 10; i++)
        {
            var multipliedNumber = inputNumber * i;

            Console.WriteLine($"{inputNumber} X {i} = {multipliedNumber}");
        }
    }
}