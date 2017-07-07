using System;

class Program
{
    public static void Main()
    {
        var volume = int.Parse(Console.ReadLine());
        var p1 = int.Parse(Console.ReadLine());
        var p2 = int.Parse(Console.ReadLine());
        double hours = double.Parse(Console.ReadLine());

        var p1fill = p1 * hours;
        var p2fill = p2 * hours;

        double total = p1fill + p2fill;

        if (volume >= total)
            Console.WriteLine("The pool is {0}% full. Pipe 1: {1}%. Pipe 2: {2}%.", (int)(total / volume * 100), (int)(p1fill / total * 100), (int)(p2fill / total * 100));
        else
            Console.WriteLine("For {0} hours the pool overflows with {1} liters.", hours, (total - volume));
    }