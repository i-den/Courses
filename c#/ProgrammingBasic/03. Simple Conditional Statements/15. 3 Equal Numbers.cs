using System;

class Program
{
    public static void Main()
    {
        var a = Console.ReadLine();
        var b = Console.ReadLine();
        var c = Console.ReadLine();

        if (a == b & a == c & b == c)
            Console.WriteLine("yes");

        else
            Console.WriteLine("no");
    }
}