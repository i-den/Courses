using System;


class Program
{
    static void Main()
    {
        
        Console.Write("Length: ");
        var length = double.Parse(Console.ReadLine());
        Console.Write("Width: ");
        var height = double.Parse(Console.ReadLine());
        Console.Write("Height: ");
        var volume = double.Parse(Console.ReadLine());
        volume = (length * height * volume) / 3;

        Console.WriteLine("Pyramid Volume: {0:F2}", volume);
    }
}

