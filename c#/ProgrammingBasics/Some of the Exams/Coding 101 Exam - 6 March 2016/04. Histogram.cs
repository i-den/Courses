using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Histogram
{
    class Program
    {
        static void Main(string[] args)
        {

            var n = int.Parse(Console.ReadLine());

            var p1 = 0;
            var p2 = 0;
            var p3 = 0;
            var p4 = 0;
            var p5 = 0;

            for (int i = 1; i <= n; i++)
            {
                var num = int.Parse(Console.ReadLine());

                if (num < 200)
                    p1++;
                else if (num >= 200 && num < 400)
                    p2++;
                else if (num >= 400 && num < 600)
                    p3++;
                else if (num >= 600 && num < 800)
                    p4++;
                else
                    p5++;
            }

            Console.WriteLine("{0:f2}%", (100 * ((double)p1 / (double)n)));
            Console.WriteLine("{0:f2}%", (100 * ((double)p2 / (double)n)));
            Console.WriteLine("{0:f2}%", (100 * ((double)p3 / (double)n)));
            Console.WriteLine("{0:f2}%", (100 * ((double)p4 / (double)n)));
            Console.WriteLine("{0:f2}%", (100 * ((double)p5 / (double)n)));

        }
    }
}
