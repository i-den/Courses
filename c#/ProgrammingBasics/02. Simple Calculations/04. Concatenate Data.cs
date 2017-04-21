using System;

namespace _04.Concatenate_Data
{
    class Program
    {
        static void Main()
        {
            var fn = Console.ReadLine();
            var ln = Console.ReadLine();
            var age = Console.ReadLine();
            var town = Console.ReadLine();
            Console.WriteLine($"You are {fn} {ln}, a {age}-years old person from {town}.");
        }
    }
}
