using System;

public class Program
{
    public static void Main()
    {
        var a = double.Parse(Console.ReadLine());
        var b = double.Parse(Console.ReadLine());

        var compare = Math.Abs(a - b) < 0.000001;
        Console.WriteLine(compare);
    }
}