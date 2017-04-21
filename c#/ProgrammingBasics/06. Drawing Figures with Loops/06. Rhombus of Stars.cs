using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Rhombus_of_Stars
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var spaces = n - 1;
            var stars = n;

            for (int row = 1; row <= n; row++)
            {
                Console.Write(new string(' ', n - row));
                Console.Write("*");
                for (int col = 2; col <= row; col++)
                {
                    Console.Write(" *");
                }

                Console.WriteLine();
            }
            for (int row = n - 1; row >= 1; row--)
            {
                 Console.Write(new string(' ', n - row));
                Console.Write("*");
                for (int col = 2; col <= row; col++)
                {
                    Console.Write(" *");
                }

                Console.WriteLine();
            }
            
            
        }
    }
}
