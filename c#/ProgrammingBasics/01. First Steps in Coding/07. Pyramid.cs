using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Pyramid
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int i = 1; i < 10; i++)
            {
                Console.WriteLine(new string(' ',10 - i) + new string('*', i * 2));
            }
            for (int i = 10; i >= 1; i--)
            {
                Console.WriteLine(new string(' ', 10 - i) + new string('*', i * 2));
            }
        }
    }
}
