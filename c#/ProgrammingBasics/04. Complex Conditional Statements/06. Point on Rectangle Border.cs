using System;

class Program
{
    public static void Main()
    {
        double x1 = double.Parse(Console.ReadLine());
        double y1 = double.Parse(Console.ReadLine());
        double x2 = double.Parse(Console.ReadLine());
        double y2 = double.Parse(Console.ReadLine());

        double x = double.Parse(Console.ReadLine());
        double y = double.Parse(Console.ReadLine());

        double xmax = Math.Max(x1, x2);
        double xmin = Math.Min(x1, x2);
        double ymax = Math.Max(y1, y2);
        double ymin = Math.Min(y1, y2);

        bool borderX = x >= xmin && x <= xmax && (y == ymin || y == ymax);
        bool borderY = y >= ymin && y <= ymax && (x == xmin || x == xmax);

        if (borderX || borderY)
            Console.WriteLine("Border");
        else
            Console.WriteLine("Inside / Outside");
    }
}