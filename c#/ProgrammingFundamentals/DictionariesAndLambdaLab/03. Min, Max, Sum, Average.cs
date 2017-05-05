using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var numbersCount = int.Parse(Console.ReadLine());
        var myArr = new int[numbersCount];

        for (int i = 0; i < numbersCount; i++)
        {
            myArr[i] = int.Parse(Console.ReadLine());
        }

        Console.WriteLine("Sum = {0}", myArr.Sum());
        Console.WriteLine("Min = {0}", myArr.Min());
        Console.WriteLine("Max = {0}", myArr.Max());
        Console.WriteLine("Average = {0}", myArr.Average());
    }
}