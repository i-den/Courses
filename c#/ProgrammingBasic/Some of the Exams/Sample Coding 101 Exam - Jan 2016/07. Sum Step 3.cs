using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        var sum1 = 0;
        var sum2 = 0;
        var sum3 = 0;

        for (int i = 1; i <= n; i++)
        {
            var num = int.Parse(Console.ReadLine());
            if (i == 1 || i % 3 - 1 == 0)
                sum1 += num;
            else if (i % 3 == 0)
                sum3 += num;
            else sum2 += num;

        }
        Console.WriteLine($"sum1 = {sum1}");
        Console.WriteLine($"sum2 = {sum2}");
        Console.WriteLine($"sum3 = {sum3}");
    }
}