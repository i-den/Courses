using System;

class Program
{
    public static void Main()
    {
        var a = int.Parse(Console.ReadLine());
        var b = int.Parse(Console.ReadLine());
        var c = int.Parse(Console.ReadLine());
        TimeSpan timey = TimeSpan.FromSeconds(a + b + c);
        Console.WriteLine($"{timey.Minutes}:{timey.Seconds:d2}");
    }
}