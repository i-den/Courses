using System;

public class Program
{
    public static void Main()
    {
        double pointOneX, pointOneY, pointTwoX, pointTwoY;

        GetPointCoordinates(out pointOneX, out pointOneY, out pointTwoX, out pointTwoY);

        CheckWhichPointIsCloser(pointOneX, pointOneY, pointTwoX, pointTwoY);
    }

    public static void GetPointCoordinates(out double a1, out double a2, out double b1, out double b2)
    {
        a1 = double.Parse(Console.ReadLine());
        a2 = double.Parse(Console.ReadLine());
        b1 = double.Parse(Console.ReadLine());
        b2 = double.Parse(Console.ReadLine());
    }

    public static void CheckWhichPointIsCloser(double a1, double a2, double b1, double b2)
    {
        double firstLength = Math.Abs(Math.Pow((a1 * a1 + a2 * a2), 2));
        double secondLength = Math.Abs(Math.Pow((b1 * b1 + b2 * b2), 2));

        Console.WriteLine("({0}, {1})", firstLength > secondLength ? b1 : a1, firstLength > secondLength ? b2 : a2);
    }
}