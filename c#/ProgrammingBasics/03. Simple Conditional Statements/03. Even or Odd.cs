﻿using System;

namespace _03.Even_or_Odd
{
    class Program
    {
        static void Main(string[] args)
        {
            var num = int.Parse(Console.ReadLine());

            if (num % 2 == 0)
                Console.WriteLine("even");
            else
                Console.WriteLine("odd");
        }
    }
}
