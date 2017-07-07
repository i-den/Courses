using System;

class Program
{
    public static void Main()
    {
        var dollars = double.Parse(Console.ReadLine());
        var bgn = dollars * 1.79549;
        Console.WriteLine(Math.Round(bgn, 2) + " BGN");
    }
}