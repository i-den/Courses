using System;

class Program
{
    public static void Main()
    {
        var r = double.Parse(Console.ReadLine());
        var area = r * r * Math.PI;
        var perimeter = 2 * Math.PI * r;
        Console.WriteLine("Area = " + area);
        Console.WriteLine("Perimeter = {0}", perimeter);
    }
}