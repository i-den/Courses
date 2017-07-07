using System;

class Program
{
    public static void Main()
    {
        int x1 = int.Parse(Console.ReadLine());
        int y1 = int.Parse(Console.ReadLine());
        int x2 = int.Parse(Console.ReadLine());
        int y2 = int.Parse(Console.ReadLine());
        int x3 = int.Parse(Console.ReadLine());
        int y3 = int.Parse(Console.ReadLine());

        var area = (double)Math.Abs(x3 - x2) * (double)Math.Abs(y1 - y2) / 2;
        Console.WriteLine(area);
    }
}