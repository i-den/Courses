using System;

class Program
{
    public static void Main()
    {
        var fig = Console.ReadLine();
        if (fig == "square")
        {
            var a = double.Parse(Console.ReadLine());
            Console.WriteLine(a * a);
        }
        if (fig == "rectangle")
        {
            var a = double.Parse(Console.ReadLine());
            var b = double.Parse(Console.ReadLine());
            Console.WriteLine(a * b);
        }
        if (fig == "circle")
        {
            var r = double.Parse(Console.ReadLine());
            Console.WriteLine(Math.PI * r * r);
        }
        if (fig == "triangle")
        {
            var a = double.Parse(Console.ReadLine());
            var b = double.Parse(Console.ReadLine());
            Console.WriteLine(a * b / 2);
        }
    }
}