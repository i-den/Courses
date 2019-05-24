using System;

public class Program
{
    public static void Main()
    {
        var linesCount = int.Parse(Console.ReadLine());

        var sum = 0L;

        for (int i = 0; i < linesCount; i++)
        {
            sum += (int)char.Parse(Console.ReadLine());
        }

        Console.WriteLine($"The sum equals: {sum}");
    }
}