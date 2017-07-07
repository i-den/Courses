using System;

class Program
{
    public static void Main()
    {
        var a = Console.ReadLine();
        var b = Console.ReadLine();

        if (a.ToLower() == b.ToLower())
            Console.WriteLine("yes");

        else
            Console.WriteLine("no");

    }
}