﻿using System;


class Program
{
    static void Main()
    {
        int people = int.Parse(Console.ReadLine());
        int courses = int.Parse(Console.ReadLine());

        Console.WriteLine(Math.Ceiling((double)people / courses));
    }
}

