﻿using System;


class Program
{
    static void Main()
    {
        string firstName = Console.ReadLine();
        string secondName = Console.ReadLine();
        int age = int.Parse(Console.ReadLine());

        Console.WriteLine("Hello, {0} {1}. You are {2} years old.", firstName, secondName, age);
    }
}

