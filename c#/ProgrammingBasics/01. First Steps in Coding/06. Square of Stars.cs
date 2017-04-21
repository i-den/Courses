using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Square_of_Stars
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("What's n? ");
            var num = int.Parse(Console.ReadLine());

            Console.WriteLine(new string('*', num));
            for (int i = 1; i <= num - 2; i++)
            {
                Console.WriteLine("*" + new string(' ', num - 2) + "*");
            }
            Console.WriteLine(new string('*', num));
        }
    }
}
