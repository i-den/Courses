using System;

public class Program
{
    public static void Main()
    {
        var a = double.Parse(Console.ReadLine());
        var b = double.Parse(Console.ReadLine());

        var perimeter = (a + b) * 2;
        var area = a * b;
        var diagonal = Math.Sqrt(a * a + b * b);

        Console.WriteLine($"{perimeter}");
        Console.WriteLine($"{area}");
        Console.WriteLine($"{diagonal}");
    }
}