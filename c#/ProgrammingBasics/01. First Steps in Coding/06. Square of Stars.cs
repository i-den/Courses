using System;

class Program
{
    public static void Main()
    {
        Console.Write("What's n? ");
        var num = int.Parse(Console.ReadLine());

        Console.WriteLine(new string('*', num));
        for (int i = 1; i <= num - 2; i++)
        {
            Console.WriteLine("*" + new string(' ', num - 2) + "*");
        }
        Console.WriteLine(new string('*', num));
    }
}