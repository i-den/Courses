using System;

public class Program
{
    public static void Main()
    {
        double cubeSide = double.Parse(Console.ReadLine());
        string parameter = Console.ReadLine();

        double result = GetParameter(cubeSide, parameter);

        Console.WriteLine("{0:f2}", result);
    }

    public static double GetParameter(double cubeSide, string parameter)
    {
        double result = 0d;

        switch (parameter)
        {
            case "face":
               result = Math.Sqrt(2 * cubeSide * cubeSide);
                break;
            case "space":
                result = Math.Sqrt(3 * cubeSide * cubeSide);
                break;
            case "volume":
                result = Math.Pow(cubeSide, 3);
                break;
            case "area":
                result = 6 * Math.Pow(cubeSide, 2);
                break;
        }

        return result;
    }
}