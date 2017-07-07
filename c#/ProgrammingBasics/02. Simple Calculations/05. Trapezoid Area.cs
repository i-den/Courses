using System;

class Program
{
    public static void Main()
    {
        var a = double.Parse(Console.ReadLine());
        var b = double.Parse(Console.ReadLine());
        var h = double.Parse(Console.ReadLine());
        var area = (a + b) * h / 2;
        Console.WriteLine("Trapezoid area = {0}", area);
    }
}