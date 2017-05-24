using System;

public class Program
{
    public static void Main()
    {
        var inputNumber = int.Parse(Console.ReadLine());
        var sum = 0;

        for (int i = 1; i < inputNumber * 2; i += 2)
        {
            Console.WriteLine(i);
            sum += i;
        }

        Console.WriteLine($"Sum: {sum}");
    }
}