using System;

public class Program
{
    public static void Main()
    {
        var width = int.Parse(Console.ReadLine());
        var height = int.Parse(Console.ReadLine());

        var megaPixels = width * height / 1000000d;

        Console.WriteLine($"{width}x{height} => {Math.Round(megaPixels, 1)}MP");
    }
}