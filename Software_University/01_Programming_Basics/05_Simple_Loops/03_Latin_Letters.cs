﻿using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        var sum = 0;

        for (var i = 1; i <= n; i++)
        {
            sum += int.Parse(Console.ReadLine());
        }

        Console.WriteLine(sum);
    }
}