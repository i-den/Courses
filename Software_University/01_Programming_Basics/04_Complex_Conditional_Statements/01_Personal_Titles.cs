﻿using System;

class Program
{
    public static void Main()
    {
        var age = double.Parse(Console.ReadLine());
        var gender = Console.ReadLine();
        if (gender == "f")
        {
            if (age < 16)
                Console.WriteLine("Miss");
            else
                Console.WriteLine("Ms.");
        }
        else if (gender == "m")
        {
            if (age < 16)
                Console.WriteLine("Master");
            else
                Console.WriteLine("Mr.");
        }
    }
}