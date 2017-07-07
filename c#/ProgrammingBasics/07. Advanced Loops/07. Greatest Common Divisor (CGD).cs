using System;

class Program
{
    public static void Main()
    {
        var a = int.Parse(Console.ReadLine());
        var b = int.Parse(Console.ReadLine());
        var aa = Math.Max(a, b);
        var bb = Math.Min(a, b);

        while (bb != 0)
        {
            var rem = bb;
            bb = aa % bb;
            aa = rem;
        }

        Console.WriteLine($"GCD = {aa})");
    }
}