using System;

namespace _11.Equal_Words
{
    class Program
    {
        static void Main()
        {
            var a = Console.ReadLine();
            var b = Console.ReadLine();

            if (a.ToLower() == b.ToLower())
                Console.WriteLine("yes");

            else
                Console.WriteLine("no");

        }
    }
}
