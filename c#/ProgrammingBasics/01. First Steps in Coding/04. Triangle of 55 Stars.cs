﻿using System;

class Program
{
    public static void Main()
    {
        for (int i = 1; i <= 10; i++)
        {
            Console.WriteLine(new string('*', i));
        }
    }
}