using System;

class Program
{
    public static void Main()
    {
        int bricks = int.Parse(Console.ReadLine());
        int workers = int.Parse(Console.ReadLine());
        int quantity = int.Parse(Console.ReadLine());

        double PerLoad = workers * quantity;
        double bla = bricks / PerLoad;
        Console.WriteLine(Math.Ceiling(bricks / PerLoad));
    }
}