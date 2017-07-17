using System;

class Program
{
    static void Main()
    {
        var a = double.Parse(Console.ReadLine());
        var b = double.Parse(Console.ReadLine());
        Abs(a, b);
    }

    public static void Abs(double a, double b)
    {
        if (a >= b)
            Console.WriteLine(a);
        else
            Console.WriteLine(b);
    }
}