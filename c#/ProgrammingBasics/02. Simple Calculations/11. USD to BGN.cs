﻿using System;

namespace _11.USD_to_BGN
{
    class Program
    {
        static void Main()
        {
            var dollars = double.Parse(Console.ReadLine());
            var bgn = dollars * 1.79549;
            Console.WriteLine(Math.Round(bgn, 2)+ " BGN");
        }
    }
}
