using System;

public class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        int years = n * 100;
        int days = (int)(years * 365.2422);
        uint hours = (uint)(days * 24);
        long minutes = hours * 60;

        Console.WriteLine("{0} centuries = {1} years = {2} days = {3} hours = {4} minutes", n, years, days, hours, minutes);
    }
}
