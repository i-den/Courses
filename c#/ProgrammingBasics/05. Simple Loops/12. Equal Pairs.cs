using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Equal_Pairs
{
    class Program
    {
        static void Main(string[] args)
        {
            var num = int.Parse(Console.ReadLine());
            var maxdiff = 0;
            var prevsum = 0;
            var diff = 0;

            for (int i = 0; i < num; i++)
            {
                var num1 = int.Parse(Console.ReadLine());
                var num2 = int.Parse(Console.ReadLine());

                var sum = num1 + num2;
                if (i != 0)
                {
                    diff = Math.Abs(sum - prevsum);
                    if (diff > maxdiff)
                        maxdiff = diff;
                }

                prevsum = sum;
            }

            if (maxdiff == 0)
                Console.WriteLine("yes value " + prevsum);
            else if (maxdiff != 0)
                Console.WriteLine("no maxdiff " + maxdiff);
        }
    }
}
