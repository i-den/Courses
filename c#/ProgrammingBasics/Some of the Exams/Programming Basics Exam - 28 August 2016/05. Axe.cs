using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Axe
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());

            for (int top = 1; top <= n; top++)
                Console.WriteLine("{0}*{1}*{2}", new string('-', n * 3), new string('-', top - 1), new string('-', ((n - 1) + (n - 1)) - (top) + 1));

            for (int mid = 1; mid <= n / 2; mid++)
                Console.WriteLine("{0}*{1}*{1}", new string('*', n * 3), new string('-', n - 1));

            for (int bot = 0; bot < n / 2; bot++)
            {
                if (bot == (n / 2) - 1 )
                {
                    Console.WriteLine("{0}*{1}*{2}", new string('-', n * 3 - bot), new string('*', (n - 1) + (bot * 2)), new string('-', n - 1 - bot));
                }
                else
                {
                    Console.WriteLine("{0}*{1}*{2}", new string('-', n * 3 - bot), new string('-', (n - 1) + (bot * 2)), new string('-', n - 1 - bot));
                }
            }
               


    }
    }
}