using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Odd_Even_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var evensum = 0;
            var oddsum = 0;

            for (int i = 1; i <= n; i++)
            {

                var add = int.Parse(Console.ReadLine());

                if (i % 2 == 0)
                {
                    evensum += add;
                }
                else
                {
                    oddsum += add;
                }
            }

            if (evensum == oddsum)
            {
                Console.WriteLine("Yes, sum = " + evensum);
            }
            else
            {
                Console.WriteLine("No, diff = " + Math.Abs(evensum - oddsum));
            }

        }
    }
}
