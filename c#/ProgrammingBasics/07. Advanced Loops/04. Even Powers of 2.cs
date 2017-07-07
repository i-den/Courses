using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        for (int i = 1, num = 1; i <= n / 2 + 1; i++, num *= 4)
            Console.WriteLine(num);
    }
}