using System;

public class Program
{
    public static void Main()
    {
        double pointOneX, pointOneY, pointTwoX, pointTwoY, pointThreeX, pointThreeY, pointFourX, pointFourY;

        GetPointPairCoordinates(out pointOneX, out pointOneY, out pointTwoX, out pointTwoY);
        GetPointPairCoordinates(out pointThreeX, out pointThreeY, out pointFourX, out pointFourY);

        double lengthOfFirstLine = GetLineLengthFromPointToPoint(pointOneX, pointOneY, pointTwoX, pointTwoY);
        double lengthOfSecondLine = GetLineLengthFromPointToPoint(pointThreeX, pointThreeY, pointFourX, pointFourY);

        if (lengthOfFirstLine >= lengthOfSecondLine)
            CheckWhichPointIsCloser(pointOneX, pointOneY, pointTwoX, pointTwoY);
        else
            CheckWhichPointIsCloser(pointThreeX, pointThreeY, pointFourX, pointFourY);
    }

    public static void GetPointPairCoordinates(out double a1, out double a2, out double b1, out double b2)
    {
        a1 = double.Parse(Console.ReadLine());
        a2 = double.Parse(Console.ReadLine());
        b1 = double.Parse(Console.ReadLine());
        b2 = double.Parse(Console.ReadLine());
    }

    public static double GetLineLengthFromPointToPoint(double a1, double a2, double b1, double b2)
    {
        double lengthX = GetLineLength(a1, b1);
        double lengthY = GetLineLength(a2, b2);

        double length = Math.Pow(lengthX, 2) + Math.Pow(lengthY, 2);
        return length;
    }

    public static double GetLineLength(double a1, double b1)
    {
        double biggerFirst = Math.Max(a1, b1);
        double smallerFirst = Math.Min(a1, b1);

        if (biggerFirst < 0)
        {
            biggerFirst = Math.Abs(biggerFirst);
            smallerFirst = Math.Abs(smallerFirst);
        }

        double length = Math.Abs(biggerFirst - smallerFirst);
        return length;
    }

    public static void CheckWhichPointIsCloser(double a1, double a2, double b1, double b2)
    {
        double firstLength = Math.Abs(Math.Pow((a1 * a1 + a2 * a2), 2));
        double secondLength = Math.Abs(Math.Pow((b1 * b1 + b2 * b2), 2));

        if (firstLength <= secondLength)
            Console.WriteLine("({0}, {1})({2}, {3})", a1, a2, b1, b2);
        else
            Console.WriteLine("({0}, {1})({2}, {3})", b1, b2, a1, a2);
    }
}