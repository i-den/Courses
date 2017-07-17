using System;

class Program
{
    public static void Main()
    {
        var x1 = double.Parse(Console.ReadLine());
        var y1 = double.Parse(Console.ReadLine());
        var x2 = double.Parse(Console.ReadLine());
        var y2 = double.Parse(Console.ReadLine());

        double x = Math.Abs(x1 - x2);
        double y = Math.Abs(y1 - y2);

        double area = x * y;
        double perimeter = 2 * (x + y);

        Console.WriteLine(area);
        Console.WriteLine(perimeter);
    }
}