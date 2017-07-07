using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (int num = 1; num <= n; num += 3)
        {
            Console.WriteLine(num);
        }
    }
}