using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (int i = 0, num = 1; i <= n; i++, num *= 2)
        {
            Console.WriteLine(num);

        }
    }
}