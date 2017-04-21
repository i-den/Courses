using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Rectangle_with_Stars
{
    class Program
    {
        static void Main(string[] args)
        {
            var s = int.Parse(Console.ReadLine());
            var n = 0;
            if (s % 2 == 0) n = s - 1;
            else n = s;

            Console.WriteLine(new string('%', s * 2));

            for (int row = 1; row <= n; row++)
            {
                Console.Write('%');
                if (row == (s + 1)/2)
                {
                    Console.Write(new string(' ',s - 2));
                    Console.Write("**");
                    Console.Write(new string(' ', s - 2));
                }
                else
                {
                    for (int col = 1; col <= (s * 2) - 2; col++)
                    {
                        Console.Write(" ");
                    }
                }
                
                Console.Write('%');
                Console.WriteLine();
            }

            Console.WriteLine(new string('%', s * 2));

        }
    }
}
