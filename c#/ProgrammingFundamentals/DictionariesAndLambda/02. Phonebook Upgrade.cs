﻿using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var phoneBook = new SortedDictionary<string, string>();

        while (true)
        {
            var input = Console.ReadLine().Split().ToList();
            var command = input[0];

            if (command == "END")
            {
                break;
            }
            else if (command == "A")
            {
                var name = input[1];
                var number = input[2];

                phoneBook[name] = number;

            }
            else if (command == "S")
            {
                var name = input[1];

                if (phoneBook.ContainsKey(name))
                {
                    Console.WriteLine($"{name} -> {phoneBook[name]}");
                }
                else
                {
                    Console.WriteLine($"Contact {name} does not exist.");
                }
            }
            else if (command == "ListAll")
            {
                foreach (var pair in phoneBook)
                {
                    Console.WriteLine($"{pair.Key} -> {pair.Value}");
                }
            }
        }
    }
}