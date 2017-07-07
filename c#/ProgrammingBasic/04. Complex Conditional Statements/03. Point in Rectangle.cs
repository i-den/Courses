using System;

class Program
{
    public static void Main()
    {
        double x1 = double.Parse(Console.ReadLine());
        double y1 = double.Parse(Console.ReadLine());
        double x2 = double.Parse(Console.ReadLine());
        double y2 = double.Parse(Console.ReadLine());

        double xmax = Math.Max(x1, x2);
        double xmin = Math.Min(x1, x2);
        double ymax = Math.Max(y1, y2);
        double ymin = Math.Min(y1, y2);

        double x = double.Parse(Console.ReadLine());
        double y = double.Parse(Console.ReadLine());

        bool isInsideX = x >= xmin && x <= xmax;
        bool isInsideY = y >= ymin && y <= ymax;
        bool isInside = isInsideX && isInsideY;

        if (isInside)
            Console.WriteLine("Inside");
        else
            Console.WriteLine("Outside");
    }
}