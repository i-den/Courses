using System;


class Program
{
    static void Main()
    {
        var r = double.Parse(Console.ReadLine());
        Console.WriteLine("{0:f12}", Math.PI * Math.Pow(r, 2));
    }
}

