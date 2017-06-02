using System;


class Program
{
    static void Main()
    {
        var num = int.Parse(Console.ReadLine());
        decimal sum = 0m;

        for (int i = 0; i < num; i++)
        {
            sum += decimal.Parse(Console.ReadLine());
        }

        Console.WriteLine(sum);
    }
}

