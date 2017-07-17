using System;

class Program
{
    public static void Main()
    {
        var first = int.Parse(Console.ReadLine());
        var second = int.Parse(Console.ReadLine());
        var point = int.Parse(Console.ReadLine());

        int max = Math.Max(first, second);
        int min = Math.Min(first, second);
        var close = 0;
        if (max - point < point - min)
            close = max - point;
        else close = point - min;

        if (point >= min && point <= max)
            Console.WriteLine("in");
        else
            Console.WriteLine("out");
        Console.WriteLine(Math.Abs(close));
    }
}