using System;

public class Program
{
    public static void Main()
    {
        var startIndex = int.Parse(Console.ReadLine());
        var endIndex = int.Parse(Console.ReadLine());

        for (int i = startIndex; i <= endIndex; i++)
        {
            Console.Write($"{(char)i} ");
        }
    }
}