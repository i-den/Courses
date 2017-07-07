using System;

class Program
{
    public static void Main()
    {
        var a = int.Parse(Console.ReadLine());
        var b = int.Parse(Console.ReadLine());
        var c = int.Parse(Console.ReadLine());

        var min = Math.Min(a, (Math.Min(b, c)));
        var max = Math.Max(a, (Math.Max(b, c)));
        var mid = (a + b + c) - max - min;

        if (min + mid == max) Console.WriteLine($"{min}+{mid}={max}");
        else Console.WriteLine("No");
    }
}